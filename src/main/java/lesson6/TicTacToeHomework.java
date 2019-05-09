package lesson6;

import java.lang.reflect.Array;
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
                HumanVsComputer();
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
        do {
            System.out.println("X turn:");
            oneComputerRandomTurn(board, teamOne);
            freeCells--;
            result = checkGameResult(board, freeCells);
            if (result.equals("")) {
                System.out.println("O turn:");
                oneComputerRandomTurn(board, teamTwo);
                freeCells--;
                result = checkGameResult(board, freeCells);
            }
        }
        while (result.equals(""));
        System.out.println(result);

    }

    public static void HumanVsComputer() {
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
                oneHumanTurn(board, teamOne);
                freeCells--;
                result = checkGameResult(board, freeCells);
                if (result.equals("")) {
                    System.out.println("O turn:");
                    oneComputerRandomTurn(board, teamTwo);
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
                oneComputerRandomTurn(board, teamOne);
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
    }

    public static void oneHumanTurn(String[][] board, String team) {
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
        printBoard(board);
    }

    public static void oneComputerRandomTurn(String[][] board, String team) {
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
        printBoard(board);
    }

    public static boolean isNotMine(String cell, String myTeam) {
        boolean result;
        if ((myTeam.equals("X")) && (cell.equals("X"))) {
            result = false;
        } else if ((myTeam.equals("X")) && (cell.equals("O"))) {
            result = true;
        } else if ((myTeam.equals("0")) && (cell.equals("X"))) {
            result = true;
        } else if((myTeam.equals("0")) && (cell.equals("O"))) {
            result = false;
        } else result = false;
            return result;
    }


    public static void oneComputerStrongTurn(String[][] board, String team) {
        int line;
        int column;
        String[] a = new String[9];
        String[] b = new String[9];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[k] = board[i][j];
                b[k] = board[j][i];
                k++;
            }
        }
        boolean flag = true;
        while (flag) {

                for (int i = 0; i < 7; i += 3) {
                    if ((a[i].equals(a[i + 1])) && (isNotMine(a[i], team))) {
                        a[i + 2] = team;
                        flag = false;
                        break;
                    } else if ((a[i].equals(a[i + 2])) && (isNotMine(a[i], team))) {
                        a[i + 1] = team;
                        flag = false;
                        break;
                    } else if ((a[i + 1].equals(a[i + 2])) && (isNotMine(a[i + 1], team))) {
                        a[i] = team;
                        flag = false;
                        break;
                    } else if ((b[i].equals(b[i + 1])) && (isNotMine(b[i], team))) {
                        b[i + 2] = team;
                        flag = false;
                        break;
                    } else if ((b[i].equals(b[i + 2])) && (isNotMine(b[i], team))) {
                        b[i + 1] = team;
                        flag = false;
                        break;
                    } else if ((b[i + 1].equals(b[i + 2])) && (isNotMine(b[i + 1], team))) {
                        b[i] = team;
                        flag = false;
                        break;
                    }
                }

        }
    }

    public static void oneComputerLightTurn(String[][] board, String team) {

    }

    public static int selectMode(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe! Select the game mode: \n1 - Computer Vs Computer\n2 - Human Vs Computer\n3 - Human Vs Human\n4 - Exit");
        String m = scanner.nextLine();
        int mode = Integer.valueOf(m);
        return mode;
    }

    public static String checkGameResult(String[][] board, int freeCells){
        String result = "";

        String[] a = new String[9];
        String[] b = new String[9];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[k] = board[i][j];
                b[k] = board[j][i];
                k++;
            }
        }
        for (int i = 0; i < 7; i += 3) {
            if ((a[i].equals(a[i + 1])) && (a[i + 1].equals(a[i + 2])) && (a[i].equals("X") || a[i].equals("O"))) {
                result = "Winner: " + a[i];
                break;
            } else if ((b[i].equals(b[i + 1])) && (b[i + 1].equals(b[i + 2])) && (b[i].equals("X") || b[i].equals("O"))) {
                result = "Winner: " + b[i];
                break;
            }
        }
        if (result.equals("")) {
            if (((a[0].equals(a[4]) && a[4].equals(a[8])) && (a[4].equals("X") || a[4].equals("O"))) || ((a[2].equals(a[4]) && a[4].equals(a[6]))) && (a[4].equals("X") || a[4].equals("O"))) {
                result = "Winner: " + a[4];
            }
            else if (freeCells == 0) {
                result = "No winner";
            }
        }
        return result;
    }

    public static String[] checkGameResultV2(String[][] board, int freeCells) {
        String result="";
        String[] lineOne = new String[3];
        String[] lineTwo = new String[3];
        String[] lineThree = new String[3];
        String[] columnOne = new String[3];
        String[] columnTwo = new String[3];
        String[] columnThree = new String[3];
        String[] diagonalOne = new String[3];
        String[] diagonalTwo = new String[3];

        String[] line = new String[24];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                line[k] = board[i][j];
                k++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                line[k] = board[j][i];
                k++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                line[k] = board[i][i];
                k++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 3; j > 0; j--) {
                line[k] = board[j][i];
                k++;
            }
        }

        return line;
    }



}
