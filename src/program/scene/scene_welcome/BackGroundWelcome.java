package program.scene.scene_welcome;

import program.GameObject;
import program.GameWindow;
import program.Settings;
import program.renderer.SingleImageRenderer;
import program.scene.SceneManager;
import program.scene.SceneStage1;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class BackGroundWelcome extends GameObject {
    public BackGroundWelcome(){
        GameObject.botLayer.add(this);
        BufferedImage image= SpriteUtils.loadImage("assets/images/scenes/game-over-background.jpg");
        this.renderer=new SingleImageRenderer(image);
//        this.position.set(Settings.GAME_WIDTH/2,Settings.GAME_HEIGHT/2);
        this.position.set(0,Settings.GAME_HEIGHT/2);
    }

    @Override
    public void run() {
        super.run();
        if(GameWindow.isAnyKeyPress){
            SceneManager.signNewScene(new SceneStage1());
        }
    }
}
