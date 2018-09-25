package TestCases;

import Utils.BaseTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import Pages.*;

public class Search extends BaseTest {

    static Logger logsearch = LogManager.getLogger(Search.class.getCanonicalName());

    @Test
    public void searchStocks() {
        FirstPage firstPage = new FirstPage(driver);
        logsearch.trace("Operate on the first page.");
        firstPage.doSearch();
        SearchPage searchPage = new SearchPage(driver);
        logsearch.trace("Operate on the search page.");
        searchPage.searchKeyword("PDD");
        assertThat(searchPage.getStockName(),equalTo("拼多多"));
    }

}
