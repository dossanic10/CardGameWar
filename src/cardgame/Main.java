package cardgame;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardGame game = new CardGame(); // Create a new game instance

        System.out.println("Welcome to the War Card Game!");

        // Start a new game
        game.startGame();

        // Game loop
        while (true) {
            System.out.println("\nType '1' to play a round, '2' to display the score, or '0' to quit:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Play a round
                    game.playRound();
                    break;
                case 2:
                    // Display the current score
                    System.out.println("Player deck size: " + game.getPlayerDeckSize());
                    System.out.println("Computer deck size: " + game.getComputerDeckSize());
                    break;
                case 0:
                    // Quit the game
                    System.out.println("Thanks for playing!");
                    return;
                default:
                    System.out.println("Invalid input. Please try again.");
            }

            // Check if there's a winner
            if (game.isGameOver()) {
                System.out.println("\nGame Over!");
                System.out.println("Winner: " + game.getWinner());
                break;
            }
        }

        scanner.close();
    }
}
