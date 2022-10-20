package com.example.test.runner;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.example.test.pages.ShopPage;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.*;

@Test
@CucumberOptions(
        glue = {"com.example.test.steps"},
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        features = {"src/test/resources/com/example/test/features/"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeClass
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.holdBrowserOpen = true;
    }

    @BeforeMethod
    public void setUp() {
        open("https://cms.demo.katalon.com/");
    }
}
