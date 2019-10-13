package com.grunclepug.consoleapps.testing.minimax;

import java.util.Scanner;

/**
 * Runs the program
 */
public class Driver
{
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Gets user input and starts the generator/scrambler
     * @param args console args
     */
    public static void main(String[] args)
    {
        System.out.println("Unique Sequential Number Generator/Scrambler v1.0");
        System.out.println("How many numbers would you like?");
        System.out.print("$> ");
        int input = Integer.parseInt(scanner.nextLine().trim());
        scanner.close();
        new UniqueSequentialNumberGenerator(input);
    }
}
