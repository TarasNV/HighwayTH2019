package trello.api;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.*;
import okhttp3.RequestBody;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TrelloApi {
    public static final String KEY = "aff2ce9dcbf0296d1aa9a66565123425";
    public static final String TOKEN = "f29a5a0b22378a4d6b611d1ea4059d1cecf80c1f289cfd6d19501faeef68ac4d";

    OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS).build();

    public void getBoardLists(String boardId) throws IOException {
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/boards/" + boardId + "/lists?cards=none&card_fields=all&filter=open&fields=all&key=" + KEY + "&token=" + TOKEN)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);

    }

    public void createCardRequest(String listId) throws IOException {
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf8"), "");
        Request request = new Request.Builder()
                .url("https://api.trello.com/1/cards?idList=" + listId + "&keepFromSource=all&key=" + KEY + "&token=" + TOKEN)
                .post(body)
                .build();
        String response = client.newCall(request).execute().body().string();
        System.out.println(response);

    }
}
