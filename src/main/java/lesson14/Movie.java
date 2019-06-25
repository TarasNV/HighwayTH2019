package lesson14;

public class Movie implements Comparable {
    public double score;
    public String title;
    public int year;

    public Movie(String title, double score, int year) {
        this.title = title;
        this.score = score;
        this.year = year;
    }

    public Movie(String title, double score){
        this.score = score;
        this.title = title;
    }

    @Override
    public int compareTo(Object o) {
        Movie m = (Movie)o;
        return (score < m.score) ? -1 : ((score == m.score) ? 0 : 1);
    }

}
