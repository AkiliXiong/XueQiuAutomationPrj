package Pages;

import Utils.BaseTest;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPage {
    private By searchInput = By.id("search_input_text");
    private By stockName = By.id("stockName");
    private By cancelButton = By.id("action_close");
    private AppiumDriver<WebElement> driver;

    public SearchPage(AppiumDriver<WebElement> driver)
    {
        this.driver=driver;
    }

    public void searchKeyword(String keyword)
    {
        WebElement inputBox = driver.findElement(searchInput);
        inputBox.sendKeys(keyword);
    }

    public void clickCancelButton()
    {
        driver.findElement(cancelButton).click();
    }

    public String getStockName()
    {
        return driver.findElements(stockName).get(0).getText();
    }
}
