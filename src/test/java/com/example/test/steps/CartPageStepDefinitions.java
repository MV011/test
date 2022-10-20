package com.example.test.steps;

import com.example.test.pages.CartPage;
import com.example.test.pages.ShopPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartPageStepDefinitions {

    private final CartPage cartPage;

    public CartPageStepDefinitions() {
        this.cartPage = new CartPage();
    }


    @Then("I find total four items listed in my cart")
    public void countCartItems() {
        this.cartPage.countCartItems(4);
    }

    @Then("When I search for lowest price item")
    public void findLowestPriceItem() {
        this.cartPage.getLowestPriceItemIndex();
    }

    @And("I am able to remove the lowest price item from my cart")
    public void removeLowestPrice() {
        cartPage.removeLowestPriceItem();
    }
    @Then("I am able to verify three items in my cart")
    public void threeItemsInCart() {
        this.cartPage.countCartItems(3);
    }

}
