package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.constans.PAUSE_LENGTH;

public class LoginPage extends AbstractPage {

    public LoginPage(WebDriver driver) throws Exception {
        super(driver);
    }

    @FindBy(id = "username")
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "Login")
    private WebElement submit;

    public void login() throws IOException {
        try {
            log.warn("Login as " + login);
            driver.navigate().to(baseURL);
            waitForElementVisible(loginField, PAUSE_LENGTH.AVG);
            loginField.clear();
            loginField.sendKeys(login);
            passwordField.clear();
            passwordField.sendKeys(password);
            submit.click();
            log.info("Submit clicked");
            Thread.sleep(5000);
            try {
                driver.switchTo().alert().dismiss();
                log.info("Alert Dismissed");
            } catch (Exception e) {
           }
            waitForElementVisible(appSelector, PAUSE_LENGTH.AVG);
        } catch (Exception e) {
            log.error(e.getMessage());
            driver.findElement(By.linkText("Continue")).click();
            waitForElementVisible(appSelector, PAUSE_LENGTH.AVG);
        }
        log.warn("User " + login + " logged in successfully!");
    }

    @FindBy(xpath = "//div[contains(@id,'userNavButton')]/span")
    private WebElement userNavigateButton;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement logoutLink;

    public void logout(String pUserLogin) {
        log.warn("Logout " + pUserLogin);
        driver.switchTo().defaultContent();
        userNavigateButton.click();
        waitForElementVisible(logoutLink, PAUSE_LENGTH.AVG);
        logoutLink.click();
        waitForElementVisible(submit, PAUSE_LENGTH.AVG);
        log.warn("User " + pUserLogin + " was loged out successfully!");
    }
}
