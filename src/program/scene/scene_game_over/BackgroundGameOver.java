package program.scene.scene_game_over;

import program.GameObject;
import program.GameWindow;
import program.Settings;
import program.player.Player;
import program.renderer.SingleImageRenderer;
import program.scene.SceneManager;
import program.scene.SceneStage1;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

import static java.awt.Color.WHITE;

public class BackgroundGameOver extends GameObject {
    public BackgroundGameOver(){
        GameObject.botLayer.add(this);
        BufferedImage image= SpriteUtils.loadImage("assets/images/scenes/victory-background.png");
        this.renderer=new SingleImageRenderer(image);
        this.position.set(Settings.GAME_WIDTH/2,Settings.GAME_HEIGHT/2);
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        g.setColor(WHITE);
        g.drawString("SCORE: ",30,30);
        g.drawString(GameObject.findActive(Player.class).score+"",150,30);
        g.setFont(Settings.BIG_SIZE);
        g.drawString("Game Over",100,150);
        g.setFont(Settings.MEDIUM_SIZE);
        g.drawString("Press Enter to replay",60,650);
    }

    public void run() {
        super.run();
        if(GameWindow.isEnterPress){
            SceneManager.signNewScene(new SceneStage1());
        }
    }
}