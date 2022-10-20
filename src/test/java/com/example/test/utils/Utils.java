package com.example.test.utils;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class Utils {

    public static boolean isAlertPresent(){
        try{
            Alert a = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(2)).until(ExpectedConditions.alertIsPresent());
            if(a!=null){
                System.out.println("Alert is present");
                WebDriverRunner.getWebDriver().switchTo().alert().accept();
                return true;
            }else{
                throw new Throwable();
            }
        }
        catch (Throwable e) {
            System.err.println("Alert isn't present!!");
            return false;
        }
    }
    public static void scrollToTop(){
        executeJavaScript("scrollTo(0, 0);");
    }
}
