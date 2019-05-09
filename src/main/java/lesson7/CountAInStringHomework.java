package lesson7;

import java.util.ArrayList;
import java.util.List;

public class CountAInStringHomework {

    public static void main(String[] args) {
        String inputString = "aasss,assdfaasdqweaaa,asdaaaas,adsasdasd,aaa,asdghnzzzzzza,zzzzxxxaaaa,zxvvxvxcvxcv,xcvxv.fsdfsdfeweqwejhsdf sf sdfs a a sdfsdf sdf";
        String substring = "a";
        List<Integer> indexesList = new ArrayList<Integer>();
        int position = 0;
        while (inputString.contains(substring)) {
            position = inputString.indexOf(substring, position);
            indexesList.add(position);
            inputString = inputString.replaceFirst(substring, " ");
        }
        System.out.println("Number of substring in string: " + indexesList.size());
        System.out.print("Indexes of character '" + substring + "' in string: [");
        for (int element : indexesList) {
            System.out.print(element);
            if (element == position) {
                System.out.println("];");
            }
            else {
                System.out.print(", ");
            }
        }
        System.out.println();

    }
}
