package cardgame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CardGame {
    private Player player;
    private Player computer;
    private Deck deck;

    public CardGame() {
        deck = new Deck();
        deck.shuffle();
    }

    public void startGame() {
        player = new Player("Player");
        computer = new Player("Computer");

        // Ensure deck has 52 cards and is shuffled
        deck.shuffle();

        // Distribute 26 cards to each player
        player.addCards(deck.dealHalf());
        computer.addCards(deck.dealHalf());
    }

    public void playRound() {
        if (!player.hasCards() || !computer.hasCards()) {
            checkForWinner();
            return;
        }

        Card playerCard = player.drawCard();
        Card computerCard = computer.drawCard();

        System.out.println(player.getName() + " plays: " + playerCard);
        System.out.println(computer.getName() + " plays: " + computerCard);

        if (playerCard.getValue().ordinal() > computerCard.getValue().ordinal()) {
            System.out.println(player.getName() + " wins the round!");
            player.addCards(Arrays.asList(playerCard, computerCard));
        } else if (playerCard.getValue().ordinal() < computerCard.getValue().ordinal()) {
            System.out.println(computer.getName() + " wins the round!");
            computer.addCards(Arrays.asList(playerCard, computerCard));
        } else {
            initiateWar(new ArrayList<>(Arrays.asList(playerCard, computerCard)));
        }
    }

    public void initiateWar(List<Card> cardsInPlay) {
        System.out.println("War!");

        List<Card> warCards = new ArrayList<>(cardsInPlay);

        for (int i = 0; i < 3; i++) {
            if (player.hasCards()) {
                warCards.add(player.drawCard());
            }
            if (computer.hasCards()) {
                warCards.add(computer.drawCard());
            }
        }

        Card playerFaceUpCard = player.hasCards() ? player.drawCard() : null;
        Card computerFaceUpCard = computer.hasCards() ? computer.drawCard() : null;

        if (!player.hasCards() || !computer.hasCards()) {
            System.out.println("One player has run out of cards! Ending the game.");
            checkForWinner();
            return;
        }

        if (playerFaceUpCard != null) {
            warCards.add(playerFaceUpCard);
            System.out.println(player.getName() + " places face-up card: " + playerFaceUpCard);
        }

        if (computerFaceUpCard != null) {
            warCards.add(computerFaceUpCard);
            System.out.println(computer.getName() + " places face-up card: " + computerFaceUpCard);
        }

        if (playerFaceUpCard.getValue().ordinal() > computerFaceUpCard.getValue().ordinal()) {
            System.out.println(player.getName() + " wins the war!");
            player.addCards(warCards);
        } else if (playerFaceUpCard.getValue().ordinal() < computerFaceUpCard.getValue().ordinal()) {
            System.out.println(computer.getName() + " wins the war!");
            computer.addCards(warCards);
        } else {
            System.out.println("Another tie! War continues...");
            initiateWar(warCards);
        }
    }

    public void checkForWinner() {
        if (!player.hasCards()) {
            System.out.println(computer.getName() + " wins the game!");
        } else if (!computer.hasCards()) {
            System.out.println(player.getName() + " wins the game!");
        }
    }

    public int getPlayerDeckSize() {
        return player.getDeckSize();
    }

    public int getComputerDeckSize() {
        return computer.getDeckSize();
    }

    public boolean isGameOver() {
        return !player.hasCards() || !computer.hasCards();
    }

    public String getWinner() {
        if (!player.hasCards()) {
            return computer.getName();
        } else if (!computer.hasCards()) {
            return player.getName();
        }
        return "No winner yet";
    }
}

