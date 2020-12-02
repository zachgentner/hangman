import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {

    private Scanner scanner;

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public void welcomeMessage() {
        System.out.println("Welcome to hangman!\n");
    }

    public String getUserInput(){
        return scanner.nextLine();
    }

    public void printHangman(Phrase phrase, ArrayList<Character> guessedLetters) {
        System.out.print("\n  ________");//LINE 1; CONSTANT
        System.out.println("          Phrase: " + phrase.getUpdatedPhrase());
        System.out.print("  |      |");//LINE 2; CONSTANT
        System.out.println("          Incorrect letters: " + guessedLetters.toString());

        if (guessedLetters.size() >= 1) {
            System.out.println("  O      |");
        } else {
            System.out.println("         |");
        } //LINE 2; HEAD; 1 GUESS

        if (guessedLetters.size() <= 1) {
            System.out.println("         |");
        } else if (guessedLetters.size() == 2) {
            System.out.println(" /       |");
        } else if (guessedLetters.size() == 3) {
            System.out.println(" /|      |");
        } else {
            System.out.println(" /|\\     |");
        } //LINE 4; TORSO & ARMS; 3 GUESSES

        if (guessedLetters.size() <= 4) {
            System.out.println("         |");
        } else if (guessedLetters.size() == 5) {
            System.out.println(" /       |");
        } else {
            System.out.println(" / \\     |");
        }//LINE 5; LEGS; 2 GUESSES

        System.out.print("         |          ");//LINE 6; CONSTANT
        System.out.print("Guess a letter or phrase: ");

    }

    public void clearScreen() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

}
