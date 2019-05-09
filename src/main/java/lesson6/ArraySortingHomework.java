package lesson6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArraySortingHomework {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of array elements: ");
        String s = scanner.nextLine();
        int n = Integer.parseInt(s);
        List<Integer> arr = generateArr(n);
        printArr(arr);
        List<Integer> sortedArr = shellSort(arr);
        printArr(sortedArr);
    }

    public static List<Integer> generateArr(int n){
        List<Integer> array = new ArrayList<Integer>();
        Random random = new Random();

        for (int i = 0; i < n; i++)
        {
            array.add(random.nextInt(50)-25);
        }
        return array;
    }

    public static List<Integer> shellSort(List<Integer> arr) {
        for (int h = arr.size() / 2; h > 0; h /= 2) {
            insertSort(arr, h);
        }
        return arr;
    }

    private static List<Integer> insertSort(List<Integer> arr, int h){
        int temp;
        for (int i = 0; i < arr.size(); i = i + h) {
            for (int j = i; j > 0; j--) {
                if  (arr.get(j-1) > arr.get(j)) {
                    temp = arr.get(j);
                    arr.set(j, arr.get(j - 1));
                    arr.set(j - 1, temp);
                }
            }
        }
        return arr;
    }
    public static void printArr(List<Integer> array) {
        for (int element : array) {
            System.out.print(element + "  ");
        }
        System.out.println();
    }
}
