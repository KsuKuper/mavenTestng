package Selenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Selenide.PageUrls.LOGIN_URL;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginTest extends BaseTest {
    @Test
    public void loginTest() {
        open(LOGIN_URL);
        $(By.id("user-name")).sendKeys("standard_user");
        $(By.id("password")).sendKeys("secret_sauce");
        $(By.id("login-button")).click();
        SelenideElement productsHeader = $(By.xpath("//span[text()='Products']"));
        Assert.assertTrue(productsHeader.isDisplayed(), String.format("Element %s Products isn't displayed", productsHeader.getText()));
    }
}
