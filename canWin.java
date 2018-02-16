
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
        for(int i = 0; i < board.length; i++)
        {
            if((i - 1) >= 0)
            {
                if(board[i].equals(board[i-1]))
                    currentlyConnected++;
                else
                    winMovePos = (i-1);
            }
            if((i + 1) < board.length)
            {
                if(board[i].equals(board[i+1]))
                    currentlyConnected++;
                else
                    winMovePos = (i+1);
            }
            if(currentlyConnected == 1)
            {
                return winMovePos;
            }
            currentlyConnected = 0;
            winMovePos = -1;
            if((i + 1) < board.length)
            {
                if(board[i].equals(board[i+1]))
                    currentlyConnected++;
                else
                    winMovePos = (i+1);
            }
            if((i + 2) < board.length)
            {
                if(board[i].equals(board[i+2]))
                    currentlyConnected++;
                else
                    winMovePos = (i+2);
            }
            if(currentlyConnected == 1)
            {
                return winMovePos;
            }
            currentlyConnected = 0;
            winMovePos = -1;
            if((i - 1) >= 0)
            {
                if(board[i].equals(board[i-1]))
                    currentlyConnected++;
                else
                    winMovePos = (i-1);
            }
            if((i - 2) >= 0)
            {
                if(board[i].equals(board[i-2]))
                    currentlyConnected++;
                else
                    winMovePos = (i-2);
            }
            if(currentlyConnected == 1)
            {
                return winMovePos;
            }
            currentlyConnected = 0;
            winMovePos = -1;
            if((i + boardSize) < board.length)
            {
                if(board[i].equals(board[i + boardSize]))
                    currentlyConnected++;
                else
                    winMovePos = (i+boardSize);
            }
            if((i - boardSize) >= 0)
            {
                if(board[i].equals(board[i - boardSize]))
                    currentlyConnected++;
                else
                    winMovePos = (i-boardSize);
            }
            if(currentlyConnected == 1)
            {
                return winMovePos;
            }
            currentlyConnected = 0;
            winMovePos = -1;
            if((i + boardSize) < board.length)
            {
                if(board[i].equals(board[i + boardSize]))
                    currentlyConnected++;
                else
                    winMovePos = (i+boardSize);
            }
            if((i + boardSize*2) < board.length)
            {
                if(board[i].equals(board[i + boardSize*2]))
                    currentlyConnected++;
                else
                    winMovePos = (i+boardSize*2);
            }
            if(currentlyConnected == 1)
            {
                return winMovePos;
            }
            currentlyConnected = 0;
            winMovePos = -1;
            if((i - boardSize) >= 0)
            {
                if(board[i].equals(board[i - boardSize]))
                    currentlyConnected++;
                else
                    winMovePos = (i-boardSize);
            }
            if((i - boardSize*2) >= 0)
            {
                if(board[i].equals(board[i - boardSize*2]))
                    currentlyConnected++;
                else
                    winMovePos = (i-boardSize*2);
            }
            if(currentlyConnected == 1)
            {
                return winMovePos;
            }
        }
        return -1;
    }

    public int canWinInDiag(String[] board, int boardSize)
    {
        int currentlyConnected = 0;
        int winMovePos = -1;
        for(int i = 0; i < board.length; i++)
        {
            if((i - boardSize - 1) >= 0)
            {
                if(board[i].equals(board[i - boardSize - 1]))
                    currentlyConnected++;
                else
                    winMovePos = (i - boardSize - 1);
            }
            if((i + boardSize + 1) < board.length)
            {
                if(board[i].equals(board[i + boardSize + 1]))
                    currentlyConnected++;
                else
                    winMovePos = (i + boardSize + 1);
            }
            if(currentlyConnected == 1)
            {
                return winMovePos;
            }
            currentlyConnected = 0;
            winMovePos = -1;
            if((i - boardSize+ 1) >= 0)
            {
                if(board[i].equals(board[i - boardSize + 1]))
                    currentlyConnected++;
                else
                    winMovePos = (i - boardSize + 1);
            }
            if((i + boardSize - 1) < board.length)
            {
                if(board[i].equals(board[i + boardSize - 1]))
                    currentlyConnected++;
                else
                    winMovePos = (i + boardSize - 1);
            }
            if(currentlyConnected == 1)
            {
                return winMovePos;
            }
        }
        return -1;
    }
}
