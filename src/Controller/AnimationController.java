package Controller;

import View.Window;
import javax.swing.JOptionPane;
import model.Animation;

public class AnimationController extends Thread {

    private Window windowAnimations;
    private Animation hero;
    private Animation apple;

    /**
     * Construtor Initialize the window
     */
    public AnimationController() {
        this.windowAnimations = new Window(this);
        this.hero = this.createAnimations("fly", 20);
        this.apple = this.createAnimations("apple", 4);
        apple.setPosY(50);
        apple.setPosX(150);
    }

    public Animation createAnimations(String nameHero, int numberImages) {
        return new Animation(nameHero, numberImages, windowAnimations);
    }

    public void verificar() {
        if (apple.getPosX() == hero.getPosX() && apple.getPosY() == hero.getPosY()) {
            System.out.println("Se han encontrado");
            JOptionPane.showMessageDialog(null, "Felicitaciones a Cogido la Manzana");
        }
    }

    public Animation getHeroe() {
        return hero;
    }

    public Animation getApple() {
        return apple;
    }

}
