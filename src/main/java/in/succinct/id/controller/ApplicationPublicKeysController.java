package in.succinct.id.controller;

import com.venky.swf.controller.ModelController;
import com.venky.swf.controller.annotations.SingleRecordAction;
import com.venky.swf.db.Database;
import com.venky.swf.path.Path;
import com.venky.swf.plugins.background.core.TaskManager;
import com.venky.swf.views.View;
import in.succinct.id.db.model.onboarding.company.ApplicationPublicKey;
import in.succinct.id.extensions.SubmittedDocumentExtension;
import in.succinct.id.extensions.SubmittedDocumentExtension.KycInspector;

public class ApplicationPublicKeysController extends ModelController<ApplicationPublicKey> {
    public ApplicationPublicKeysController(Path path) {
        super(path);
    }

    @SingleRecordAction(icon = "fa-check")
    public View verify(long id ){
        ApplicationPublicKey key = Database.getTable(getModelClass()).get(id);
        key.verify(false);
        return show(key);
    }
}
