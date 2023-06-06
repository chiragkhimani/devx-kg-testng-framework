package com.automation.test;

import com.automation.pages.*;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrderConfirmationTest extends BaseTest {

    @Test
    public void orderConfirmation() {
        loginPage.doLogin(ConfigReader.getProperty("login.username"), ConfigReader.getProperty("login.password"));
        homePage.clickOnAddToCartBtnOfFirstProduct();
        homePage.clickOnCartIcon();
        cartPage.clickOnCheckoutBtn();
        checkoutPage.fillShippingDetails();
        checkoutPage.clickOnContinueBtn();
        reviewPage.printReviewPageDetails();
        reviewPage.clickOnFinish();
        orderConfirmationPage.verifyConfirmationPageDisplayed();
    }

}
