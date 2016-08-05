package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.constans.PAUSE_LENGTH;

public class LeadsPage extends AbstractPage {

	public LeadsPage(WebDriver driver) throws Exception {
		super(driver);
	}

	@FindBy(xpath = "//em[@class='x-btn-split']")
	private WebElement sectionDropdown;

	@FindBy(xpath = "//input[@title='New Lead']")
	private WebElement newLeadButton;

	@FindBy(id = "name_firstlea2")
	private WebElement firstNameField;

	@FindBy(id = "name_lastlea2")
	private WebElement lastNameField;

	@FindBy(id = "lea8")
	private WebElement phoneField;

	@FindBy(xpath = "//label[text()='Пол']/../following-sibling::td[1]//select")
	private WebElement sexSelect;

	public void createLead(String lastName, String firstName, String status)
			throws Exception {
		log.info("Creating Lead " + lastName + "...");

		openPage("Leads");
		newButton.click();
		log.info("Clicked on \"New\" button");

		firstNameField.clear();
		firstNameField.sendKeys(firstName);
		lastNameField.clear();
		lastNameField.sendKeys(lastName);

		Select sexSel = new Select(sexSelect);
		sexSel.selectByVisibleText("Мужской");

		Select leadStatus = new Select(driver.findElement(By.id("lea13")));
		leadStatus.selectByVisibleText(status);

		phoneField.sendKeys("79562253636");

		saveButton.click();
		log.info("Clicked on Save");
		Thread.sleep(2000);

		waitForElementVisible(
				By.xpath("//h2[contains(text(), '" + firstName + " " + lastName
						+ "')]"), PAUSE_LENGTH.AVG);
		log.info("Create Lead " + lastName + " - Done");
	}

	@FindBy(id = "phSearchInput")
	private WebElement searchField;

	@FindBy(id = "phSearchButton")
	private WebElement searchButton;

	public void deleteLead(String firstName, String lastName) throws Exception {
		log.info("Deleting Lead " + lastName + "...");

		findItem(lastName, "Lead", delButton, 3);

		
		delButton.click();
		log.info("Clicked on Delete");
		driver.switchTo().alert().accept();

		Thread.sleep(2000);
		waitForElementVisible(newButton, PAUSE_LENGTH.AVG);
		log.info("Delete Lead " + lastName + " - Done");
	}
}