package model;

import Controller.Ejecucion;
import View.Window;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Animation {

    private String name_Animac;
    private int Size_Sprint;
    private String[] Adress_Imagenes;
    private int posX;
    private int posY;
    private Image img_anima;
    private int num_imag_Actual;
    private Window Ventana;
    private Ejecucion acciones;

    public Animation(String nombre, int tam, Window ventana) {
        this.name_Animac = nombre;
        this.Size_Sprint = tam;
        this.Ventana = ventana;
        this.posX = 0;
        this.posY = 0;
        this.num_imag_Actual = 0;
        this.img_anima = null;
        Adress_Imagenes = new String[Size_Sprint];
        acciones = new Ejecucion(ventana, this);
        acciones.start();
        this.cargarDirImagenes(nombre, Size_Sprint);
    }

    public void cargarDirImagenes(String nombre, int tam) {
        System.out.println(nombre);
        for (int i = 0; i < Size_Sprint; i++) {
            if (i < 10) {
                Adress_Imagenes[i] = "./imagenes/" + nombre + "_000" + i + ".png";
            }
            if (i >= 10) {
                Adress_Imagenes[i] = "./imagenes/" + nombre + "_00" + i + ".png";
            }
        }
    }

    public String getNombreAnimacion() {
        return name_Animac;
    }

    public String[] getDirImagenes() {
        return Adress_Imagenes;
    }

    public int getTamanospri() {
        return Size_Sprint;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Image getImg_anima() {
        return img_anima;
    }

    public void setImg_anima(String dir_img_anima) {
        //img_anima = Toolkit.getDefaultToolkit().getImage(dir_img_anima);
        try {
            if (dir_img_anima!=null) {
                 img_anima = ImageIO.read(new File(dir_img_anima));
            }          
        } catch (IOException ex) {

        }
    }

    public int getNum_imag_Actual() {
        return num_imag_Actual;
    }

    public void setNum_imag_Actual() {

        if (num_imag_Actual == Size_Sprint - 1) {
            num_imag_Actual = 0;
            System.out.println("Entro");
        }
        num_imag_Actual++;
    }

}
