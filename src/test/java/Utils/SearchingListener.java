package Utils;

import io.appium.java_client.events.api.general.SearchingEventListener;
import io.appium.java_client.functions.ExpectedCondition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchingListener implements SearchingEventListener {

    static Logger log = LogManager.getLogger(SearchingListener.class);
    private String locator = null;

    private String splitBy(By by) {
        String str = by.toString().split("-")[1].toString().split(":")[3];
        return str.substring(0, str.length() - 3);
    }

    @Override
    public void beforeFindBy(final By by, WebElement webElement, WebDriver webDriver) {
        try {
            locator = splitBy(by);
        } catch (Exception e) {
            log.error("by不能按格式切割！");
        }
        try {
            WebDriverWait wait = new WebDriverWait(webDriver,
                    10);
            wait.until(new ExpectedCondition<WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    return driver.findElement(by);
                }
            }).isDisplayed();
            log.info("beforeFindBy:searching............"
                    + webDriver.findElement(by));
        } catch (Exception e) {
            try {
                log.error("beforeFindBy监听" + 10
                        + "秒" + " " + splitBy(by) + "不可见");
            } catch (Exception e2) {
                log.error("beforeFindBy监听" + 10
                        + "秒,by不能按格式切割！");
            }
        }
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }
}
