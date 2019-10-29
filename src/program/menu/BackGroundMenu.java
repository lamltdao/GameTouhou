package program.menu;

import program.GameObject;
import program.Settings;
import program.player.Player;
import program.scene.scene_game_over.BackgroundGameOver;

import java.awt.*;

public class BackGroundMenu extends GameObject {
    public BackGroundMenu(){
        GameObject.topLayer.add(this);
        this.position.set(Settings.BACKGROUND_WIDTH,0);
    }

    @Override
    public void render(Graphics g) {
//        g.setColor(Color.BLACK);
//        g.fillRect((int)this.position.x,(int)this.position.y,(Settings.GAME_WIDTH-Settings.BACKGROUND_WIDTH),Settings.GAME_HEIGHT);
        g.setColor(Color.white);
//        g.drawString("SCORE: ",Settings.BACKGROUND_WIDTH+30,30);
        g.drawString("SCORE: ",30,30);
//        g.drawString(GameObject.findActive(Player.class).score+"",Settings.BACKGROUND_WIDTH+150,30);
        g.drawString(GameObject.findActive(Player.class).score+"",150,30);
        g.drawString("BULLET NUMBER: "+Settings.PBULLET_NUMBER+"",200,30);

    }
}
