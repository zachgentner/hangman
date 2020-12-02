import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private UserInterface ui; //Prints messages to the console for the user to interact with.
    private Phrase phrase; //Represents the phrase that the user is attempting to guess.
    private boolean gameOver = false; //Keeps track of whether or not the user has guessed too many times.
    private ArrayList<Character> incorrectGuesses = new ArrayList<>(); //Keeps a record of the previously guessed letters.
    private String category;

    public Game(Scanner scanner) {
        ui = new UserInterface(scanner);
    }

    public void startGame() {
        ui.welcomeMessage();
        System.out.println("Enter a phrase for the player to guess.");
        phrase = new Phrase(ui.getUserInput());
        System.out.println("Enter a category for the player to reference.");
        category = ui.getUserInput();
        ui.clearScreen();

        while (gameOver == false) {
            System.out.print("Category: " + category.toUpperCase());
            ui.printHangman(phrase, incorrectGuesses);
            getUserGuess(ui.getUserInput());
            checkGameOver();
        }

    }

    private void getUserGuess(String userInput) {

        if (userInput.length() == 1) {
            char guessedLetter = userInput.charAt(0);
            if (phrase.containsLetter(guessedLetter)) {
                phrase.revealLetter(guessedLetter);
            } else {
                incorrectGuesses.add(guessedLetter);
            }
        } else if (userInput.length() > 1) {
            if (userInput.equals(phrase.getOriginalPhrase())) {
                System.out.println("\nCongratulations! You guessed the phrase!");
                gameOver = true;
                restart();
            } //End the game if the user correctly guesses the phrase.
        }
    }

    public void checkGameOver() {
        if (incorrectGuesses.size() == 6) {
            ui.printHangman(phrase, incorrectGuesses);
            System.out.println("\n\nYou lose! The phrase was \"" + phrase.getOriginalPhrase() + "\".");
            gameOver = true;
            restart();
        } //End the game if the user guesses 6 letters that are not in the phrase.

        if(phrase.getUpdatedPhrase().equals(phrase.getOriginalPhrase())){
            System.out.println("\nCongratulations! You guessed all the letters of the phrase!");
            gameOver = true;
            restart();
        } //End the game if the user has revealed each letter in the phrase.

    } //Check for conditions under which the game would end.

    public void restart(){
        System.out.print("Would you like to play again? ");
        String reply = ui.getUserInput();
        if(reply.toLowerCase().equals("yes") || reply.toLowerCase().equals("y")){
            gameOver = false;
            incorrectGuesses.clear();
            ui.clearScreen();
            startGame();
        } else {
            System.out.println("Goodbye. Thanks for playing!");
        }
    }

}
