package vehicles;

public class Car extends VehiclesImpl {

    static final double AC_FUEL_CONSUMPTION = 0.9;


    public Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption);
    }


    @Override
    public void setFuelConsumption(double fuelConsumption) {
        super.setFuelConsumption(fuelConsumption + AC_FUEL_CONSUMPTION);
    }
}
