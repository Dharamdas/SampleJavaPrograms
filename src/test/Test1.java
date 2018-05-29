package test;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.max;

public class Test1 {

    public static void main(String[] args) {
          int[] numbers = new int[] {2,5, 10, -5, 0, 25, 35};
         int[] numbers2 = new int[] {5, 10, -5, -2, 0, 25, 35};
         int[] noNegativeNumbers = new int[] {5, 10, 15, 25, 35};
        System.out.println(Test1.getSumOfTwoClosestToZeroElements(numbers));
         System.out.println(Test1.getSumOfTwoClosestToZeroElements(numbers2));
        System.out.println(Test1.getSumOfTwoClosestToZeroElements(noNegativeNumbers));



    }


    public static int getSumOfTwoClosestToZeroElements(int[] a) {
            /*
             Please implement this method to
             return the sum of the two elements closest to zero.
             If there are two elements equally close to zero like -2 and 2,
             consider the positive element to be "closer" to zero than the negative one.
            */
        int[] b = a;
        Arrays.sort(b);
        int negativeValuePlacement = 0;
        int positiveValuePlacement = 0;
        int closestNumberToZero;

        for( int i = 0; i < b.length; i++) {

            if (b[i] <= 0)
            {
                negativeValuePlacement++;
                positiveValuePlacement++;
            }
            if (b[i] == 0)
                positiveValuePlacement++;
        }
        --negativeValuePlacement;

        if (b[0] >= 0)
            closestNumberToZero = b[positiveValuePlacement];
        else
            {

            if ((b[negativeValuePlacement]*-1) < b[positiveValuePlacement])
            {

                closestNumberToZero = (b[negativeValuePlacement]*-1);
            }
            else
                closestNumberToZero = b[positiveValuePlacement];
           }
        return closestNumberToZero;
    }

}
