package vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        VehiclesImpl car = putVehicle(scan);
        VehiclesImpl truck = putVehicle(scan);



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
                        car.refuel(liters);
                    } else {
                        truck.refuel(liters);
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);

//        DecimalFormat format = new DecimalFormat("0.00");
//
//        format.setRoundingMode(RoundingMode.UP);

//        System.out.println("Car: " + format.format(car.getFuelQuantity()));
//        System.out.println("Truck: " + format.format(truck.getFuelQuantity()));

    }

    private static VehiclesImpl putVehicle(Scanner scan) {
        String[] input = scan.nextLine().split("\\s+");
        String name = input[0];
        double fuelQuantity = Double.parseDouble(input[1]);
        double fuelConsumption = Double.parseDouble(input[2]);

        if (name.equals("Car")) {
            return new Car(fuelQuantity, fuelConsumption);
        }
        return new Truck(fuelQuantity, fuelConsumption);
    }
}
