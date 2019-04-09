package lesson2;

public class DatatypeSamples {

    public static void main(String[] args){

        System.out.println("Int to char result: " + intToChar(12));
        System.out.println("Float to char result: " + floatToChar(43.3f));
        System.out.println("Float to char to int result: " + floatToCharToInt(324.2f));
    }

    private static char intToChar(int i){
        char c;
        c = (char) i;
        return c;
    }

    private static char floatToChar(float f){
        char c;
        c = (char) f;
        return c;
    }

    private static int floatToCharToInt(float f){
        int i;
        char c;
        c = floatToChar(f);
        i = (int) c;
        return i;
    }
}
