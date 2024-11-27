package cardgame;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Player {
    private String name;
    private Queue<Card> deck;

    public Player(String name) {
        this.name = name;
        this.deck = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void addCards(List<Card> cards) {
        deck.addAll(cards);
    }

    public void addCards(Card card) {
        deck.add(card);
    }

    public Card drawCard() {
        return deck.poll();
    }

    public boolean hasCards() {
        return !deck.isEmpty();
    }

    public int getDeckSize() {
        return deck.size();
    }
}

