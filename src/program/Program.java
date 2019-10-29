package program;
//import javax.scene.layout.Background;
import program.player.Player;

import javax.swing.*;
//import program.People;

import java.awt.*;
import java.util.ArrayList;

import static java.awt.Color.*;

/**
 * Created by huynq on 7/4/17.
 */
public class Program {
    public static void main(String[] args) {
        GamePanel gamePanel = new GamePanel();
        GameWindow window = new GameWindow();
        gamePanel.setPreferredSize(new Dimension(Settings.GAME_WIDTH,Settings.GAME_HEIGHT));//setPreferedzize cho gamepanel
        window.add(gamePanel);
        window.pack();
        gamePanel.setBackground(BLACK);
        window.setVisible(true);
        gamePanel.gameLoop();
    }
}
