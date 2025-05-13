package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static Urls.PageUrls.LOGIN_URL;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends BasePage {
    private final SelenideElement userNameInput = $(By.id("user-name"));
    private final SelenideElement passwordInput = $(By.id("password"));
    private final SelenideElement loginButton = $(By.id("login-button"));

    public boolean openLoginPage() {
        open(LOGIN_URL);
        return false;
    }

    public void inputUserName(String userName) {
        userNameInput.shouldBe(visible).sendKeys(userName);
    }

    public void inputPassword(String password) {
        passwordInput.shouldBe(visible).sendKeys(password);
    }

    public void clickLogin() {
        loginButton.shouldBe(enabled).click();
    }

}
