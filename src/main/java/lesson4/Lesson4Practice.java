package lesson4;

import net.bytebuddy.description.field.FieldDescription;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Lesson4Practice {
    public static void main(String[] args) {
        //dayOfWeek();
        taskOneTwo(6,6,2,6);
        taskThree(4, 2, 7, 2, 7);
        taskFour("Gary", "Gary");
        taskFive(11);
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

    //

    /**
     * 1. Даны 4 числа типа int. Сравнить их и вывести наименьшее на консоль.
     * 2. Вывести на консоль количество максимальных чисел среди этих четырех.
     * List of int number to work with
     * @param i
     * @param j
     * @param k
     * @param l
     */
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

    /**
     * 3. Даны 5 чисел (тип int). Вывести вначале наименьшее, а затем наибольшее из данных чисел.
     * List of int numbers to find min and max
     * @param i
     * @param j
     * @param k
     * @param l
     * @param m
     */
    public static void taskThree(int i, int j, int k, int l, int m){
        int arr[] = {i, j, k, l, m};
        Arrays.sort(arr);
        System.out.println("Min element = " + arr[0]);
        System.out.println("Max element = " + arr[arr.length - 1]);
    }

    /**
     * 4. Даны имена 2х человек (тип String). Если имена равны, то вывести сообщение о том, что люди являются тезками.
     * @param nameFirst - first name to compare
     * @param nameSecond - second name to compare
     */
    public static void taskFour(String nameFirst, String nameSecond){
        if (nameFirst.equals(nameSecond)) {
            System.out.println("These people are namesakes.");
        }
        else {
            System.out.println("These people has different names.");
        }
    }

    /**
     * 5. Дано число месяца (тип int). Необходимо определить время года (зима, весна, лето, осень) и вывести на консоль.
     * @param i - number of month from 1 to 12
     */
    public static void taskFive(int i){
        switch (i) {
            case 3 :
            case 4 :
            case 5 :
                System.out.println("This is spring.");
                break;
            case 6 :
            case 7 :
            case 8 :
                System.out.println("This is summer.");
                break;
            case 9 :
            case 10 :
            case 11 :
                System.out.println("This is autumn.");
                break;
            case 12 :
            case 1 :
            case 2 :
                System.out.println("This is winter.");
                break;
            default :
                System.out.println("There is no month with such id.");
        }
    }

}
