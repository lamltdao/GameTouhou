package program.player;

import program.GameObject;
import program.GameWindow;
import program.Settings;
import program.Vector2D;
import program.enemy.Enemy;
import program.physics.BoxCollider;
import program.renderer.AnimationRenderer;

import program.renderer.PlayerRenderer;
import program.scene.SceneManager;
import program.scene.scene_game_over.SceneGameOver;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static java.lang.Math.PI;

public class Player extends GameObject {

//    ArrayList<PlayerBullet>bullets;//replaced by GameObject.objectsj
    public int hp;

    public Player()
    {
        GameObject.midLayer.add(this);
        position.set(Settings.PLAYER_START_X,Settings.PLAYER_START_Y);
        hp=Settings.PLAYER_HP;
        renderer=new PlayerRenderer();
        hitbox= new BoxCollider(this,Settings.PLAYER_WIDTH,Settings.PLAYER_HEIGHT);
        score=0;
        Settings.PBULLET_NUMBER=1;
    }

    public void run() {
        super.run();//position.add(velocity);
        this.move();
        this.limitPosition();
        this.changeBulletNumber();
        this.fire();
        this.intersectEnemy();

    }

    public void limitPosition(){
            position.setX(Mathx.clamp(position.x,0, Settings.BACKGROUND_WIDTH-Settings.PLAYER_WIDTH));
            position.setY(Mathx.clamp(position.y,0,Settings.GAME_HEIGHT-Settings.PLAYER_HEIGHT));}
            public void move(){
                double playerSpeed = Settings.PLAYER_SPEED;
                 this.velocity.x = 0;
                 this.velocity.y = 0;
                //test trước qua lệnh if rồi cộng vào x,y;
                if (GameWindow.isUpPress) {
                    //playerY -= playerSpeed;
                    this.velocity.y -= playerSpeed;
                }
                if (GameWindow.isDownPress) {
                    //playerY += playerSpeed;
                    this.velocity.y += playerSpeed;
                }
                if (GameWindow.isLeftPress) {
                    //playerX -= playerSpeed;
                    this.velocity.x -= playerSpeed;
                }
                if (GameWindow.isRightPress) {
                    // playerX += playerSpeed;
                    this.velocity.x += playerSpeed;
                }
                //TODO: recalculate

                if (this.velocity.x != 0 && this.velocity.y != 0) {
                    double v = playerSpeed / Math.sqrt(2);
                    this.velocity.x = Math.signum(this.velocity.x) * v;
                    this.velocity.y = Math.signum(this.velocity.y) * v;
                }
                position.add(this.velocity.x, this.velocity.y);
            }

            int count=0;
            public  void fire(){
            count++;
            if(GameWindow.isFirePressJ&&count>Settings.PLAYER_FIRE_DELAY){
            double fromX=this.position.x+10;
            double toX=this.position.x-10;
//            double fromAngle=-PI/3;
//            double toAngle=-2*PI/3;
            double fromAngle=PI/2;
            double toAngle=2.5*PI;
                // fromAngle trùng vs toAngle nên cái j cx thay đổi 1 đơn vị
            int PBULLET_NUMBER=Settings.PBULLET_NUMBER+1;
                // trừ 1 vì đạn cuối trùng vs đạn đầu
            for(int i=0;i<PBULLET_NUMBER-1;i++){
                //PlayerBullet bullet=new PlayerBullet();
                PlayerBullet bullet=PlayerBullet.recycle(PlayerBullet.class);
                double x=fromX+i*(toX-fromX)/(PBULLET_NUMBER-1);
                bullet.position.set(x,this.position.y);
                double angle=fromAngle+i*(toAngle-fromAngle)/(PBULLET_NUMBER-1);
                bullet.velocity.setAngle(angle*-1);
            }
            count=0;
        }
    }

    int countKPress=0;
    public void changeBulletNumber(){
        countKPress++;

        if(GameWindow.isChangeBulletNumber&& countKPress>Settings.CHANGE_BULLET_DELAY&&this.score>=Settings.PBULLET_NUMBER*Settings.SCORE_REQUIRED_TO_CHANGE_BULLET_NUMBER){
            if(Settings.PBULLET_NUMBER<Settings.MAX_PBULLET_NUMBER)Settings.PBULLET_NUMBER+=1;
            else Settings.PBULLET_NUMBER=1;
            countKPress=0;
        }
        if(GameWindow.isChangeBulletNumber&&countKPress>Settings.CHANGE_BULLET_DELAY&&this.score<Settings.PBULLET_NUMBER*Settings.SCORE_REQUIRED_TO_CHANGE_BULLET_NUMBER)
        {
            PlayerRenderer.isEnoughScore=false;
            countKPress=0;
        }
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
        g.setColor(Color.RED);
        g.drawString(this.hp+"",
                (int)this.position.x-15,
                (int)this.position.y-25);
    }

    @Override
    public void deactive() {
        super.deactive();
        SceneManager.signNewScene(new SceneGameOver());
    }

    public void intersectEnemy(){
        Enemy enemy=GameObject.findIntersect(Enemy.class,this.hitbox);
        if(enemy!=null){
            enemy.deactive();
            this.takeDamage(enemy.damage);
        }
    }

    public void takeDamage(int damage){
        hp-=damage;
        if(hp<=0){
            hp=0;
            this.deactive();
        }
    }
}
