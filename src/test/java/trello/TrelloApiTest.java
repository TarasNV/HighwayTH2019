package trello;

import org.testng.annotations.Test;
import trello.api.TrelloApi;

import java.io.IOException;

public class TrelloApiTest {

    @Test
    public void apiTest() throws IOException {
        TrelloApi trelloApi = new TrelloApi();
        trelloApi.getBoardLists("C3gYYvq9");
    }
}
