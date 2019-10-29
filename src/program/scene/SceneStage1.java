package program.scene;

import program.GameBackGround;
import program.GameObject;
import program.enemy.EnemySummoner;
import program.menu.BackGroundMenu;
import program.player.Player;

public class SceneStage1 extends Scene {
    @Override
    public void init() {
        GameObject.recycle(GameBackGround.class);
        GameObject.recycle(EnemySummoner.class);
        GameObject.recycle(Player.class);
        GameObject.recycle(BackGroundMenu.class);
    }

    @Override
    public void clear() {
        GameObject.clearAll();
    }
}
