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
//public class Bullet1  {
//    BufferedImage image;
//
//
//    //Vector2D position;
//    ArrayList<Vector2D> bulletPositions;
//    Player p;
//
//    public Bullet1(Player p) {
//        //  position=new Vector2D(300,300);
//       // image1 = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
//        bulletPositions = new ArrayList<>();
//        this.p = p;
//        image=SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
//
//    }
//
//
//           public void render(Graphics g) {
//        // g.drawImage(image,(int)position.x,(int)position.y,null);
//
//
//            for (int i = 0; i < bulletPositions.size(); i++) {
//                Vector2D bulletposition = bulletPositions.get(i);
//                g.drawImage(
//                        image,
//                        (int) bulletposition.x,
//                        (int) bulletposition.y,
//                        null
//                );
//            }
//
//
//
//
//
//    }
//
//    public void run() {
//        this.runJ();
//        this.fire();
//
//    }
//
//    public void runJ() {
//
//        for (int i = 0; i < bulletPositions.size(); i++) {
//            Vector2D bulletPosition = bulletPositions.get(i);
//            bulletPosition.setX(Mathx.clamp(bulletPosition.x,0,384-32));
//            bulletPosition.setY(Mathx.clamp(bulletPosition.y,0,600-48));
//            if(bulletPosition.x==0||bulletPosition.x==384-32)bulletPosition.x=-100;
//            if(bulletPosition.y==0||bulletPosition.y==600-48)bulletPosition.y=600-48+100;
//            bulletPosition.add(0, -7);
//         }
//
//
////                for(int i=0;i<bulletPositions.size();i++){
////                    Vector2D bulletPosition=bulletPositions.get(i);
//////                    bulletPosition.setX(Mathx.clamp(bulletPosition.x,0-100,384-32+100));
//////                    bulletPosition.setY(Mathx.clamp(bulletPosition.y,0-100,600-48+100));
//////                    bulletPosition.add(1,0);
//////                for(int j=0;j<bulletPositions.size();j++){
////
////                bulletPosition.setAngle(bulletPosition.getAngle()+Math.PI/30);
//
//        //}
//
//
//        // }
//
//
//    }
////    public void runK(){
////        for(int i=0;i<bulletPositions.size();i++){
////            Vector2D bulletPosition=bulletPositions.get(i);
////            bulletPosition.setAngle(Math.PI/3);
////            bulletPosition.subtract(0,5);
//
//
////        }
////    }
//
//
//    int count = 0;
//
//    public void fire() {
//        count++;
//
//        if (GameWindow.isFirePressJ  && count > 20) {
//            Vector2D bulletPosition = new Vector2D(p.position.x, p.position.y);
//
//
//
//            //position.clone();
//            ;
//
//            bulletPositions.add(bulletPosition);
//            count = 0;
//        }
//
//    }
//
//}
//
//
//
