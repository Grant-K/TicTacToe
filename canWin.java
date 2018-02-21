
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
                for(int ci = 1; ci < boardSize; ci++)
                {
                    if((c + ci) <= i + boardSize - 1)
                    {
                        if(board[c].equals(board[c+ci]))
                            currentlyConnected++;
                        else
                            winMovePos = (c + ci);
                    }
                }
                if(currentlyConnected == boardSize - 2 && winMovePos > -1 && (board[winMovePos].equals("X") == false) && (board[winMovePos].equals("O") == false))
                {
                    return winMovePos;
                }
                currentlyConnected = 0;
                winMovePos = -1;
                for(int ci = 1; ci < boardSize; ci++)
                {
                    if((c + boardSize*ci) <= i + boardSize*ci + boardSize - 1 && i + boardSize*ci + boardSize - 1 < board.length)
                    {
                        if(board[c].equals(board[c + boardSize*ci]))
                            currentlyConnected++;
                        else
                            winMovePos = (c + boardSize*ci);
                    }
                }
                System.out.println("Currently Connected " + currentlyConnected);
                if(currentlyConnected == boardSize - 2 && winMovePos > -1 && (board[winMovePos].equals("X") == false) && (board[winMovePos].equals("O") == false))
                {
                    return winMovePos;
                }
                currentlyConnected = 0;
                winMovePos = -1;
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
                for(int ci = 1; ci < boardSize; ci++)
                {
                    if((c + boardSize*ci + ci) < board.length)
                    {
                        if(board[c].equals(board[c + boardSize*ci + ci]))
                            currentlyConnected++;
                        else
                            winMovePos = (c + boardSize*ci + ci);
                    }
                }
                if(currentlyConnected == boardSize - 2 && winMovePos > -1 && (board[winMovePos].equals("X") == false) && (board[winMovePos].equals("O") == false))
                {
                    return winMovePos;
                }
                currentlyConnected = 0;
                winMovePos = -1;
                for(int ci = 1; ci < boardSize; ci++)
                {
                    if((c + boardSize*ci - ci) >= i + boardSize*ci && i + boardSize*ci < board.length)
                    {
                        if(board[c].equals(board[c + boardSize*ci - ci]))
                            currentlyConnected++;
                        else
                            winMovePos = (c + boardSize*ci - ci);
                    }
                }
                if(currentlyConnected == boardSize - 2 && winMovePos > -1 && (board[winMovePos].equals("X") == false) && (board[winMovePos].equals("O") == false))
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
