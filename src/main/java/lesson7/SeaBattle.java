package lesson7;

import java.util.Scanner;

public class SeaBattle {

    public static void main(String[] args) {

    }

    public static void setHumanShips() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set 4-deck ship. Line or column?\nl - line\nc - column");
        String lineOrColumn = scanner.nextLine();
        boolean flag = true;
        while (flag) {
            switch (lineOrColumn) {
                case "l" :

                    flag = false;
                case "c" :

                    flag = false;
                default :
                    System.out.println("I don't understand you. Please enter l or c.");
                    break;
            }
        }
    }

    public static void setFourDeckShip(String[][] board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Set 4-deck ship. Line or column?\nl - line\nc - column");
        String lineOrColumn = scanner.nextLine();
        boolean flag = true;
        while (flag) {
            switch (lineOrColumn) {
                case "l" :
                    setShip(board, lineOrColumn, 4);
                    flag = false;
                case "c" :

                    flag = false;
                default :
                    System.out.println("I don't understand you. Please enter l or c: ");
                    break;
            }
        }
    }

    public static void setShip(String[][] board, String course, int deck) {
        Scanner scanner = new Scanner(System.in);
        switch (course) {
            case "l" :

                System.out.println("Please enter number of line: ");
                String lineNumberString = scanner.nextLine();
                int lineNumber = Integer.valueOf(lineNumberString);

                System.out.println("Please enter number of column of the first deck. Should be from 1 to " + (11 - deck) + ": ");
                String startColumnString = scanner.nextLine();
                int startColumn = Integer.valueOf(startColumnString);

                for (int i = startColumn; i < startColumn + deck; i++) {
                    board[lineNumber][i] = "4";
                }
                break;
            case "c" :
                System.out.println("Please enter number of column: ");
                String columnNumberString = scanner.nextLine();
                int columnNumber = Integer.valueOf(columnNumberString);

                System.out.println("Please enter number of line of the first deck. Should be from 1 to " + (11 - deck) + ": ");
                String startLineString = scanner.nextLine();
                int startLine = Integer.valueOf(startLineString);

                for (int i = startLine; i < startLine + deck; i++) {
                    board[i][columnNumber] = "4";
                }
                break;
        }
    }
}
