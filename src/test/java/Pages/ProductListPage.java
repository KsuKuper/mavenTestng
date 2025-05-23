package Pages;

import Elements.ProductListItems;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class ProductListPage {
    private final SelenideElement backToProductButton = $(By.xpath("//button[@id='back-to-products']"));

    public void openAndVerifierProductDetailPage() {
        new ProductListItems("Sauce Labs Onesie").openProductDetails();
        Assert.assertTrue(backToProductButton.isDisplayed(), "Кнопка 'Назад к продуктам' не найдена. Вы не на странице деталей продукта.");
    }

    public void addItemProductToCart() {
        new ProductListItems("Sauce Labs Onesie").addProductToCart();
    }

    public void removeItemProductFromCart() {
        new ProductListItems("Sauce Labs Onesie").removeProductFromCart();
    }
}
