package lesson2;

public class HomeTask2_4 {
    public static void main(String[] args){
        taskOne(10,3);
        taskTwo(22);
        taskThree(23.49f);
        taskFour(946);
    }

    private static void taskOne(int q, int w){
        int quotient = q / w;
        int remainder = q % w;
        System.out.println("Result of division of number q and w : quotient  = " + quotient + ", remainder = " + remainder);
    }

    private static void taskTwo(int n){
        int firstDigit = n / 10;
        int secondDigit = n % 10;
        int sum = firstDigit + secondDigit;
        System.out.println("Sum of first and second digits = " + sum);
    }

    private static void taskThree(float n){
        int result = Math.round(n);
        System.out.println(n + " rounded value = " + result);
    }

    private static void taskFour(int n){
        int thirdDigit = n % 100 % 10;
        int secondDigit = (n / 10) % 10;
        int firstDigit = n / 100;
        int sum = firstDigit + secondDigit + thirdDigit;
        System.out.println("Sum of number digits = " + sum);
    }
}
