package lesson6;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeHomework {

    public static void main(String[] args) {
        int mode = selectMode();
        switch (mode) {
            case 1 :
                ComputerVsComputer();
                break;
            case 2 :
                //int modeHumanComputer = selectModeHumanComputer();
                HumanVsComputer(selectModeHumanComputer());
                break;
            case 3 :
                HumanVsHuman();
                break;
            case 4 :
                break;
            default :
                //TODO: add loop for incorrect answer;
                break;
        }

    }

    public static void ComputerVsComputer() {
        String[][] board = initialiseBoard();
        printBoard(board);
        int freeCells = 9;
        String teamOne = "X";
        String teamTwo = "O";
        String result = "";
        while (result.equals("")) {
            System.out.println("X turn:");
            board = oneComputerRandomTurn(board, teamOne);
            printBoard(board);
            freeCells--;
            result = checkGameResult(board, freeCells);
            if (result.equals("")) {
                System.out.println("O turn:");
                board = oneComputerRandomTurn(board, teamTwo);
                printBoard(board);
                freeCells--;
                result = checkGameResult(board, freeCells);
            }
        }
        System.out.println(result);

    }

    public static void HumanVsComputer(int mode) {
        Random random = new Random();
        String[][] board = initialiseBoard();
        printBoard(board);
        int freeCells = 9;
        String teamOne = "X";
        String teamTwo = "O";
        String result = "";
        int whoStart = random.nextInt(2) ;
        if (whoStart == 1) {
            System.out.println("Human starts...");
            do {
                System.out.println("X turn:");
                board = oneHumanTurn(board, teamOne);
                printBoard(board);
                freeCells--;
                result = checkGameResult(board, freeCells);
                if (result.equals("")) {
                    System.out.println("O turn:");
                    if (mode == 1) {
                        board = oneComputerRandomTurn(board, teamTwo);
                    } else if (mode == 2) {
                        board = oneComputerStrongTurn(board, teamTwo);
                    }
                    printBoard(board);
                    freeCells--;
                    result = checkGameResult(board, freeCells);
                }
            }
            while (result.equals(""));
            System.out.println(result);
        }
        else {
            System.out.println("Computer starts...");
            do {
                System.out.println("X turn:");
                if (mode == 1) {
                    board = oneComputerRandomTurn(board, teamOne);
                } else if (mode == 2) {
                    board = oneComputerStrongTurn(board, teamOne);
                }
                printBoard(board);
                freeCells--;
                result = checkGameResult(board, freeCells);
                if (result.equals("")) {
                    System.out.println("O turn:");
                    board = oneHumanTurn(board, teamTwo);
                    printBoard(board);
                    freeCells--;
                    result = checkGameResult(board, freeCells);
                }
            }
            while (result.equals(""));
            System.out.println(result);
        }
    }

    public static void HumanVsHuman() {
        String[][] board = initialiseBoard();
        printBoard(board);
        int freeCells = 9;
        String teamOne = "X";
        String teamTwo = "O";
        String result = "";
        do {
            System.out.println("X turn:");
            oneHumanTurn(board, teamOne);
            freeCells--;
            result = checkGameResult(board, freeCells);
            if (result.equals("")) {
                System.out.println("O turn:");
                oneHumanTurn(board, teamTwo);
                freeCells--;
                result = checkGameResult(board, freeCells);
            }
        }
        while (result.equals(""));
        System.out.println(result);
    }

    public static int selectModeHumanComputer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select mode:\n1 - Light\n2 - Hard");
        String s = scanner.nextLine();
        int mode = Integer.valueOf(s);
        return mode;
    }

    public static String[][] initialiseBoard() {
        String[][] board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "-";
            }
        }
        return board;
    }

    public static void printBoard(String[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public static String[][] oneHumanTurn(String[][] board, String team) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Enter line number from 1 to 3: ");
            String l = scanner.nextLine();
            int line = Integer.valueOf(l) - 1;
            System.out.println("Enter column number from 1 to 3: ");
            String c = scanner.nextLine();
            int column = Integer.valueOf(c) - 1;
            if (board[line][column] == "-") {
                board[line][column] = team;
                flag = false;
            } else {
                System.out.println("This cell is occupied. Try another one.");
            }
        }
        return board;
    }

    public static String[][] oneComputerRandomTurn(String[][] board, String team) {
        Random random = new Random();
        int line;
        int column;
        boolean flag = true;
        while (flag) {
            line = random.nextInt(3);
            column = random.nextInt(3);
            if (board[line][column] == "-") {
                board[line][column] = team;
                flag = false;
            }
        }
        return board;
    }

    public static String[][] oneComputerStrongTurn(String[][] board, String team) {
        String[] boardLine = boardToLine(board);
        boolean flag = true;
        int lastUpdate;

        for (int i = 0; i < 22; i = i + 3) {
            if ((boardLine[i].equals(boardLine[i + 1]) && (isMine(boardLine[i], team) && (boardLine[i + 2].equals("-"))))){
                boardLine[i + 2] = team;
                lastUpdate = i + 2;
                board = lineToBoard(boardLine, lastUpdate);
                flag = false;
                break;
            } else if ((boardLine[i].equals(boardLine[i + 2]) && (isMine(boardLine[i], team) && (boardLine[i + 1].equals("-"))))){
                boardLine[i + 1] = team;
                lastUpdate = i + 1;
                board = lineToBoard(boardLine, lastUpdate);
                flag = false;
                break;
            } else if ((boardLine[i + 1].equals(boardLine[i + 2]) && (isMine(boardLine[i + 1], team) && (boardLine[i].equals("-"))))){
                boardLine[i] = team;
                lastUpdate = i;
                board = lineToBoard(boardLine, lastUpdate);
                flag = false;
                break;
            } else if ((boardLine[i].equals(boardLine[i + 1]) && (isNotMine(boardLine[i], team) && (boardLine[i + 2].equals("-"))))){
                boardLine[i + 2] = team;
                lastUpdate = i + 2;
                board = lineToBoard(boardLine, lastUpdate);
                flag = false;
                break;
            } else if ((boardLine[i].equals(boardLine[i + 2]) && (isNotMine(boardLine[i], team) && (boardLine[i + 1].equals("-"))))){
                boardLine[i + 1] = team;
                lastUpdate = i + 1;
                board = lineToBoard(boardLine, lastUpdate);
                flag = false;
                break;
            } else if ((boardLine[i + 1].equals(boardLine[i + 2]) && (isNotMine(boardLine[i + 1], team) && (boardLine[i].equals("-"))))){
                boardLine[i] = team;
                lastUpdate = i;
                board = lineToBoard(boardLine, lastUpdate);
                flag = false;
                break;
            }
        }
        if (flag) {
            if (board[1][1].equals("-")) {
                board[1][1] = team;
            } else if (board[0][0].equals("-")) {
                board[0][0] = team;
            } else if (board[0][2].equals("-")) {
                board[0][2] = team;
            } else if (board[2][0].equals("-")) {
                board[2][0] = team;
            } else if (board[2][2].equals("-")) {
                board[2][2] = team;
            } else board = oneComputerRandomTurn(board, team);
        }
        return board;
    }

    public static String[][] oneComputerLightTurn(String[][] board, String team) {
        String[] boardLine = boardToLine(board);
        int[] notAllowed = new int[24];
        int k = 0;
        for (int i = 0; i < 22; i = i + 3) {
            if ((boardLine[i].equals(boardLine[i + 1]) && (isMine(boardLine[i], team) && (boardLine[i + 2].equals("-"))))){
                notAllowed[k] = i + 2;
                k++;
            } else if ((boardLine[i].equals(boardLine[i + 2]) && (isMine(boardLine[i], team) && (boardLine[i + 1].equals("-"))))){
                notAllowed[k] = i + 1;
                k++;
            } else if ((boardLine[i + 1].equals(boardLine[i + 2]) && (isMine(boardLine[i], team) && (boardLine[i].equals("-"))))){
                notAllowed[k] = i;
                k++;
            } else if ((boardLine[i].equals(boardLine[i + 1]) && (isNotMine(boardLine[i], team) && (boardLine[i + 2].equals("-"))))){
                notAllowed[k] = i + 2;
                k++;
            } else if ((boardLine[i].equals(boardLine[i + 2]) && (isNotMine(boardLine[i], team) && (boardLine[i + 1].equals("-"))))){
                notAllowed[k] = i + 1;
                k++;
            } else if ((boardLine[i + 1].equals(boardLine[i + 2]) && (isNotMine(boardLine[i], team) && (boardLine[i].equals("-"))))){
                notAllowed[k] = i;
                k++;
            }
        }

        
        return board;
    }

    public static boolean isNotMine(String cell, String myTeam) {
        boolean result;
        if (((myTeam.equals("X")) && (cell.equals("O"))) || ((myTeam.equals("O")) && (cell.equals("X")))) {
            result = true;
        } else result = false;
            return result;
    }

    public static boolean isMine(String cell, String myTeam) {
        boolean result;
        if (((myTeam.equals("X")) && (cell.equals("X"))) || ((myTeam.equals("O")) && (cell.equals("O")))) {
            result = true;
        } else result = false;
        return result;
    }

    public static int selectMode(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe! Select the game mode: \n1 - Computer Vs Computer\n2 - Human Vs Computer\n3 - Human Vs Human\n4 - Exit");
        String m = scanner.nextLine();
        int mode = Integer.valueOf(m);
        return mode;
    }

    public static String checkGameResult(String[][] board, int freeCells) {
        String result = "";
        String[] boardLine = boardToLine(board);

        for (int i = 0; i < 22; i = i + 3) {
            if ((boardLine[i].equals(boardLine[i + 1])) && (boardLine[i + 1].equals(boardLine[i + 2])) && (boardLine[i].equals("X") || boardLine[i].equals("O"))) {
                result = "Winner: " + boardLine[i];
                break;
            }
        }
        if ((freeCells == 0) && (result.equals(""))) {
            result = "No winner.";
        }
        return result;
    }

    public static String[] boardToLine(String[][] board) {
        String[] boardLine = new String[24];
        int k = 0;
        int d = 18;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardLine[k] = board[i][j];
                boardLine[k + 9] = board[j][i];
                k++;
            }
            boardLine[d] = board[i][i];
            boardLine[d + 3] = board[i][2 - i];
            d++;

        }
        return boardLine;
    }

    public static String[][] lineToBoard (String[] line, int lastUpdate) {
        String[][] board = new String[3][3];
        int k = 0;
        if (lastUpdate < 9) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = line[k];
                    k++;
                }
            }
        }
        else if (lastUpdate >= 9) {
            k = 9;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[j][i] = line[k];
                    k++;
                }
            }
        }
        if ((lastUpdate >= 18) && (lastUpdate < 21)) {
            k = 18;
            for (int i = 0; i < 3; i++) {
                board[i][i] = line[k];
                k++;
            }
        } else if (lastUpdate >= 21){
            k = 21;
            for (int i = 0; i < 3; i++) {
                board[i][2 - i] = line[k];
                k++;
            }
        }
        return board;
    }
}
