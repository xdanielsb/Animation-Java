package Control;

import View.Window;
import model.animacion;

import static java.lang.Thread.sleep;

public class Ejecucion extends Thread {

    private Window Ventana;
    private animacion animado;

    public Ejecucion(Window ventana, animacion personaje) {
        this.Ventana = ventana;
        this.animado = personaje;
    }

    @Override
    public void run() {
        while (true) {
            animado.setImg_anima(animado.getDirImagenes()[animado.getNum_imag_Actual()]);
            animado.setNum_imag_Actual();
            
            System.out.println(animado.getNombreAnimacion());
            Ventana.repaint();
            try {
                sleep(1000 / animado.getTamanospri());
            } catch (InterruptedException ex) {            
            }
        }

    }

}
