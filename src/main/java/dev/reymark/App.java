package dev.reymark;

import dev.reymark.app.RootLoader;
import dev.reymark.data.people.MemberDAO;
import dev.sol.core.application.FXApplication;
import dev.sol.core.application.loader.FXLoaderFactory;
import dev.sol.core.registry.FXCollectionsRegister;
import dev.sol.core.registry.FXControllerRegister;
import dev.sol.core.registry.FXNodeRegister;
import dev.sol.core.scene.FXSkin;
import dev.sol.db.DBService;
import javafx.collections.FXCollections;

public class App extends FXApplication {
    public static final FXControllerRegister CONTROLLER_REGISTRY = FXControllerRegister.INSTANCE;
    public static final FXCollectionsRegister COLLECTIONS_REGISTRY = FXCollectionsRegister.INSTANCE;
    public static final FXNodeRegister NODE_REGISTER = FXNodeRegister.INSTANCE;

    public static final DBService DB_COOP = DBService.INSTANCE
            .initialize("jdbc:mysql://localhost/coop_db_sql?user=root&password=");

    @Override
    public void initialize() throws Exception {
        setTitle("Coop Main");
        setSkin(FXSkin.PRIMER_LIGHT);
        applicationStage.setResizable(false);

        initialize_dataset();
        initialize_application();

    }

    public void initialize_dataset() {

        COLLECTIONS_REGISTRY.register("MEMBER", FXCollections.observableArrayList(MemberDAO.getMemberList()));
    }

    public void initialize_application() {

        RootLoader rootLoader = (RootLoader) FXLoaderFactory
                .createInstance(RootLoader.class, App.class.getResource("/dev/reymark/app/ROOT.fxml"))
                .addParameter("scene", applicationScene).initialize();
        rootLoader.load();
    }

}