package Steps;

import Pages.ProductPage;
import org.testng.Assert;

public class ProductPageSteps {
    private final ProductPage productPage = new ProductPage();

    public void sortProductByPrice() {
        productPage.clickSelect();
        productPage.clickOptionSelect();
        Assert.assertEquals(productPage.checkSelect(), "Price (low to high)", (String.format("Expected 'Price (low to high)' item in the select, but found: %s", productPage.checkSelect())));
    }
}
