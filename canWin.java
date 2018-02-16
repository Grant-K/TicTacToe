
/**
 * Write a description of class WinnerCheck here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class canWin
{
    public int someoneCanWin(String[] board, int boardSize)
    {
        int winPos = -1;
        //System.out.println("Doing Line Check!");
        winPos = canWinInLine(board,boardSize);
        if(winPos == -1)
        {
            //System.out.println("Doing Diagnal Check!");
            winPos = canWinInDiag(board,boardSize);
        }
        return winPos;
    }

    public int canWinInLine(String[] board, int boardSize)
    {
        int currentlyConnected = 0;
        int winMovePos = -1;
        for(int i = 0; i < board.length; i += boardSize)
        {
            for(int c = i; c < boardSize*((i + boardSize)/boardSize); c++)
            {
                if((c - 1) >= i)
                {
                    if(board[c].equals(board[c-1]))
                        currentlyConnected++;
                    else
                        winMovePos = (c-1);
                }
                if((c + 1) <= i + boardSize - 1  && i + boardSize - 1 < board.length)
                {
                    if(board[c].equals(board[c+1]))
                        currentlyConnected++;
                    else
                        winMovePos = (c+1);
                }
                if(currentlyConnected == 1 && winMovePos > -1)
                {
                    return winMovePos;
                }
                currentlyConnected = 0;
                winMovePos = -1;
                if((c + 1) <= i + boardSize - 1 && i + boardSize - 1 < board.length)
                {
                    if(board[c].equals(board[c+1]))
                        currentlyConnected++;
                    else
                        winMovePos = (c+1);
                }
                if((c + 2) <= i + boardSize - 1  && i + boardSize - 1 < board.length)
                {
                    if(board[c].equals(board[c+2]))
                        currentlyConnected++;
                    else
                        winMovePos = (c+2);
                }
                if(currentlyConnected == 1 && winMovePos > -1)
                {
                    return winMovePos;
                }
                currentlyConnected = 0;
                winMovePos = -1;
                if((c - 1) >= i)
                {
                    if(board[c].equals(board[c-1]))
                        currentlyConnected++;
                    else
                        winMovePos = (c-1);
                }
                if((c - 2) >= i)
                {
                    if(board[c].equals(board[c-2]))
                        currentlyConnected++;
                    else
                        winMovePos = (c-2);
                }
                if(currentlyConnected == 1 && winMovePos > -1)
                {
                    return winMovePos;
                }
                currentlyConnected = 0;
                winMovePos = -1;
                if((c + boardSize) <= i + boardSize + (c - i)  && i + boardSize + (c - i) < board.length)
                {
                    if(board[c].equals(board[c + boardSize]))
                        currentlyConnected++;
                    else
                        winMovePos = (c+boardSize);
                }
                if((c - boardSize) >= i - boardSize && i - boardSize >= 0)
                {
                    if(board[c].equals(board[c - boardSize]))
                        currentlyConnected++;
                    else
                        winMovePos = (c-boardSize);
                }
                if(currentlyConnected == 1 && winMovePos > -1)
                {
                    return winMovePos;
                }
                currentlyConnected = 0;
                winMovePos = -1;
                if((c + boardSize) <= i + boardSize + (c - i)  && i + boardSize + (c - i) < board.length)
                {
                    if(board[c].equals(board[c + boardSize]))
                        currentlyConnected++;
                    else
                        winMovePos = (c+boardSize);
                }
                if((c + boardSize*2) <= i + boardSize*2 + (c - i)  && i + boardSize*2 + (c - i) < board.length)
                {
                    if(board[c].equals(board[c + boardSize*2]))
                        currentlyConnected++;
                    else
                        winMovePos = (c+boardSize*2);
                }
                if(currentlyConnected == 1 && winMovePos > -1)
                {
                    return winMovePos;
                }
                currentlyConnected = 0;
                winMovePos = -1;
                if((c - boardSize) >= i - boardSize && i - boardSize >= 0)
                {
                    if(board[c].equals(board[c - boardSize]))
                        currentlyConnected++;
                    else
                        winMovePos = (c-boardSize);
                }
                if((c - boardSize*2) >= i - boardSize*2 && i - boardSize*2 >= 0)
                {
                    if(board[c].equals(board[c - boardSize*2]))
                        currentlyConnected++;
                    else
                        winMovePos = (c-boardSize*2);
                }
                if(currentlyConnected == 1 && winMovePos > -1)
                {
                    return winMovePos;
                }
            }
        }
        return -1;
    }

    public int canWinInDiag(String[] board, int boardSize)
    {
        int currentlyConnected = 0;
        int winMovePos = -1;
        for(int i = 0; i < board.length; i += boardSize)
        {
            for(int c = i; c < boardSize*((i + boardSize)/boardSize); c++)
            {
                if((c - boardSize - 1) > 0)
                {
                    if(board[c].equals(board[c - boardSize - 1]))
                        currentlyConnected++;
                    else
                        winMovePos = (c - boardSize - 1);
                }
                if((c + boardSize + 1) < board.length)
                {
                    if(board[c].equals(board[c + boardSize + 1]))
                        currentlyConnected++;
                    else
                        winMovePos = (c + boardSize + 1);
                }
                if(currentlyConnected == 1 && winMovePos > -1)
                {
                    return winMovePos;
                }
                currentlyConnected = 0;
                winMovePos = -1;
                if((c - boardSize + 1) > 0)
                {
                    if(board[c].equals(board[c - boardSize + 1]))
                        currentlyConnected++;
                    else
                        winMovePos = (c - boardSize + 1);
                }
                if((c + boardSize - 1) < board.length)
                {
                    if(board[c].equals(board[c + boardSize - 1]))
                        currentlyConnected++;
                    else
                        winMovePos = (c + boardSize - 1);
                }
                if(currentlyConnected == 1 && winMovePos > -1)
                {
                    return winMovePos;
                }
                currentlyConnected = 0;
                winMovePos = -1;
            }
        }
        return -1;
    }
}
