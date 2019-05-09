import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static lesson6.ArraySortingHomework.shellSort;

public class ArraySortingTests {

    @Test
    public static void insertSortTest(){
        List<Integer> array = new ArrayList<Integer>(){{
            add(1);
            add(4);
            add(-2);
            add(0);
            add(-5);
            add(8);
            add(4);
            add(-2);
            add(23);
            add(21);
            add(-5);
            add(3);
        }};
        List<Integer> arrayExpected = new ArrayList<Integer>() {{
            add(-5);
            add(-5);
            add(-2);
            add(-2);
            add(0);
            add(1);
            add(3);
            add(4);
            add(4);
            add(8);
            add(21);
            add(23);
        }};
        List<Integer> arraySorted = shellSort(array);

        int i = 0;
        for (int element : arrayExpected) {
            Assert.assertTrue(element == arraySorted.get(i), "Element with position " + (i+1) + " wrong.");
            i++;
        }

    }
}
