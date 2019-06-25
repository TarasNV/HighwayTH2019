package lesson10;

public class ExceptionExample {
    public static void main(String[] args) {
        int a = 4;
        try {
            System.out.println(a / 0);
        } catch (ArithmeticException e) {
            System.out.println("EXCEPTION!!! /0");
            System.out.println(a / 1);
        }
    }
}
