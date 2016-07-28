package View;

import Controller.AnimationController;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Window extends JFrame implements MouseMotionListener, KeyListener {

    private AnimationController gest;
    private BufferStrategy myBuffer;

    public Window(AnimationController gest) {
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.gest = gest;
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.createBufferStrategy(2);
        myBuffer = this.getBufferStrategy();
        this.repaint();
        
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = null;
        if (myBuffer != null) {
            g2 = (Graphics2D) myBuffer.getDrawGraphics();
            g2.clearRect(0, 0, 800, 800);
            this.drawImages(g2);
            myBuffer.show();
        }
    }

    public void drawImages(Graphics2D g) {
        g.drawImage(gest.getHeroe().getImg_anima(), gest.getHeroe().getPosX(), gest.getHeroe().getPosY(), this);
        g.drawImage(gest.getApple().getImg_anima(), gest.getApple().getPosX(), gest.getApple().getPosY(), this);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (gest.getHeroe() != null && gest != null) {
            gest.getHeroe().setPosX(e.getX());
            gest.getHeroe().setPosY(e.getY());
            gest.verificar();
        }

    }

    public AnimationController getGest() {
        return gest;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == 37) {
            System.out.println("izquierda");
            gest.getApple().setPosX(gest.getApple().getPosX() - 10);
        }
        if (e.getKeyCode() == 38) {
            System.out.println("arriba ");
            gest.getApple().setPosY(gest.getApple().getPosY() - 10);
        }
        if (e.getKeyCode() == 39) {
            gest.getApple().setPosX(gest.getApple().getPosX() + 10);
            System.out.println("derecha");
        }
        if (e.getKeyCode() == 40) {
            System.out.println("abajo");
            gest.getApple().setPosY(gest.getApple().getPosY() + 10);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
