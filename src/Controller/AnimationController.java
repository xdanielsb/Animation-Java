package Controller;

import View.Window;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Animation;

public class AnimationController extends Thread {

    private Window windowAnimations;
    private ArrayList<Animation> animations;

    /**
     * Construtor Initialize the window
     */
    public AnimationController() {
        this.windowAnimations = new Window(this);
        this.animations = new ArrayList<>();
        //Create the animation of the app
        animations.add(createAnimations("fly", 20));
        animations.add(createAnimations("apple", 4));

    }

    /**
     * Create the animations
     *
     * @param nameHero
     * @param numberImages
     * @return
     */
    public Animation createAnimations(String nameHero, int numberImages) {
        Animation animation = new Animation(nameHero, numberImages, windowAnimations);
        animation.setPosY(50);
        animation.setPosX(150);
        return animation;
    }

    /**
     * Method for checking the collision among the animations
     * Note: Change the range  of the width and height of the images
     * for being more accurate of the colliision
     */
    
    public void checkCollision() {
        for (Animation animation_origin : animations) {
            for (Animation animation_destiny : animations) {
                if (animation_origin.getPosX()==animation_destiny.getPosX() 
                && animation_destiny.getPosY() == animation_origin.getPosY()) {
                    
                }
            }
        }
        
    }

    public Animation getHeroe() {
        return hero;
    }

    public Animation getApple() {
        return apple;
    }

}
