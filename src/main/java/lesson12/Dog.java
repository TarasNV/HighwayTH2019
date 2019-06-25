package lesson12;

public class Dog extends Pet {

    @Override
    public void voice() {
        System.out.println("GAF GAF");
    }

    @Override
    public void move() {
        System.out.println("go");
    }
}
