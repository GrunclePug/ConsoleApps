package com.grunclepug.consoleapps.minimax;

import java.util.Scanner;

public class Game
{
    private Scanner scanner = new Scanner(System.in);
    private Board board = new Board();
    private int[] numbers;
    private int[] temp;
    private int eval;
    private boolean won = false;

    public void play()
    {
        System.out.println("Welcome to MiniMax!!");
        System.out.println("if you don't know how to play, type 'help'");
        setup();
        board.printBoard();

        while(true)
        {
            if(!captureInput())
            {
                break;
            }
        }

        if(won)
        {
            System.out.println("Congrats, you won!!");
        }
        else
        {
            System.out.println("Game over, you lost :(");
        }
    }

    private void setup()
    {
        numbers = generateNumbers();

        for(int i = 0; i < numbers.length; i++)
        {
            board.setVal(i + 1, numbers[i]);
        }
        evaluate(1);
    }

    private boolean captureInput()
    {
        System.out.print("$> ");
        String input = scanner.nextLine().trim();

        if(input.equalsIgnoreCase("quit"))
        {
            scanner.close();
            return false;
        }
        else if(input.equalsIgnoreCase("help"))
        {
            System.out.println("MiniMax Help:");
            System.out.println("MiniMax is a decision rule used to minimize the worst-case potential loss;" +
                    "\nin other words, a player considers all of the best opponent responses to his strategies," +
                    "\nand selects the strategy such that the opponent's best strategy gives a payoff as large as possible.");
            System.out.println("Your objective is to figure out the highest number you can achieve," +
                    "\nassuming your opponent does everything in their power to get the lowest number.");
        }
        else
        {
            if(Integer.parseInt(input) == eval)
            {
                won = true;
            }
            scanner.close();
            return false;
        }
        return true;
    }

    private int[] generateNumbers()
    {
        //Generate ints
        int[] numbers = new int[Board.PLACES];
        for(int i = 0; i < Board.PLACES; ++i)
        {
            numbers[i] = (i + 1);
        }
        //Knuth shuffle
        for(int i = 0; i < Board.PLACES; ++i){
            int randomIndex = (int)Math.floor(Math.random() * (i + 1));
            int temp = numbers[i];
            numbers[i] = numbers[randomIndex];
            numbers[randomIndex] = temp;
        }
        return numbers;
    }

    private void evaluate(int stage)
    {
        if(stage == 3)
        {
            eval = Math.max(temp[0], temp[1]);
        }
        if(stage == 2)
        {
            int temp1 = Math.min(temp[0], temp[1]);
            int temp2 = Math.min(temp[2], temp[3]);
            temp = new int[2];
            temp[0] = temp1;
            temp[1] = temp2;
            evaluate(3);
        }
        if(stage == 1)
        {
            temp = new int[4];
            temp[0] = Math.max(board.getVal(1), board.getVal(2));
            temp[1] = Math.max(board.getVal(3), board.getVal(4));
            temp[2] = Math.max(board.getVal(5), board.getVal(6));
            temp[3] = Math.max(board.getVal(7), board.getVal(8));

            evaluate(2);
        }
    }
}
