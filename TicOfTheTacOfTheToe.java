import java.util.*;
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
    private char[] board = new char[9];
    private int players = 1;
    private int turns = 0;
    private int[][] winLines = new int[][]{{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,7}, {0,4,8}, {2,4,8}};
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
        Scanner scan = new Scanner(System.in);
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
            System.out.print("One Player Game");
            onePlayerGame();
        }
        else if(players == 2)
        {
            System.out.print("Two Player Game");
        }
        else
        {
            System.out.println("Invalid amount of players! Please Try Again!");
            TicOfTheTacOfTheToe();
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
        for(int i = 0; i < board.length; i++)
        {
            board[i] = (char)i;
        }
    }
    
    public void show()
    {
        for(int i = 0; i < board.length; i += 3)
        {
            System.out.println("+---+---+");
            System.out.println("| " + board[i] + " | " + board[i+1] + " | " + board[i+2] + " |");
        }
    }
    
    public boolean hasWinner()
    {
        boolean isWinner = false;
        if(turns >= 5)
        {
            for(int i = 0; i < 8; i++)
            {
                if(board[winLines[i][0]] == 'X' && board[winLines[i][1]] == 'X' && board[winLines[i][2]] == 'X')
                {
                    System.out.println("Player 1 (X) Wins!");
                    isWinner = true;
                }
                else if(board[winLines[i][0]] == 'O' && board[winLines[i][1]] == 'O' && board[winLines[i][2]] == 'O')
                {
                    System.out.println("Player 1 (X) Wins!");
                    isWinner = true;
                }
            }
        }
        return isWinner;
    }
    
    public void input()
    {
        Scanner scan = new Scanner(System.in);
        if(turns % 2 == 0)
        {
            System.out.println("It is Player 1's (X) Turn.");
            System.out.println("Please Enter An Avaliable Poistion to Make Your Move.");
            show();
             while(scan.hasNextInt() == false || board[scan.nextInt()] == 'X' || board[scan.nextInt()] == 'O')
            {
                System.out.println("Invalid Input!\n Please Try Again Make Sure You Enter The Number Of The Position to Make Your Move!");
                System.out.println("It is Player 1's (X) Turn.");
                System.out.println("Please Enter An Avaliable Poistion to Make Your Move.");
                show();
            }
            board[scan.nextInt()] = 'X';
            turns++;
        }
        else
        {
            System.out.println("It is Player 2's (O) Turn.");
            System.out.println("Please Enter An Avaliable Poistion to Make Your Move.");
            show();
            while(scan.hasNextInt() == false || board[scan.nextInt()] == 'X' || board[scan.nextInt()] == 'O')
            {
                System.out.println("Invalid Input!\n Please Try Again Make Sure You Enter The Number Of The Position to Make Your Move!");
                System.out.println("It is Player 2's (O) Turn.");
                System.out.println("Please Enter An Avaliable Poistion to Make Your Move.");
                show();
            }
            board[scan.nextInt()] = 'O';
            turns++;
        }
    }
    
    public void onePlayerGame()
    {
        System.out.println("One Player Game (Player VS. Computer");
        while(turns < 9 && hasWinner() == false)
        {
            if(turns % 2 == 0)
            {
                input();
                System.out.println("A move was made the board now looks like this.");
                show();
            }
            else
            {
                int move = (int)Math.random() * 8;
                while(board[move] == 'X' || board[move] == 'O')
                {
                    move = (int)Math.random() * 8;
                }
                board[move] = 'O';
                System.out.println("A move was made the board now looks like this.");
                show();
            }
        }
        if(hasWinner() == true)
        {
            System.out.println("Would You Like to Play Again? (Y) (N)");
        }
        else
        {
            System.out.println("The Game Was a Tie!");
            System.out.println("Would You Like to Play Again? (Y) (N)");
        }
    }
}
