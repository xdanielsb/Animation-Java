package View;

import Controller.AnimationController;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JFrame;
import model.Animation;

/**
 *
 * @author Daniel
 */
public class Window extends JFrame implements MouseMotionListener, KeyListener {

    private AnimationController controller;
    private BufferStrategy myBuffer;
    private static final int widthWindow = 800, heightWindow = 800;

    public Window(AnimationController aux) {
        this.controller = aux;

        //Add listeners
        this.addMouseMotionListener(this);
        this.addKeyListener(this);

        //Add properties
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.createBufferStrategy(2);
        this.setSize(widthWindow, heightWindow);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        myBuffer = this.getBufferStrategy();
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = null;
        if (myBuffer != null) {
            g2 = (Graphics2D) myBuffer.getDrawGraphics();
            g2.clearRect(0, 0, widthWindow, heightWindow);
            this.drawImages(g2);
            myBuffer.show();
        }
    }
    /**
     * draw the images
     * @param g 
     */
    public void drawImages(Graphics2D g) {
        ArrayList<Animation> animations= controller.getAnimations();
        for (Animation animation: animations) {
            Image image = animation.getImg_anima();
            int posX = animation.getPosX();
            int posY = animation.getPosY();
            g.drawImage(image, posX, posY,this);
        }
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (controller.getHeroe() != null && controller != null) {
            controller.getHeroe().setPosX(e.getX());
            controller.getHeroe().setPosY(e.getY());
            controller.checkCollision();
        }

    }

    public AnimationController getGest() {
        return controller;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == 37) {
            System.out.println("izquierda");
            controller.getApple().setPosX(controller.getApple().getPosX() - 10);
        }
        if (e.getKeyCode() == 38) {
            System.out.println("arriba ");
            controller.getApple().setPosY(controller.getApple().getPosY() - 10);
        }
        if (e.getKeyCode() == 39) {
            controller.getApple().setPosX(controller.getApple().getPosX() + 10);
            System.out.println("derecha");
        }
        if (e.getKeyCode() == 40) {
            System.out.println("abajo");
            controller.getApple().setPosY(controller.getApple().getPosY() + 10);
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
