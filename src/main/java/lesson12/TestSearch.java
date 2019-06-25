package lesson12;

import trello.pages.TrelloPageBase;

import java.util.List;

public class TestSearch extends TrelloPageBase {
    public void search() {
        SearchForm searchForm = new GoogleSearch();
        List<String> result = searchForm.search("test");
    }

    @Override
    public void isOpened() {

    }
}
