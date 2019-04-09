package lesson2;

import java.util.Scanner;

public class HomeTask2_3 {

    public static void main(String[] args){
        charToInt();
        intToChar();
    }

    private static void charToInt(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter character: ");
        String inputValue = scanner.nextLine();

        char[] charValueArr =  inputValue.toCharArray();
        char charValue = charValueArr[0];
        int intValue = charValue;
        System.out.println("Char to Int result is: " + intValue);
    }

    private static void intToChar(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter integer number: ");
        String inputValue = scanner.nextLine();

        int intValue = Integer.parseInt(inputValue);
        char charValue = (char) intValue;
        System.out.println("Int to Char result is: " + charValue);
    }
}
