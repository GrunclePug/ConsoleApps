package com.grunclepug.consoleapps.minimax;

/**
 * Board for MiniMax game
 * @author grunclepug
 * @version 1.0
 */
public class Board
{
    public static final int PLACES = 8;
    public String[][] board =
            {
                    {"   ", "   ", "   ", "   ", "?", "   ", "   ", "   ", "   "},
                    {"   ", "   ", "   ", " / ", " ", " \\ ", "   ", "   ", "   "},
                    {"   ", "   ", " / ", "   ", " ", "   ", " \\ ", "   ", "   "},
                    {"   ", " / ", " \\ ", "   ", " ", "   ",  " / ", " \\ ", "   "},
                    {" / ", " \\ ", " / ", " \\ ", " ", " / ", " \\ ", " / ", " \\ "},
                    {"   ", "   ", "   ", "   ", " ", "   ", "   ", "   ", "   "},
            };

    /**
     * Prints the board
     */
    public void printBoard()
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[0].length; j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public int getPlace(int index)
    {
        int val = 0;
        switch(index)
        {
            case 1:
                val = 0;
                break;
            case 2:
                val = 1;
                break;
            case 3:
                val = 2;
                break;
            case 4:
                val = 3;
                break;
            case 5:
                val = 5;
                break;
            case 6:
                val = 6;
                break;
            case 7:
                val = 7;
                break;
            case 8:
                val = 8;
                break;
        }
        return val;
    }
    public int getVal(int val)
    {
        return Integer.parseInt(board[5][getPlace(val)].trim());
    }

    public void setVal(int place, int val)
    {
        if(place >= 0 && place <= PLACES && val > 0 && val < 10)
        {
            board[5][getPlace(place)] = (" " + val + " ");
        }
    }
}