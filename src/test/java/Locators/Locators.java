package Locators;

import org.openqa.selenium.By;

public class Locators {
    //    Локатор для ссылки на Twitter в футтере по полному тексту ссылки
    By linkedInLink = By.linkText("Twitter");
    //    Локатор для ссылки на Facebook в футтере на частичному тексту ‘Face’
    By twitterLink = By.partialLinkText("Face");
    //    Локатор по тегу для выпадающего списка фильтров
    By selectDropDown = By.tagName("select");
    //    С помощью By.className написать локатор для элемента Products
    By productsLogo = By.className("product_label");
    //    На странице тележки с помощью локатора By.name найти кнопку Checkout
    By checkoutBtn = By.name("CHECKOUT");
    //    На странице Products с помощью локатора By.id найти элементы для добавления продукта в тележку
    By itemProducts = By.id("item_4_title_link");
    //    С помощью cssSelector написать локатор для получения всех элементов на странице
    By allElementsOnPage = By.cssSelector("*");
    //    С помощью cssSelector написать локатор для нажождения кнопок добавления в корзину по айди
    By addToCartBtn = By.cssSelector("#item_4_img_link");
    //    С помощью cssSelector написать локатор для нахождения всех кнопок внутри элемента с id = header_container
    By buttonsHeader = By.cssSelector("#header_container button");
    //    C помощью cssSelector написать локатор для названий продуктов используя css class
    By productsItem = By.cssSelector(".inventory_item");
    //    C помощью cssSelector написать локатор для нахождения элементов добавить в корзину по атрибуту data-test - не нашла такого класса
}
