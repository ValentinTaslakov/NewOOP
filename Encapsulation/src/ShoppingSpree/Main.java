package ShoppingSpree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, Person> personInfo = new LinkedHashMap<>();
        Map<String, Product> productInfo = new HashMap<>();

        String[] personData = scan.nextLine().split(";");

        for (String element : personData) {
            String[] elements = element.split("=");
            String name = elements[0];
            double money = Double.parseDouble(elements[1]);
            try {
                Person person = new Person(name,money);
                personInfo.put(name,person);

            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] productData = scan.nextLine().split(";");

        for (String element : productData) {
            String[] elements = element.split("=");
            String name = elements[0];
            double price = Double.parseDouble(elements[1]);
            try {
                Product product = new Product(name,price);
                productInfo.put(name,product);

            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
        }

        String command = scan.nextLine();

        while (!command.equals("END")){

            String[] commandData = command.split("\\s+");

            String personName = commandData[0];
            String productName = commandData[1];

            try {
                Person person = personInfo.get(personName);
                Product product = productInfo.get(productName);
                person.buyProduct(product);


            }catch (IllegalArgumentException e){

                System.out.println(e.getMessage());
            }

            command = scan.nextLine();
        }

        for (Person person : personInfo.values()) {

            System.out.print(person.getName() + " - ");
            if (person.getProducts().isEmpty()){
                System.out.println("Nothing bought");
            }else {
                System.out.println(person.getProducts()
                        .stream()
                        .map(Product::getName)
                        .collect(Collectors.joining(", "))
                );
            }

        }

    }
}
