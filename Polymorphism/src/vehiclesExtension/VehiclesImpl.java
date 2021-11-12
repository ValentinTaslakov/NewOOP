package vehiclesExtension;

import java.text.DecimalFormat;

public abstract class VehiclesImpl implements Vehicle {

    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    public VehiclesImpl(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.setFuelConsumption(fuelConsumption);
        this.tankCapacity = tankCapacity;

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
        if (liters <= 0){
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        double tankFreeSpace = this.tankCapacity - this.fuelQuantity;
        if (tankFreeSpace < liters){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.setFuelQuantity(this.fuelQuantity +  liters);

    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuelQuantity);
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
