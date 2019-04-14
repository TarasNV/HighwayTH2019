package lesson6;

public class BubbleSort {

    public static void main(String[] args){
        int[] arr = {12, 43, 21, 45, 22, -6, 12, 5, 6};
        int temp;

        boolean flag = true;
        for (int j : arr) {
            flag = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    flag = true;
                }
            }

            for (int element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
            if (!flag)
                break;
        }


    }
}
