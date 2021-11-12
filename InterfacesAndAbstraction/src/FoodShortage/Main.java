package FoodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scan.nextLine());

        List<Person> buyers = new ArrayList<>();

        while (numberOfPeople-- > 0) {
            String[] people = scan.nextLine().split("\\s+");

            String name = people[0];
            int age = Integer.parseInt(people[1]);

            if (people.length == 4) {

                String id = people[2];
                String birthDate = people[3];
                Citizen citizen = new Citizen(name, age, id, birthDate);

                buyers.add(citizen);

            } else if (people.length == 3) {

                String group = people[2];
                Rebel rebel = new Rebel(name, age, group);

                buyers.add(rebel);
            }
        }

        String peopleWhoBought = scan.nextLine();

        while (!peopleWhoBought.equals("End")) {

            for (Person person : buyers) {
                if (person.getName().equals(peopleWhoBought)) {

                    ((Buyer) person).buyFood();

                }
            }

            peopleWhoBought = scan.nextLine();
        }
        int totalFoodPurchased = 0;
        for (Person person : buyers) {
            totalFoodPurchased += ((Buyer) person).getFood();
        }
        System.out.println(totalFoodPurchased);

    }
}
