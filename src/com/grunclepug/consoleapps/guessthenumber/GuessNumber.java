package com.grunclepug.consoleapps.guessthenumber;

import javax.swing.JOptionPane;

/**
 * Number Guessing Game
 * @author grunclepug
 * @version 1.0
 */
public class GuessNumber
{
    //Constants
    private static final int MAXIMUM_NUMBER = 100;

    /**
     * Main Method
     * @param args The number guessed
     */
    public static void main(String[] args)
    {
        int count = 1;
        int guess = 0;
        int randNumber = (int) (Math.random() * 100 + 1);

        while(guess != randNumber)
        {
            String response = JOptionPane.showInputDialog(null, "Enter a number between 1 and 100", 3);
            guess = Integer.parseInt(response);
            JOptionPane.showMessageDialog(null, "" + guessNumber(guess, randNumber, count++));
        }
    }

    /**
     * Guesses for the random number
     * @param guess number guessed
     * @param answer random number
     * @param count amount of tries
     * @return Results, as a string
     */
    private static String guessNumber(int guess, int answer, int count)
    {
        if(guess <=0 || guess > MAXIMUM_NUMBER)
        {
            return "Invalid guess. Must be between 1 and 100 inclusive";
        }
        else if(guess == answer)
        {
            return ("Correct!!\nGuess count: " + count);
        }
        else if(guess > answer)
        {
            return ("You guessed too high! Try again\nGuess count: " + count);
        }
        else if(guess < answer)
        {
            return ("You guessed too low! Try again\nGuess count: " + count);
        }
        else
        {
            return ("Your guess is incorrect, try again\nGuess count: " + count);
        }
    }
}
