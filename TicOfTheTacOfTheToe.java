import java.util.*;
import java.util.Date;
/**
 * Write a description of class TicOfTheTacOfTheToe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TicOfTheTacOfTheToe
{
    // instance variables - replace the example below with your own
    private int x;
    private String[] board;
    private int players = 1;
    private int turns = 0;
    private int boardSize = 3;
    private int[][] winLines = new int[][]{{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    private boolean playAgain = true;
    /**
     * Constructor for objects of class TicOfTheTacOfTheToe
     */
    public static void main(String[] args)
    {
        TicOfTheTacOfTheToe game = new TicOfTheTacOfTheToe();
        game.TicOfTheTacOfTheToe();
    }

    public void TicOfTheTacOfTheToe()
    {
        while(playAgain == true)
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please Enter What Size You Want the Board to Be. (Minimum of 3)\nIe. Entering 5 Will Create a 5x5 Board.");
            if(scan.hasNextInt())
            {
                boardSize = scan.nextInt();
            }
            else
            {
                while(scan.hasNextInt() == false || boardSize < 3)
                {
                    scan.next();
                    System.out.println("Invalid Input!");
                    System.out.println("Please Enter What Size You Want the Board to Be. (Minimum of 3)\nEx. Entering 5 Will Create a 5x5 Board.");
                }
                boardSize = scan.nextInt();
            }
            board = new String[boardSize * boardSize];
            System.out.println("Enter 1 for 1 player, or Enter 2 for 2 players");
            while(scan.hasNextInt() == false)
            {
                scan.next();
                System.out.println("Invalid Input!");
                System.out.println("Enter 1 for 1 player or Enter 2 for 2 players");
            }
            players = scan.nextInt();
            reset();
            if(players == 1)
            {
                System.out.print('\u000C');
                onePlayerGame();
            }
            else if(players == 2)
            {
                System.out.print('\u000C');
                twoPlayerGame();
            }
            else
            {
                System.out.println("Invalid amount of players! Please Try Again!");
                TicOfTheTacOfTheToe();
            }
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void reset()
    {
        turns = 0;
        for(int i = 0; i < board.length; i++)
        {
            board[i] = Integer.toString(i);
        }
    }

    public void show()
    {
        for(int i = 0; i < board.length-1; i += boardSize)
        {
            System.out.print("+");
            for(int z = 0; z < boardSize; z++)
            {
                if(board.length >= 100)
                    System.out.print("-----");
                else if(board.length >= 10)
                    System.out.print("----");
                else
                    System.out.print("---");
                System.out.print("+");
            }
            System.out.println();
            if(board.length >= 100)
            {
                System.out.print("| ");
                for(int y = 0; y < boardSize-1; y++)
                {
                    if(board.length >= 100)
                    {
                        if(i+y >= 99)
                        {
                            System.out.print(String.format("%-3s", board[i+y]));
                            System.out.print(" | ");
                        }
                        else if(i+y >= 10)
                        {
                            if(board[i+y].equals("X") || board[i+y].equals("O"))
                            {
                                System.out.print("-" + board[i+y] + "-");
                            }
                            else
                                System.out.print(String.format("%-2s", board[i+y]));
                            System.out.print(" | ");
                        }
                        else
                        {
                            if(board[i+y].equals("X") || board[i+y].equals("O"))
                            {
                                System.out.print("-" + board[i+y] + "-");
                            }
                            else
                                System.out.print(String.format("%-1s", board[i+y]));
                            System.out.print(" | ");
                        }
                    }
                }
                if(i + boardSize-1 < 10)
                {
                    if(board[i + boardSize-1].equals("X") || board[i + boardSize-1].equals("O"))
                    {
                        System.out.print("-" + board[i + boardSize-1] + "-" + " |");
                    }
                    else
                        System.out.println("00" + board[i + boardSize-1] + " |");
                }
                else if(i + boardSize-1 < 100)
                {
                    if(board[i + boardSize-1].equals("X") || board[i + boardSize-1].equals("O"))
                    {
                        System.out.print("-" + board[i + boardSize-1] + " |");
                    }
                    else
                        System.out.println("0" + board[i + boardSize-1] + " |");
                }
                else
                    System.out.println((board[i + boardSize-1] + " |"));
            }
            else if(board.length >= 10)
            {
                System.out.print("| ");
                for(int y = 0; y < boardSize-1; y++)
                {
                    if(i+y >= 9)
                    {
                        System.out.print(String.format("%-2s", board[i+y]));
                        System.out.print(" | ");
                    }
                    else
                    {
                        if(i+y < 10 && board.length >= 99)
                        {
                            if(board[i+y].equals("X") || board[i+y].equals("O"))
                            {
                                System.out.print("-" + board[i+y] + "-" + " |");
                            }
                            else
                                System.out.print("00" + board[i+y]);
                            System.out.print(" | ");
                        }
                        else
                        {
                            if(board[i+y].equals("X") || board[i+y].equals("O"))
                            {
                                System.out.print("-" + board[i+y]);
                            }
                            else
                                System.out.print("0" + board[i+y]);
                            System.out.print(" | ");
                        }
                    }
                }
                if (i + boardSize-1 < 10)
                {
                    if(board[i + boardSize-1].equals("X") || board[i + boardSize-1].equals("O"))
                    {
                        System.out.print("-" + board[i + boardSize-1] + " |");
                    }
                    else
                        System.out.println("0" + (board[i + boardSize-1] + " |"));
                }
                else
                {
                    System.out.println((board[i + boardSize-1] + " |"));
                }
            }
            else
            {
                System.out.print("| " + board[i] + " | ");
                for(int y = 1; y < boardSize-1; y++)
                    System.out.print(board[i+y] + " | ");
                System.out.println(board[i + boardSize-1] + " |");
            }
        }
        System.out.print("+");
        for(int z = 0; z < boardSize; z++)
        {
            if(board.length >= 100)
                System.out.print("-----");
            else if(board.length >= 10)
                System.out.print("----");
            else
                System.out.print("---");
            System.out.print("+");
        }
        System.out.println();
    }

    public boolean hasWinner()
    {
        boolean isWinner = false;
        if(turns >= 4)
        {
            isWinner=winInLine();
            if(isWinner == false)
                isWinner=winInDiag();
        }
        return isWinner;
    }

    public boolean winInLine()
    {
        int currentlyConnected = 0;
        for(int i = 0; i < board.length; i++)
        {
            currentlyConnected = 0;
            if((i - 1) >= 0)
            {
                if(board[i].equals(board[i-1]))
                    currentlyConnected++;
            }
            if((i + 1) < board.length)
            {
                if(board[i].equals(board[i+1]))
                    currentlyConnected++;
            }
            if(currentlyConnected == 2)
            {
                System.out.println(board[i] + "'s Win!");
                return true;
            }
            currentlyConnected = 0;
            if((i + 1) < board.length)
            {
                if(board[i].equals(board[i+1]))
                    currentlyConnected++;
            }
            if((i + 2) < board.length)
            {
                if(board[i].equals(board[i+2]))
                    currentlyConnected++;
            }
            if(currentlyConnected == 2)
            {
                System.out.println(board[i] + "'s Win!");
                return true;
            }
            currentlyConnected = 0;
            if((i - 1) >= 0)
            {
                if(board[i].equals(board[i-1]))
                    currentlyConnected++;
            }
            if((i - 2) >= 0)
            {
                if(board[i].equals(board[i-2]))
                    currentlyConnected++;
            }
            if(currentlyConnected == 2)
            {
                System.out.println(board[i] + "'s Win!");
                return true;
            }
            currentlyConnected = 0;
            if((i + boardSize - 1) < board.length)
            {
                if(board[i].equals(board[i + boardSize - 1]))
                    currentlyConnected++;
            }
            if((i - boardSize - 1) >= 0)
            {
                if(board[i].equals(board[i-boardSize- 1]))
                    currentlyConnected++;
            }
            if(currentlyConnected == 2)
            {
                System.out.println(board[i] + "'s Win!");
                return true;
            }
            currentlyConnected = 0;
            if((i + boardSize - 1) < board.length)
            {
                if(board[i].equals(board[i + boardSize -  1]))
                    currentlyConnected++;
            }
            if((i + boardSize*2 - 2) < board.length)
            {
                if(board[i].equals(board[i + boardSize*2 - 2]))
                    currentlyConnected++;
            }
            if(currentlyConnected == 2)
            {
                System.out.println(board[i] + "'s Win!");
                return true;
            }
            currentlyConnected = 0;
            if((i - boardSize - 1) >= 0)
            {
                if(board[i].equals(board[i - boardSize - 1]))
                    currentlyConnected++;
            }
            if((i - boardSize*2 - 2) >= 0)
            {
                if(board[i].equals(board[i - boardSize*2 - 2]))
                    currentlyConnected++;
            }
            if(currentlyConnected == 2)
            {
                System.out.println(board[i] + "'s Win!");
                return true;
            }
        }
        return false;
    }

    public boolean winInDiag()
    {
        int currentlyConnected = 0;
        for(int i = 0; i < board.length; i++)
        {
            currentlyConnected = 0;
            if((i - boardSize - 1 - 1) >= 0)
            {
                if(board[i].equals(board[i - boardSize - 1 - 1]))
                    currentlyConnected++;
            }
            if((i + boardSize - 1 + 1) < board.length)
            {
                if(board[i].equals(board[i + boardSize - 1 + 1]))
                    currentlyConnected++;
            }
            if(currentlyConnected == 2)
            {
                System.out.println(board[i] + "'s Win!");
                return true;
            }
            currentlyConnected = 0;
            if((i - boardSize - 1 + 1) >= 0)
            {
                if(board[i].equals(board[i - boardSize - 1 + 1]))
                    currentlyConnected++;
            }
            if((i + boardSize - 1 - 1) < board.length)
            {
                if(board[i].equals(board[i + boardSize - 1 - 1]))
                    currentlyConnected++;
            }
            if(currentlyConnected == 2)
            {
                System.out.println(board[i] + "'s Win!");
                return true;
            }
        }
        return false;
    }

    public void input()
    {
        Scanner scan = new Scanner(System.in);
        int moveIndex = 0;
        boolean hadNextInt = false;
        if(turns % 2 == 0)
        {
            System.out.println("It is Player 1's (X) Turn.");
            System.out.println("Please Enter An Avaliable Position to Make Your Move.");
            show();
            if(scan.hasNextInt())
            {
                moveIndex = scan.nextInt();
                hadNextInt = true;
            }
            if((hadNextInt == false && scan.hasNextInt() == false) || board[moveIndex] == "X" || board[moveIndex] == "O" || moveIndex > board.length-1 || moveIndex < 0)
                while((hadNextInt == false && scan.hasNextInt() == false) || board[moveIndex] == "X" || board[moveIndex] == "O" || moveIndex > board.length-1 || moveIndex < 0)
                {

                    System.out.println("Invalid Input!\nPlease Try Again Make Sure You Enter The Number Of The Position to Make Your Move!");
                    System.out.println("It is Player 1's (X) Turn.");
                    System.out.println("Please Enter An Avaliable Position to Make Your Move.");
                    show();
                    if(scan.hasNextInt())
                    {
                        moveIndex = scan.nextInt();
                        hadNextInt = true;
                    }
                }
            board[moveIndex] = "X";
            turns++;
        }
        else
        {
            System.out.println("It is Player 2's (O) Turn.");
            System.out.println("Please Enter An Avaliable Position to Make Your Move.");
            show();
            if(scan.hasNextInt())
            {
                moveIndex = scan.nextInt();
                hadNextInt = true;
            }
            if((hadNextInt == false && scan.hasNextInt() == false) || board[moveIndex] == "X" || board[moveIndex] == "O")
                while((hadNextInt == false && scan.hasNextInt() == false) || board[moveIndex] == "X" || board[moveIndex] == "O")
                {

                    System.out.println("Invalid Input!\nPlease Try Again Make Sure You Enter The Number Of The Position to Make Your Move!");
                    System.out.println("It is Player 2's (O) Turn.");
                    System.out.println("Please Enter An Avaliable Position to Make Your Move.");
                    show();
                    if(scan.hasNextInt())
                    {
                        moveIndex = scan.nextInt();
                        hadNextInt = true;
                    }
                }
            board[moveIndex] = "O";
            turns++;
        }
    }

    public void onePlayerGame()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("One Player Game (Player VS. Computer)");
        while(turns < board.length && hasWinner() == false)
        {
            if(turns % 2 == 0)
            {
                input();
                System.out.print('\u000C');
                System.out.println("A move was made the board now looks like this.");
                show();
            }
            else
            {
                int move = (int)Math.random() * (board.length-1);
                while(board[move] == "X" || board[move] == "O")
                {
                    move = (int)(Math.random() * (board.length-1));
                }
                turns++;
                board[move] = "O";
                System.out.println("A move was made the board now looks like this.");
                show();
            }
        }
        if(turns >= board.length && hasWinner() == false)
            System.out.println("The Game Was a Tie!");
        System.out.println("Would You Like to Play Again? (Y) (N)");
        String cont = scan.next();
        while((cont.toLowerCase().equals("n")) == false && (cont.toLowerCase().equals("y")) == false)
        {
            System.out.println("Invalid Input!");
            System.out.println("Would You Like to Play Again? (Y) (N)");
            cont = scan.next();
        }
        if(cont.toLowerCase().equals("y"))
        {
            System.out.println("Thanks For Playing!\nGame will now restart!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print('\u000C');
        }
        else
        {
            System.out.println("Thanks For Playing!\nProgram will now exit!");
            playAgain = false;
        }
    }

    public void twoPlayerGame()
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Two Player Game (Player VS. Player");
        while(turns < board.length && hasWinner() == false)
        {
            input();
            System.out.print('\u000C');
            System.out.println("A move was made the board now looks like this.");
            show();
        }
        if(turns >= board.length && hasWinner() == false)
            System.out.println("The Game Was a Tie!");
        System.out.println("Would You Like to Play Again? (Y) (N)");
        String cont = scan.next();
        while((cont.toLowerCase().equals("n")) == false && (cont.toLowerCase().equals("y")) == false)
        {
            System.out.println("Invalid Input!");
            System.out.println("Would You Like to Play Again? (Y) (N)");

        }
        if(cont.toLowerCase().equals("y"))
        {
            System.out.println("Thanks For Playing!\nGame will now restart!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print('\u000C');
        }
        else
        {
            System.out.println("Thanks For Playing!\nProgram will now exit!");
            playAgain = false;
        }
    }
}
