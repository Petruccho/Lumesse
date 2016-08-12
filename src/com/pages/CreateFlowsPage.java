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
	private WebElement noCriteriaType;

	// @FindBy(xpath =
	// "//html/body/div[4]/div[2]/div[2]/div[2]/div[2]/div/label/div[2]/input")
	@FindBy(xpath = "//span[text()='Criteria Name']/..//input")
	private WebElement nameCriteriaField;

	@FindBy(xpath = "//div[@class='body processuicommonPanel processuicommonOutcomePanel showPanel']//button[@class='saveButton uiButton--default uiButton--brand uiButton']")
	private WebElement saveCriteriaButton;

	@FindBy(xpath = "//div[@class='processuiruleOutcomeGroup'][1]//div[@class='wrapper Outcomeactions processuiruleActionContainer processuiruleActionContainerGroup']//span[text()='Add Action']")
	private WebElement addActionImmideateOneButton;

	@FindBy(xpath = "//div[@class='processuiruleOutcomeGroup'][2]//div[@class='wrapper Outcomeactions processuiruleActionContainer processuiruleActionContainerGroup']//span[text()='Add Action']")
	private WebElement addActionImmideateTwoButton;

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
	private WebElement addParameterRowButton;

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

	public void creategenerateTalentProspectDataFlow(String name,
			String description, String objectName, String criteriaName)
			throws Exception {

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
		noCriteriaType.click();
		Thread.sleep(2000);
		// driver.findElement(By.xpath("//html/body/div[4]/div[2]/div[2]/div[2]/div[3]/button[1]")).click();
		waitForElementVisible(saveCriteriaButton, PAUSE_LENGTH.AVG);
		saveCriteriaButton.click();

		// Time to close exception
		Thread.sleep(8000);

		waitForElementVisible(addActionImmideateOneButton, PAUSE_LENGTH.AVG);
		addActionImmideateOneButton.click();
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
		apexClassField.sendKeys("tobase__to_process_generateTalentData");
		waitForElementVisible(
				By.xpath("//mark[text()='tobase__to_process_generateTalentData']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(
				By.xpath("//mark[text()='tobase__to_process_generateTalentData']"))
				.click();
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_DOWN);
		waitForElementVisible(oneValueField, PAUSE_LENGTH.AVG);
		oneValueField.click();
		waitForElementVisible(contactField, PAUSE_LENGTH.AVG);
		contactField.sendKeys("Contact ID");
		waitForElementVisible(
				By.xpath("//span[contains(text(),'Contact ID')]"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//span[contains(text(),'Contact ID')]"))
				.click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		// Second row
		Thread.sleep(2000);
		addParameterRowButton.click();
		waitForElementVisible(twoField, PAUSE_LENGTH.AVG);
		twoField.sendKeys("Skills to Import");
		waitForElementVisible(
				By.xpath("//span[text()='2 Field']/..//a[contains(text(),'Skills to Import')]"),
				PAUSE_LENGTH.AVG);
		driver.findElement(
				By.xpath("//span[text()='2 Field']/..//a[contains(text(),'Skills to Import')]"))
				.click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_DOWN);
		waitForElementVisible(twoValueField, PAUSE_LENGTH.AVG);
		twoValueField.click();
		waitForElementVisible(contactField, PAUSE_LENGTH.AVG);
		contactField.sendKeys("Skills to Import");
		waitForElementVisible(By.xpath("//span[text()='Skills to Import']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//span[text()='Skills to Import']"))
				.click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		// Third row
		Thread.sleep(2000);
		addParameterRowButton.click();
		waitForElementVisible(threeField, PAUSE_LENGTH.AVG);
		threeField.sendKeys("Targeted Roles To Import");
		waitForElementVisible(
				By.xpath("//span[text()='3 Field']/..//a[contains(text(),'Targeted Roles To Import')]"),
				PAUSE_LENGTH.AVG);
		driver.findElement(
				By.xpath("//span[text()='3 Field']/..//a[contains(text(),'Targeted Roles To Import')]"))
				.click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_DOWN);
		waitForElementVisible(threeValueField, PAUSE_LENGTH.AVG);
		threeValueField.click();
		waitForElementVisible(contactField, PAUSE_LENGTH.AVG);
		contactField.sendKeys("Targeted Roles");
		waitForElementVisible(By.xpath("//span[text()='Targeted Roles']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//span[text()='Targeted Roles']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Thread.sleep(2000);
		saveActionButton.click();

		Thread.sleep(6000);
		activateButton.click();

		waitForElementVisible(confirmActivateButton, PAUSE_LENGTH.AVG);
		confirmActivateButton.click();
	}

	@FindBy(xpath = "//span[text() = 'Conditions are met']")
	private WebElement conditionsCriteriaType;

	@FindBy(xpath = "//div[@class='modal-container']//input")
	private WebElement contactContainerField;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][1]//span[text()='Find a field...']")
	private WebElement criteriaOneField;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][1]//option[@value='EqualTo']/parent::select")
	private WebElement operatorOneSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][1]//option[@value='String']/parent::select")
	private WebElement typeOneSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][1]//option[text()='Select One']/parent::select")
	private WebElement valueOneSelect;

	@FindBy(xpath = "//div[@class='body processuicommonItemList processuicommonConditionList']//span[text()='Add Row']")
	private WebElement addConditionRowButton;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][2]//span[text()='Find a field...']")
	private WebElement criteriaTwoField;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][2]//option[@value='EqualTo']/parent::select")
	private WebElement operatorTwoSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][2]//option[@value='String']/parent::select")
	private WebElement typeTwoSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][2]//option[text()='Select One']/parent::select")
	private WebElement valueTwoSelect;

	@FindBy(xpath = "//span[text() = 'All of the conditions are met (AND)']")
	private WebElement allConditionsType;

	@FindBy(xpath = "//div[@class='textPostRow processuicommonActionTypeChatterPost']//option[text()='Select One']/parent::select")
	private WebElement postToSelect;

	@FindBy(xpath = "//div[@class='uiBlock']//span[text()='Merge Field']")
	private WebElement mergeFieldField;

	public void createPostContactCommentToChatterFlow(String name,
			String description, String objectName, String criteriaName)
			throws Exception {

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
		conditionsCriteriaType.click();

		// First Condition
		criteriaOneField.click();
		waitForElementVisible(contactContainerField, PAUSE_LENGTH.AVG);
		contactContainerField.sendKeys("Comments");
		waitForElementVisible(By.xpath("//span[text()='Comments']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//span[text()='Comments']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		Select operatorOne = new Select(operatorOneSelect);
		operatorOne.selectByVisibleText("Does not equal");
		Thread.sleep(2000);
		Select typeOne = new Select(typeOneSelect);
		typeOne.selectByVisibleText("Global Constant");
		Thread.sleep(2000);
		Select valueOne = new Select(valueOneSelect);
		valueOne.selectByVisibleText("$GlobalConstant.Null");
		Thread.sleep(2000);
		addConditionRowButton.click();
		Thread.sleep(2000);

		// Second condition
		criteriaTwoField.click();
		waitForElementVisible(contactContainerField, PAUSE_LENGTH.AVG);
		contactContainerField.sendKeys("Comments");
		waitForElementVisible(By.xpath("//span[text()='Comments']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//span[text()='Comments']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Select operatorTwo = new Select(operatorTwoSelect);
		operatorTwo.selectByVisibleText("Does not equal");
		Thread.sleep(2000);
		Select typeTwo = new Select(typeTwoSelect);
		typeTwo.selectByVisibleText("Global Constant");
		Thread.sleep(2000);
		Select valueTwo = new Select(valueTwoSelect);
		valueTwo.selectByVisibleText("$GlobalConstant.EmptyString");
		Thread.sleep(2000);

		allConditionsType.click();

		Thread.sleep(2000);
		saveCriteriaButton.click();

		// Time to close exception
		Thread.sleep(8000);

		waitForElementVisible(addActionImmideateOneButton, PAUSE_LENGTH.AVG);
		addActionImmideateOneButton.click();
		waitForElementVisible(actionTypeSelect, PAUSE_LENGTH.AVG);
		Select actionType = new Select(actionTypeSelect);
		actionType.selectByVisibleText("Post to Chatter");

		waitForElementVisible(actionNameField, PAUSE_LENGTH.AVG);
		actionNameField.sendKeys("Post Comment to Chatter");

		Select postTo = new Select(postToSelect);
		postTo.selectByVisibleText("This Record");

		waitForElementVisible(mergeFieldField, PAUSE_LENGTH.AVG);
		mergeFieldField.click();

		waitForElementVisible(contactContainerField, PAUSE_LENGTH.AVG);
		contactContainerField.sendKeys("Comments");
		waitForElementVisible(By.xpath("//span[text()='Comments']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//span[text()='Comments']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		Thread.sleep(2000);
		saveActionButton.click();

		Thread.sleep(6000);
		activateButton.click();

		waitForElementVisible(confirmActivateButton, PAUSE_LENGTH.AVG);
		confirmActivateButton.click();
	}

	@FindBy(xpath = "//span[text() = 'when a record is created or edited']")
	private WebElement createdEditedOption;

	@FindBy(xpath = "//div[@class='body processuicommonPanel processuicommonOutcomePanel showPanel']//a[@class='advancedLink processuicommonAdvancedSection']")
	private WebElement advancedCriteriaLink;

	@FindBy(xpath = "//div[@class='outcomeUpdateOnce']//span[text() = 'Yes']")
	private WebElement yesAdvancedCriteriaRadio;

	@FindBy(xpath = "//span[text() = 'Select a record to update...']")
	private WebElement recordTypeField;

	@FindBy(xpath = "//span[text() = 'Select a record related to the tobase__Prospect_Response__c']")
	private WebElement selectARecordRelatedRadio;

	@FindBy(xpath = "//input[@placeholder='Type to filter list…']")
	private WebElement recordInputField;

	@FindBy(xpath = "//span[text() = 'No criteria—just update the records!']")
	private WebElement noCriteriaUpdateRadio;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][1]//option[@value='Picklist']/parent::select")
	private WebElement oneTypeDefineCriteriaSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][1]//span[text()='1 Field']/..//input")
	private WebElement oneUpdateRecordsField;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][1]//option[@value='Picklist']/parent::select")
	private WebElement oneTypeUpdateRecordsSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][1]//option[@label='Select One']/parent::select")
	private WebElement oneValueUpdateRecordsSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][2]//label[@class='uiLabel processuicommonInput processuicommonInputText']//input")
	private WebElement twoValueDefineCriteriaInput;

	public void createupdateContactProspectStatusOnResponseFlow(String name,
			String description, String objectName, String criteriaName,
			String conditionTwoValue, String actionValue) throws Exception {
	
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
		createdEditedOption.click();
		Thread.sleep(2000);
		saveButton.click();
		Thread.sleep(2000);
	
		waitForElementVisible(addCriteria, PAUSE_LENGTH.AVG);
		addCriteria.click();
		waitForElementVisible(nameCriteriaField, PAUSE_LENGTH.AVG);
		nameCriteriaField.sendKeys(criteriaName);
		conditionsCriteriaType.click();
	
		// First Condition
		criteriaOneField.click();
		waitForElementVisible(contactContainerField, PAUSE_LENGTH.AVG);
		contactContainerField.sendKeys("Status");
		waitForElementVisible(By.xpath("//span[text()='Status']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//span[text()='Status']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
	
		Select operatorOne = new Select(operatorOneSelect);
		operatorOne.selectByVisibleText("Equals");
		Thread.sleep(2000);
		Select typeOne = new Select(oneTypeDefineCriteriaSelect);
		typeOne.selectByVisibleText("Picklist");
		Thread.sleep(2000);
		Select valueOne = new Select(valueOneSelect);
		valueOne.selectByVisibleText("Responded");
		Thread.sleep(2000);
		addConditionRowButton.click();
		Thread.sleep(2000);
	
		// Second condition
		criteriaTwoField.click();
		waitForElementVisible(contactContainerField, PAUSE_LENGTH.AVG);
		contactContainerField.sendKeys("Response");
		waitForElementVisible(By.xpath("//span[text()='Response']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//span[text()='Response']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Select operatorTwo = new Select(operatorTwoSelect);
		operatorTwo.selectByVisibleText("Equals");
		Thread.sleep(2000);
		Select typeTwo = new Select(typeTwoSelect);
		typeTwo.selectByVisibleText("String");
		Thread.sleep(2000);
		twoValueDefineCriteriaInput.sendKeys(conditionTwoValue);
		Thread.sleep(2000);
	
		allConditionsType.click();
	
		advancedCriteriaLink.click();
		waitForElementVisible(yesAdvancedCriteriaRadio, PAUSE_LENGTH.AVG);
		yesAdvancedCriteriaRadio.click();
		Thread.sleep(2000);
		saveCriteriaButton.click();
	
		// Time to close exception
		Thread.sleep(8000);
	
		waitForElementVisible(addActionImmideateOneButton, PAUSE_LENGTH.AVG);
		addActionImmideateOneButton.click();
		waitForElementVisible(actionTypeSelect, PAUSE_LENGTH.AVG);
		Select actionType = new Select(actionTypeSelect);
		actionType.selectByVisibleText("Update Records");
	
		waitForElementVisible(actionNameField, PAUSE_LENGTH.AVG);
		actionNameField.sendKeys("Update Contact Prospect Status");
	
		recordTypeField.click();
		waitForElementVisible(selectARecordRelatedRadio, PAUSE_LENGTH.AVG);
		selectARecordRelatedRadio.click();
		recordInputField.sendKeys("Contact");
		waitForElementVisible(By.xpath("//span[text()='Contact']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//span[text()='Contact']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
	
		Thread.sleep(2000);
		waitForElementVisible(noCriteriaUpdateRadio, PAUSE_LENGTH.AVG);
		noCriteriaUpdateRadio.click();
	
		waitForElementVisible(oneUpdateRecordsField, PAUSE_LENGTH.AVG);
		oneUpdateRecordsField.sendKeys("Prospect Status");
		waitForElementVisible(
				By.xpath("//div[@class='lookup__menu uiAbstractList uiAutocompleteList uiInput uiAutocomplete uiInput--default uiInput--lookup']//a[text()='Prospect Status']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(
				By.xpath("//div[@class='lookup__menu uiAbstractList uiAutocompleteList uiInput uiAutocomplete uiInput--default uiInput--lookup']//a[text()='Prospect Status']"))
				.click();
	
		Select oneType = new Select(oneTypeUpdateRecordsSelect);
		oneType.selectByVisibleText("Picklist");
	
		Select oneValue = new Select(oneValueUpdateRecordsSelect);
		oneValue.selectByVisibleText(actionValue);
	
		Thread.sleep(2000);
		saveActionButton.click();
	
		Thread.sleep(6000);
		activateButton.click();
	
		waitForElementVisible(confirmActivateButton, PAUSE_LENGTH.AVG);
		confirmActivateButton.click();
	}

}
