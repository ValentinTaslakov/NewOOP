package PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] pizzaData = scan.nextLine().split("\\s+");

        String pizzaName = pizzaData[1];
        int numberOfToppings = Integer.parseInt(pizzaData[2]);

        Pizza pizza;

        try {
           pizza = new Pizza(pizzaName, numberOfToppings);

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }

        String[] doughData = scan.nextLine().split("\\s+");

        String flourType = doughData[1];
        String bakingTechnique = doughData[2];
        double weightInGrams = Double.parseDouble(doughData[3]);

        Dough dough;

        try {
             dough = new Dough(flourType,bakingTechnique,weightInGrams);

        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }

        pizza.setDough(dough);


        String input = scan.nextLine();

        while (!input.equals("END")){

            String[] toppingData = input.split("\\s+");

            String toppingType = toppingData[1];
            double weight = Double.parseDouble(toppingData[2]);

            Topping topping;
            try{
                 topping = new Topping(toppingType,weight);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
            pizza.addTopping(topping);

            input = scan.nextLine();
        }

        System.out.println(pizza);
    }
}
