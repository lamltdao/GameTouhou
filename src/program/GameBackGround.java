package program;

import program.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameBackGround extends GameObject
{
//    BufferedImage image;

//    Vector2D position;
//    Vector2D velocity;

    public GameBackGround() {
        //image= SpriteUtils.loadImage("assets/images/background/0.png");
        GameObject.botLayer.add(this);
        renderer=new SingleImageRenderer("assets/images/background/0.png");
        position=new Vector2D(0,Settings.GAME_HEIGHT-Settings.BACKGROUND_HEIGHT);
        velocity=new Vector2D(0,Settings.BACKGROUND_SPEED);
        anchor.set(0,0);
    }

    //Có thể xóa luôn
    public void render(Graphics g)
    {
//        g.drawImage(image,(int)position.x,(int)position.y,null);
        super.render(g);
    }

    @Override
    public void run()
    {
//        position.add(velocity.x,velocity.y);//thay vi positon.y+=10;
        super.run();
        if(position.y>=0) position.setY(Settings.GAME_HEIGHT-Settings.BACKGROUND_HEIGHT);
    }

}
