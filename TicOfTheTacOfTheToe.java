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
    private String[] board = new String[9];
    private int players = 1;
    private int turns = 0;
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
        for(int i = 0; i < board.length; i += 3)
        {
            System.out.println("+---+---+---+");
            System.out.println("| " + board[i] + " | " + board[i+1] + " | " + board[i+2] + " |");
        }
    }

    public boolean hasWinner()
    {
        boolean isWinner = false;
        if(turns >= 4)
        {
            for(int i = 0; i < 8; i++)
            {
                if(board[winLines[i][0]] == "X" && board[winLines[i][1]] == "X" && board[winLines[i][2]] == "X")
                {
                    System.out.println("Player 1 (X) Wins!");
                    isWinner = true;
                    i = 8;
                }
                else if(board[winLines[i][0]] == "O" && board[winLines[i][1]] == "O" && board[winLines[i][2]] == "O")
                {
                    System.out.println("Player 2 (O) Wins!");
                    isWinner = true;
                    i = 8;
                }
            }
        }
        return isWinner;
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
            if((hadNextInt == false && scan.hasNextInt() == false) || board[moveIndex] == "X" || board[moveIndex] == "O" || moveIndex > 8 || moveIndex < 0)
                while((hadNextInt == false && scan.hasNextInt() == false) || board[moveIndex] == "X" || board[moveIndex] == "O" || moveIndex > 8 || moveIndex < 0)
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
        while(turns < 9 && hasWinner() == false)
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
                int move = (int)Math.random() * 8;
                while(board[move] == "X" || board[move] == "O")
                {
                    move = (int)(Math.random() * 8);
                }
                turns++;
                board[move] = "O";
                System.out.println("A move was made the board now looks like this.");
                show();
            }
        }
        if(turns >= 9 && hasWinner() == false)
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
        while(turns < 9 && hasWinner() == false)
        {
            input();
            System.out.print('\u000C');
            System.out.println("A move was made the board now looks like this.");
            show();
        }
        if(turns >= 9 && hasWinner() == false)
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
