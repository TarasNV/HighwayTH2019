package lesson4;

public class SwitchExample {
    public static void main(String[] args){
        String name = "Jack";
        switch (name) {
            case "Jack":
                System.out.println("Hello, captain");
                break;
            case "Oleh":
                System.out.println("Hello , Oleh");
                break;
            case "Bob":
                System.out.println("Marly");
                break;
            default:
                System.out.println("I don't have case for you");;
        }
    }
}
