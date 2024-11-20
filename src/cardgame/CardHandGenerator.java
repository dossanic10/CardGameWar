
package cardgame;

import java.util.Random;

/**
 * A class to generate a hand of cards with random cards from
 * the type Card. Takes in the size of the hand
 * @author dancye
 */
public class CardHandGenerator 
{
    public static Card[] generateHand(int numCards)
    {
        Card[] hand = new Card[numCards];
       Random random = new Random();
       for(int i=0; i<hand.length; i++)
       {
           Card.Value value = Card.Value.values()[random.nextInt(13)];
           Card.Suit suit = Card.Suit.values()[random.nextInt(4)];
           Card card = new Card(value, suit);
           hand[i] = card;
           //print out each card that we generate
           System.out.println("generating: "+ card.getValue() + " of " + card.getSuit() );
       }  
        return hand;
    }
   
}
