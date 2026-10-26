package laohan.test.event_;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author wb
 * @date 2026/6/10 16:57
 */
public class BallMove extends JFrame  {
    MyPanel mp=null;
    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove(){
        mp=new MyPanel();
        this.add(mp);
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


}


class MyPanel extends JPanel implements KeyListener{

    int x=10;
    int y=10;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.red);
        g.fillOval(x,y,20,20);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println((char)e.getKeyCode()+"被按下");
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;
        }else if (e.getKeyCode()==KeyEvent.VK_UP){
            y--;
        } else if (e.getKeyCode()==KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
            x++;
        }

        this.repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

}