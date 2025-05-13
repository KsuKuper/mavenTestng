package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage extends BasePage {
    private final SelenideElement productHeader = $(By.xpath("//span[text()='Products']"));
    private final SelenideElement productItem = $(By.xpath("(//button[contains(text(), 'Add')])[2]"));
    private final SelenideElement productItemSauceLabsOnesie = $(By.xpath("//button[contains(@class, 'btn_primary') and contains(@name, 'add-to-cart-sauce-labs-onesie')]"));
    private final SelenideElement select = $(By.xpath("//select[@class='product_sort_container']"));
    private final SelenideElement optionSelect = $(By.xpath("//option[@value='lohi']"));
    private final SelenideElement burgerMenu = $(By.xpath("//button[@id='react-burger-menu-btn']"));

    public String checkHeader() {
        return productHeader.shouldHave(text("Products")).getText();
    }

    public void addProductItemToCart() {
        productItem.click();
    }

    public void productItemSauceLabsOnesieToCart() {
        productItemSauceLabsOnesie.click();
    }

    public void clickSelect() {
        select.click();
    }

    public void clickOptionSelect() {
        optionSelect.click();
    }

    public String checkSelect() {
        return select.shouldHave(text("Price (low to high)")).getText();
    }

    public void clickBurgerMenu() {
        burgerMenu.shouldBe(enabled).click();
    }
}
