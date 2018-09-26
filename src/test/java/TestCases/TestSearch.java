package TestCases;

import Utils.BaseTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.tools.picocli.CommandLine;
import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import Pages.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestSearch extends BaseTest {

    @Parameterized.Parameters(name="{index}:fib({0})={1}")
    public static Collection<Object[]> data()
    {
        return Arrays.asList(new Object[][]{{"PDD","拼多多"},{"腾讯","腾讯控股"},{"pingan","中国平安"}});
    }

    @Parameterized.Parameter
    public String searchKeyword;

    @Parameterized.Parameter(1)
    public String result;

    static Logger logsearch = LogManager.getLogger(TestSearch.class.getCanonicalName());

    @Test
    public void searchStocks() {
        FirstPage firstPage = new FirstPage(driver);
        logsearch.trace("Operate on the first page.");
        firstPage.doSearch();
        SearchPage searchPage = new SearchPage(driver);
        logsearch.trace("Operate on the search page.");
        searchPage.searchKeyword(searchKeyword);
        assertThat(searchPage.getStockName(),equalTo(result));
        searchPage.clickCancelButton();
    }

}
