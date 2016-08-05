package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import com.constans.PAUSE_LENGTH;

public class SetupPage extends AbstractPage {

    public SetupPage(WebDriver driver) throws Exception {
        super(driver);
    }

    @FindBy(xpath = "//span[@class = 'globalHeaderProfilePhoto chatter-avatarSmall chatter-avatar']")
    private WebElement userNavigation;

    @FindBy(xpath = "//a[@title='Setup']")
    private WebElement setupItem;

    @FindBy(id = "setupSearch")
    private WebElement searchField;

    @FindBy(xpath = "//td[contains(text(),'Turn on Chatter')]/../..//input")
    private WebElement chatterEnableCheckbox;

   @FindBy(xpath = "//input[@value='Edit']")
    private WebElement editButton;

    @FindBy(xpath = "//input[@value='Save']")
    private WebElement saveButton;


    @FindBy(xpath = "//label[contains(text(),'Enable Actions in the Publisher')]/../..//input")
    private WebElement enableActionsInThePublisher;





    public void findSetupElement(String element)
            throws Exception {
        //driver.switchTo().alert().dismiss();
        userNavigation.click();
        waitForElementVisible(setupItem,PAUSE_LENGTH.AVG);
        setupItem.click();
        waitForElementVisible(searchField,PAUSE_LENGTH.AVG);
        searchField.sendKeys(element);
        waitForElementVisible(By.xpath("//a[text()='" + element + "']"), PAUSE_LENGTH.AVG);

        driver.findElement(By.xpath("//a[text()='" + element + "']")).click();
    }


    public void enableActionsInThePublisher()
            throws Exception {
        waitForElementVisible(editButton,PAUSE_LENGTH.AVG);
        editButton.click();
        Thread.sleep(5000);
        waitForElementVisible(enableActionsInThePublisher,PAUSE_LENGTH.AVG);
        log.info(enableActionsInThePublisher.getAttribute("checked"));
        log.info(enableActionsInThePublisher.getAttribute("type"));
        if(!("true").equals(enableActionsInThePublisher.getAttribute("checked"))){
            enableActionsInThePublisher.click();
            log.info("Checkbox was checked");
            saveButton.click();
        }
    }

}
