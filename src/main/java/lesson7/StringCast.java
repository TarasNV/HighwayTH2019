package lesson7;

public class StringCast {
    public static void main(String[] args) {
        String s = "123.123";
        int sToInt = Integer.valueOf(s);

        String sToIntToString = String.valueOf(sToInt);

    }
}
