package com.example.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.example.test.utils.Utils;

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
    public String addedToCartSelector = ".added_to_cart";

    public void addRandomProductsToCart(int productCount) {


    }

    public void clickViewCart() {
        Utils.scrollToTop();
        cartButton.click();
    }
}
