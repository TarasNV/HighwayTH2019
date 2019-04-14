package lesson6;

import java.util.Arrays;

public class ArraysClassExample {
    public static void main(String[] args) {
        /*int someArray[] = {1, 5, 7, 2, 0};
        Arrays.sort(someArray);
        System.out.println("Sorted array:" + Arrays.toString(someArray));*/
        charArray();
    }

    public static void charArray(){
        char[] arr = new char[255];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char)i;
            System.out.print(arr[i] + " ");
        }

    }
}
