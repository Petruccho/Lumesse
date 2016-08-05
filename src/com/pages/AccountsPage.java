package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.constans.PAUSE_LENGTH;

public class AccountsPage extends AbstractPage {

	public AccountsPage(WebDriver driver) throws Exception {
		super(driver);
	}

	@FindBy(xpath = "//em[@class='x-btn-split']")
	private WebElement sectionDropdown;

	@FindBy(xpath = "//input[@title='New Account']")
	private WebElement newAccountButton;

	@FindBy(id = "p3")
	private WebElement recordTypeSelect;

	@FindBy(id = "name_firstacc2")
	private WebElement firstNameField;

	@FindBy(id = "name_lastacc2")
	private WebElement lastNameField;

	@FindBy(xpath = "//label[text()='Пол']/../following-sibling::td[1]//select")
	private WebElement sexSelect;

	@FindBy(xpath = "//label[text()='Основной телефон']/../following-sibling::td[1]//select")
	private WebElement phoneSelect;

	@FindBy(xpath = "//label[text()='Mobile']/../following-sibling::td[1]//input")
	private WebElement mobileField;

	public void createAccount(String firstName, String lastName,
			String recordType, String sex) throws Exception {
		log.info("Creating Account " + lastName + "...");

		openPage("Accounts");

		newButton.click();
		log.info("Clicked on New Account");

		waitForElementVisible(recordTypeSelect, PAUSE_LENGTH.AVG);

		Select recordTypeSel = new Select(recordTypeSelect);
		recordTypeSel.selectByVisibleText(recordType);

		continueButton.click();

		waitForElementVisible(firstNameField, PAUSE_LENGTH.AVG);
		firstNameField.clear();
		firstNameField.sendKeys(firstName);
		lastNameField.clear();
		lastNameField.sendKeys(lastName);
		Select sexSel = new Select(sexSelect);
		sexSel.selectByVisibleText(sex);

		Select phoneSel = new Select(phoneSelect);
		phoneSel.selectByVisibleText("Мобильный основной");
		mobileField.clear();
		mobileField.sendKeys("74958581414");

		saveButton.click();
		log.info("Clicked on Save");
		Thread.sleep(5000);

		waitForElementVisible(
				By.xpath("//h2[contains(text(), '" + firstName + " " + lastName
						+ "')]"), PAUSE_LENGTH.AVG);

		log.info("Create Account " + lastName + " - Done");
	}

	public void deleteAccount(String lastName) throws Exception {
		log.info("Deleting Account " + lastName + "...");

		findItem(lastName, "Account", deleteButton, 3);

		deleteButton.click();
		log.info("Clicked on Delete");
		driver.switchTo().alert().accept();

		Thread.sleep(2000);
		waitForElementVisible(newButton, PAUSE_LENGTH.AVG);
		log.info("Delete Account " + lastName + " - Done");
	}
}