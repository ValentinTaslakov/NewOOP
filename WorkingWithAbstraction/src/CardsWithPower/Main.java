package CardsWithPower;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Rank cardRank = Rank.valueOf(scan.nextLine().toUpperCase(Locale.ROOT));

        Suits suitName = Suits.valueOf(scan.nextLine().toUpperCase(Locale.ROOT));

        Card card = new Card(cardRank,suitName);

        System.out.println(card);


    }
}
