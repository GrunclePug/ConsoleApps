package com.grunclepug.consoleapps.tictactoe;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BotAI extends Board
{
    //Constants
    private static final int MAX_BOARD_INDEX = 5;

    //Variables
    private static Scanner sc = new Scanner(System.in);
    private static Board bd = new Board();
    private static String[][] board = bd.board;
    private static int[] bestPos; //Best position for the bot to play

    public static void botPlay()
    {
        minimax(bd, 0, true);
        if(legalMove(bestPos[0], bestPos[1]))
            board[bestPos[0]][bestPos[1]] = " O ";
    }

    public static int minimax(Board bd, int depth, boolean max)
    {
        int[][] possibleMoves = getPossibleMoves(bd);
        if(tie(bd.board))
        {
            return 0;
        }
        else if(userWin(bd.board))
        {
            return depth - 10;
        }
        else if(botWin(bd.board))
        {
            return 10 - depth;
        }

        if(max)
        {
            double bestScore = Double.NEGATIVE_INFINITY;
            for(int[] move: possibleMoves)
            {
                Board modified = new Board();

                for(int i = 0; i < bd.board.length; i++)
                {
                    for(int j = 0; j < bd.board[0].length; j++)
                    {
                        modified.board[i][j] = bd.board[i][j];
                    }
                }

                modified.board[move[0]][move[1]] = " O ";

                int score = minimax(modified, depth++, false);
                if(score > bestScore)
                {
                    bestScore = score;
                    bestPos = move;
                }
                if(userWin(modified.board))
                {
                    bestPos = move;
                    break;
                }
                else if(botWin(modified.board))
                {
                    bestPos = move;
                    break;
                }
            }
            return (int)bestScore;
        }
        else
        {
            double bestScore = Double.POSITIVE_INFINITY;
            for(int[] move: possibleMoves)
            {
                Board modified = new Board();

                for(int i = 0; i < bd.board.length; i++)
                {
                    for(int j = 0; j < bd.board[0].length; j++)
                    {
                        modified.board[i][j] = bd.board[i][j];
                    }
                }

                modified.board[move[0]][move[1]] = " X ";

                int score = minimax(modified, depth++, true);
                if(score < bestScore)
                {
                    bestScore = score;
                    bestPos = move;
                }
                if(userWin(modified.board))
                {
                    bestPos = move;
                    break;
                }
                else if(botWin(modified.board))
                {
                    bestPos = move;
                    break;
                }
            }
            return (int)bestScore;
        }
    }

    public static int[][] getPossibleMoves(Board bd)
    {
        ArrayList<int[]> moves = new ArrayList<>();

        for(int i = 0; i < bd.board.length; i += 2)
        {
            for(int j = 0; j < bd.board[0].length; j += 2)
            {
                if(bd.board[i][j].contains("   "))
                {
                    int[] place = {i,j};
                    moves.add(place);
                }
            }
        }

        int[][] possibleMoves = new int[moves.size()][2]; // Contains 1d arrays each of two integers
        for(int i = 0; i < moves.size(); i++)
        {
            possibleMoves[i] = moves.get(i);
        }
        return possibleMoves;
    }

    public static boolean legalMove(int x, int y)
    {
        return !board[x][y].equals(" X ") && !board[x][y].equals(" O ");
    }

    public static boolean updateBoard(int x, int y)
    {
        if(legalMove(x, y))
        {
            board[x][y] = " X ";
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void userPlay()
    {
        try
        {
            System.out.println("Enter X, Y coordinates for your move, separated by a space: ");

            int x = 2 * sc.nextInt() - 2;
            int y = 2 * sc.nextInt() - 2;
            userAction(x, y);
        }
        catch(InputMismatchException e)
        {
            System.out.println("Invalid Input, please enter only integers");

            sc.nextLine();
            userPlay();
        }
        return;
    }

    public static void userAction(int x, int y)
    {
        while(!updateBoard(x, y))
        {
            System.out.println("Please enter your coordinates again\n");
            userPlay();
            return;
        }
    }

    public static boolean botWin(String[][] board)
    {
        for(int i = 0; i < MAX_BOARD_INDEX; i += 2) //Checking horizontals and verticals
        {
            if (board[i][0].equals(board[i][2]) && board[i][0].equals(board[i][4]))
            {
                if (board[i][0].contains("O"))
                {
                    return true;
                }
            }
            if (board[0][i].equals(board[2][i]) && board[0][i].equals(board[4][i]))
            {
                if (board[0][i].contains("O"))
                {
                    return true;
                }
            }
        }

        if((board[0][0].equals(board[2][2]) && board[0][0].equals(board[4][4]))) //Checking first diagonal
        {
            if (board[0][0].contains("O"))
            {
                return true;
            }
        }
        else if ((board[0][4].equals(board[2][2]) && board[0][4].equals(board[4][0]))) //Checking second diagonal
        {
            if (board[0][4].contains("O")) {
                return true;
            }
        }
        return false;
    }

    public static boolean userWin(String[][] board)
    {
        for(int i = 0; i < MAX_BOARD_INDEX; i += 2) //Checking horizontals and verticals
        {
            if (board[i][0].equals(board[i][2]) && board[i][0].equals(board[i][4]))
            {
                if (board[i][0].contains("X"))
                {
                    return true;
                }
            }
            if (board[0][i].equals(board[2][i]) && board[0][i].equals(board[4][i]))
            {
                if (board[0][i].contains("X"))
                {
                    return true;
                }
            }
        }

        if((board[0][0].equals(board[2][2]) && board[0][0].equals(board[4][4]))) //Checking first diagonal
        {
            if (board[0][0].contains("X"))
            {
                return true;
            }
        }
        else if ((board[0][4].equals(board[2][2]) && board[0][4].equals(board[4][0]))) //Checking second diagonal
        {
            if (board[0][4].contains("X")) {
                return true;
            }
        }
        return false;
    }

    public static boolean tie(String[][] board)
    {
        for(int i = 0; i < MAX_BOARD_INDEX; i += 2)
        {
            for(int j = 0; j < MAX_BOARD_INDEX; j += 2)
            {
                if(board[i][j].equals("   ") || board[j][i].equals("   "))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        System.out.println("Welcome to Tic Tac Toe.\nEnter your move with X, Y coordinates seperated by a space\n");
        bd.printBoard();

        String decision = "y";
        while(decision.equalsIgnoreCase("y"))
        {
            for(int i = 0; i < MAX_BOARD_INDEX; i += 2)
            {
                for(int j = 0; j < MAX_BOARD_INDEX; j += 2)
                {
                    board[i][j] = "   ";
                }
            }

            while(!userWin(bd.board) && !botWin(bd.board))
            {
                if(tie(board))
                {
                    break;
                }
                userPlay();
                botPlay();
                bd.printBoard();
            }

            if(userWin(bd.board))
            {
                System.out.println("Congrats, You Won!!\n");
            }
            else if(botWin(bd.board))
            {
                System.out.println("Lol, what a loser\n");
            }
            System.out.println("Do you want to play again? (y/n): ");

            decision = sc.next();
        }
        System.out.println("Alright, bye.");
    }
}
