package lesson14;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GetRequest {

    @Test
    public void tryIt() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://www.imdb.com/chart/top").build();
        Response response = client.newCall(request).execute();

        String html = response.body().string();

        List<Movie> movie = new ArrayList<>();

        Document document = Jsoup.parse(html);
        Elements elements = document.select(".lister-list tr");

        for (Element element : elements) {
            String title = element.select(".titleColumn").text();
            double score = Double.parseDouble(element.select(".ratingColumn.imdbRating").text());
            int year = Integer.parseInt(element.select(".secondaryInfo").text()
            .replace("(", "")
            .replace(")", ""));
        }
    }
}
