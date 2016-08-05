package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.constans.PAUSE_LENGTH;

public class QueuePage extends AbstractPage {

	public QueuePage(WebDriver driver) throws Exception {
		super(driver);
	}

	@FindBy(xpath = "//em[@class='x-btn-split']")
	private WebElement sectionDropdown;

	@FindBy(xpath = "//input[@title='New Участник очереди']")
	private WebElement newQueueUserButton;

	@FindBy(id = "Name")
	private WebElement nameField;

	@FindBy(xpath = "//label[text()='Пользователь']/../following-sibling::td[1]/span/input")
	private WebElement userField;

	@FindBy(xpath = "//label[text()='Очередь']/../following-sibling::td[1]//span/input")
	private WebElement queueField;

	@FindBy(xpath = "//div[@id='userNavButton']/span")
	private WebElement userLabel;

	public void addUserToQueue() throws Exception {
		String currentUser = userLabel.getText();
		log.info("Add " + currentUser + " to queue");
		closeAllTabs();
		log.info("Closed all tabs");

		switchToFrame(pageLabel);

		newQueueUserButton.click();
		log.info("Clicked on New Queue User");

		driver.switchTo().defaultContent();

		Thread.sleep(5000);

		switchToFrame(nameField);

		nameField.clear();
		nameField.sendKeys(currentUser);

		userField.clear();
		userField.sendKeys(currentUser);

		queueField.clear();
		queueField.sendKeys("ИФЛ");

		saveButton.click();
		log.info("Clicked on Save");

		waitForElementVisible(
				By.xpath("//h2[contains(text(), '" + currentUser + "')]"),
				PAUSE_LENGTH.AVG);

		log.info("Add " + currentUser + " to queue - Done");
	}

	public boolean verifyUserInQueue()
			throws Exception {
		String currentUser = userLabel.getText();
		log.info("Verify " + currentUser + " in queue");
		boolean result = false;
		try {
			findItem(currentUser, "Участники очереди", delButton, 2);
			timeout(5);
			result = delButton.isDisplayed();
		} catch (Exception e) {
			log.info(e.getMessage());
		}

		driver.switchTo().defaultContent();
		timeout(defaultTimeout);
		log.info("Verify " + currentUser + " in queue - " + result);
		return result;
	}

}