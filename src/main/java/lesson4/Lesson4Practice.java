package lesson4;

import net.bytebuddy.description.field.FieldDescription;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lesson4Practice {
    public static void main(String[] args) {
        //dayOfWeek();
        //taskOneTwo(6,6,2,6);
        //taskThree(4, 2, 7, 2, 7);
        taskFour("Gary", "Gary");
    }

    public static void dayOfWeek() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number from 1 to 7: ");
        String s = scanner.nextLine();
        //int dayNumber = Integer.parseInt(s);

        switch(s){
            case "1":
                System.out.println("This is Monday.");
                break;
            case "2":
                System.out.println("This is Tuesday.");
                break;
            case "3":
                System.out.println("This is Wednesday.");
                break;
            case "4":
                System.out.println("This is Thursday.");
                break;
            case "5":
                System.out.println("This is Friday.");
                break;
            case "6":
                System.out.println("This is Saturday.");
                break;
            case "7":
                System.out.println("This is Sunday.");
                break;
            default:
                System.out.println("There is no such day of week.");
                break;
        }
    }

    public static void taskOneTwo(int i, int j, int k, int l) {
        List<Integer> list = Arrays.asList(j, k, l);
        int min = i;
        for (int value : list) {
            if (min > value) {
                min = value;
            }
        }
        System.out.println("Min number is: " + min);

        int max = i;
        int maxAmount = 1;
        for (int value : list) {
            if (max < value) {
                max = value;
                maxAmount = 1;
            }
            else if (max == value) {
                maxAmount++;
            }
        }

        System.out.println("Max numbers amount = " + maxAmount);
    }

    public static void taskThree(int i, int j, int k, int l, int m){
        int arr[] = {i, j, k, l, m};
        Arrays.sort(arr);
        System.out.println("Min element = " + arr[0]);
        System.out.println("Max element = " + arr[arr.length - 1]);
    }

    public static void taskFour(String nameFirst, String nameSecond){
        if (nameFirst.equals(nameSecond)) {
            System.out.println("These people are namesakes.");
        }
    }

    public static void taskFive(int i){
        //TODO: specify the task
    }

}
