
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
                if((c - 1) >= i)
                {
                    if(board[c].equals(board[c-1]))
                        currentlyConnected++;
                }
                if((c + 1) <= i + boardSize - 1 && i + boardSize - 1 < board.length)
                {
                    if(board[c].equals(board[c+1]))
                        currentlyConnected++;
                }
                if(currentlyConnected == 2)
                {
                    System.out.println(board[c] + "'s Win!");
                    return true;
                }
                currentlyConnected = 0;
                if((c + 1) <= i + boardSize - 1 && i + boardSize - 1 < board.length)
                {
                    if(board[c].equals(board[c+1]))
                        currentlyConnected++;
                }
                if((c + 2) <= i + boardSize - 1 && i + boardSize - 1 < board.length)
                {
                    if(board[c].equals(board[c+2]))
                        currentlyConnected++;
                }
                if(currentlyConnected == 2)
                {
                    System.out.println(board[c] + "'s Win!");
                    return true;
                }
                currentlyConnected = 0;
                if((c - 1) >= i)
                {
                    if(board[c].equals(board[c-1]))
                        currentlyConnected++;
                }
                if((c - 2) >= i)
                {
                    if(board[c].equals(board[c-2]))
                        currentlyConnected++;
                }
                if(currentlyConnected == 2)
                {
                    System.out.println(board[c] + "'s Win!");
                    return true;
                }
                currentlyConnected = 0;
                if((c + boardSize) <= i + boardSize && i + boardSize < board.length)
                {
                    if(board[c].equals(board[c + boardSize]))
                        currentlyConnected++;
                }
                if((c - boardSize) >= i - boardSize && i - boardSize >= 0)
                {
                    if(board[c].equals(board[c - boardSize]))
                        currentlyConnected++;
                }
                if(currentlyConnected == 2)
                {
                    System.out.println(board[c] + "'s Win!");
                    return true;
                }
                currentlyConnected = 0;
                if((c + boardSize) <= i + boardSize && i + boardSize < board.length)
                {
                    if(board[c].equals(board[c + boardSize]))
                        currentlyConnected++;
                }
                if((c + boardSize*2) <= i + boardSize*2 && i + boardSize*2 < board.length)
                {
                    if(board[c].equals(board[c + boardSize*2]))
                        currentlyConnected++;
                }
                if(currentlyConnected == 2)
                {
                    System.out.println(board[c] + "'s Win!");
                    return true;
                }
                currentlyConnected = 0;
                if((c - boardSize) >= i - boardSize && i - boardSize >= 0)
                {
                    if(board[c].equals(board[c - boardSize]))
                        currentlyConnected++;
                }
                if((c - boardSize*2) >= i - boardSize*2 && i - boardSize*2 >= 0)
                {
                    if(board[c].equals(board[c - boardSize*2]))
                        currentlyConnected++;
                }
                if(currentlyConnected == 2)
                {
                    System.out.println(board[c] + "'s Win!");
                    return true;
                }
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
                currentlyConnected = 0;
                if((c - boardSize - 1) > 0)
                {
                    if(board[c].equals(board[c - boardSize - 1]))
                        currentlyConnected++;
                }
                if((c + boardSize + 1) < board.length)
                {
                    if(board[c].equals(board[c + boardSize + 1]))
                        currentlyConnected++;
                }
                if(currentlyConnected == 2)
                {
                    System.out.println(board[c] + "'s Win!");
                    return true;
                }
                currentlyConnected = 0;
                if((c - boardSize+ 1) > 0)
                {
                    if(board[c].equals(board[c - boardSize + 1]))
                        currentlyConnected++;
                }
                if((c + boardSize - 1) < board.length)
                {
                    if(board[c].equals(board[c + boardSize - 1]))
                        currentlyConnected++;
                }
                if(currentlyConnected == 2)
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
