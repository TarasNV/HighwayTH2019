package lesson4;

public class WhileExample {
    public static void main(String[] args){
        int i = 1;
        while (i < 5) {
            System.out.print(i + " ");
            i++;
        }

        int j = 1;
        do {
            j++;
            System.out.print(j + " ");
        } while (j < 5);

    }
}
