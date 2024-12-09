package dev.reymark.app.memberform;

import dev.reymark.App;
import dev.reymark.app.RootController;
import dev.reymark.models.people.Member;
import dev.sol.core.application.loader.FXLoader;
import javafx.scene.Scene;

public class MemberFormLoader extends FXLoader {

    @Override
    public void load() {
        Scene scene = (Scene) params.get("scene");
        Member member = (Member) params.get("MEMBER");
        scene.setRoot(root);

        RootController controller = loader.getController();
        App.CONTROLLER_REGISTRY.register("MEMBER_FORM", controller);
        controller
                .addParameter("SCENE", scene)
                .addParameter("MEMBER", member == null ? new Member() : member)
                .addParameter("ISNEW", member == null)
                .load();
    }

}
