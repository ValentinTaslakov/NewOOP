package vehicles;

public class Truck extends VehiclesImpl {

    static final double AC_FUEL_CONSUMPTION = 1.6;
    static final double PERCENTAGE_REFUELING = 0.95;

    public Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);

    }

    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + AC_FUEL_CONSUMPTION);
    }

    @Override
    public void refuel(double liters) {
        super.refuel(liters * PERCENTAGE_REFUELING);
    }
}
