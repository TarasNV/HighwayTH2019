package lesson6;

public class ArrayMinMax {

    public static void main(String[] args){
        int ar[] = {2,3,-1,6,6,6,7,8,9,0,1111};

        int min = ar[1];
        int max = ar[1];

        for (int i : ar) {
            if (ar[i] < min)
                min = ar[i];
            if (ar[i] > max)
                max = ar[i];
        }

        System.out.println("Max element is: " + max);
        System.out.println("Min element is: " + min);
    }
}
