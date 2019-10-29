package program;

        import program.enemy.EnemySummoner;
        import program.player.Player;
        import program.scene.SceneManager;
        import program.scene.scene_welcome.SceneWelcome;

        import javax.swing.*;
        import java.awt.*;


public class GamePanel extends JPanel  {
    //drawBackground
   GameBackGround background;
    //drawPlayer
    Player player;
    EnemySummoner summoner;



    public GamePanel()
    {
//        background=new GameBackGround();
//        player= new Player();
//        GameObject.recycle(Enemy.class);
//        summoner=new EnemySummoner();
        SceneManager.signNewScene(new SceneWelcome());

    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);//JPanel.paint();

        for(int i=0;i<GameObject.objects.size();i++){
            GameObject object=GameObject.objects.get(i);
            if(object.active){object.render(g);}
        }


    }

    public void runAll() {


    for(int i=0;i<GameObject.objects.size();i++){
        GameObject object= GameObject.objects.get(i);
        if(object.active)object.run();


    }


  }

    public void gameLoop()
    {
        long lastTime=0;
        while(true)
        {
           // long currentTime=System.currentTimeMillis();
            long currentTime=System.currentTimeMillis();
            if(currentTime-lastTime>=1000/60)
            {
                //System.out.println(currentTime-lastTime);
                this.repaint();
                this.runAll();
                lastTime=currentTime;
            }

        }
    }
}

