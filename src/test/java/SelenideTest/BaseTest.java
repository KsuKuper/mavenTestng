package SelenideTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @BeforeSuite
    public void setUpBrowser() {
        Configuration.timeout = 10000;
        Configuration.pollingInterval = 1000;
        Configuration.browserSize = "1800x900";
        Configuration.headless = true;
    }

    @AfterSuite(alwaysRun = true)
    public void quitDriver() {
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }
}
