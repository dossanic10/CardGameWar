
package CardGame;

/**
 * A class that models Card Objects
 * A card has a value (1-13) and a suit (Hearts, diamonds, spades, clubs)
 * @author dancye, 2023
 */
public class Card 
{
    private Value value;
    private Suit suit; 
    //array of possible Suits
    public enum Suit
    {
        HEARTS, CLUBS, SPADES, DIAMONDS
    }
    
    public enum Value
    {
        ACE, TWO, THREE, FOUR, FIVE,SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }
    
    //public static final String[] SUITS = {"Hearts", "Diamonds", "Spades", "Clubs"};
    /**
     * 2 argument constructor
     * @param givenValue
     * @param givenSuit
     */
    public Card(Value givenValue, Suit givenSuit)
    {
        value = givenValue;
        suit = givenSuit;
    }
    /**
     * @return the value
     */
    public Value getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Value value) {
        this.value = value;
    }

    /**
     * @return the suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * @param suit the suit to set
     */
    public void setSuit(Suit suit) {
        this.suit = suit;
    }
    
    
    
}
