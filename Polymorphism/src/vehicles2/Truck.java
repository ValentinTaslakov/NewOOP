package vehicles2;

import java.text.DecimalFormat;

public class Truck implements Vehicles {

    private double fuelQuantity;
    private double fuelConsumption;

    public Truck(double fuelQuantity, double fuelConsumption) {
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
        this.fuelConsumption = fuelConsumption + 1.6;
    }

    @Override
    public String driving(double distance) {
        if (this.fuelConsumption * distance <= getFuelQuantity()) {

            setFuelQuantity(getFuelQuantity() - this.fuelConsumption * distance);

            DecimalFormat format = new DecimalFormat("#.####");
            return "Truck travelled " + format.format(distance) + " km";
        }
        return "Truck needs refueling";
    }


    @Override
    public void refueling(double liters) {
        setFuelQuantity(getFuelQuantity() + liters * 0.95);
    }
}
