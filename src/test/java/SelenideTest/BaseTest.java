package SelenideTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    @BeforeSuite
    public void setUpBrowser() {
        Configuration.timeout = 10000;
        Configuration.pollingInterval = 1000;
        Configuration.browserSize = "1800x900";

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-default-apps");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-search-engine-choice-screen");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        Configuration.browserCapabilities = options;
    }

    @AfterSuite(alwaysRun = true)
    public void quitDriver() {
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }
}
