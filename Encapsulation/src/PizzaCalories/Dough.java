package PizzaCalories;

import java.util.HashMap;
import java.util.Map;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);

    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        if (!(flourType.equals("Wholegrain")) && !(flourType.equals("White"))) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!(bakingTechnique.equals("Homemade"))
                && !(bakingTechnique.equals("Chewy"))
                && !(bakingTechnique.equals("Crispy"))) {

            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }



    public double calculateCalories() {
        double baseCalories = this.weight * 2;
        Map<String, Double> modifiers = new HashMap<>();
        modifiers.put("White", 1.5);
        modifiers.put("Wholegrain", 1.0);
        modifiers.put("Crispy", 0.9);
        modifiers.put("Chewy", 1.1);
        modifiers.put("Homemade", 1.0);

        return baseCalories * modifiers.get(this.flourType) * modifiers.get(this.bakingTechnique);

    }
}
