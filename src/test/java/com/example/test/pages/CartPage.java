package com.example.test.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

    List<SelenideElement> cartItems = $$(".cart_item");

    List<SelenideElement> productRemove = $$(".remove");

    SelenideElement removeAlert = $(".woocommerce-message");
    String priceSelector = ".product-price .woocommerce-Price-amount.amount";

    public int getLowestPriceItemIndex() {
        int lowestPriceItemIndex = 0;
        float lowestPrice = Float.parseFloat(cartItems.get(0).$(priceSelector).getText().replaceAll("[^0-9]", ""));
        for(int i = 1; i < cartItems.size(); i++) {
            float tempPrice = Float.parseFloat(cartItems.get(i).$(priceSelector).getText().replaceAll("[^0-9]", ""));
            if(tempPrice < lowestPrice) {
                lowestPrice = tempPrice;
                lowestPriceItemIndex = i;
            }
        }
        return lowestPriceItemIndex;
    }

    public void removeLowestPriceItem() {

        productRemove.get(getLowestPriceItemIndex()).click();
        removeAlert.shouldBe(Condition.appear);
    }

    public void countCartItems(int expectedCount) {
        ((ElementsCollection) cartItems).shouldHave(size(expectedCount));
    }
}
