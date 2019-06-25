package lesson12;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetExample {

    public static void main(String[] args) {
        Random random = new Random(30);
        SortedSet<Integer> numberSet = new TreeSet<>();
        for(int i = 0; i < 1000; i++)
            numberSet.add(random.nextInt(10));
        System.out.println(numberSet);
    }
}
