package assignment1;

import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class Main {

    public static void main(String[] args) {
        // TODO: Valid data through Exceptions (IllegalArgumentException, ...).
        // TODO: Create Document.
        // TODO: Write out the history of the game;
        // TODO: Read dice from file.

        Monopoly game = new Monopoly();
        try {
            game.read("assignments-1-input.txt");
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            System.exit(-1);
        } catch (InvalidInputException e) {
            System.out.println("Invalid input!");
            System.exit(-1);
        } catch (NoSuchElementException e) {
            System.out.println("Not enough element!");
            System.exit(-1);
        }
        game.start();
    }
}
