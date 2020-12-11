package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ThresholdFilter {

    public static void filter(File image, File output, Integer n, Integer x, Integer y){
        int[] masi =  new int[n*2];
        int[] masj =  new int[n*2];
        int[] mass =  new int[n*2];
        int[] mas  =  new int[n*2];

        BufferedImage sourceImage = null;
        try {
            sourceImage = ImageIO.read(image);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        int Width = sourceImage.getWidth();
        int Height = sourceImage.getHeight();
        BufferedImage outputPicture = new BufferedImage(Width, Height, sourceImage.getType());
        int colorSum = 0;
        int red = 0;
        int green = 0;
        int blue = 0;
        int col = 0;
        int row = 0;
        int k = 0;
        int q = 0;
        for(int j = y - 1; j < Height - (n - y); j++){
            for(int i = x - 1; i < Width - (n - x); i++){
                for(col = i - (x -1); col < i - (x -1) + n; col++) {
                    row = j;
                    masi[k] = col;
                    masj[k] = row;
                    Color color = new Color(sourceImage.getRGB(row, col));
                    colorSum = (color.getRed() + color.getGreen() + color.getBlue());
                    mass[k] = colorSum;
                     mas[k] = colorSum;
                    k++;
                }
                for(row = j - (y -1); row < j - (y -1) + n; row++) {
                    col = i;
                    masi[k] = col;
                    masj[k] = row;
                    Color color = new Color(sourceImage.getRGB(row, col));
                    colorSum = (color.getRed() + color.getGreen() + color.getBlue());
                    mass[k] = colorSum;
                    mas[k] = colorSum;
                    k++;
                }
                Arrays.sort(mass);
                k = 0;
                q = mass[((n-1)/2+1)];
                while (mas[k]!=q) {
                    k++;
                }
                Color newColor = new Color(sourceImage.getRGB(masj[k], masi[k]));
                sourceImage.setRGB(j, i, newColor.getRGB());
                k = 0;
            }
        }
        try {
            ImageIO.write(sourceImage, "bmp", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
