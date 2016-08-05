package com.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.constans.PAUSE_LENGTH;

/**
 * Created with IntelliJ IDEA. User: olga.yurush Date: 8/1/16 Time: 9:38 AM To
 * change this template use File | Settings | File Templates.
 */
public class CreateFlowsPage extends AbstractPage {

	public CreateFlowsPage(WebDriver driver) throws Exception {
		super(driver);
	}

	@FindBy(xpath = "//span[@class = ' label bBody truncate']")
	private WebElement newButton;

	@FindBy(id = "processName")
	private WebElement processName;

	@FindBy(id = "processDescription")
	private WebElement processDescription;

	@FindBy(xpath = "//span[text() = 'Save']")
	private WebElement saveButton;

	@FindBy(xpath = "//span[text() = 'Add Object']")
	private WebElement addObject;

	@FindBy(xpath = "//div[@class = 'body margin']/input")
	private WebElement findObject;

	@FindBy(xpath = "//span[text() = 'Add Criteria']")
	private WebElement addCriteria;

	@FindBy(xpath = "//span[text() = 'No criteria—just execute the actions!']")
	private WebElement criteriaType;

	// @FindBy(xpath =
	// "//html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div/label/div[2]/input")
	@FindBy(xpath = "//span[text()='Criteria Name']/..//input")
	private WebElement nameCriteriaField;

	@FindBy(xpath = "//div[@class='body processuicommonPanel processuicommonOutcomePanel showPanel']//button[@class='saveButton uiButton--default uiButton--brand uiButton']")
	private WebElement saveCriteriaButton;

	@FindBy(xpath = "//div[@class='wrapper Outcomeactions processuiruleActionContainer processuiruleActionContainerGroup']//span[text()='Add Action']")
	private WebElement addActionImmideateButton;

	@FindBy(xpath = "//span[text()='Action Type']/..//select")
	private WebElement actionTypeSelect;

	// @FindBy(xpath =
	// "//html/body/div[4]/div[2]/div[2]/div[3]/div[2]/div/div/label[1]/span[1]")
	@FindBy(xpath = "//span[text()='Action Name']/..//input")
	private WebElement actionNameField;

	@FindBy(xpath = "//span[text()='Apex Class']/..//input")
	private WebElement apexClassField;

	@FindBy(xpath = "//option[text()='Reference']")
	private WebElement referenceOption;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][1]//span[text()='Find a field...']")
	private WebElement oneValueField;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][2]//span[text()='Find a field...']")
	private WebElement twoValueField;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][3]//span[text()='Find a field...']")
	private WebElement threeValueField;

	@FindBy(xpath = "//div[@class='wrapper processuicommonTraverserNode']//input")
	private WebElement contactField;

	@FindBy(xpath = "//span[text()='Choose']")
	private WebElement chooseButton;

	@FindBy(xpath = "//div[@class='body processuicommonItemList processuicommonParameterList processuicommonApexParameterList']//span[text()='Add Row']")
	private WebElement addRowButton;

	@FindBy(xpath = "//span[text()='2 Field']/..//input")
	private WebElement twoField;

	@FindBy(xpath = "//span[text()='3 Field']/..//input")
	private WebElement threeField;

	@FindBy(xpath = "//div[@class='body processuicommonPanel processuicommonActionPanel showPanel']//span[text()='Save']")
	private WebElement saveActionButton;

	@FindBy(xpath = "//button[@class='activate uiButton--default uiButton--brand uiButton']")
	private WebElement activateButton;
	
	
	@FindBy(xpath = "//button[@class='uiButton--default uiButton--brand uiButton']")
	private WebElement confirmActivateButton;
	
	public void createFlow(String name, String description, String objectName,
			String criteriaName, String apexClassName, String oneValueName,
			String twoFieldName, String twoValueName, String threeFieldName,
			String threeValueName) throws Exception {

		newButton.click();
		waitForElementVisible(processName, PAUSE_LENGTH.AVG);
		processName.clear();
		processName.sendKeys(name);
		processDescription.clear();
		processDescription.sendKeys(description);
		Thread.sleep(2000);
		waitForElementVisible(processName, PAUSE_LENGTH.AVG);
		saveButton.click();
		Thread.sleep(2000);
		waitForElementVisible(addObject, PAUSE_LENGTH.AVG);
		addObject.click();
		waitForElementVisible(findObject, PAUSE_LENGTH.AVG);
		findObject.clear();
		findObject.sendKeys(objectName);
		// Thread.sleep(4000);
		waitForElementVisible(By.xpath("//mark[text()='" + objectName + "']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//mark[text()='" + objectName + "']"))
				.click();
		Thread.sleep(2000);
		saveButton.click();
		Thread.sleep(2000);
		waitForElementVisible(addCriteria, PAUSE_LENGTH.AVG);
		addCriteria.click();
		waitForElementVisible(nameCriteriaField, PAUSE_LENGTH.AVG);
		nameCriteriaField.sendKeys(criteriaName);
		criteriaType.click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//html/body/div[4]/div[2]/div[2]/div[2]/div[3]/button[1]")).click();
		waitForElementVisible(saveCriteriaButton, PAUSE_LENGTH.AVG);
		saveCriteriaButton.click();
		Thread.sleep(2000);
		waitForElementVisible(addActionImmideateButton, PAUSE_LENGTH.AVG);
		addActionImmideateButton.click();
		waitForElementVisible(actionTypeSelect, PAUSE_LENGTH.AVG);
		Select actionType = new Select(actionTypeSelect);
		actionType.selectByVisibleText("Apex");
		// driver.findElement(By.xpath("//html/body/div[4]/div[2]/div[1]/div/div/div[6]/span/div/div/div[3]/div[1]/div[3]/div/a/div/span[2]")).click();
		// Thread.sleep(2000);
		// driver.findElement(By.xpath(".//*[@id='942:2;a']"));
		waitForElementVisible(actionNameField, PAUSE_LENGTH.AVG);
		actionNameField.sendKeys("Generate Talent Prospect Data");
		// Select actionType = new
		// Select(driver.findElement(By.xpath(".//*[@id='942:2;a']")));
		// actionType.selectByVisibleText("Apex");
		apexClassField.sendKeys(apexClassName);
		waitForElementVisible(
				By.xpath("//mark[text()='" + apexClassName + "']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//mark[text()='" + apexClassName + "']"))
				.click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_DOWN);
		waitForElementVisible(oneValueField, PAUSE_LENGTH.AVG);
		oneValueField.click();
		waitForElementVisible(contactField, PAUSE_LENGTH.AVG);
		contactField.sendKeys(oneValueName);
		waitForElementVisible(
				By.xpath("//span[contains(text(),'" + oneValueName + "')]"),
				PAUSE_LENGTH.AVG);
		driver.findElement(
				By.xpath("//span[contains(text(),'" + oneValueName + "')]"))
				.click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		// Second row
		Thread.sleep(2000);
		addRowButton.click();
		waitForElementVisible(twoField, PAUSE_LENGTH.AVG);
		twoField.sendKeys(twoFieldName);
		waitForElementVisible(
				By.xpath("//span[text()='2 Field']/..//a[contains(text(),'"
						+ twoFieldName + "')]"), PAUSE_LENGTH.AVG);
		driver.findElement(
				By.xpath("//span[text()='2 Field']/..//a[contains(text(),'"
						+ twoFieldName + "')]")).click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_DOWN);
		waitForElementVisible(twoValueField, PAUSE_LENGTH.AVG);
		twoValueField.click();
		waitForElementVisible(contactField, PAUSE_LENGTH.AVG);
		contactField.sendKeys(twoValueName);
		waitForElementVisible(
				By.xpath("//span[text()='" + twoValueName + "']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//span[text()='" + twoValueName + "']"))
				.click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		// Third row
		Thread.sleep(2000);
		addRowButton.click();
		waitForElementVisible(threeField, PAUSE_LENGTH.AVG);
		threeField.sendKeys(threeFieldName);
		waitForElementVisible(
				By.xpath("//span[text()='3 Field']/..//a[contains(text(),'"
						+ threeValueName + "')]"), PAUSE_LENGTH.AVG);
		driver.findElement(
				By.xpath("//span[text()='3 Field']/..//a[contains(text(),'"
						+ threeValueName + "')]")).click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_DOWN);
		waitForElementVisible(threeValueField, PAUSE_LENGTH.AVG);
		threeValueField.click();
		waitForElementVisible(contactField, PAUSE_LENGTH.AVG);
		contactField.sendKeys(threeValueName);
		waitForElementVisible(
				By.xpath("//span[text()='" + threeValueName + "']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//span[text()='" + threeValueName + "']"))
				.click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Thread.sleep(2000);
		saveActionButton.click();
		
		Thread.sleep(3000);
		activateButton.click();
		
		waitForElementVisible(confirmActivateButton, PAUSE_LENGTH.AVG);
		confirmActivateButton.click();
	}

}
