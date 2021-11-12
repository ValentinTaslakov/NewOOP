package WildFarm;

public abstract class AnimalImpl  {
    private String name;
    private String type;
    private double weight;
    private int foodEaten;

    public AnimalImpl(String name, String type, double weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
        this.foodEaten = 0;
    }


    public abstract void makeSound();


    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    public String getName(){
        return name;
    }

    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public int getFoodEaten() {
        return foodEaten;
    }
}
