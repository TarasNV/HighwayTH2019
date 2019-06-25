package lesson7;

public class MainForBox {
    public static void main(String[] args) {
        Box myBox = new Box();
        Box cube = new Box();
        Box paralelepiped = new Box();

        cube.setDim(10, 10, 10);
        paralelepiped.setDim(10, 20, 15);

        cube.getVolume();
        paralelepiped.getVolume();

        HeavyBox heavyBox = new HeavyBox();

        Box box = new HeavyBox();
    }
}
