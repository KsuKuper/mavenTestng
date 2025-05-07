package Selenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Selenide.PageUrls.LOGIN_URL;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddProductToCartTest extends BaseTest {
    @Test
    public void addToCartTest() {
        //steps
        open(LOGIN_URL);
        $(By.id("user-name")).sendKeys("standard_user");
        $(By.id("password")).sendKeys("secret_sauce");
        $(By.id("login-button")).click();
        $(By.xpath("//span[text()='Products']")).shouldHave(text("Products"));
        $(By.xpath("(//button[contains(text(), 'Add')])[2]")).click();
        $(By.xpath("//div[@id='shopping_cart_container']")).click();
        SelenideElement shoppingCartBadge = $(By.xpath("//span[@class='shopping_cart_badge']"));
        String badgeText = shoppingCartBadge.getText();

        //result
        Assert.assertEquals("1", "1", badgeText);
    }
}
