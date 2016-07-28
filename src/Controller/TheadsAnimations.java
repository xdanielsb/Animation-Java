package Controller;

import View.Window;
import model.Animation;

import static java.lang.Thread.sleep;

public class TheadsAnimations extends Thread {

    private Window screen;
    private Animation animation;

    /**
     * 
     * @param screen
     * @param animation 
     */
    public TheadsAnimations(Window screen, Animation animation) {
        this.screen = screen;
        this.animation = animation;
    }
    /**
     * Control the animations in the screen 
     */
    @Override
    public void run() {
        while (true) {
            
            animation.setImg_anima(animation.getPathsAnimations()[animation.getNum_imag_Actual()]);
            animation.setNum_imag_Actual();
            System.out.println(animation.getName());
            screen.repaint();
            try {
                sleep(1000 / animation.getSizeSprint());
            } catch (InterruptedException ex) {
            }
        }
    }

}
