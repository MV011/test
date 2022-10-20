package com.example.test.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Selenide.*;

public class ShopPage {

    public List<SelenideElement> productTiles = $$(".purchasable");

    public List<SelenideElement> shopPageNavigation = $$(".woocommerce-pagination li");

    public SelenideElement cartButton = $(".nav-menu li:first-of-type");

    public String addToCartButtonSelector = ".add_to_cart_button";

    public void addRandomProductsToCart(int productCount) {

        Set<Integer> randomNumbers = new HashSet<>();

        while(randomNumbers.size() < productCount) {
            randomNumbers.add(ThreadLocalRandom.current().nextInt(0, productTiles.size()));
        }

        for (Integer randomNumber : randomNumbers) {
            SelenideElement element = this.productTiles.get(randomNumber);
            element.hover();
            element.$(addToCartButtonSelector).click();
            if(WebDriverRunner.getWebDriver().getCurrentUrl().contains("product")) {
                $(".single_add_to_cart_button.button").click();
                WebDriverRunner.getWebDriver().navigate().back();
            }
        }
    }

    public void clickViewCart() {
        cartButton.click();
    }
}
