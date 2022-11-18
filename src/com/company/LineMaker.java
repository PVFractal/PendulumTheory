package com.company;

import java.util.ArrayList;

public class LineMaker {

    //Program Settings
    final int ARRAY_SIZE = 100;
    final double IMAGE_SIZE = 1000;

    ArrayList<Double> pointList;
    public void UpdateFile(double timeInterval) {
        FillList();

        MakeData(timeInterval);

    }

    private void MakeData(double timeInterval) {
        for (double point : pointList) {
            double percentage = point / ARRAY_SIZE;




        }
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
