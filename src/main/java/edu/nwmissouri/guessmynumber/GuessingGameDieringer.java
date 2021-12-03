package edu.nwmissouri.guessmynumber;

import javax.swing.*;

/**
 * “Guess a Number” game that allows user to guess a random number. Uses Swing
 * to make a nice graphical user interface.
 *
 * Original Source: https://hackr.io/blog/java-projects
 *
 * Read about jOptionPane:
 * https://docs.oracle.com/javase/7/docs/api/javax/swing/JOptionPane.html
 * .showInputDialog() .showMessageDialog()
 *
 * @author Denise Case, Alex Dieringer
 */
public class GuessingGameDieringer {

    public static void main(String[] args) {
        // TODO: change computerNumber to secretNumber Hint: Right-click / Refactor / Rename
        int computerNumber = (int) (Math.random() * 100 + 1);
        int userAnswer = 0;
        System.out.println("The correct guess would be " + computerNumber);
        int count = 1;

        while (userAnswer != computerNumber) {
            // TODO: create 3 local variables for the arguments so we know what they mean
            // showInputDialog - the first argument is always null (no parent)
            // message = "Enter a guess between 1 and 100" // what type?
            // title = "Guessing Game" // what type?
            // messageType = JOptionPane.INFORMATION_MESSAGE
            // Works the same as original 3 but more expressive - this is an example of a what? Hint: enum
            String response = JOptionPane.showInputDialog(null,
                    "Enter a guess between 1 and 100", "Guessing Game", 3);
            userAnswer = Integer.parseInt(response);

            JOptionPane.showMessageDialog(null, "" + calculateMessage(userAnswer, computerNumber, count));
            count++;
        }
    }
    
    public static String calculateMessage(int userAnswer, int computerNumber, int count) {
        String guessPrompt = "You used: " + count;
        guessPrompt += (count == 1) ? "guess." : "guesses.";
        
        if (userAnswer <= 0 || userAnswer > 100) {
            return "Your guess is invalid";
        } else if (userAnswer == computerNumber) {
            return "Correct!\nTotal Guesses: " + count;
        } else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\n" + guessPrompt;
        } else if (userAnswer < computerNumber) {
            return "Your guess is too low, try again.\n" + guessPrompt;
        } else {
            return "Your guess is incorrect\n" + guessPrompt;
        }
    }
}
