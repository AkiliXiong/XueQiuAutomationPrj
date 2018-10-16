package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseTest {
    public static AppiumDriver<WebElement> driver;
    static AppiumDriverLocalService service;
    static Logger logbase = LogManager.getLogger(BaseTest.class.getCanonicalName());

    @BeforeClass
    public static void startDriver()
    {
        String START_ACTIVITY=".view.WelcomeActivityAlias";

        service=AppiumDriverLocalService.buildDefaultService();
        service.start();
        logbase.trace("The service is started.");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","b53bbecd");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appPackage","com.xueqiu.android");
        capabilities.setCapability("appActivity",".view.WelcomeActivityAlias");
        capabilities.setCapability("noReset","false");
        //capabilities.setCapability("fullReset","true");
        capabilities.setCapability("printPageSourceOnFindFailure","true");
        capabilities.setCapability("unicodeKeyboard","true");
        driver = new AppiumDriver<WebElement>(service.getUrl(),capabilities);
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        logbase.trace("The driver is started.");
    }

    @AfterClass
    public static void quitDriver()
    {
        driver.quit();
        service.stop();
        logbase.trace("The driver is quit.");
    }


}
