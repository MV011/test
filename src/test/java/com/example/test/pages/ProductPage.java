package com.example.test.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    SelenideElement addToCart = $(".single_add_to_cart_button.button");

    public void clickAddToCart() {
        addToCart.click();
    }
}
