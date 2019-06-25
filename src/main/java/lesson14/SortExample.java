package lesson14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortExample {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("A",2.5));
        movies.add(new Movie("AB",3.5));
        movies.add(new Movie("AC",4.5));
        movies.add(new Movie("BA",5.5));

        for (Movie movie: movies) {
            System.out.println(movie);
        }
        System.out.println("SORTING");
        Collections.sort(movies);
        for (Movie movie: movies) {
            System.out.println(movie);
        }
    }
}
