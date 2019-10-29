package program.scene.scene_game_over;

import program.GameObject;
import program.scene.Scene;
import program.scene.SceneManager;

public class SceneGameOver extends Scene {
    @Override
    public void init() {
        GameObject.recycle(BackgroundGameOver.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
