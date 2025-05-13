package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CartPage extends BasePage {
    private final SelenideElement cartLink = $(By.xpath("//div[@id='shopping_cart_container']"));
    private final SelenideElement yourCartHeader = $(By.xpath("//span[contains(text(), 'Your Cart')]"));
    private final SelenideElement cartBadge = $(By.xpath("//span[@class='shopping_cart_badge']"));
    private final SelenideElement cartItemSauceLabsOnesie = $(By.xpath("//div[contains(text(), 'Sauce Labs Onesie')]"));
    private final SelenideElement checkoutButton = $(By.xpath("//button[@id='checkout']"));
    private final SelenideElement yourInfoHeader = $(By.xpath("//span[contains(text(), 'Checkout: Your Information')]"));
    private final SelenideElement firstNameField = $(By.id("first-name"));
    private final SelenideElement lastNameField = $(By.id("last-name"));
    private final SelenideElement zipCodeField = $(By.id("postal-code"));
    private final SelenideElement continueButton = $(By.id("continue"));
    private final SelenideElement overviewHeader = $(By.xpath("//span[contains(text(), 'Checkout: Overview')]"));
    private final SelenideElement finishButton = $(By.id("finish"));
    private final SelenideElement completeHeader = $(By.xpath("//span[contains(text(), 'Checkout: Complete!')]"));
    private final SelenideElement titleOrderComplete = $(By.xpath("//h2[contains(text(), 'Thank you for your order!')]"));
    private final SelenideElement removeButton = $(By.xpath("//button[contains(., 'Remove')]"));

    // Page - cart
    public void openCart() {
        cartLink.click();
    }

    public String checkBadgeText() {
        return cartBadge.shouldHave(text("1")).getText();
    }

    public String checkYourCartHeader() {
        return yourCartHeader.shouldHave(text("Your Cart")).getText();
    }

    public String checkItemSauceLabsOnesieInTheCart() {
        return cartItemSauceLabsOnesie.shouldHave(text("Sauce Labs Onesie")).getText();
    }

    public String checkCheckoutButton() {
        return checkoutButton.shouldHave(text("Checkout")).getText();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
    }

    public void clickRemoveButton() {
        removeButton.click();
    }

    public void checkEmptyCart() {
        boolean isCartBadgeDisplayed = cartBadge.isDisplayed();
        Assert.assertFalse(isCartBadgeDisplayed, "The badge isn't displayed, the cart is empty");
    }

    //Page - checkout steps
    public String checkYourInfoHeader() {
        return yourInfoHeader.shouldHave(text("Checkout: Your Information")).getText();
    }

    public void inputFirstName(String firstName) {
        firstNameField.shouldBe(visible).sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameField.shouldBe(visible).sendKeys(lastName);
    }

    public void inputZipCode(String zipCode) {
        zipCodeField.shouldBe(visible).sendKeys(zipCode);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public String checkOverviewHeader() {
        return overviewHeader.shouldHave(text("Checkout: Overview")).getText();
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public String checkCompleteHeader() {
        return completeHeader.shouldHave(text("Checkout: Complete!")).getText();
    }

    public String checkTitleOrderComplete() {
        return titleOrderComplete.shouldHave(text("Thank you for your order!")).getText();
    }
}
