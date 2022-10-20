package com.example.test.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.example.test.pages.ProductPage;
import com.example.test.pages.ShopPage;
import com.example.test.utils.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Selenide.$;

public class ShopPageStepDefinitions {

    private final ShopPage shopPage;
    private final ProductPage productPage;

    public ShopPageStepDefinitions() {
        this.shopPage = new ShopPage();
        this.productPage = new ProductPage();
    }

    @Given("I add four random items to my cart")
    public void addProductsToCart() {

        int productCount = 4;

        Set<Integer> randomNumbers = new HashSet<>();

        while(randomNumbers.size() < productCount) {
            randomNumbers.add(ThreadLocalRandom.current().nextInt(0, shopPage.productTiles.size()));
            System.out.println(randomNumbers.size());
        }
        System.out.println(randomNumbers);

        for (Integer randomNumber : randomNumbers) {
            SelenideElement element = shopPage.productTiles.get(randomNumber);
            element.scrollTo();
            shopPage.cartButton.shouldNotBe(Condition.visible);
            element.hover();
            element.$(shopPage.addToCartButtonSelector).click();
            if(WebDriverRunner.getWebDriver().getCurrentUrl().contains("product")) {
                productPage.addProductToCart();
                WebDriverRunner.getWebDriver().navigate().to("https://cms.demo.katalon.com/");
            }
            else {
                element.$(shopPage.addedToCartSelector).shouldBe(Condition.visible);
            }
        }
    }

    @When("I view my cart")
    public void viewCart() {
        shopPage.clickViewCart();
    }
}
