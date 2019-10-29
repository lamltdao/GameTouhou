package program.enemy;

import program.GameObject;
import program.Settings;
import program.Vector2D;
import program.physics.BoxCollider;
import program.player.Player;
import program.renderer.AnimationRenderer;
import program.renderer.SingleImageRenderer;

import java.awt.*;

public class EnemyBullet extends GameObject {
    public int damage;
    public EnemyBullet(){
        renderer=new AnimationRenderer("assets/images/enemies/bullets");
        position=new Vector2D();
        velocity=new Vector2D(0,-Settings.ENEMY_BULLET_SPEED);//hoặc velocity.set(x,y);
        hitbox=new BoxCollider(this,24,24);
        damage=Settings.ENEMY_BULLET_DAMAGE;
    }


    public void render(Graphics g){
        super.render(g);

    }

    @Override
    public void run(){
        super.run();
        this.deactiveIfNeeded();
        this.intersectsPlayer();
    }

    public void deactiveIfNeeded(){
        if(position.y<-30||position.x>Settings.BACKGROUND_WIDTH)this.deactive();

    }
    public void intersectsPlayer(){
        Player player=GameObject.findIntersect(Player.class,this.hitbox);
        if(player!=null){
            this.deactive();
            player.takeDamage(this.damage);
        }
    }
}
