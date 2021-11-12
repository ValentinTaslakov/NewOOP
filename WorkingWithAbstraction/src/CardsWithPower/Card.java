package CardsWithPower;

public class Card {

    private Rank rank;

    private Suits suit;

    private int power;

    public Card(Rank cardRank, Suits suitName) {
        this.rank = cardRank;

        this.suit = suitName;

        this.power = cardRank.getPower() + suit.getPower();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d%n"
                ,Rank.valueOf(String.valueOf(rank))
                ,Suits.valueOf(String.valueOf(suit))
        ,power);
    }
}
