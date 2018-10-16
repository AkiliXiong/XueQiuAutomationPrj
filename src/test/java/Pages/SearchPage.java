package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;
import static Utils.BaseTest.driver;

public class SearchPage {
    private By searchInput = By.id("search_input_text");
    private By stockName = By.id("stockName");
    private By cancelButton = By.id("action_close");
    private By userName = By.id("user_name");

    public SearchPage searchKeyword(String keyword)
    {
        WebElement inputBox = driver.findElement(searchInput);
        inputBox.sendKeys(keyword);
        return this;
    }

    public void clickCancelButton()
    {
        driver.findElement(cancelButton).click();
    }

    public List<String> getStockName()
    {
        return driver.findElements(stockName).stream().map(e->e.getText()).collect(Collectors.toList());
    }

    public List<String> getUserName()
    {
        return driver.findElements(userName).stream().map(e->e.getText()).collect(Collectors.toList());
    }
}
