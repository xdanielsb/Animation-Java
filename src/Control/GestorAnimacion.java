
package Control;

import View.Window;
import javax.swing.JOptionPane;
import model.animacion;

public class GestorAnimacion extends Thread {

  //  private Thread hiloPrincipal;
    private Window ventAccion;
    private animacion heroe;
    private animacion apple;

    public GestorAnimacion() {
        this.ventAccion = new Window(this);
        this.createAnimacions();
    }

    public void createAnimacions() {
        this.heroe = new animacion("fly", 20, ventAccion);
        this.apple = new animacion("apple", 4, ventAccion);
        apple.setPosY(50);
        apple.setPosX(150);
    }

  

    public animacion getHeroe() {
        return heroe;
    }

    public animacion getApple() {
        return apple;
    }

    public void verificar() {
        if (apple.getPosX() == heroe.getPosX() && apple.getPosY() == heroe.getPosY()) {
            System.out.println("Se han encontrado");
            JOptionPane.showMessageDialog(null, "Felicitaciones a Cogido la Manzana");
        }
    }



}
