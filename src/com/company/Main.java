package com.company;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File inputImage = new File(args[0]);
        File imageWithNoise = new File(args[1]);
        File filtredImage = new File(args[2]);
        Start.addNoise(inputImage, imageWithNoise, new Integer(args[3]));
        ThresholdFilter.filter(imageWithNoise, filtredImage, new Integer(args[4]), new Integer(args[5]), new Integer(args[6]));
    }
}
