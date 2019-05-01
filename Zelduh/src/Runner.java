//Import statements

import java.awt.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Map;

import javax.swing.*;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;


public class Runner{
    private JPanel panel;
    private ZeldaGame game = new ZeldaGame();
    private Timer timer;
    private int ticks;

    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int WIDTH = (int) (screenSize.getWidth()*3/4), HEIGHT = (int) (screenSize.getHeight()*3/4);
    private static final int REFRESH_RATE = 10;

    public Runner(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run(){
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    start();
                }catch (ClassNotFoundException | InstantiationException | IllegalAccessException| UnsupportedLookAndFeelException ex){
                }
            }
        });
    }

    public static void main(String[] args) {new Runner();}

    private void start() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel(){
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGame(g);
            }
        };
    }
}