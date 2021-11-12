package BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Birthable> birthableList = new ArrayList<>();

        String input = scan.nextLine();

        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");
            String classType = tokens[0];

            switch (classType){
                case "Citizen":
                    String citizenName = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    String citizenId = tokens[3];
                    String citizenBirthdate = tokens[4];

                    Citizen citizen = new Citizen(citizenName,age,citizenId,citizenBirthdate);

                    birthableList.add(citizen);
                    break;

                case "Robot":
                    String model = tokens[1];
                    String robotId = tokens[2];

                    Robot robot = new Robot(model , robotId);
                    break;

                case "Pet":
                    String petName = tokens[1];
                    String petBirthdate = tokens[2];

                    Pet pet = new Pet(petName,petBirthdate);

                    birthableList.add(pet);
                    break;
            }


            input = scan.nextLine();
        }

        String yearToSearch = scan.nextLine();
        boolean isFound = false;

        for (Birthable birthable : birthableList) {

            if (birthable.getBirthDate().endsWith(yearToSearch)){
                isFound = true;
                System.out.println(birthable.getBirthDate());
            }
        }

        if (!isFound){
//            System.out.println("<no output>");
        }
    }
}
