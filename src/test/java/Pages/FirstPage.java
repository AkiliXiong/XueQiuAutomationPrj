package Pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FirstPage {
    private By cancelBtn=By.id("cancel");
    private By searchBox=By.id("home_search");
    private AppiumDriver<WebElement> driver;

    public FirstPage(AppiumDriver<WebElement> driver)
    {
        this.driver=driver;
    }

    public void clickCancelButton()
    {
        driver.findElement(cancelBtn).click();
    }

    public void doSearch() {
        if(driver.findElements(cancelBtn).size()>0) {
            clickCancelButton();
        }
        driver.findElement(searchBox).click();
    }
}
