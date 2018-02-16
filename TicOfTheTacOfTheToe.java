import java.util.*;
/**
 * Write a description of class TicOfTheTacOfTheToe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TicOfTheTacOfTheToe
{
    private int x;
    private String[] board;
    private int players = 1;
    private int turns = 0;
    private int boardSize = 3;
    private boolean playAgain = true;
    private WinnerCheck winCheck = new WinnerCheck();
    private canWin canWinCheck = new canWin();
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
                System.out.print("-----");
                System.out.print("+");
            }
            System.out.println();
            System.out.print("| ");
            for(int y = 0; y < boardSize; y++)
            {
                if(i+y >= 99)
                {
                    if(board[i+y].equals("X") || board[i+y].equals("O"))
                    {
                        System.out.print(" " + board[i+y] + " ");
                    }
                    else
                        System.out.print(String.format("%-3s", board[i+y]));
                    System.out.print(" | ");
                }
                else if(i+y >= 10)
                {
                    if(board[i+y].equals("X") || board[i+y].equals("O"))
                    {
                        System.out.print(" " + board[i+y] + " ");
                    }
                    else
                        System.out.print(String.format("%-3s", ("0" + board[i+y])));
                    System.out.print(" | ");
                }
                else
                {
                    if(board[i+y].equals("X") || board[i+y].equals("O"))
                    {
                        System.out.print(" " + board[i+y] + " ");
                    }
                    else
                        System.out.print(String.format("%-3s", ("00" + board[i+y])));
                    System.out.print(" | ");
                }
            }
            System.out.println();
        }
        System.out.print("+");
        for(int z = 0; z < boardSize; z++)
        {
            System.out.print("-----");
            System.out.print("+");
        }
        System.out.println();
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
        boolean hadWinner = false;
        while(turns < board.length && hadWinner == false)
        {
            if(turns % 2 == 0)
            {
                input();
                System.out.print('\u000C');
                hadWinner = winCheck.hasWinner(board,boardSize);
            }
            else
            {
                int move = (int)Math.random() * (board.length-1);
                if(canWinCheck.someoneCanWin(board,boardSize) >= 0)
                    move = canWinCheck.someoneCanWin(board,boardSize);
                while(board[move] == "X" || board[move] == "O")
                {
                    move = (int)(Math.random() * (board.length-1));
                }
                turns++;
                board[move] = "O";
                hadWinner =  winCheck.hasWinner(board,boardSize);
            }
        }
        if(turns >= board.length && hadWinner == false)
        {
            System.out.println("The Game Was a Tie!");
            show();
        }
        else
            show();
        System.out.println("Would You Like to Play Again? (Y) or (N)");
        String cont = scan.next();
        while((cont.toLowerCase().equals("n")) == false && (cont.toLowerCase().equals("y")) == false)
        {
            System.out.println("Invalid Input!");
            System.out.println("Would You Like to Play Again? (Y) or (N)");
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
        boolean hadWinner = false;
        System.out.println("Two Player Game (Player VS. Player");
        while(turns < board.length && hadWinner == false)
        {
            input();
            hadWinner =  winCheck.hasWinner(board,boardSize);
        }
        if(turns >= board.length && hadWinner == false)
        {
            System.out.println("The Game Was a Tie!");
            show();
        }
        else
            show();
        System.out.println("Would You Like to Play Again? (Y) or (N)");
        String cont = scan.next();
        while((cont.toLowerCase().equals("n")) == false && (cont.toLowerCase().equals("y")) == false)
        {
            System.out.println("Invalid Input!");
            System.out.println("Would You Like to Play Again? (Y) or (N)");

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
