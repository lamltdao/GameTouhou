package program.enemy;

import program.GameObject;
import program.GameWindow;
import program.Settings;
import program.Vector2D;
import program.physics.BoxCollider;
import program.player.Player;
import program.player.PlayerBullet;
import program.renderer.AnimationRenderer;
import program.renderer.Renderer;
import program.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;

import java.lang.reflect.Array;
import java.util.Random;
import java.awt.*;
import java.util.Set;

import static java.lang.Math.PI;

public class Enemy extends GameObject {
    public int hp;
    public int damage;
    public Enemy(){
        GameObject.midLayer.add(this);

        renderer=new AnimationRenderer("assets/images/enemies/level0/pink");
        position=this.randomPosition();
        //position.set(50,50);

        velocity.set(1,3);
        velocity.setAngle(PI/12);
        hitbox=new BoxCollider(this,Settings.ENEMY_WIDTH,Settings.ENEMY_HEIGHT);
        hp=Settings.ENEMY_HP;
        damage=Settings.ENEMY_DAMAGE;
    }
    @Override
    public void run(){
        super.run();
        this.move();
        this.fire();
        this.increaseSpeedAndHealthWhenScoreIncrease();
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        g.setColor(Color.RED);
        g.drawString(hp+"",
                (int)this.position.x-15,
                (int)this.position.y-15);
    }

    @Override
    public void reset() {
        super.reset();
        position=this.randomPosition();
        hitbox=new BoxCollider(this,Settings.ENEMY_WIDTH,Settings.ENEMY_HEIGHT);
        velocity.set(1,3);
        hp=Settings.ENEMY_HP;
        Player player= GameObject.findActive(Player.class);
        for(int i=0;i<player.score/10;i++){
            if(player.score>=10){
                velocity.scale(Settings.ENEMY_SPEED_SCALE);
                hp+=Settings.ENEMY_HEALTH_INCREASE;
            }

            if(player.score>=60)i-=1;
        }
        velocity.setAngle(PI/12);
    }

    private void move() {
        if(this.outBoundRight()&&this.onGoingRight()){
            this.reverseVelocityX();
        }

        if(this.outBoundLeft()&&this.onGoingLeft()){
                this.reverseVelocityX();
            }
        if(this.position.y<=this.anchor.y*Settings.ENEMY_HEIGHT&&this.velocity.y<0){
                this.velocity.setY(-this.velocity.y);
        }

        if(this.position.y>=Settings.GAME_HEIGHT-this.anchor.y*Settings.ENEMY_HEIGHT&&this.velocity.y>0){
                this.velocity.setY(-this.velocity.y);
            }
    }
    private boolean outBoundRight(){
        return this.position.x>=Settings.BACKGROUND_WIDTH-this.anchor.x*Settings.ENEMY_WIDTH;
    }

    private boolean outBoundLeft(){
        return this.position.x<=this.anchor.x*Settings.ENEMY_WIDTH;
    }

    private boolean onGoingRight(){
        return this.velocity.x>0 ;
    }

    private boolean onGoingLeft(){
        return this.velocity.x<0;
    }

    private void reverseVelocityX(){
        this.velocity.setX(-this.velocity.x);
    }

    int anotherCount=0;
    public void increaseSpeedAndHealthWhenScoreIncrease(){
        Player player=GameObject.findActive(Player.class);
        if(player!=null&&player.score%10==0&&anotherCount==0&&player.score>0){
            this.velocity.scale(Settings.ENEMY_SPEED_SCALE);
            this.hp+=Settings.ENEMY_HEALTH_INCREASE;
            anotherCount=1;
        }
        if(player.score%10==1)anotherCount=0;
    }
    public void takeDamage(int damage){
        hp-=damage;
        if(hp<=0){
            hp=0;
            GameObject.findActive(Player.class).score++;
            this.deactive();
            this.hitbox=null;
        }
    }

    public Vector2D randomPosition(){
        Random random= new Random();
        int randomX= random.nextInt(Settings.BACKGROUND_WIDTH);
        int randomY=random.nextInt(Settings.GAME_HEIGHT/3);
        return new Vector2D(randomX,randomY);
    }

    int count=0;
    public  void fire(){
        count++;
        if(count>Settings.ENEMY_FIRE_DELAY){
            double fromX=this.position.x+10;
            double toX=this.position.x-10;
            double fromAngle=-PI/3;
            double toAngle=-2*PI/3;

            for(int i=0;i<Settings.ENEMY_BULLET_NUMBER;i++){
                EnemyBullet bullet=EnemyBullet.recycle(EnemyBullet.class);
                double x=fromX+i*(toX-fromX)/(Settings.ENEMY_BULLET_NUMBER-1);
                bullet.position.set(x,this.position.y);
                double angle=fromAngle+i*(toAngle-fromAngle)/(Settings.ENEMY_BULLET_NUMBER-1);
                //angle bắn lên trên ,nhân -1 để xuống dưới
                bullet.velocity.setAngle(angle*-1);

            }
            count=0;
        }
    }
}
