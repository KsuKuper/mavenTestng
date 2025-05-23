package Elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProductListItems {
    private final String identifier;
    private SelenideElement item;
    private SelenideElement addToCartButton;
    private SelenideElement removeFromCartButton;

    public ProductListItems(String identifier) {
        this.identifier = identifier;
        initElements();
    }

    private void initElements() {
        String itemNameXpath = "//div[@data-test='inventory-item-name' and text()='%s']";
        item = $x(String.format(itemNameXpath, identifier)).shouldBe(Condition.visible);
        String itemAddToCartXpath = "//div[@data-test='inventory-item-name' and text()='%s']/ancestor::div[@data-test='inventory-item-description']//button[contains(text(), 'Add to cart')]";
        addToCartButton = $x(String.format(itemAddToCartXpath, identifier));
        String itemRemoveFromCartXpath = "//div[@data-test='inventory-item-name' and text()='%s']/ancestor::div[@data-test='inventory-item-description']//button[contains(text(), 'Remove')]";
        removeFromCartButton = $x(String.format(itemRemoveFromCartXpath, identifier));
    }

    public void openProductDetails() {
        item.click();
    }

    public void addProductToCart() {
        if (!isProductInCart()) {
            addToCartButton.shouldBe(Condition.visible).shouldBe(Condition.enabled).click();
            removeFromCartButton.shouldBe(Condition.visible);
        } else {
            System.out.println("Продукт уже добавлен в корзину.");
        }
    }

    public boolean isProductInCart() {
        return removeFromCartButton.is(Condition.visible);
    }

    public void removeProductFromCart() {
        if (isProductInCart()) {
            removeFromCartButton.shouldBe(Condition.visible).shouldBe(Condition.enabled).click();
            addToCartButton.shouldBe(Condition.visible);
        } else {
            System.out.println("Продукт не найден в корзине.");
        }
    }
}
