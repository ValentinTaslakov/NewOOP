package JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String dimension = scanner.nextLine();

        int[] dimensions = toArray(dimension);

        int x = dimensions[0];
        int y = dimensions[1];

        int[][] matrix = new int[x][y];

        int value = 0;

        for (int i = 0; i < x; i++) {

            for (int j = 0; j < y; j++) {

                matrix[i][j] = value++;
            }
        }

        String command = scanner.nextLine();

        int sum = 0;
        while (!command.equals("Let the Force be with you")) {

            int[] coordinatesPeter = toArray(command);

            int peterStartX = coordinatesPeter[0];

            int peterStartY = coordinatesPeter[1];

            int[] coordinatesEvil = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int evilStartX = coordinatesEvil[0];

            int evilStartY = coordinatesEvil[1];

            evilRange(evilStartX, evilStartY, matrix);

            sum = peterCourse(peterStartX, peterStartY, matrix);


            command = scanner.nextLine();
        }

        System.out.println(sum);

    }

    private static int peterCourse(int peterStartX, int peterStartY, int[][] matrix) {
        int sum = 0;
        while (peterStartX >= 0 && peterStartY < matrix[1].length) {

            if (peterStartX >= 0 && peterStartX < matrix.length
                    && peterStartY >= 0
                    && peterStartY < matrix[0].length) {

                sum += matrix[peterStartX][peterStartY];

            }

            peterStartY++;
            peterStartX--;
        }
        return sum;
    }

    private static void evilRange(int X, int Y, int[][] matrix) {

        while (X >= 0 && Y >= 0) {

            if (X >= 0 && X < matrix.length && Y >= 0 && Y < matrix[0].length) {

                matrix[X][Y] = 0;
            }

            X--;
            Y--;
        }
    }

    public static int[] toArray(String string) {
        return Arrays.stream(string
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
