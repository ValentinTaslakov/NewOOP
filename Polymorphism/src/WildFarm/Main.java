package WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<AnimalImpl> animals = new ArrayList<>();

        String input = scan.nextLine();

        while (!input.equals("End")) {
            String[] animalData = input.split("\\s+");
            AnimalImpl animal = getAnimal(animalData);

            String[] foodData = scan.nextLine().split("\\s+");
            Food food = getFood(foodData);

            animal.makeSound();
            try {
                animal.eat(food);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }

            animals.add(animal);
            input = scan.nextLine();
        }

        animals.forEach(System.out::println);
    }

    private static Food getFood(String[] foodData) {
        String type = foodData[0];
        int quantity = Integer.parseInt(foodData[1]);

        if (type.equals("Meat")){
            return new Meat(quantity);
        }else return new Vegetable(quantity);
    }

    private static AnimalImpl getAnimal(String[] animalData) {

        String type = animalData[0];
        String name = animalData[1];
        double weight = Double.parseDouble(animalData[2]);
        String livingRegion = animalData[3];
        AnimalImpl animal = null;

        switch (type) {
            case "Mouse":
                animal = new Mouse(name, type, weight, livingRegion);
                break;

            case "Zebra":
                animal = new Zebra(name, type, weight, livingRegion);
            break;

            case "Cat":
                String breed = animalData[4];
                animal = new Cat(name, type, weight, livingRegion, breed);
            break;

            case "Tiger":
                animal = new Tiger(name, type, weight, livingRegion);
            break;
            default:
                throw new  IllegalArgumentException("No such animal");
        }

        return animal;
    }
}
