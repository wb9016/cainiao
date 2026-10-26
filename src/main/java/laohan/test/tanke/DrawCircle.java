package laohan.test.tanke;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Scanner;
import java.util.Vector;

/**
 * @author wb
 * @date 2026/6/10 14:52
 */
public class DrawCircle extends JFrame{
    private MyPanel mp=null;
    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle(){
        mp=new MyPanel();
        this.add(mp);
        Thread thread = new Thread(mp);
        thread.start();
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

//class MyPanel extends JPanel{
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//        g.drawOval(10,10,100,100);
//
//        //测试
////        g.drawLine(10,10,110,110);
//
////        g.drawRect(10,10,100,100);
//
////        g.setColor(Color.green);
////        g.fillRect(10,10,100,100);
////            g.fillOval(10,10,100,100);
//
//        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("61.jpg"));
//        g.drawImage(image,10,10,1200,1600,this);
//
//    }
//}

class MyPanel extends JPanel implements KeyListener, Runnable{

    Hero hero=null;
    Vector<Enemy> enemyTanks=new Vector<>();
    int enemyTankSize=3;
    public MyPanel() {

        Scanner scanner = new Scanner(System.in);
//        System.out.print("输入坦克速度：");
        int speed=3;
        hero = new Hero(100, 400);
        hero.setSpeed(speed);
        for (int i = 0; i < enemyTankSize; i++) {
            Enemy enemy = new Enemy((i + 1) * 100, 60);
            enemy.setSpeed(speed);
            enemy.setDirect(2);
            enemyTanks.add(enemy);
        }

     }
    @Override
    public void paint(Graphics g) {
        super.paint(g); // 必须保留，用来清屏

//        g.drawOval(10, 10, 100, 100);
//
//        java.net.URL url = MyPanel.class.getResource("/61.jpg");
//        if (url != null) {
//            Image image = Toolkit.getDefaultToolkit().getImage(url);
//            g.drawImage(image, 10, 10, 1200, 1600, this);
//        }

//        g.setColor(Color.red);
//        g.setFont(new Font("宋体", Font.BOLD, 24));
//
//        g.drawString("wb 牛逼", 50, 50);

//        g.drawRect(20,0,100,750);
        //画出坦克
        drawTank(hero.getX(),hero.getY(),g,hero.getDirect(),0);

        //画出子弹
        if (hero.shot!=null&&hero.shot.isLive==true){
//            System.out.println("绘制子弹");
            g.draw3DRect(hero.shot.x,hero.shot.y,1,1,false);
        }

        for (int i=0;i<enemyTanks.size();i++){
            Enemy enemy = enemyTanks.get(i);
            drawTank(enemy.getX(),enemy.getY(),g,enemy.getDirect(),1);
        }
//        drawTank(hero.getX()+100,hero.getY(),g,hero.getDirect(),1);
//        drawTank(hero.getX()+200,hero.getY(),g,hero.getDirect(),1);
//        drawTank(hero.getX()+300,hero.getY(),g,hero.getDirect(),1);

    }

    /**
     *
     * @param x 左上角坐标
     * @param y 左上角y坐标
     * @param g 画笔
     * @param direct 方向
     * @param type 类型
     */
    public void drawTank(int x,int y,Graphics g,int direct,int type){
        switch (type){
            case 0:
                g.setColor(Color.red);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }

        //direct 0上 1右 2下 3左
        switch (direct){
            case 0:
                g.fill3DRect(x-20,y-30,10,60,false);//左履带
                g.fill3DRect(x+10,y-30,10,60,false);//右履带
                g.fill3DRect(x-10,y-20,20,40,false);
                g.fillOval(x-10,y-10,20,20);
                g.drawLine(x,y-30,x,y);
                break;
            case 1:
                g.fill3DRect(x-30,y-20,60,10,false);//上履带
                g.fill3DRect(x-30,y+10,60,10,false);//下履带
                g.fill3DRect(x-20,y-10,40,20,false);
                g.fillOval(x-10,y-10,20,20);
                g.drawLine(x,y,x+30,y);
                break;
            case 2:
                g.fill3DRect(x-20,y-30,10,60,false);//左履带
                g.fill3DRect(x+10,y-30,10,60,false);//右履带
                g.fill3DRect(x-10,y-20,20,40,false);
                g.fillOval(x-10,y-10,20,20);
                g.drawLine(x,y+30,x,y);
                break;
            case 3:
                g.fill3DRect(x-30,y-20,60,10,false);//上履带
                g.fill3DRect(x-30,y+10,60,10,false);//下履带
                g.fill3DRect(x-20,y-10,40,20,false);
                g.fillOval(x-10,y-10,20,20);
                g.drawLine(x-30,y,x,y);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_W)
        {
            hero.setDirect(0);
            hero.moveUp();
        } else if (e.getKeyCode()==KeyEvent.VK_D) {
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode()==KeyEvent.VK_S) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode()==KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.moveLeft();
        }

        if (e.getKeyCode()==KeyEvent.VK_J){
            hero.shotEnemy();
        }

        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.repaint();
        }
    }
}



class Hero extends Tank{
    Shot shot=null;

    public Hero(int x, int y) {
        super(x, y);
    }

    public Hero(int x, int y, int direct) {
        super(x, y, direct);
    }

    public void shotEnemy(){
        switch (getDirect()){
            case 0:
                shot = new Shot(getX(),getY()-30,0);
                break;
            case 1:
                shot = new Shot(getX()+30,getY(),1);
                break;
            case 2:
                shot = new Shot(getX(),getY()+30,2);
                break;
            case 3:
                shot = new Shot(getX()-30,getY(),3);
                break;
        }

        //启动射击线程
        new Thread(shot).start();
    }
}

class Enemy extends Tank{

    public Enemy(int x, int y) {
        super(x, y);
    }

    public Enemy(int x, int y, int direct) {
        super(x, y, direct);
    }
}


class Shot implements Runnable{
    //x坐标
    int x;
    //y坐标
    int y;
    //方向
    int direct=0;
    //速度
    int speed = 2;
    //子弹是否存活
    boolean isLive=true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            switch (direct){
                case 0://上
                    y-=speed;
                    break;
                case 1://右
                    x+=speed;
                    break;
                case 2://下
                    y+=speed;
                    break;
                case 3://左
                    x-=speed;
                    break;
            }

            System.out.println("子弹坐标：("+x+","+y+")");
            //如果子弹到达边界，消失
            if (!(x>=0&&x<=1000&&y>=0&&y<=750)){
                isLive=false;
                break;
            }
        }
    }

}