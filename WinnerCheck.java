
/**
 * Write a description of class WinnerCheck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinnerCheck
{
    public boolean hasWinner(String[] board, int boardSize)
    {
        boolean isWinner = false;
        //System.out.println("Doing Line Check!");
        isWinner = winInLine(board,boardSize);
        if(isWinner == false)
        {
            //System.out.println("Doing Diagnal Check!");
            isWinner = winInDiag(board,boardSize);
        }
        return isWinner;
    }

    public boolean winInLine(String[] board, int boardSize)
    {
        int currentlyConnected = 0;
        for(int i = 0; i < board.length; i += boardSize)
        {
            for(int c = i; c < boardSize*((i + boardSize)/boardSize); c++)
            {
                for(int ci = 1; ci < boardSize; ci++)
                {
                    if((c + ci) <= i + boardSize - 1)
                    {
                        if(board[c].equals(board[c+ci]))
                            currentlyConnected++;
                    }
                }
                if(currentlyConnected == boardSize - 1)
                {
                    System.out.println(board[c] + "'s Win!");
                    return true;
                }
                currentlyConnected = 0;
                for(int ci = 1; ci < boardSize; ci++)
                {
                    if((c + boardSize*ci) <= i + boardSize*ci + boardSize - 1 && i + boardSize*ci + boardSize - 1 < board.length)
                    {
                        if(board[c].equals(board[c + boardSize*ci]))
                            currentlyConnected++;
                    }
                }
                if(currentlyConnected == boardSize - 1)
                {
                    System.out.println(board[c] + "'s Win!");
                    return true;
                }
                currentlyConnected = 0;
            }
        }
        return false;
    }

    public boolean winInDiag(String[] board, int boardSize)
    {
        int currentlyConnected = 0;
        for(int i = 0; i < board.length; i += boardSize)
        {
            for(int c = i; c < boardSize*((i + boardSize)/boardSize); c++)
            {
                for(int ci = 1; ci < boardSize; ci++)
                {
                    if((c + boardSize*ci + ci) < board.length)
                    {
                        if(board[c].equals(board[c + boardSize*ci + ci]))
                            currentlyConnected++;
                    }
                }
                System.out.println("Currently Connected " + currentlyConnected);
                if(currentlyConnected == boardSize - 1)
                {
                    System.out.println(board[c] + "'s Win!");
                    return true;
                }
                currentlyConnected = 0;
                for(int ci = 1; ci < boardSize; ci++)
                {
                    if((c + boardSize*ci - ci) >= i + boardSize*ci && i + boardSize*ci < board.length)
                    {
                        if(board[c].equals(board[c + boardSize*ci - ci]))
                            currentlyConnected++;
                    }
                }
                if(currentlyConnected == boardSize - 1)
                {
                    System.out.println(board[c] + "'s Win!");
                    return true;
                }
                currentlyConnected = 0;
            }
        }
        return false;
    }
}
