package SelenideTest;

import Elements.ProductListItems;
import Pages.*;
import Steps.CartPageSteps;
import Steps.LoginPageSteps;
import Steps.ProductPageSteps;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Urls.PageUrls.LOGIN_URL;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AddProductToCartTest extends BaseTest {
    @Test
    public void addToCartTestWithoutArchitecture() {
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
        Assert.assertEquals(badgeText, "1", (String.format("Expected 1 item in the cart, but found: %s", badgeText)));
    }

    @Test
    public void addToCartWithPageObjectPattern() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginPage();
        loginPage.inputUserName("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLogin();
        ProductPage productPage = new ProductPage();
        Assert.assertEquals(productPage.checkHeader(), "Products", (String.format("Expected Products element on the page, but found: %s", productPage.checkHeader())));
    }

    @Test
//    Для теста из прошлого домашнего задания произвести рефакторинг и применить подходы Page Objects и Steps.
    public void loginTestWithAbstractClassSteps() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.login("standard_user", "secret_sauce");
        ProductPage productPage = new ProductPage();
        Assert.assertEquals(productPage.checkHeader(), "Products", (String.format("Expected Products element on the page, but found: %s", productPage.checkHeader())));
        productPage.addProductItemToCart();
        CartPage cartPage = new CartPage();
        cartPage.openCart();
        Assert.assertEquals(cartPage.checkBadgeText(), "1", (String.format("Expected 1 item in the cart, but found: %s", cartPage.checkBadgeText())));
    }

    @Test
//    Используя Page Objects и Steps подходы написать тест для покупки Sauce Labs Onesie.
    public void buyProduct() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.login("standard_user", "secret_sauce");
        ProductPage productPage = new ProductPage();
        Assert.assertEquals(productPage.checkHeader(), "Products", (String.format("Expected Products element on the page, but found: %s", productPage.checkHeader())));
        productPage.productItemSauceLabsOnesieToCart();
        CartPageSteps cartPageSteps = new CartPageSteps();
        cartPageSteps.buyProductItem();
        cartPageSteps.processAndValidateCheckoutInformation("Ksu", "Kuper", "225686");
    }

    @Test
//    Используя Page Objects и Steps подходы написать тест для проверки работоспособности сортировки продуктов по цене.
    public void sortProduct() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.login("standard_user", "secret_sauce");
        ProductPageSteps productPageSteps = new ProductPageSteps();
        productPageSteps.sortProductsByPriceWithValidation();
    }

    @Test
//    Используя Page Objects и Steps подходы написать тест для проверки функциональности удаления продукта из корзины.
    public void deleteProductFromCart() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.login("standard_user", "secret_sauce");
        ProductPage productPage = new ProductPage();
        Assert.assertEquals(productPage.checkHeader(), "Products", (String.format("Expected Products element on the page, but found: %s", productPage.checkHeader())));
        productPage.productItemSauceLabsOnesieToCart();
        CartPageSteps cartPageSteps = new CartPageSteps();
        cartPageSteps.addSauceLabsOnesieToCartAndValidateResult();
    }

    @Test
//    Используя Page Objects и Steps подходы написать тест для проверки функциональности логаута.
    public void logout() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.login("standard_user", "secret_sauce");
        ProductPage productPage = new ProductPage();
        Assert.assertEquals(productPage.checkHeader(), "Products", (String.format("Expected Products element on the page, but found: %s", productPage.checkHeader())));
        productPage.clickBurgerMenu();
        LogoutPage logoutPage = new LogoutPage();
        logoutPage.clickLogoutLinkBurgerMenu();
        LoginPage loginPage = new LoginPage();
        Assert.assertFalse(loginPage.openLoginPage(), "Login page is open");
    }

    @Test
//    Элемент должен уметь перейти в детали продукта
    public void openDetailOfProduct() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.login("standard_user", "secret_sauce");
        ProductListPage productListPage = new ProductListPage();
        productListPage.openAndVerifierProductDetailPage();
    }

    @Test
    // Элемент должен уметь добавить продукт, нужно учитывать состояние продукта на момент взаимодействия, если уже добавлен, то повторное добавление не производить
    public void addProductToCart() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.login("standard_user", "secret_sauce");
        // Инициализация страницы списка продуктов
        ProductListPage productListPage = new ProductListPage();
        productListPage.addItemProductToCart();
        // Проверка, что продукт добавлен в корзину
        boolean isProductInCart = new ProductListItems("Sauce Labs Onesie").isProductInCart();
        Assert.assertTrue(isProductInCart, "Продукт не был добавлен в корзину, хотя должен был быть.");
    }

    @Test
    // Элемент должен уметь удалить продукт из корзины, нужно учитывать состояние продукта на момент взаимодействия, если не добавлен, то удаление не производить
    public void addAndRemoveProductToCart() {
        LoginPageSteps loginPageSteps = new LoginPageSteps();
        loginPageSteps.login("standard_user", "secret_sauce");
        ProductListPage productListPage = new ProductListPage();
        productListPage.addItemProductToCart();
        // Проверка, что продукт добавлен в корзину
        boolean isProductInCart = new ProductListItems("Sauce Labs Onesie").isProductInCart();
        Assert.assertTrue(isProductInCart, "Продукт не был добавлен в корзину, хотя должен был быть.");
        productListPage.removeItemProductFromCart();
        // Проверка, что продукт был удален из корзины
        boolean isProductStillInCart = new ProductListItems("Sauce Labs Onesie").isProductInCart();
        Assert.assertFalse(isProductStillInCart, "Продукт не был удален из корзины, хотя должен был быть.");
    }
}



