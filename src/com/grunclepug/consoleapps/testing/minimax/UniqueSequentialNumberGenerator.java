package com.grunclepug.consoleapps.testing.minimax;

/**
 * Generates x sequential numbers and scrambles them.
 */
public class UniqueSequentialNumberGenerator
{
    private int[] numbers;

    /**
     * ctor
     * @param amount How many numbers to generate
     */
    public UniqueSequentialNumberGenerator(int amount)
    {
        generateNumbers(amount);
        printNumbers();
    }

    /**
     * Displays all of the generated numbers.
     */
    public void printNumbers()
    {
        System.out.println(numbers.length + " numbers generated and scrambled:");
        for(int i = 0; i < numbers.length; i++)
        {
            System.out.print(numbers[i] + " ");
        }
    }

    /**
     * Generates and scrambles x sequential numbers.
     * @param amount How many numbers to generate/scramble
     * @return Array of scrambled numbers
     */
    private int[] generateNumbers(int amount)
    {
        //Generate ints
        numbers = new int[amount];
        for(int i = 0; i < amount; ++i)
        {
            numbers[i] = (i + 1);
        }
        //Knuth shuffle
        for(int i = 0; i < amount; ++i){
            int randomIndex = (int)Math.floor(Math.random() * (i + 1));
            int temp = numbers[i];
            numbers[i] = numbers[randomIndex];
            numbers[randomIndex] = temp;
        }
        return numbers;
    }
}
