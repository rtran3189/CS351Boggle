import java.util.Random;
import java.util.TreeSet;

public class Tray
{
    private String letters;
    private int lettersLength;
    private char[][] trayArray;
    private int[] charArray;
    private TreeSet<String> validWordList;
    private final int ROW_SIZE = 5;
    private final int COL_SIZE = 5;


    public Tray()
    {
        letters = "abcdefghijklmnopqrstuvwxyz";
        lettersLength = letters.length();
        trayArray = new char[ROW_SIZE][COL_SIZE];
        charArray = new int[letters.length()];
        validWordList = new TreeSet<>();
        this.generateTray();
    }

    //TODO: no char can appear more than 4 times.
    //TODO: Q increases chances of U next to it somewhere.
    private void generateTray()
    {
        Random r = new Random();
        int randomNum;

        for (int i = 0; i < ROW_SIZE; i++)
        {
            for (int j = 0; j < COL_SIZE; j++)
            {
                randomNum = r.nextInt(lettersLength);
                trayArray[i][j] = letters.charAt(randomNum);
                charArray[randomNum]++;
            }
        }
    }

    public void printTray()
    {
        for (int row = 0; row < ROW_SIZE; row++)
        {
            for (int col = 0; col < COL_SIZE; col++)
            {
                System.out.print(trayArray[row][col] + " ");
            }
            System.out.print("\n");
        }
    }


    public boolean doesExist(String word)
    {
        int rowLength = trayArray.length;
        int colLength = trayArray[0].length;

        boolean result = false;

        for(int i=0; i<rowLength; i++)
        {
            for(int j=0; j<colLength; j++)
            {
                if(checkSurround(trayArray,word,i,j,0))
                {
                    result = true;
                }
            }
        }

        return result;
    }

    private boolean checkSurround(char[][] board, String word, int row, int col, int searchIndex) {
        int m = board.length;
        int n = board[0].length;

        if (row < 0 || col < 0 || row >= m || col >= n) {
            return false;
        }

        if (board[row][col] == word.charAt(searchIndex)) {
            char temp = board[row][col];
            board[row][col] = '#';
            if (searchIndex == word.length() - 1) {
                board[row][col] = temp;
                return true;
            } else if (checkSurround(board, word, row - 1, col, searchIndex + 1)
                    || checkSurround(board, word, row + 1, col, searchIndex + 1)
                    || checkSurround(board, word, row, col - 1, searchIndex + 1)
                    || checkSurround(board, word, row, col + 1, searchIndex + 1)
                    || checkSurround(board, word, row + 1, col + 1, searchIndex + 1)
                    || checkSurround(board, word, row - 1, col - 1, searchIndex + 1)
                    || checkSurround(board, word, row - 1, col + 1, searchIndex + 1)
                    || checkSurround(board, word, row + 1, col - 1, searchIndex + 1)) {
                board[row][col] = temp;
                return true;
            }
            board[row][col] = temp;
        }
        return false;
    }
}
