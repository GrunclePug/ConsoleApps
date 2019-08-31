package com.grunclepug.consoleapps.tictactoe;

/**
 * Board for Tic Tac Toe game
 * @author grunclepug
 */
public class Board
{
    //Board layout
    public String[][] board =
            {
                    {"   ", "|", "   ", "|", "   "},
                    {"---", "|", "---", "|", "---"},
                    {"   ", "|", "   ", "|", "   "},
                    {"---", "|", "---", "|", "---"},
                    {"   ", "|", "   ", "|", "   "}
            };

    /**
     * Default Constructor
     */
    public Board()
    {
    }

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
}
