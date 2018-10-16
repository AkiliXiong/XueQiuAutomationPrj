package Pages;

import org.openqa.selenium.By;
import static Utils.BaseTest.driver;

public class FirstPage {
    private By cancelBtn=By.id("cancel");
    private By searchBox=By.id("home_search");


    public void clickCancelButton()
    {
        driver.findElement(cancelBtn).click();
    }

    public SearchPage doSearch() {
//        if(driver.findElements(cancelBtn).size()>0) {
//            clickCancelButton();
//        }
        driver.findElement(searchBox).click();
        return new SearchPage();
    }
}
