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
import java.util.ConcurrentModificationException;
import javax.swing.JFrame;
import model.Animation;

/**
 *
 * @author Daniel
 */
public class Window extends JFrame implements MouseMotionListener, KeyListener {

    private AnimationController controller;
    private BufferStrategy myBuffer;
    private static final int widthWindow = 800, heightWindow = 400;

    public Window(AnimationController aux) {
        this.controller = aux;

        //Add listeners
        this.addMouseMotionListener(this);
        this.addKeyListener(this);

        //Add properties
        this.setVisible(true);
        
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
            try {
                this.drawImages(g2);
            } catch (ConcurrentModificationException ex) {

            }
            myBuffer.show();
        }
    }

    /**
     * draw the images
     *
     * @param g
     */
    public void drawImages(Graphics2D g) {
        ArrayList<Animation> animations = controller.getAnimations();
        for (Animation animation : animations) {
            Image image = animation.getImg_anima();
            int posX = animation.getPosX();
            int posY = animation.getPosY();
            g.drawImage(image, posX, posY, this);
        }

    }

    /**
     * Method for move the hero with the mouse
     *
     * @param e
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        Animation hero = controller.getAnimation("fly");
        hero.setPosX(e.getX());
        hero.setPosY(e.getY());
        controller.checkCollision();
    }

    /**
     * Control the events of the key
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        Animation apple = controller.getAnimation("apple");
        int posX = apple.getPosX();
        int posY = apple.getPosY();
        if (e.getKeyCode() == 37) {//Left
            apple.setPosX(posX - 10);
        }
        if (e.getKeyCode() == 38) {//Up
            apple.setPosY(posY - 10);
        }
        if (e.getKeyCode() == 39) {//Rigth
            apple.setPosX(posX + 10);
        }
        if (e.getKeyCode() == 40) {//Down
            apple.setPosY(posY + 10);
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

    public AnimationController getGest() {
        return controller;
    }

}
