package Xpath;

import org.openqa.selenium.By;

public class LocatorsXpath {
    //    Локатор для ссылки на Twitter в футтере по полному тексту ссылки
    By linkedInLink = By.linkText("Twitter");
    //a[text()='Twitter']

    //    Локатор для ссылки на Facebook в футтере на частичному тексту ‘Face’
    By twitterLink = By.partialLinkText("Face");
    //a[contains(text(), 'Face')]

    //    Локатор по тегу для выпадающего списка фильтров
    By selectDropDown = By.tagName("select");
    //    Локатор выпадающего списка
    //select[@class='product_sort_container']

    //    Локатор значения из выпадающего списка
    //option[@value='az']

    //    На странице тележки по атрибуту name найти кнопку Checkout
    //button[@name='checkout']
    //    На странице тележки по text найти кнопку Checkout
    //button[text()='Checkout']

    //    Написать локатор для получения всех элементов на странице
    //*;

    //    На странице Products с помощью локатора By.id найти элементы для добавления продукта в тележку
    By itemProducts = By.id("item_4_title_link");
    //a[contains(@id, 'item_4_title_link')]

    //    На странице Products по индексу выбрать только вторую кнопку Add to cart
    //    (//button[contains(text(), 'Add')])[2]

    //    Найти все div элементы, к которым применен class ‘inventory_item_label’ или ‘inventory_item_img ‘
    //div[contains(@class, 'inventory_item_label')]

    //    Найти все кнопки, к которым применен class ‘btn_primary’ и имеют атрибут name ‘add-to-cart-sauce-labs-onesie’
    //button[contains(@class, 'btn_primary') and contains(@name, 'add-to-cart-sauce-labs-onesie')]

    //    Используя xpath оси найти все кнопки Add to cart на странице Products относительно цен
    //div[@class='pricebar']/button[preceding-sibling::div[@class='inventory_item_price']]

    //    Используя xpath оси найти все цены на странице Products относительно кнопок Add to cart
    //button[contains(text(),'Add to cart')]/preceding-sibling::div[@class='inventory_item_price']
}

