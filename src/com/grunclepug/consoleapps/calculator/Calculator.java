package com.grunclepug.consoleapps.calculator;

import java.util.Scanner;

/**
 * Java Calculator
 * @author grunclepug
 * @version 1.0
 */
public class Calculator
{
    //Variables
    private static Scanner sc = new Scanner(System.in);

    /**
     * Main method
     * @param args input from console
     */
    public static void main(String[] args)
    {
        int number1;
        int number2;
        String operation;

        String decision = "y";
        while(decision.equalsIgnoreCase("y"))
        {
            System.out.println("First number: ");
            number1 = sc.nextInt();

            System.out.println("Second number: ");
            number2 = sc.nextInt();

            System.out.println("Operation: ");
            operation = sc.next();

            System.out.println("Answer: " + calculate(number1, number2, operation));

            //Check if user want's to continue
            System.out.println("Would you like to continue? (Y/N)");
            decision = sc.next();
        }
    }

    /**
     * Calculate Method
     * @param num1 first number
     * @param num2 second number
     * @param op operation to use
     * @return the answer
     */
    private static int calculate(int num1, int num2, String op)
    {
        int answer = 0;

        switch(op)
        {
            case "+":
                return answer = (num1 + num2);
            case "-":
                return answer = (num1 - num2);
            case "*":
                return answer = (num1 * num2);
            case "/":
                return answer = (num1 / num2);

            default: return 0;
        }
    }
}
