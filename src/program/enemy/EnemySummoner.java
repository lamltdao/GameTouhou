package program.enemy;

import program.GameObject;
import program.Settings;
import program.player.Player;

public class EnemySummoner extends GameObject {
    public EnemySummoner(){
        GameObject.midLayer.add(this);
    }

    @Override
    public void run() {
        super.run();
        this.summonEnemy();
        this.increaseEnemy();
    }

    int count=0;
    private void summonEnemy() {
    count++;
        if(count> Settings.ENEMY_SUMMON_DELAY){
        GameObject.recycle(Enemy.class);
        count=0;
        }
    }

    int anotherCount=0;
    public void increaseEnemy(){
        int playerScore= GameObject.findActive(Player.class).score;
        if(playerScore%10==0&&playerScore>0&&anotherCount==0){
            if(Settings.ENEMY_SUMMON_DELAY>50){
                Settings.ENEMY_SUMMON_DELAY-=50;
                anotherCount=1;
            }
            if(playerScore%10==1)anotherCount=0;
        }
    }
}
