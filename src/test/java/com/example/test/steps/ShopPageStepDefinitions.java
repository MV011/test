package com.example.test.steps;

import com.example.test.pages.ShopPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;

public class ShopPageStepDefinitions {

    private final ShopPage shopPage;

    public ShopPageStepDefinitions() {
        this.shopPage = new ShopPage();
    }

    @Given("I add four random items to my cart")
    public void addProductsToCart() {
        shopPage.addRandomProductsToCart(4);
    }

    @When("I view my cart")
    public void viewCart() {
        shopPage.clickViewCart();
    }
}
