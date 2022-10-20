package com.example.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.example.test.utils.Utils;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    SelenideElement addToCart = $(".single_add_to_cart_button.button");
    SelenideElement optionDropdownButton = $(".select2-selection__rendered");
    SelenideElement dropdownOption = $(".select2-results__option:nth-child(2)");

    SelenideElement addToCartButton = $(".single_add_to_cart_button.button");



    public void clickAddToCart() {
        addToCart.click();
    }

    public void addProductToCart() {
        addToCart.click();
        if(Utils.isAlertPresent()) {
            optionDropdownButton.click();
            dropdownOption.shouldBe(Condition.interactable);
            dropdownOption.click();
            addToCartButton.click();
        }
    }
}
