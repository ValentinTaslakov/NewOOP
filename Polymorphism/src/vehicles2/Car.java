package vehicles2;

import java.text.DecimalFormat;

public class Car implements Vehicles {
    private double fuelQuantity;
    private double fuelConsumption;

    public Car(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumption(fuelConsumption);

    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }


    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption + 0.9;
    }

    @Override
    public String driving(double distance) {

        if (this.fuelConsumption * distance <= getFuelQuantity()) {

            setFuelQuantity(getFuelQuantity() - this.fuelConsumption * distance);

            DecimalFormat format = new DecimalFormat("#.####");
            return "Car travelled " + format.format(distance) + " km";
        }
        return "Car needs refueling";
    }

    @Override
    public void refueling(double liters) {
        setFuelQuantity(getFuelQuantity() + liters);
    }
}
