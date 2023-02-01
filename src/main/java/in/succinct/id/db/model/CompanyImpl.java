package in.succinct.id.db.model;

import com.venky.core.util.ObjectUtil;
import com.venky.swf.db.Database;
import com.venky.swf.db.annotations.column.IS_VIRTUAL;
import com.venky.swf.db.table.ModelImpl;

import java.util.List;

public class CompanyImpl extends ModelImpl<Company> {
    public CompanyImpl(Company company){
        super(company);
    }
    public long getAdminId(){
        com.venky.swf.db.model.User u = Database.getInstance().getCurrentUser();
        User user= (u == null ? null :u.getRawRecord().getAsProxy(User.class));
        if (getRawRecord().isNewRecord()){
            return 0L;
        }

        Company company  = getProxy();
        List<CompanyAdministrator> administrators = company.getCompanyAdministrators();


        if (user != null) {
            if (administrators.stream().anyMatch(a -> ObjectUtil.equals(a.getUserId(), user.getId()))){
                return user.getId();
            }else if (!administrators.isEmpty()){
                return administrators.get(0).getUserId();
            }
        }

        return 1L;
    }

    public void setAdminId(long id){

    }
}
