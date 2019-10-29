package program.renderer;

import program.GameObject;
import program.Settings;
import program.player.Player;

import java.awt.*;

import static java.awt.Color.RED;
import static java.awt.Color.YELLOW;

public class PlayerRenderer extends  Renderer {
    AnimationRenderer leftAnimation;
    AnimationRenderer rightAnimation;
    AnimationRenderer straightAnimation;
    public static boolean isEnoughScore=true;
    public static boolean isMoreEnemyComing=false;
    public PlayerRenderer(){
        leftAnimation=new AnimationRenderer("assets/images/players/left");
        rightAnimation=new AnimationRenderer("assets/images/players/right");
        straightAnimation=new AnimationRenderer("assets/images/players/straight");
    }

    int anotherCount=0;
    int count;
    @Override
    public void render(Graphics g, GameObject master) {
        if(master.velocity.x<0){leftAnimation.render(g,master);}
        else if(master.velocity.x>0){rightAnimation.render(g,master);}
        else{straightAnimation.render(g,master);}


        //SHOW SCORE REQUIRED TO CHANGE BULLET_NUMBER


        if(!isEnoughScore){
            count++;
            g.setColor(RED);
            g.drawString("Your score must be over "+ Settings.PBULLET_NUMBER*Settings.SCORE_REQUIRED_TO_CHANGE_BULLET_NUMBER+" to increase bullet number",10,50);
            if(count>20){
                count=0;
                isEnoughScore=!isEnoughScore;
            }
        }
        //SHOW MORE ENEMY COMING

        if(master.score%10==0&&master.score>0){
            g.setColor(YELLOW);
            g.drawString("MORE ENEMIES ARE COMING ",Settings.GAME_WIDTH/2,50);
        }

        //DRAW HEALTH in Player

    }
}
