package vehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        VehiclesImpl car = null;
        VehiclesImpl truck = null;
        VehiclesImpl bus = null;

        try {
             car = putVehicle(scan);
             truck = putVehicle(scan);
             bus = putVehicle(scan);

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


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
                    } else if (vehicleType.equals("Truck")){
                        System.out.println(truck.driving(distance));
                    }else {
                        BusDriving busDriving = (BusDriving) bus;
                        System.out.println(busDriving.driveWithPeople((distance)));
                    }
                    break;
                case "DriveEmpty":
                    distance = Double.parseDouble(commands[2]);
                    BusDriving busDriving = (BusDriving) bus;
                    System.out.println(busDriving.driveWithoutPeople(distance));
                    break;
                case "Refuel":
                    try {
                        double liters = Double.parseDouble(commands[2]);
                        if (vehicleType.equals("Car")) {
                            car.refuel(liters);
                        } else if (vehicleType.equals("Truck")){
                            truck.refuel(liters);
                        }else {
                            bus.refuel(liters);
                        }
                        break;
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);


    }

    private static VehiclesImpl putVehicle(Scanner scan) {
        String[] input = scan.nextLine().split("\\s+");
        String name = input[0];
        double fuelQuantity = Double.parseDouble(input[1]);
        double fuelConsumption = Double.parseDouble(input[2]);
        double tankCapacity = Double.parseDouble(input[3]);

        if (name.equals("Car")) {
            return new Car(fuelQuantity, fuelConsumption, tankCapacity);
        } else if (name.equals("Truck")) {
            return new Truck(fuelQuantity, fuelConsumption, tankCapacity);
        }
        return new Bus(fuelQuantity,fuelConsumption,tankCapacity);
    }
}
