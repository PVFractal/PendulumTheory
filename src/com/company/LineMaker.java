package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class LineMaker {

    //Program Settings
    final int ARRAY_SIZE = 100;
    final double IMAGE_SIZE = 1000;
    final double MAX_SWING = IMAGE_SIZE*0.4;


    Writer wr;
    ArrayList<Double> pointList;
    public void UpdateFile(double timeInterval) {
        FillList();

        MakeData(timeInterval);

    }

    private void MakeData(double timeInterval) {
        try {
            wr = new FileWriter("LineFractal.txt");
        }
        catch(IOException e) {
            System.out.println("Nothing found");
        }

        for (double point : pointList) {
            double percentage = point / ARRAY_SIZE;
            double sinVal = SinValue(percentage, timeInterval);
            try {
                wr.write(sinVal + "\n");
            }
            catch(IOException e) {
                System.out.println("Didn't write");
            }
        }

        try {
            wr.close();
        }
        catch(IOException e) {
            System.out.println("Nothing found");
        }


    }

    private double SinValue(double percentage, double timeInterval) {
        double multiplier = 1.0 + (percentage/10.0);
        double pureSin = Math.sin(multiplier*timeInterval);
        pureSin *= MAX_SWING;
        pureSin += IMAGE_SIZE/2.0;
        return pureSin;
    }

    private void FillList() {
        pointList = new ArrayList<>(ARRAY_SIZE);
        for (int i = 0; i < ARRAY_SIZE; i++) {
            Double iVal = (double)i;
            Double percentage = iVal / (double)ARRAY_SIZE;
            pointList.add(percentage*IMAGE_SIZE);
        }
    }
}
