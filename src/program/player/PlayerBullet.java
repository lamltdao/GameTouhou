package program.player;

import program.GameObject;
import program.Settings;
import program.Vector2D;
import program.enemy.Enemy;
import program.physics.BoxCollider;
import program.renderer.AnimationRenderer;
import program.renderer.Renderer;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject {
    public int damage;
    public  PlayerBullet(){

        renderer=new AnimationRenderer("assets/images/player-bullets/a");

        position=new Vector2D();//(0,0))
        velocity=new Vector2D(0,-Settings.PBULLET_SPEED);//hoặc velocity.set(x,y);
        hitbox=new BoxCollider(this,24,24);
        damage=Settings.PBULLET_DAMAGE;
    }


    public void render(Graphics g){
        super.render(g);

    }

    @Override
    public void run(){
        super.run();
        this.deactiveIfNeeded();
        this.intersectsEnemy();
    }

    public void deactiveIfNeeded(){
        if(position.y<-30||position.x>Settings.BACKGROUND_WIDTH)this.deactive();

    }
    public void intersectsEnemy(){
        Enemy enemy=GameObject.findIntersect(Enemy.class,this.hitbox);
        if(enemy!=null){
            this.deactive();
            enemy.takeDamage(this.damage);
        }
    }
}
