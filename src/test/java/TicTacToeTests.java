import org.testng.Assert;
import org.testng.annotations.Test;

import static lesson6.TicTacToeHomework.*;

public class TicTacToeTests {

    @Test
    public static void checkGameResultLine1Tests(){
        String[][] board = initialiseBoard();
        for (int i = 0; i < 3; i++) {
            board[0][i] = "X";
        }
        String resultExpected = "Winner: X";
        String resultActual = checkGameResult(board, 6);
        Assert.assertEquals(resultActual, resultExpected, "Incorrect result.");
    }

    @Test
    public static void checkGameResultLine2Tests(){
        String[][] board = initialiseBoard();
        for (int i = 0; i < 3; i++) {
            board[1][i] = "X";
        }
        String resultExpected = "Winner: X";
        String resultActual = checkGameResult(board, 6);
        Assert.assertEquals(resultActual, resultExpected, "Incorrect result.");
    }

    @Test
    public static void checkGameResultLine3Tests(){
        String[][] board = initialiseBoard();
        for (int i = 0; i < 3; i++) {
            board[2][i] = "X";
        }
        String resultExpected = "Winner: X";
        String resultActual = checkGameResult(board, 6);
        Assert.assertEquals(resultActual, resultExpected, "Incorrect result.");
    }

    @Test
    public static void checkGameResultCol1Tests(){
        String[][] board = initialiseBoard();
        for (int i = 0; i < 3; i++) {
            board[i][0] = "X";
        }
        String resultExpected = "Winner: X";
        String resultActual = checkGameResult(board, 6);
        Assert.assertEquals(resultActual, resultExpected, "Incorrect result.");
    }

    @Test
    public static void checkGameResultCol2Tests(){
        String[][] board = initialiseBoard();
        for (int i = 0; i < 3; i++) {
            board[i][1] = "X";
        }
        String resultExpected = "Winner: X";
        String resultActual = checkGameResult(board, 6);
        Assert.assertEquals(resultActual, resultExpected, "Incorrect result.");
    }

    @Test
    public static void checkGameResultCol3Tests(){
        String[][] board = initialiseBoard();
        for (int i = 0; i < 3; i++) {
            board[i][2] = "X";
        }
        String resultExpected = "Winner: X";
        String resultActual = checkGameResult(board, 6);
        Assert.assertEquals(resultActual, resultExpected, "Incorrect result.");
    }

    @Test
    public static void checkGameResultD1Tests(){
        String[][] board = initialiseBoard();
        for (int i = 0; i < 3; i++) {
            board[i][i] = "X";
        }
        String resultExpected = "Winner: X";
        String resultActual = checkGameResult(board, 6);
        Assert.assertEquals(resultActual, resultExpected, "Incorrect result.");
    }

    @Test
    public static void checkGameResultD2Tests(){
        String[][] board = initialiseBoard();
        int k = 2;
        for (int i = 0; i < 3; i++) {
            board[i][k] = "X";
            k = k - 1;
        }
        String resultExpected = "Winner: X";
        String resultActual = checkGameResult(board, 6);
        Assert.assertEquals(resultActual, resultExpected, "Incorrect result.");
    }

    @Test
    public static void
}
