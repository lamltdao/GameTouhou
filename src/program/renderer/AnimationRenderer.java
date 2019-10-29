package program.renderer;

import program.GameObject;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;

public class AnimationRenderer extends Renderer {
    ArrayList<BufferedImage>images;
    int currentImageIndex;
    int count=0;
    public AnimationRenderer(String directoryPath){
        images= SpriteUtils.loadImages(directoryPath);
        currentImageIndex=0;
    }
    @Override
    public void render(Graphics g, GameObject master) {
        BufferedImage currentImage=images.get(currentImageIndex);
        g.drawImage(currentImage,
                    (int)(master.position.x-master.anchor.x*currentImage.getWidth()),
                    (int)(master.position.y-master.anchor.y*currentImage.getHeight()),
                null);
        count++;
        if(count>5){
            currentImageIndex++;
            if(currentImageIndex>=images.size())currentImageIndex=0;
            count=0;
        }


      //  if(master.hitbox!=null)this.drawHitBox(g,master);
    }

    private void drawHitBox(Graphics g, GameObject master) {
//        System.out.println("Enemy"+(int)master.position.x+" "+(int)master.position.y);
//        System.out.println("BOX"+(int)master.hitbox.left()+" "+(int)master.hitbox.top());
        g.setColor(Color.PINK);
        g.drawRect(
            (int)master.hitbox.left(),
            (int)master.hitbox.top(),
            master.hitbox.width,
            master.hitbox.height
    );
    }

}
