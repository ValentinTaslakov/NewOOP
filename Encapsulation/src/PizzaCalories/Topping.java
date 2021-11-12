package PizzaCalories;

import java.util.HashMap;
import java.util.Map;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            String message = String.format("%s weight should be in the range [1..50]."
                    , this.toppingType);
            throw new IllegalArgumentException(message);
        }
        this.weight = weight;
    }

    private void setToppingType(String toppingType) {
        if (!toppingType.equals("Meat") && !toppingType.equals("Veggies")
                && !toppingType.equals("Cheese") && !toppingType.equals("Sauce")) {
            throw new IllegalArgumentException("Cannot place " + toppingType +
                    " on top of your pizza.");
        }
        this.toppingType = toppingType;
    }


    public double calculateCalories() {

        double baseCalories = this.weight * 2;

        Map<String, Double> modifiers = new HashMap<>();
        modifiers.put("Meat", 1.2);
        modifiers.put("Veggies", 0.8);
        modifiers.put("Cheese", 1.1);
        modifiers.put("Sauce", 0.9);

        return baseCalories * modifiers.get(this.toppingType);
    }
}
