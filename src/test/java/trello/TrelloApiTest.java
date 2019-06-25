package trello;

import org.testng.annotations.Test;
import trello.api.TrelloApi;
import trello.api.models.TrelloList;

import java.io.IOException;
import java.util.List;

public class TrelloApiTest {

    @Test
    public void apiTest() throws IOException {
        TrelloApi trelloApi = new TrelloApi();
        List<TrelloList> boardList = trelloApi.getBoardLists("C3gYYvq9");
        for (TrelloList list : boardList) {
            System.out.println(list.id);
        }

        trelloApi.createCard("5ce41a77d94d0723122bb5da");
    }
}
