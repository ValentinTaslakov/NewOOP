package vehicles2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] inputCar = scan.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(inputCar[1])
                ,Double.parseDouble(inputCar[2]));

        String[] inputTruck = scan.nextLine().split("\\s+");

        Truck truck = new Truck(Double.parseDouble(inputTruck[1])
                ,Double.parseDouble(inputTruck[2]));


        int numberOfCommands = Integer.parseInt(scan.nextLine());

        while (numberOfCommands-- > 0) {
            String[] commands = scan.nextLine().split("\\s+");

            String command = commands[0];
            String vehicleType = commands[1];

            switch (command) {
                case "Drive":
                    double distance = Double.parseDouble(commands[2]);
                    if (vehicleType.equals("Car")) {
                        System.out.println(car.driving(distance));
                    } else {
                        System.out.println(truck.driving(distance));
                    }
                    break;
                case "Refuel":
                    double liters = Double.parseDouble(commands[2]);
                    if (vehicleType.equals("Car")) {
                        car.refueling(liters);
                    } else {
                        truck.refueling(liters);
                    }
                    break;
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());

//        DecimalFormat format = new DecimalFormat("0.00");
//
//        format.setRoundingMode(RoundingMode.UP);

//        System.out.println("Car: " + format.format(car.getFuelQuantity()));
//        System.out.println("Truck: " + format.format(truck.getFuelQuantity()));

    }

}

