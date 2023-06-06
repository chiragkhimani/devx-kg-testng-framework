package com.automation.test;

import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void verifyUserCanLogin() {
        loginPage.doLogin(ConfigReader.getProperty("login.username"), ConfigReader.getProperty("login.password"));
        homePage.verifyHomePage();
    }

    @Test
    public void verifyUserCannotLoginWithInvalidCred() {
        loginPage.doLogin("admin", "admin123");
        loginPage.verifyInvalidLoginErrorIsDisplayed();
    }

    @Test
    public void verifyUserCanLogout(){
        loginPage.doLogin(ConfigReader.getProperty("login.username"), ConfigReader.getProperty("login.password"));
        homePage.verifyHomePage();
        homePage.clickOnHamburgerIcon();
        homePage.clickOnLogoutLink();
        loginPage.verifyLoginPage();
    }

}
