
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
        for(int i = 0; i < board.length; i++)
        {
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
            if((i + boardSize) < board.length)
            {
                if(board[i].equals(board[i + boardSize]))
                    currentlyConnected++;
            }
            if((i - boardSize) >= 0)
            {
                if(board[i].equals(board[i - boardSize]))
                    currentlyConnected++;
            }
            if(currentlyConnected == 2)
            {
                System.out.println(board[i] + "'s Win!");
                return true;
            }
            currentlyConnected = 0;
            if((i + boardSize) < board.length)
            {
                if(board[i].equals(board[i + boardSize]))
                    currentlyConnected++;
            }
            if((i + boardSize*2) < board.length)
            {
                if(board[i].equals(board[i + boardSize*2]))
                    currentlyConnected++;
            }
            if(currentlyConnected == 2)
            {
                System.out.println(board[i] + "'s Win!");
                return true;
            }
            currentlyConnected = 0;
            if((i - boardSize) >= 0)
            {
                if(board[i].equals(board[i - boardSize]))
                    currentlyConnected++;
            }
            if((i - boardSize*2) >= 0)
            {
                if(board[i].equals(board[i - boardSize*2]))
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

    public boolean winInDiag(String[] board, int boardSize)
    {
        int currentlyConnected = 0;
        for(int i = 0; i < board.length; i++)
        {
            currentlyConnected = 0;
            if((i - boardSize - 1) >= 0)
            {
                if(board[i].equals(board[i - boardSize - 1]))
                    currentlyConnected++;
            }
            if((i + boardSize + 1) < board.length)
            {
                if(board[i].equals(board[i + boardSize + 1]))
                    currentlyConnected++;
            }
            if(currentlyConnected == 2)
            {
                System.out.println(board[i] + "'s Win!");
                return true;
            }
            currentlyConnected = 0;
            if((i - boardSize+ 1) >= 0)
            {
                if(board[i].equals(board[i - boardSize + 1]))
                    currentlyConnected++;
            }
            if((i + boardSize - 1) < board.length)
            {
                if(board[i].equals(board[i + boardSize - 1]))
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
}
