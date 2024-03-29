package in.succinct.id.db.model.onboarding.company;

import com.venky.swf.db.annotations.column.COLUMN_DEF;
import com.venky.swf.db.annotations.column.defaulting.StandardDefault;
import com.venky.swf.db.annotations.column.pm.PARTICIPANT;
import com.venky.swf.db.annotations.column.ui.HIDDEN;
import com.venky.swf.db.annotations.column.ui.PROTECTION;
import com.venky.swf.db.annotations.column.ui.PROTECTION.Kind;
import com.venky.swf.db.annotations.model.MENU;

import java.util.List;

@MENU("Admin")
public interface Company extends com.venky.swf.plugins.collab.db.model.participants.admin.Company {

    @PROTECTION(Kind.DISABLED)
    @COLUMN_DEF(StandardDefault.BOOLEAN_FALSE)
    public boolean isKycComplete();
    public void setKycComplete(boolean kycComplete);


    public List<SubmittedCompanyDocument> getSubmittedDocuments();

    @HIDDEN
    public List<ClaimRequest> getClaimRequests();

    public ClaimRequest claim();
}
