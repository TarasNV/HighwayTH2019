import lesson6.TicTacToeHomework;
import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Parameters;
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
        String resultActual = TicTacToeHomework.checkGameResult(board, 6);
        Assert.assertEquals(resultActual, resultExpected, "Incorrect result.");
    }

    @Test
    public static void checkGameResultLine2Tests(){
        String[][] board = initialiseBoard();
        for (int i = 0; i < 3; i++) {
            board[1][i] = "X";
        }
        String resultExpected = "Winner: X";
        String resultActual = TicTacToeHomework.checkGameResult(board, 6);
        Assert.assertEquals(resultActual, resultExpected, "Incorrect result.");
    }

    @Test
    public static void checkGameResultLine3Tests(){
        String[][] board = initialiseBoard();
        for (int i = 0; i < 3; i++) {
            board[2][i] = "X";
        }
        String resultExpected = "Winner: X";
        String resultActual = TicTacToeHomework.checkGameResult(board, 6);
        Assert.assertEquals(resultActual, resultExpected, "Incorrect result.");
    }

    @Test
    public static void checkGameResultCol1Tests(){
        String[][] board = initialiseBoard();
        for (int i = 0; i < 3; i++) {
            board[i][0] = "X";
        }
        String resultExpected = "Winner: X";
        String resultActual = TicTacToeHomework.checkGameResult(board, 6);
        Assert.assertEquals(resultActual, resultExpected, "Incorrect result.");
    }

    @Test
    public static void checkGameResultCol2Tests(){
        String[][] board = initialiseBoard();
        for (int i = 0; i < 3; i++) {
            board[i][1] = "X";
        }
        String resultExpected = "Winner: X";
        String resultActual = TicTacToeHomework.checkGameResult(board, 6);
        Assert.assertEquals(resultActual, resultExpected, "Incorrect result.");
    }

    @Test
    public static void checkGameResultCol3Tests(){
        String[][] board = initialiseBoard();
        for (int i = 0; i < 3; i++) {
            board[i][2] = "X";
        }
        String resultExpected = "Winner: X";
        String resultActual = TicTacToeHomework.checkGameResult(board, 6);
        Assert.assertEquals(resultActual, resultExpected, "Incorrect result.");
    }

    @Test
    public static void checkGameResultD1Tests(){
        String[][] board = initialiseBoard();
        for (int i = 0; i < 3; i++) {
            board[i][i] = "X";
        }
        String resultExpected = "Winner: X";
        String resultActual = TicTacToeHomework.checkGameResult(board, 6);
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
        String resultActual = TicTacToeHomework.checkGameResult(board, 6);
        Assert.assertEquals(resultActual, resultExpected, "Incorrect result.");
    }

    @Test
    public static void checkGameResultV3Test() {
        String [][] board = new String[3][3];
        int k = 1;

        String[] boardLine = new String[24];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = String.valueOf(k);
                k++;
            }
        }

        int l = 0;
        int d = 18;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardLine[l] = board[i][j];
                boardLine[l + 9] = board[j][i];
                l++;
            }
            boardLine[d] = board[i][i];
            boardLine[d + 3] = board[i][2 - i];
            d++;
        }

        for (String element : boardLine) {
            System.out.print(element + " ");
        }


    }

    @Test
    public static void boardToLineTest() {
        String board[][] = new String[3][3];
        String line[] = new String[24];
        int k = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = String.valueOf(k);
                k++;
            }
        }

        line = boardToLine(board);
        for (String element : line) {
            System.out.print(element + " ");
        }
    }

    @Test
    @Parameters()
    public static void lineToBoardTest() {
        String[] line = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "11", "44", "77", "22", "55", "88", "33", "66", "99", "111", "555", "999", "3333", "5555", "7777"};
        for (int i = 0; i < 24; i++) {
            String[][] board = lineToBoard(line, i);
            printBoard(board);
            System.out.println("lastUpdate = " + i);
        }


    }

    @Test
    public static void computerStrongTurnTest() {

    }

}
