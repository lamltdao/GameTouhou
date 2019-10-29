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
//public class Bullet2 {
//
//
//    BufferedImage image;
//
//
//    //Vector2D position;
//    ArrayList<Vector2D> bulletPositions;
//    Player p;
//
//    public Bullet2(Player p) {
//        //  position=new Vector2D(300,300);
//        // image1 = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
//        bulletPositions = new ArrayList<>();
//        this.p = p;
//        image = SpriteUtils.loadImage("assets/images/enemies/explosion-big/2.png");
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
//        this.runK();
//        this.fire();
//
//    }
//
//    public void runK() {
//        for (int i = 0; i < bulletPositions.size(); i++) {
//            Vector2D bulletPosition = bulletPositions.get(i);
////            for (int j = 0; j < bulletPositions.size(); j++) {
//            bulletPosition.setX(Mathx.clamp(bulletPosition.x,0,384-32));
//            bulletPosition.setY(Mathx.clamp(bulletPosition.y,0,600-48));
//            if(bulletPosition.x==0||bulletPosition.x==384-32)bulletPosition.x=-100;
//            if(bulletPosition.y==0||bulletPosition.y==600-48)bulletPosition.y=600-48+100;
//                bulletPosition.setAngle(bulletPosition.getAngle() + Math.PI / 30);
//
//                //}
//
//
//                // }
//
//
//            //}
//        }
//    }
//        int count = 0;
//    public void fire(){
//            count++;
//
//            if (GameWindow.isFirePressK && count > 20) {
//                Vector2D bulletPosition = new Vector2D(p.position.x, p.position.y);
//
//                //position.clone();
//                ;
//
//                bulletPositions.add(bulletPosition);
//                count = 0;
//            }
//
//        }
//
//
//    }
//
//
