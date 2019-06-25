package lesson7;

public class Box {
    public double width; // ширина
    public double height; // высота
    public double depth; // глубина

    public Box(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Box(){

    }

    public double getVolume() {

        return width * height * depth;
    }

    public void setDim(int v, int h, int d) {
        width = v;
        height = h;
        depth = d;
    }

    public void printInfo(){
        System.out.println("Объем коробки: " + getVolume());
    }
}


