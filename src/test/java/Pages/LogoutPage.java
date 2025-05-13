package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;

public class LogoutPage extends BasePage {
    private final SelenideElement logoutLinkBurgerMenu = $(By.xpath("//a[@id='logout_sidebar_link']"));

    public void clickLogoutLinkBurgerMenu() {
        logoutLinkBurgerMenu.shouldBe(enabled).click();
    }
}
