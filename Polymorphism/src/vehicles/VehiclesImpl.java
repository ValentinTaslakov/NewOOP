package vehicles;

import java.text.DecimalFormat;

public abstract class VehiclesImpl implements Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;

    public VehiclesImpl(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumption(fuelConsumption);

    }

    @Override
    public String driving(double distance) {

        double fuelNeeded = this.getFuelConsumption() * distance;

        if (fuelNeeded < this.fuelQuantity) {

            this.fuelQuantity -= fuelNeeded;
            DecimalFormat format = new DecimalFormat("##.##");
            return this.getClass().getSimpleName() + " travelled " + format.format(distance) + " km";
        }
        return this.getClass().getSimpleName() + " needs refueling";

    }

    @Override
    public void refuel(double liters) {

        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
