package program.scene.scene_welcome;

import program.GameObject;
import program.scene.Scene;
import program.scene.scene_welcome.BackGroundWelcome;

public class SceneWelcome extends Scene {
    @Override
    public void init() {
        GameObject.recycle(BackGroundWelcome.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
