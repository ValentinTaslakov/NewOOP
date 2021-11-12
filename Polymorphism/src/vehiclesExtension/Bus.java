package vehiclesExtension;

public class Bus extends VehiclesImpl implements BusDriving {

    static final double FUEL_CONSUMPTION_WITH_PEOPLE = 1.4;


    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity);
    }

    @Override
    public String driveWithoutPeople(double distance) {
        return super.driving(distance);
    }

    @Override
    public String driveWithPeople(double distance) {
        super.setFuelConsumption(super.getFuelConsumption() + FUEL_CONSUMPTION_WITH_PEOPLE);
        return super.driving(distance);
    }
}
