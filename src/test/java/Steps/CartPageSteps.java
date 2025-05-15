package Steps;

import Pages.CartPage;
import org.testng.Assert;

public class CartPageSteps {
    private final CartPage cartPage = new CartPage();

    public void buyProductItem() {
        cartPage.openCart();
        cartPage.checkYourCartHeader();
        Assert.assertEquals(cartPage.checkYourCartHeader(), "Your Cart", (String.format("Expected 'Your Cart' item in the cart, but found: %s", cartPage.checkYourCartHeader())));
        cartPage.checkBadgeText();
        Assert.assertEquals(cartPage.checkBadgeText(), "1", (String.format("Expected 1 item in the cart, but found: %s", cartPage.checkBadgeText())));
        cartPage.checkItemSauceLabsOnesieInTheCart();
        Assert.assertEquals(cartPage.checkItemSauceLabsOnesieInTheCart(), "Sauce Labs Onesie", (String.format("Expected 'Sauce Labs Onesie' item in the cart, but found: %s", cartPage.checkItemSauceLabsOnesieInTheCart())));
        cartPage.checkCheckoutButton();
        Assert.assertEquals(cartPage.checkCheckoutButton(), "Checkout", (String.format("Expected 'Checkout' button in the cart, but found: %s", cartPage.checkCheckoutButton())));
        cartPage.clickCheckoutButton();
    }

    public void processAndValidateCheckoutInformation(String firstName, String lastName, String zipCode) {
        cartPage.checkYourInfoHeader();
        Assert.assertEquals(cartPage.checkYourInfoHeader(), "Checkout: Your Information", (String.format("Expected 'Checkout: Your Information' item in the cart, but found: %s", cartPage.checkYourInfoHeader())));
        cartPage.inputFirstName(firstName);
        cartPage.inputLastName(lastName);
        cartPage.inputZipCode(zipCode);
        cartPage.clickContinueButton();
        cartPage.checkOverviewHeader();
        Assert.assertEquals(cartPage.checkOverviewHeader(), "Checkout: Overview", (String.format("Expected 'Checkout: Overview' item in the cart, but found: %s", cartPage.checkOverviewHeader())));
        cartPage.clickFinishButton();
        cartPage.checkCompleteHeader();
        Assert.assertEquals(cartPage.checkCompleteHeader(), "Checkout: Complete!", (String.format("Expected 'Checkout: Complete!' item in the cart, but found: %s", cartPage.checkCompleteHeader())));
        cartPage.checkTitleOrderComplete();
        Assert.assertEquals(cartPage.checkTitleOrderComplete(), "Thank you for your order!", (String.format("Expected 'Thank you for your order!' item in the cart, but found: %s", cartPage.checkTitleOrderComplete())));
    }

    public void addSauceLabsOnesieToCartAndValidateResult() {
        cartPage.openCart();
        cartPage.checkYourCartHeader();
        Assert.assertEquals(cartPage.checkYourCartHeader(), "Your Cart", (String.format("Expected 'Your Cart' item in the cart, but found: %s", cartPage.checkYourCartHeader())));
        cartPage.checkItemSauceLabsOnesieInTheCart();
        Assert.assertEquals(cartPage.checkItemSauceLabsOnesieInTheCart(), "Sauce Labs Onesie", (String.format("Expected 'Sauce Labs Onesie' item in the cart, but found: %s", cartPage.checkItemSauceLabsOnesieInTheCart())));
        cartPage.checkCheckoutButton();
        Assert.assertEquals(cartPage.checkCheckoutButton(), "Checkout", (String.format("Expected 'Checkout' button in the cart, but found: %s", cartPage.checkCheckoutButton())));
        cartPage.clickRemoveButton();
        cartPage.checkEmptyCart();
    }
}
