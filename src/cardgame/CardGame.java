package CardGame;

import CardGame.Card.Suit;
import CardGame.Card.Value;
import java.util.Random;
import java.util.Scanner;

/**
 * A class to model a card game where the computer
 * generates a hand of cards and the user guesses a card.
 * @author dancye, 2023
 */
public class CardGame {
  
    
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       Scanner input = new Scanner(System.in);
      Card[] hand = CardHandGenerator.generateHand(7);
       //ask the user for a lucky card
       System.out.println("Please choose a suit for your lucky card:");
       for(int i=0; i<Card.Suit.values().length; i++)
       {
           System.out.println((i +1) + ": " + Card.Suit.values()[i]);
       }
       int suit = input.nextInt()-1;
       //System.out.println("Enter a value(1 to 13)");
       int valuePosition = input.nextInt()-1;
       //create a new Card with the two values Chosen
       Card userGuess = new Card(Card.Value.values()[valuePosition], Card.Suit.values()[suit]);
       //check to see if it matches
       boolean match = false;
       for(Card card: hand)
       {
           if(card.getValue()==userGuess.getValue()&&(card.getSuit().equals(userGuess.getSuit())))
           {
               match=true;
               break;
           }
       }
       System.out.println("Did you guess it?" + match);
    }

	public int getValue() {
		return this.value;
	}

	/**
	 * 
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}

	public String getSuit() {
		return this.suit;
	}

	/**
	 * 
	 * @param suit
	 */
	public void setSuit(String suit) {
		this.suit = suit;
	}

	/**
	 * 
	 * @param suit
	 * @param value
	 */
	CardGame(String suit, int value) {
		// TODO - implement CardGame.CardGame
		throw new UnsupportedOperationException();
	}

	/**
	 * @param args the command line arguments
	 */
	private int value;
	private String suit;

	
	
    
}