//package program;
//
//import program.player.Player;
//import tklibs.Mathx;
//import tklibs.SpriteUtils;
//
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.util.ArrayList;
//
//public class Bullet3 {
//    BufferedImage image;
//
//
//    //Vector2D position;
//    ArrayList<Vector2D> bulletPositions;
//    Player p;
//
//    public Bullet3(Player p) {
//        //  position=new Vector2D(300,300);
//        // image1 = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
//        bulletPositions = new ArrayList<>();
//        this.p = p;
//        image = SpriteUtils.loadImage("assets/images/players/straight/6.png");
//
//    }
//
//    public void render(Graphics g) {
//
//
//
//        for (int i = 0; i < bulletPositions.size(); i++) {
//            Vector2D bulletposition = bulletPositions.get(i);
//            g.drawImage(
//                    image,
//                    (int) bulletposition.x,
//                    (int) bulletposition.y,
//                    null
//            );
//        }
//
//
//    }
//
//    public void run() {
//        this.runL();
//        this.fire();
//
//    }
//
//    public void runL() {
//        for (int i = 0; i < bulletPositions.size(); i++) {
//            Vector2D bulletPosition = bulletPositions.get(i);
//            if(i%3==0) {//bulletPosition.setAngle(PI /6);
//                bulletPosition.add(0,-5);} else
//            if(i%3==1){//bulletPosition.setAngle(PI/3);
//                bulletPosition.add(-3,-5);}else
//            if(i%3==2)
//            {//bulletPosition.setAngle(PI/2);
//                 bulletPosition.add(3,-5);}
//
//            //EM CHIU PHAN LIMIT CHO THG BULLET NAY =((
//            bulletPosition.setX(Mathx.clamp(bulletPosition.x,0,384-32));
//            bulletPosition.setY(Mathx.clamp(bulletPosition.y,0,600-48));
//            if(bulletPosition.x==0||bulletPosition.x==384-32)bulletPosition.x=384;
//            if(bulletPosition.y==0||bulletPosition.y==600-48)bulletPosition.y=600-48+150;
//
//
//
//
//
//        }
//    }
//    int count = 0;
//    public void fire(){
//        count++;
//
//        if (GameWindow.isFirePressL && count > 20) {
//           //nhieu dan
//            Vector2D bulletPosition1 = new Vector2D(p.position.x, p.position.y);
//            Vector2D bulletPosition2 = new Vector2D(p.position.x, p.position.y);
//            Vector2D bulletPosition3 = new Vector2D(p.position.x, p.position.y);
//
//            //position.clone();
//            ;
//
//            bulletPositions.add(bulletPosition1);
//            bulletPositions.add(bulletPosition2);
//            bulletPositions.add(bulletPosition3);
//            count = 0;
//        }
//
//    }
//
//
//
//}
//
//
