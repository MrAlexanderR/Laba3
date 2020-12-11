package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Start {

    public static void addNoise(File image, File output, Integer lvl){
        BufferedImage sourceImage = null;
        try {
            sourceImage = ImageIO.read(image);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        int generate = ( (sourceImage.getHeight() * sourceImage.getWidth()) / 100) * lvl;
        Random randomRow = new Random();
        Random randomCol = new Random();
        for(int i=0; i < generate; i++) {
            Color noise = new Color(255,255,255);
            sourceImage.setRGB(randomRow.nextInt(sourceImage.getWidth()), randomCol.nextInt(sourceImage.getHeight()), noise.getRGB());
        }
        try {
            ImageIO.write(sourceImage, "bmp", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
