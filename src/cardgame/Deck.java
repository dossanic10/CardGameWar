package cardgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                cards.add(new Card(value, suit));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public List<Card> dealHalf() {
        List<Card> halfDeck = new ArrayList<>(cards.subList(0, 26));
        cards.removeAll(halfDeck);
        return halfDeck;
    }

    public int size() {
        return cards.size();
    }
}
