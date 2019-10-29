package program;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameWindow extends JFrame  {
    public static boolean isUpPress; //muon truy cap ko can tao doi tuong=>static
    public static boolean isDownPress;
    public static boolean isLeftPress;
    public static boolean isRightPress;
    public static boolean isFirePressJ;
    public static boolean isChangeBulletNumber;
    public static boolean isFirePressL;
    public static boolean isAnyKeyPress;
    public static boolean isEnterPress;


  public GameWindow()
  {   //this.setVisible(true);
      this.setTitle("Game Touhou");
      //this.setSize(800,600);
      this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//thoat man hinh
      this.setResizable(false);//nguoi dung khong the chinh sua kich thuoc cua so
      this.addKeyListener(new KeyAdapter() {
                              @Override
                              public void keyPressed(KeyEvent e) {
                                  //ham duoc goi khi giu phim
//                                  e.getKeyCode();//cover ca space esc,...
//                                  System.out.println(e.getKeyChar());//chi alphabet
                                  isAnyKeyPress=true;
                                  if(e.getKeyCode()==KeyEvent.VK_W){isUpPress=true;}
                                  if(e.getKeyCode()==KeyEvent.VK_S){isDownPress=true;}
                                  if(e.getKeyCode()==KeyEvent.VK_A){isLeftPress=true;}
                                  if(e.getKeyCode()==KeyEvent.VK_D){isRightPress=true;}
                                  if(e.getKeyCode()==KeyEvent.VK_J){isFirePressJ=true;}
                                  if(e.getKeyCode()==KeyEvent.VK_K) isChangeBulletNumber=true;
                                  if(e.getKeyCode()==KeyEvent.VK_L){isFirePressL=true;}
                                  if(e.getKeyCode()==KeyEvent.VK_ENTER){isEnterPress=true;}
                              }

                              @Override
                              public void keyReleased(KeyEvent e) {
                                  //ham duoc goi khi nha phim
                                 // System.out.println("Key release");
                                  isAnyKeyPress=false;
                                  if(e.getKeyCode()==KeyEvent.VK_W)isUpPress=false;
                                  if(e.getKeyCode()==KeyEvent.VK_S)isDownPress=false;
                                  if(e.getKeyCode()==KeyEvent.VK_A)isLeftPress=false;
                                  if(e.getKeyCode()==KeyEvent.VK_D)isRightPress=false;
                                  if(e.getKeyCode()==KeyEvent.VK_J)isFirePressJ=false;
                                  if(e.getKeyCode()==KeyEvent.VK_K)isChangeBulletNumber=false;
                                  if(e.getKeyCode()==KeyEvent.VK_L){isFirePressL=false;}
                                  if(e.getKeyCode()==KeyEvent.VK_ENTER){isEnterPress=false;}
                              }
                          }
      );
  }

}
