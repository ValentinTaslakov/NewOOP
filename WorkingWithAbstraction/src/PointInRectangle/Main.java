package PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

import static PointInRectangle.Point.createPoint;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int[] pointCoordinates = readArray(scan);

        Point bottomLeft = createPoint(pointCoordinates[0] , pointCoordinates[1]);
        Point topRight = createPoint(pointCoordinates[2] , pointCoordinates[3]);

        Rectangle rectangle = new Rectangle(bottomLeft , topRight);

        int pointsToCheck = Integer.parseInt(scan.nextLine());

        while (pointsToCheck -- > 0){

            int[] inputData = readArray(scan);

            Point checkingPoint = createPoint(inputData[0] , inputData[1]);

            boolean isInside = rectangle.isInside(checkingPoint);

            System.out.println(isInside);
        }


    }

    private static int[] readArray(Scanner scan) {

        return Arrays
                .stream(scan.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
