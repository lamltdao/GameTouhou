package program;

import static java.lang.StrictMath.*;

public class Vector2D {
   public double x;
   public double y;
   public Vector2D(double x,double y)
   {
       this.x=x;
       this.y=y;
   }
   public Vector2D()
    {
        this(0,0);

    }
//   public Vector2D(double x){
//       this(x,0);
//   }
    public void add(double x,double y){
       this.x+=x;
       this.y+=y;
    }

    public void add(Vector2D other){
       this.add(other.x,other.y);
    }//overload add()
    public void subtract(double x,double y){
       this.x-=x;
       this.y-=y;
    }
    public void subtract(Vector2D other){
       this.subtract(other.x,other.y);
    }
    public void scale(double rate){
       this.x*=rate;
       this.y*=rate;

    }
    public Vector2D clone(){
       Vector2D newVector=new Vector2D(this.x,this.y);
       return newVector;
       //return new Vector2D(this.x,this.y);
    }
    public double getLength(){
       return sqrt(x*x+y*y);

    }
    public void setLength(double length){
      double currentLength=this.getLength();
        if(currentLength!=0){
        x*=length/currentLength;
        y*=length/currentLength;}
    }
    public double getAngle(){

      return Math.atan(y/x);//x=0 vx ko sao
    }
    public void setAngle(double angle){
       double length=this.getLength();
       x=length*cos(angle);
       y=length*sin(angle);
    }
    @Override
    public String toString() {
        return "(x:"+x+";y:"+y+")";
    }
    public void setX(double x){
       this.x=x;
    }

    public void setY(double y) {
//        System.out.println(y);//giup kiem soat y đầu vào
       this.y = y;
    }

    public void set(double x,double y){
       this.x=x;
       this.y=y;
    }
    public  void set(Vector2D other){
       other.set(other.x,other.y);
    }
//get() tương tự
    public  double  getX(){return x;}

    public   double getY() {
        return y;
    }

    public static void main(String[] args){
        Vector2D v1=new Vector2D(3,3);
//        System.out.println(v1.getLength());
//        System.out.println(v1.getAngle());
        v1.setLength(10);
//        System.out.println(v1.getLength());
        v1.setAngle(2*PI/3);
//        System.out.println(v1.getAngle());
    }
}

