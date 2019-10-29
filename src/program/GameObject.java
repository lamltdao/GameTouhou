package program;

import program.physics.BoxCollider;
import program.renderer.Renderer;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GameObject {
    //static ~ quan ly doi tuong
    public static ArrayList<GameObject> objects =new ArrayList<>();
    public static ArrayList<GameObject> topLayer =new ArrayList<>();
    public static ArrayList<GameObject> midLayer =new ArrayList<>();
    public static ArrayList<GameObject> botLayer =new ArrayList<>();
    public static int score;
    public static void addNew(GameObject object){objects.add(object);}

    public static <E extends GameObject> E recycle(Class<E> cls){
        E object= findDeactive(cls);
        if(object!=null)
        {
        object.reset();
        return object;
        }

        try{
            object=cls.getConstructor().newInstance();
            return object;
        } catch(Exception ex){
            return null;
        }
    }
    public static<E extends GameObject> E findDeactive(Class<E> cls){
        for(int i=0;i<objects.size();i++){
            GameObject object=objects.get(i);
            if(!object.active&&object.getClass().isAssignableFrom(cls)){
                return(E) object;
            }

        }
        return null;
    }

    public static<E extends GameObject> E findActive(Class<E> cls){
        for(int i=0;i<objects.size();i++){
            GameObject object=objects.get(i);
            if(object.active&&object.getClass().isAssignableFrom(cls)){
                return(E) object;
            }

        }
        return null;
    }

    public static<E extends GameObject> E findIntersect(Class<E> cls,BoxCollider hitbox){
        for(int i=0;i<objects.size();i++){
            GameObject object=objects.get(i);
            if(object.active
                    &&object.getClass().isAssignableFrom(cls)
                    &&object.hitbox!=null
                    &&object.hitbox.intersects(hitbox))return (E) object;
        }
        return  null;
    }

    public static void clearAll() {
        objects.clear();
        topLayer.clear();
        midLayer.clear();
        botLayer.clear();

    }

    //non-static~dinh nghia doi tuong
    //public BufferedImage image;
    public Renderer renderer;
    public Vector2D position;
    public Vector2D velocity;
    public boolean active;
    public BoxCollider hitbox;//=null
    public Vector2D anchor;


    public GameObject(){
        objects.add(this);
        position=new Vector2D();
        velocity=new Vector2D();
        active=true;
        anchor=new Vector2D(0.5,0.5);

    }
    public void render(Graphics g){
        //if(image!=null)g.drawImage(image,(int)position.x,(int)position.y,null);
        if(renderer!=null)renderer.render(g,this);
    }

    public void run(){
        //position.add(velocity.x,velocity.y);
        position.add(velocity);

    }

    public void renderAll(Graphics g){
        for(int i=0;i<botLayer.size();i++){
            GameObject gameObject=botLayer.get(i);
            if(gameObject.active){
                gameObject.render(g);
            }
        }
        for(int i=0;i<midLayer.size();i++){
            GameObject gameObject=botLayer.get(i);
            if(gameObject.active){
                gameObject.render(g);
            }
        }
        for(int i=0;i<topLayer.size();i++){
            GameObject gameObject=botLayer.get(i);
            if(gameObject.active){
                gameObject.render(g);
            }
        }
    }



    public void deactive(){
        active=false;
    }

    public void reset(){
        active=true;
    }
}
