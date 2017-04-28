package model;

import Controller.TheadsAnimations;
import View.Window;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Animation {

    private String name;
    private int sizeSprint;
    private String[] pathsImages;
    private int posX;
    private int posY;
    private Image currentImage;
    private int numCurrentImage;
    private Window window;
    private TheadsAnimations actions;

    public Animation(String nombre, int tam, Window ventana) {
        System.out.println("Creating the animation"+ nombre);
        this.name = nombre;
        this.sizeSprint = tam;
        this.window = ventana;
        this.posX = 50;
        this.posY = 150;
        this.numCurrentImage = 0;
        pathsImages = new String[sizeSprint];
        actions = new TheadsAnimations(ventana, this);
        loadpathsImagesAnimation(nombre, sizeSprint);
        actions.start();

    }

    public void loadpathsImagesAnimation(String nombre, int tam) {
        for (int i = 0; i < sizeSprint; i++) {
            pathsImages[i] = (i < 10) ? "../imagenes/" + nombre + "_000" + i + ".png" : "../imagenes/" + nombre + "_00" + i + ".png";
            System.out.println(pathsImages[i]);
        }
    }

    public void setImage(String dir_img_anima) {
        //img_anima = Toolkit.getDefaultToolkit().getImage(dir_img_anima);
        try {
            currentImage = ImageIO.read(new File(dir_img_anima));
        } catch (IOException ex) {
        }
    }


    public void setNumCurrentImage() {
        numCurrentImage++ ;
        numCurrentImage%=sizeSprint;
    }


    public int getNumCurrentImage() {
        return numCurrentImage;
    }

    public String getName() {
        return name;
    }

    public String[] getPathsAnimations() {
        return pathsImages;
    }

    public int getSizeSprint() {
        return sizeSprint;
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
        return currentImage;
    }

}
