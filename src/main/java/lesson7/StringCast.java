package lesson7;

public class StringCast {
    public static void main(String[] args) {
        System.out.println(extraEnd("asd"));
    }

    public static String extraEnd(String str) {
        return str.substring(0, str.length()/2 + 1);
    }

}
