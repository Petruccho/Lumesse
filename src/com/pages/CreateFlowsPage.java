package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.constans.PAUSE_LENGTH;

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
	private WebElement selectAFieldField;

	@FindBy(xpath = "//div[@class='wrapper processuicommonTraverserNode'][2]//input")
	private WebElement twoSelectAFieldField;

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

	public void createGenerateTalentProspectDataFlow(String name,
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

		waitForElementVisible(saveCriteriaButton, PAUSE_LENGTH.AVG);
		saveCriteriaButton.click();

		// Time to close exception
		Thread.sleep(8000);

		waitForElementVisible(addActionImmideateOneButton, PAUSE_LENGTH.AVG);
		addActionImmideateOneButton.click();
		waitForElementVisible(actionTypeSelect, PAUSE_LENGTH.AVG);
		Select actionType = new Select(actionTypeSelect);
		actionType.selectByVisibleText("Apex");

		waitForElementVisible(actionNameField, PAUSE_LENGTH.AVG);
		actionNameField.sendKeys("Generate Talent Prospect Data");

		apexClassField.sendKeys("tobase__to_process_generateTalentData");
		waitForElementVisible(
				By.xpath("//mark[text()='tobase__to_process_generateTalentData']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(
				By.xpath("//mark[text()='tobase__to_process_generateTalentData']"))
				.click();
		Thread.sleep(2000);
		Select oneTypeSetApexvariables = new Select(
				oneTypeSetApexVariablesSelect);
		oneTypeSetApexvariables.selectByVisibleText("Reference");
		waitForElementVisible(oneValueField, PAUSE_LENGTH.AVG);
		oneValueField.click();
		waitForElementVisible(selectAFieldField, PAUSE_LENGTH.AVG);
		selectAFieldField.sendKeys("Contact ID");
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
		Select twoTypeSetApexvariables = new Select(
				twoTypeSetApexVariablesSelect);
		twoTypeSetApexvariables.selectByVisibleText("Reference");
		waitForElementVisible(twoValueField, PAUSE_LENGTH.AVG);
		twoValueField.click();
		waitForElementVisible(selectAFieldField, PAUSE_LENGTH.AVG);
		selectAFieldField.sendKeys("Skills to Import");
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
		Select threeTypeSetApexvariables = new Select(
				threeTypeSetApexVariablesSelect);
		threeTypeSetApexvariables.selectByVisibleText("Reference");
		waitForElementVisible(threeValueField, PAUSE_LENGTH.AVG);
		threeValueField.click();
		waitForElementVisible(selectAFieldField, PAUSE_LENGTH.AVG);
		selectAFieldField.sendKeys("Targeted Roles");
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
	private WebElement inputContainerField;

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
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Comments");
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
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Comments");
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

		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Comments");
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

	public void createUpdateContactProspectStatusOnResponseFlow(String name,
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
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Status");
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
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Response");
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

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][2]//option[@value='Boolean']/parent::select")
	private WebElement twoTypeDefineCriteriaSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][2]//option[@value='true']/parent::select")
	private WebElement valueTwoDefineCriteriaSelect;

	@FindBy(xpath = "//option[@label='Global actions']/parent::select")
	private WebElement filterSearchBySelect;

	@FindBy(xpath = "//option[@label='Log a Call']/parent::select")
	private WebElement typeFilterSearchBySelect;

	@FindBy(xpath = "//div[@class='quickActionField sub third']//input")
	private WebElement actionFilterSearchByField;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][1]//option[@label='Reference']/parent::select")
	private WebElement oneTypeSetQuickActionsSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][1]//span[text()='Find a field...']")
	private WebElement oneValueSetQuickActionsField;

	@FindBy(xpath = "//div[@class='body processuicommonItemList processuicommonParameterList processuicommonQuickActionParameterList']//span[text()='Add Row']")
	private WebElement addRowQuickActionParameterListButton;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][2]//input[@placeholder='Find a field...']")
	private WebElement twoFieldSetQuickActionsField;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][2]//option[@label='Reference']/parent::select")
	private WebElement twoTypeSetQuickActionsSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][2]//span[text()='Find a field...']")
	private WebElement twoValueSetQuickActionsField;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][3]//input[@placeholder='Find a field...']")
	private WebElement threeFieldSetQuickActionsField;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][3]//option[@label='Reference']/parent::select")
	private WebElement threeTypeSetQuickActionsSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][3]//option[@label='Select One']/parent::select")
	private WebElement threeValueSetQuickActionsSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][4]//input[@placeholder='Find a field...']")
	private WebElement fourFieldSetQuickActionsField;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][4]//option[@label='Reference']/parent::select")
	private WebElement fourTypeSetQuickActionsSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][4]//span[text()='Build a formula...']")
	private WebElement fourValueSetQuickActionsField;

	@FindBy(xpath = "//tr[@class='inlineFormulaBuilder processuicommonItemListRow processuicommonParameterListRow']//textarea")
	private WebElement formulaField;

	@FindBy(xpath = "//tr[@class='inlineFormulaBuilder processuicommonItemListRow processuicommonParameterListRow']//span[text()='Use this Formula']")
	private WebElement useThisFormulaButton;

	public void createCreateTaskForProjectOwnerOnResponseFlow(String name,
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
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Status");
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
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Response");
		waitForElementVisible(By.xpath("//span[text()='Response']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//span[text()='Response']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Select operatorTwo = new Select(operatorTwoSelect);
		operatorTwo.selectByVisibleText("Is changed");
		Thread.sleep(2000);
		Select typeTwo = new Select(twoTypeDefineCriteriaSelect);
		typeTwo.selectByVisibleText("Boolean");
		Thread.sleep(2000);
		Select valueTwo = new Select(valueTwoDefineCriteriaSelect);
		valueTwo.selectByVisibleText("True");
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
		actionType.selectByVisibleText("Quick Actions");

		waitForElementVisible(actionNameField, PAUSE_LENGTH.AVG);
		actionNameField.sendKeys("Create a Task for Project Owner");

		waitForElementVisible(filterSearchBySelect, PAUSE_LENGTH.AVG);
		Select filterSearchBy = new Select(filterSearchBySelect);
		filterSearchBy.selectByVisibleText("Global actions");

		waitForElementVisible(typeFilterSearchBySelect, PAUSE_LENGTH.AVG);
		Select typeFilterSearchBy = new Select(typeFilterSearchBySelect);
		typeFilterSearchBy.selectByVisibleText("Create a Record");

		waitForElementVisible(actionFilterSearchByField, PAUSE_LENGTH.AVG);
		actionFilterSearchByField.sendKeys("NewTask");
		waitForElementVisible(By.xpath("//a[text()='NewTask']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//a[text()='NewTask']")).click();

		Thread.sleep(2000);
		Select oneTypeSetQuickActions = new Select(oneTypeSetQuickActionsSelect);
		oneTypeSetQuickActions.selectByVisibleText("Reference");

		waitForElementVisible(oneValueSetQuickActionsField, PAUSE_LENGTH.AVG);
		oneValueSetQuickActionsField.click();
		waitForElementVisible(selectAFieldField, PAUSE_LENGTH.AVG);
		selectAFieldField.sendKeys("Recruiting Project");
		waitForElementVisible(
				By.xpath("//div[contains(text(),'Recruiting Project')]"),
				PAUSE_LENGTH.AVG);
		driver.findElement(
				By.xpath("//div[contains(text(),'Recruiting Project')]"))
				.click();
		Thread.sleep(2000);
		waitForElementVisible(twoSelectAFieldField, PAUSE_LENGTH.AVG);
		twoSelectAFieldField.sendKeys("Owner ID");
		waitForElementVisible(
				By.xpath("//div[@class='visible uiAutocompletePanel--default uiAutocompletePanel--lookup uiAutocompletePanel'][2]//span[contains(text(),'Owner ID')]"),
				PAUSE_LENGTH.AVG);
		driver.findElement(
				By.xpath("//div[@class='visible uiAutocompletePanel--default uiAutocompletePanel--lookup uiAutocompletePanel'][2]//span[contains(text(),'Owner ID')]"))
				.click();

		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Thread.sleep(2000);

		// Second Action

		addRowQuickActionParameterListButton.click();
		Thread.sleep(2000);

		twoFieldSetQuickActionsField.sendKeys("Related Record ID");
		waitForElementVisible(By.xpath("//a[text()='Related Record ID']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//a[text()='Related Record ID']")).click();
		Thread.sleep(2000);
		Select twoTypeSetQuickActions = new Select(twoTypeSetQuickActionsSelect);
		twoTypeSetQuickActions.selectByVisibleText("Reference");

		waitForElementVisible(twoValueSetQuickActionsField, PAUSE_LENGTH.AVG);
		twoValueSetQuickActionsField.click();
		waitForElementVisible(selectAFieldField, PAUSE_LENGTH.AVG);

		selectAFieldField.sendKeys("Record ID");
		waitForElementVisible(By.xpath("//span[contains(text(),'Record ID')]"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//span[contains(text(),'Record ID')]"))
				.click();

		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Thread.sleep(2000);

		// Third Action

		addRowQuickActionParameterListButton.click();
		Thread.sleep(2000);

		threeFieldSetQuickActionsField.sendKeys("Status");
		waitForElementVisible(
				By.xpath("//div[@class='lookup__menu uiAbstractList uiAutocompleteList uiInput uiAutocomplete uiInput--default uiInput--lookup']//a[text()='Status']"),
				PAUSE_LENGTH.AVG);
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//div[@class='lookup__menu uiAbstractList uiAutocompleteList uiInput uiAutocomplete uiInput--default uiInput--lookup']//a[text()='Status']"))
				.click();
		Thread.sleep(2000);
		Select threeTypeSetQuickActions = new Select(
				threeTypeSetQuickActionsSelect);
		threeTypeSetQuickActions.selectByVisibleText("Picklist");

		Thread.sleep(2000);
		Select threeValueSetQuickActions = new Select(
				threeValueSetQuickActionsSelect);
		threeValueSetQuickActions.selectByVisibleText("Not Started");

		// Fourth Action
		addRowQuickActionParameterListButton.click();
		Thread.sleep(2000);

		fourFieldSetQuickActionsField.sendKeys("Subject");
		waitForElementVisible(
				By.xpath("//div[@class='lookup__menu uiAbstractList uiAutocompleteList uiInput uiAutocomplete uiInput--default uiInput--lookup']//a[text()='Subject']"),
				PAUSE_LENGTH.AVG);
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//div[@class='lookup__menu uiAbstractList uiAutocompleteList uiInput uiAutocomplete uiInput--default uiInput--lookup']//a[text()='Subject']"))
				.click();
		Thread.sleep(2000);
		Select fourTypeSetQuickActions = new Select(
				fourTypeSetQuickActionsSelect);
		fourTypeSetQuickActions.selectByVisibleText("Formula");

		waitForElementVisible(fourValueSetQuickActionsField, PAUSE_LENGTH.AVG);
		fourValueSetQuickActionsField.click();

		waitForElementVisible(formulaField, PAUSE_LENGTH.AVG);
		formulaField
				.sendKeys("[tobase__Prospect_Response__c].tobase__Contact__c.FirstName + 'responded with' + [tobase__Prospect_Response__c].tobase__Response__c");
		useThisFormulaButton.click();

		Thread.sleep(2000);
		saveActionButton.click();

		Thread.sleep(6000);
		activateButton.click();

		waitForElementVisible(confirmActivateButton, PAUSE_LENGTH.AVG);
		confirmActivateButton.click();
	}

	@FindBy(xpath = "//input[@placeholder = 'Find a record...']")
	private WebElement recordTypeCreateARecordField;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][1]//option[@value='GlobalConstant']/parent::select")
	private WebElement oneTypeDefineCriteriaATSelect;

	@FindBy(xpath = "//div[@class='body processuicommonItemList processuicommonParameterList']//span[text()='Add Row']")
	private WebElement addCreateARecordRowButton;

	public void createAutoTargetingFlow(String name, String description,
			String objectName, String criteriaName) throws Exception {

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

		criteriaOneField.click();
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Current_Role__c");
		waitForElementVisible(By.xpath("//span[text()='Current_Role__c']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//span[text()='Current_Role__c']"))
				.click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		Select operatorOne = new Select(operatorOneSelect);
		operatorOne.selectByVisibleText("Does not equal");
		Thread.sleep(2000);
		Select typeOne = new Select(oneTypeDefineCriteriaATSelect);
		typeOne.selectByVisibleText("Global Constant");
		Thread.sleep(2000);
		Select valueOne = new Select(valueOneSelect);
		valueOne.selectByVisibleText("$GlobalConstant.Null");
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
		actionType.selectByVisibleText("Create a Record");

		waitForElementVisible(actionNameField, PAUSE_LENGTH.AVG);
		actionNameField.sendKeys("Create Targeted Role");

		recordTypeCreateARecordField.sendKeys("Targeted Role");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//mark[text()='Targeted Role']")).click();

		// First

		oneUpdateRecordsField.clear();
		oneUpdateRecordsField.sendKeys("Contact");
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//div[@class='lookup__menu uiAbstractList uiAutocompleteList uiInput uiAutocomplete uiInput--default uiInput--lookup']//a[text()='Contact']"))
				.click();

		Select oneTypeSetQuickActions = new Select(oneTypeSetQuickActionsSelect);
		oneTypeSetQuickActions.selectByVisibleText("Reference");

		waitForElementVisible(oneValueSetQuickActionsField, PAUSE_LENGTH.AVG);
		oneValueSetQuickActionsField.click();
		waitForElementVisible(selectAFieldField, PAUSE_LENGTH.AVG);
		selectAFieldField.sendKeys("Contact ID");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'Contact ID')]"))
				.click();
		Thread.sleep(2000);
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Thread.sleep(2000);

		// Second

		addCreateARecordRowButton.click();
		Thread.sleep(2000);

		twoFieldSetQuickActionsField.sendKeys("Functional Role");
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//div[@class='lookup__menu uiAbstractList uiAutocompleteList uiInput uiAutocomplete uiInput--default uiInput--lookup']//a[text()='Functional Role']"))
				.click();
		Thread.sleep(2000);
		Select twoTypeSetQuickActions = new Select(twoTypeSetQuickActionsSelect);
		twoTypeSetQuickActions.selectByVisibleText("Reference");

		waitForElementVisible(twoValueSetQuickActionsField, PAUSE_LENGTH.AVG);
		twoValueSetQuickActionsField.click();
		waitForElementVisible(selectAFieldField, PAUSE_LENGTH.AVG);

		selectAFieldField.sendKeys("Current_Role__c");
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//div[@class='visible uiAutocompletePanel--default uiAutocompletePanel--lookup uiAutocompletePanel']//span[contains(text(),'Current_Role__c')]"))
				.click();

		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		Thread.sleep(2000);
		saveActionButton.click();

		Thread.sleep(6000);
		activateButton.click();

		waitForElementVisible(confirmActivateButton, PAUSE_LENGTH.AVG);
		confirmActivateButton.click();
	}

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][1]//option[@label='Reference']/parent::select")
	private WebElement oneTypeSetApexVariablesSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][2]//option[@label='Reference']/parent::select")
	private WebElement twoTypeSetApexVariablesSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][3]//option[@label='Reference']/parent::select")
	private WebElement threeTypeSetApexVariablesSelect;

	public void createAutoPipeliningFlow(String name, String description,
			String objectName, String criteriaName) throws Exception {

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

		criteriaOneField.click();
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Current_Role__c");
		waitForElementVisible(By.xpath("//span[text()='Current_Role__c']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//span[text()='Current_Role__c']"))
				.click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		Select operatorOne = new Select(operatorOneSelect);
		operatorOne.selectByVisibleText("Does not equal");
		Thread.sleep(2000);
		Select typeOne = new Select(oneTypeDefineCriteriaATSelect);
		typeOne.selectByVisibleText("Global Constant");
		Thread.sleep(2000);
		Select valueOne = new Select(valueOneSelect);
		valueOne.selectByVisibleText("$GlobalConstant.Null");
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
		actionType.selectByVisibleText("Apex");
		waitForElementVisible(actionNameField, PAUSE_LENGTH.AVG);
		actionNameField.sendKeys("Create Recruiting Project Member");

		apexClassField.sendKeys("tobase__to_process_autoPipeliningProspect");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//a[text()='tobase__to_process_autoPipeliningProspect']"))
				.click();
		Thread.sleep(2000);
		Select oneTypeSetApexvariables = new Select(
				oneTypeSetApexVariablesSelect);
		oneTypeSetApexvariables.selectByVisibleText("Reference");

		waitForElementVisible(oneValueField, PAUSE_LENGTH.AVG);
		oneValueField.click();
		waitForElementVisible(selectAFieldField, PAUSE_LENGTH.AVG);
		selectAFieldField.sendKeys("Contact ID");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Contact ID')]"))
				.click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		// Second row
		Thread.sleep(2000);
		addParameterRowButton.click();
		waitForElementVisible(twoField, PAUSE_LENGTH.AVG);
		twoField.sendKeys("Functional Role Lookup");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//span[text()='2 Field']/..//a[contains(text(),'Functional Role Lookup')]"))
				.click();
		Thread.sleep(2000);
		Select twoTypeSetApexvariables = new Select(
				twoTypeSetApexVariablesSelect);
		twoTypeSetApexvariables.selectByVisibleText("Reference");
		waitForElementVisible(twoValueField, PAUSE_LENGTH.AVG);
		twoValueField.click();
		waitForElementVisible(selectAFieldField, PAUSE_LENGTH.AVG);
		selectAFieldField.sendKeys("Current_Role__c");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Current_Role__c']"))
				.click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		Thread.sleep(2000);
		saveActionButton.click();

		Thread.sleep(6000);
		activateButton.click();

		waitForElementVisible(confirmActivateButton, PAUSE_LENGTH.AVG);
		confirmActivateButton.click();
	}

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][1]//option[@value='GlobalConstant']/parent::select")
	private WebElement oneTypeDefineCriteriaConditionSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][2]//option[@value='GlobalConstant']/parent::select")
	private WebElement twoTypeDefineCriteriaConditionSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][2]//option[text()='Select One']/parent::select")
	private WebElement valueTwoDefineCriteriaConditionSelect;

	public void createImportingNotesFromQuickSaveFlow(String name,
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
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Notes To Save");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Notes To Save']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		Select operatorOne = new Select(operatorOneSelect);
		operatorOne.selectByVisibleText("Does not equal");
		Thread.sleep(2000);
		Select typeOne = new Select(oneTypeDefineCriteriaConditionSelect);
		typeOne.selectByVisibleText("Global Constant");
		Thread.sleep(2000);
		Select valueOne = new Select(valueOneSelect);
		valueOne.selectByVisibleText("$GlobalConstant.Null");
		Thread.sleep(2000);
		addConditionRowButton.click();
		Thread.sleep(2000);

		// Second condition
		criteriaTwoField.click();
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Notes To Save");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Notes To Save']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Select operatorTwo = new Select(operatorTwoSelect);
		operatorTwo.selectByVisibleText("Does not equal");
		Thread.sleep(2000);
		Select typeTwo = new Select(twoTypeDefineCriteriaConditionSelect);
		typeTwo.selectByVisibleText("Global Constant");
		Thread.sleep(2000);
		Select valueTwo = new Select(valueTwoDefineCriteriaConditionSelect);
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
		actionType.selectByVisibleText("Apex");
		waitForElementVisible(actionNameField, PAUSE_LENGTH.AVG);
		actionNameField.sendKeys("Import Note");

		apexClassField.sendKeys("tobase__to_process_importQuickSaveNote");
		Thread.sleep(3000);
		driver.findElement(
				By.xpath("//mark[text()='tobase__to_process_importQuickSaveNote']"))
				.click();
		Thread.sleep(2000);
		Select oneTypeSetApexvariables = new Select(
				oneTypeSetApexVariablesSelect);
		oneTypeSetApexvariables.selectByVisibleText("Reference");
		waitForElementVisible(oneValueField, PAUSE_LENGTH.AVG);
		oneValueField.click();
		waitForElementVisible(selectAFieldField, PAUSE_LENGTH.AVG);
		selectAFieldField.sendKeys("Contact ID");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Contact ID')]"))
				.click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		// Second row
		Thread.sleep(2000);
		addParameterRowButton.click();
		waitForElementVisible(twoField, PAUSE_LENGTH.AVG);
		twoField.sendKeys("Note Field");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//span[text()='2 Field']/..//a[contains(text(),'Note Field')]"))
				.click();
		Thread.sleep(2000);
		Select twoTypeSetApexvariables = new Select(
				twoTypeSetApexVariablesSelect);
		twoTypeSetApexvariables.selectByVisibleText("Reference");
		waitForElementVisible(twoValueField, PAUSE_LENGTH.AVG);
		twoValueField.click();
		waitForElementVisible(selectAFieldField, PAUSE_LENGTH.AVG);
		selectAFieldField.sendKeys("Notes To Save");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Notes To Save']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		Thread.sleep(2000);
		saveActionButton.click();

		Thread.sleep(6000);
		activateButton.click();

		waitForElementVisible(confirmActivateButton, PAUSE_LENGTH.AVG);
		confirmActivateButton.click();
	}

	public void createTaskCreationHiringManagerFlow(String name,
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

		// Condition
		criteriaOneField.click();
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("tobase__Hiring_Manager__c");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//span[text()='tobase__Hiring_Manager__c']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		Select operatorOne = new Select(operatorOneSelect);
		operatorOne.selectByVisibleText("Does not equal");
		Thread.sleep(2000);
		Select typeOne = new Select(oneTypeDefineCriteriaConditionSelect);
		typeOne.selectByVisibleText("Global Constant");
		Thread.sleep(2000);
		Select valueOne = new Select(valueOneSelect);
		valueOne.selectByVisibleText("$GlobalConstant.Null");
		Thread.sleep(2000);

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
		actionType.selectByVisibleText("Quick Actions");

		waitForElementVisible(actionNameField, PAUSE_LENGTH.AVG);
		actionNameField.sendKeys("Create Task for Hiring Manager");

		waitForElementVisible(filterSearchBySelect, PAUSE_LENGTH.AVG);
		Select filterSearchBy = new Select(filterSearchBySelect);
		filterSearchBy.selectByVisibleText("Global actions");

		waitForElementVisible(typeFilterSearchBySelect, PAUSE_LENGTH.AVG);
		Select typeFilterSearchBy = new Select(typeFilterSearchBySelect);
		typeFilterSearchBy.selectByVisibleText("Create a Record");

		waitForElementVisible(actionFilterSearchByField, PAUSE_LENGTH.AVG);
		actionFilterSearchByField.sendKeys("NewTask");
		waitForElementVisible(By.xpath("//a[text()='NewTask']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//a[text()='NewTask']")).click();

		Thread.sleep(2000);
		Select oneTypeSetQuickActions = new Select(oneTypeSetQuickActionsSelect);
		oneTypeSetQuickActions.selectByVisibleText("Reference");

		waitForElementVisible(oneValueSetQuickActionsField, PAUSE_LENGTH.AVG);
		oneValueSetQuickActionsField.click();
		waitForElementVisible(selectAFieldField, PAUSE_LENGTH.AVG);
		selectAFieldField.sendKeys("tobase__Hiring_Manager__c");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//div[@class='visible uiAutocompletePanel--default uiAutocompletePanel--lookup uiAutocompletePanel']//span[contains(text(),'tobase__Hiring_Manager__c')]"))
				.click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Thread.sleep(2000);

		// Second Action

		addRowQuickActionParameterListButton.click();
		Thread.sleep(2000);

		twoFieldSetQuickActionsField.sendKeys("Related Record ID");
		waitForElementVisible(By.xpath("//a[text()='Related Record ID']"),
				PAUSE_LENGTH.AVG);
		driver.findElement(By.xpath("//a[text()='Related Record ID']")).click();
		Thread.sleep(2000);
		Select twoTypeSetQuickActions = new Select(twoTypeSetQuickActionsSelect);
		twoTypeSetQuickActions.selectByVisibleText("Reference");

		waitForElementVisible(twoValueSetQuickActionsField, PAUSE_LENGTH.AVG);
		twoValueSetQuickActionsField.click();
		waitForElementVisible(selectAFieldField, PAUSE_LENGTH.AVG);

		selectAFieldField.sendKeys("Record ID");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Record ID')]"))
				.click();

		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Thread.sleep(2000);

		// Third Action

		addRowQuickActionParameterListButton.click();
		Thread.sleep(2000);

		threeFieldSetQuickActionsField.sendKeys("Status");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//div[@class='lookup__menu uiAbstractList uiAutocompleteList uiInput uiAutocomplete uiInput--default uiInput--lookup']//a[text()='Status']"))
				.click();
		Thread.sleep(2000);
		Select threeTypeSetQuickActions = new Select(
				threeTypeSetQuickActionsSelect);
		threeTypeSetQuickActions.selectByVisibleText("Picklist");

		Thread.sleep(2000);
		Select threeValueSetQuickActions = new Select(
				threeValueSetQuickActionsSelect);
		threeValueSetQuickActions.selectByVisibleText("Not Started");

		// Fourth Action
		addRowQuickActionParameterListButton.click();
		Thread.sleep(2000);

		fourFieldSetQuickActionsField.sendKeys("Subject");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//div[@class='lookup__menu uiAbstractList uiAutocompleteList uiInput uiAutocomplete uiInput--default uiInput--lookup']//a[text()='Subject']"))
				.click();
		Thread.sleep(2000);
		Select fourTypeSetQuickActions = new Select(
				fourTypeSetQuickActionsSelect);
		fourTypeSetQuickActions.selectByVisibleText("Formula");

		waitForElementVisible(fourValueSetQuickActionsField, PAUSE_LENGTH.AVG);
		fourValueSetQuickActionsField.click();

		waitForElementVisible(formulaField, PAUSE_LENGTH.AVG);
		formulaField
				.sendKeys("[tobase__Recruiting_Project__c].Name + ' project has been shared with you.'");
		useThisFormulaButton.click();

		Thread.sleep(2000);
		saveActionButton.click();

		Thread.sleep(6000);
		activateButton.click();

		waitForElementVisible(confirmActivateButton, PAUSE_LENGTH.AVG);
		confirmActivateButton.click();
	}

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][1]//option[@value='Boolean']/parent::select")
	private WebElement oneTypeDefineCriteriaBooleanSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][3]//span[text()='Find a field...']")
	private WebElement criteriaThreeField;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][3]//option[@value='String']/parent::select")
	private WebElement typeThreeSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][3]//option[@value='EqualTo']/parent::select")
	private WebElement operatorThreeSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][3]//option[text()='Select One']/parent::select")
	private WebElement valueThreeSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][1]//input")
	private WebElement oneValueStringField;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][2]//input")
	private WebElement twoValueStringField;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonParameterListRow'][3]//label[@class='uiLabel processuicommonInput processuicommonInputText']//input")
	private WebElement threeValueStringField;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][1]//option[@value='true']/parent::select")
	private WebElement valueOneBooleanSelect;

	public void createImportSkillsToContactFlow(String name,
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
		createdEditedOption.click();
		Thread.sleep(2000);
		saveButton.click();
		Thread.sleep(2000);

		waitForElementVisible(addCriteria, PAUSE_LENGTH.AVG);
		addCriteria.click();
		waitForElementVisible(nameCriteriaField, PAUSE_LENGTH.AVG);
		nameCriteriaField.sendKeys(criteriaName);
		conditionsCriteriaType.click();
		Thread.sleep(2000);

		// First Condition
		criteriaOneField.click();
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Skills");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Skills']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		Select operatorOne = new Select(operatorOneSelect);
		operatorOne.selectByVisibleText("Is changed");
		Thread.sleep(2000);
		Select typeOne = new Select(oneTypeDefineCriteriaBooleanSelect);
		typeOne.selectByVisibleText("Boolean");
		Thread.sleep(2000);
		Select valueOne = new Select(valueOneBooleanSelect);
		valueOne.selectByVisibleText("True");
		Thread.sleep(2000);

		// Second condition
		addConditionRowButton.click();
		Thread.sleep(2000);
		criteriaTwoField.click();
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Skills");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Skills']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Select operatorTwo = new Select(operatorTwoSelect);
		operatorTwo.selectByVisibleText("Does not equal");
		Thread.sleep(2000);
		Select typeTwo = new Select(typeTwoSelect);
		typeTwo.selectByVisibleText("Global Constant");
		Thread.sleep(2000);
		Select valueTwo = new Select(valueTwoSelect);
		valueTwo.selectByVisibleText("$GlobalConstant.Null");

		addConditionRowButton.click();
		Thread.sleep(2000);
		criteriaThreeField.click();
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Skills");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Skills']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Select operatorThree = new Select(operatorThreeSelect);
		operatorThree.selectByVisibleText("Does not equal");
		Thread.sleep(2000);
		Select typeThree = new Select(typeThreeSelect);
		typeThree.selectByVisibleText("Global Constant");
		Thread.sleep(2000);
		Select valueThree = new Select(valueThreeSelect);
		valueThree.selectByVisibleText("$GlobalConstant.EmptyString");

		Thread.sleep(2000);
		allConditionsType.click();
		Thread.sleep(2000);
		saveCriteriaButton.click();

		waitForElementVisible(saveCriteriaButton, PAUSE_LENGTH.AVG);
		saveCriteriaButton.click();

		// Time to close exception
		Thread.sleep(8000);

		waitForElementVisible(addActionImmideateOneButton, PAUSE_LENGTH.AVG);
		addActionImmideateOneButton.click();
		waitForElementVisible(actionTypeSelect, PAUSE_LENGTH.AVG);
		Select actionType = new Select(actionTypeSelect);
		actionType.selectByVisibleText("Apex");
		waitForElementVisible(actionNameField, PAUSE_LENGTH.AVG);
		actionNameField.sendKeys("Copy Skills to Contact");
		apexClassField.sendKeys("Import Talent Data to Contact");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//mark[text()='Import Talent Data to Contact']"))
				.click();
		Thread.sleep(2000);
		Select oneTypeSetApexvariables = new Select(
				oneTypeSetApexVariablesSelect);
		oneTypeSetApexvariables.selectByVisibleText("String");
		waitForElementVisible(oneValueStringField, PAUSE_LENGTH.AVG);
		oneValueStringField.sendKeys("Skills__c");

		// Second row
		Thread.sleep(2000);
		Select twoTypeSetApexvariables = new Select(
				twoTypeSetApexVariablesSelect);
		twoTypeSetApexvariables.selectByVisibleText("Reference");
		waitForElementVisible(twoValueField, PAUSE_LENGTH.AVG);
		twoValueField.click();
		waitForElementVisible(selectAFieldField, PAUSE_LENGTH.AVG);
		selectAFieldField.sendKeys("Record ID");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Record ID']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		// Third row
		Thread.sleep(2000);
		addParameterRowButton.click();
		waitForElementVisible(threeField, PAUSE_LENGTH.AVG);
		threeField.sendKeys("Source Field API Name");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//span[text()='3 Field']/..//a[contains(text(),'Source Field API Name')]"))
				.click();
		Thread.sleep(2000);
		Select threeTypeSetApexvariables = new Select(
				threeTypeSetApexVariablesSelect);
		threeTypeSetApexvariables.selectByVisibleText("String");
		waitForElementVisible(threeValueStringField, PAUSE_LENGTH.AVG);
		threeValueStringField.sendKeys("tobase__Skills__c");
		Thread.sleep(2000);
		saveActionButton.click();

		Thread.sleep(6000);
		activateButton.click();

		waitForElementVisible(confirmActivateButton, PAUSE_LENGTH.AVG);
		confirmActivateButton.click();
	}

	public void createImportTargetedRolesToContactFlow(String name,
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
		createdEditedOption.click();
		Thread.sleep(2000);
		saveButton.click();
		Thread.sleep(2000);

		waitForElementVisible(addCriteria, PAUSE_LENGTH.AVG);
		addCriteria.click();
		waitForElementVisible(nameCriteriaField, PAUSE_LENGTH.AVG);
		nameCriteriaField.sendKeys(criteriaName);
		conditionsCriteriaType.click();
		Thread.sleep(2000);

		// First Condition
		criteriaOneField.click();
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Targeted Roles");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Targeted Roles']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		Select operatorOne = new Select(operatorOneSelect);
		operatorOne.selectByVisibleText("Is changed");
		Thread.sleep(2000);
		Select typeOne = new Select(oneTypeDefineCriteriaBooleanSelect);
		typeOne.selectByVisibleText("Boolean");
		Thread.sleep(2000);
		Select valueOne = new Select(valueOneBooleanSelect);
		valueOne.selectByVisibleText("True");
		Thread.sleep(2000);

		// Second condition
		addConditionRowButton.click();
		Thread.sleep(2000);
		criteriaTwoField.click();
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Targeted Roles");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Targeted Roles']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Select operatorTwo = new Select(operatorTwoSelect);
		operatorTwo.selectByVisibleText("Does not equal");
		Thread.sleep(2000);
		Select typeTwo = new Select(typeTwoSelect);
		typeTwo.selectByVisibleText("Global Constant");
		Thread.sleep(2000);
		Select valueTwo = new Select(valueTwoSelect);
		valueTwo.selectByVisibleText("$GlobalConstant.Null");

		addConditionRowButton.click();
		Thread.sleep(2000);
		criteriaThreeField.click();
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Targeted Roles");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Targeted Roles']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Select operatorThree = new Select(operatorThreeSelect);
		operatorThree.selectByVisibleText("Does not equal");
		Thread.sleep(2000);
		Select typeThree = new Select(typeThreeSelect);
		typeThree.selectByVisibleText("Global Constant");
		Thread.sleep(2000);
		Select valueThree = new Select(valueThreeSelect);
		valueThree.selectByVisibleText("$GlobalConstant.EmptyString");

		Thread.sleep(2000);
		allConditionsType.click();
		Thread.sleep(2000);
		saveCriteriaButton.click();

		waitForElementVisible(saveCriteriaButton, PAUSE_LENGTH.AVG);
		saveCriteriaButton.click();

		// Time to close exception
		Thread.sleep(8000);

		waitForElementVisible(addActionImmideateOneButton, PAUSE_LENGTH.AVG);
		addActionImmideateOneButton.click();
		waitForElementVisible(actionTypeSelect, PAUSE_LENGTH.AVG);
		Select actionType = new Select(actionTypeSelect);
		actionType.selectByVisibleText("Apex");
		waitForElementVisible(actionNameField, PAUSE_LENGTH.AVG);
		actionNameField.sendKeys("Import Targeted Role to Contact");
		apexClassField.sendKeys("Import Talent Data to Contact");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//mark[text()='Import Talent Data to Contact']"))
				.click();
		Thread.sleep(2000);
		Select oneTypeSetApexvariables = new Select(
				oneTypeSetApexVariablesSelect);
		oneTypeSetApexvariables.selectByVisibleText("String");
		waitForElementVisible(oneValueStringField, PAUSE_LENGTH.AVG);
		oneValueStringField.sendKeys("Targeted_Roles__c");

		// Second row
		Thread.sleep(2000);
		Select twoTypeSetApexvariables = new Select(
				twoTypeSetApexVariablesSelect);
		twoTypeSetApexvariables.selectByVisibleText("Reference");
		waitForElementVisible(twoValueField, PAUSE_LENGTH.AVG);
		twoValueField.click();
		waitForElementVisible(selectAFieldField, PAUSE_LENGTH.AVG);
		selectAFieldField.sendKeys("Record ID");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Record ID']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		// Third row
		Thread.sleep(2000);
		addParameterRowButton.click();
		waitForElementVisible(threeField, PAUSE_LENGTH.AVG);
		threeField.sendKeys("Source Field API Name");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//span[text()='3 Field']/..//a[contains(text(),'Source Field API Name')]"))
				.click();
		Thread.sleep(2000);
		Select threeTypeSetApexvariables = new Select(
				threeTypeSetApexVariablesSelect);
		threeTypeSetApexvariables.selectByVisibleText("String");
		waitForElementVisible(threeValueStringField, PAUSE_LENGTH.AVG);
		threeValueStringField.sendKeys("tobase__Targeted_Roles__c");
		Thread.sleep(2000);
		saveActionButton.click();

		Thread.sleep(6000);
		activateButton.click();

		waitForElementVisible(confirmActivateButton, PAUSE_LENGTH.AVG);
		confirmActivateButton.click();
	}

	public void createImportEducationHistoryToContactFlow(String name,
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
		createdEditedOption.click();
		Thread.sleep(2000);
		saveButton.click();
		Thread.sleep(2000);

		waitForElementVisible(addCriteria, PAUSE_LENGTH.AVG);
		addCriteria.click();
		waitForElementVisible(nameCriteriaField, PAUSE_LENGTH.AVG);
		nameCriteriaField.sendKeys(criteriaName);
		conditionsCriteriaType.click();
		Thread.sleep(2000);

		// Condition
		criteriaOneField.click();
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("tobase__Talent_Profile__c");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//span[text()='tobase__Talent_Profile__c']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		Select operatorOne = new Select(operatorOneSelect);
		operatorOne.selectByVisibleText("Does not equal");
		Thread.sleep(2000);
		Select typeOne = new Select(oneTypeDefineCriteriaConditionSelect);
		typeOne.selectByVisibleText("Global Constant");
		Thread.sleep(2000);
		Select valueOne = new Select(valueOneSelect);
		valueOne.selectByVisibleText("$GlobalConstant.Null");
		Thread.sleep(2000);

		allConditionsType.click();
		Thread.sleep(2000);
		saveCriteriaButton.click();

		waitForElementVisible(saveCriteriaButton, PAUSE_LENGTH.AVG);
		saveCriteriaButton.click();

		// Time to close exception
		Thread.sleep(8000);

		waitForElementVisible(addActionImmideateOneButton, PAUSE_LENGTH.AVG);
		addActionImmideateOneButton.click();
		waitForElementVisible(actionTypeSelect, PAUSE_LENGTH.AVG);
		Select actionType = new Select(actionTypeSelect);
		actionType.selectByVisibleText("Apex");
		waitForElementVisible(actionNameField, PAUSE_LENGTH.AVG);
		actionNameField.sendKeys("Copy Education History to Contact");
		apexClassField.sendKeys("Import Talent Data to Contact");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//mark[text()='Import Talent Data to Contact']"))
				.click();
		Thread.sleep(2000);
		Select oneTypeSetApexvariables = new Select(
				oneTypeSetApexVariablesSelect);
		oneTypeSetApexvariables.selectByVisibleText("String");
		waitForElementVisible(oneValueStringField, PAUSE_LENGTH.AVG);
		oneValueStringField.sendKeys("Education_History__c");

		// Second row
		Thread.sleep(2000);
		Select twoTypeSetApexvariables = new Select(
				twoTypeSetApexVariablesSelect);
		twoTypeSetApexvariables.selectByVisibleText("Reference");
		waitForElementVisible(twoValueField, PAUSE_LENGTH.AVG);
		twoValueField.click();
		waitForElementVisible(selectAFieldField, PAUSE_LENGTH.AVG);
		selectAFieldField.sendKeys("tobase__Talent_Profile__c");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//span[text()='tobase__Talent_Profile__c']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		// Third row
		Thread.sleep(2000);
		addParameterRowButton.click();
		waitForElementVisible(threeField, PAUSE_LENGTH.AVG);
		threeField.sendKeys("Source Child Record API Name");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//span[text()='3 Field']/..//a[contains(text(),'Source Child Record API Name')]"))
				.click();
		Thread.sleep(2000);
		Select threeTypeSetApexvariables = new Select(
				threeTypeSetApexVariablesSelect);
		threeTypeSetApexvariables.selectByVisibleText("String");
		waitForElementVisible(threeValueStringField, PAUSE_LENGTH.AVG);
		threeValueStringField.sendKeys("tobase__Education_History__c");
		Thread.sleep(2000);
		saveActionButton.click();

		Thread.sleep(6000);
		activateButton.click();

		waitForElementVisible(confirmActivateButton, PAUSE_LENGTH.AVG);
		confirmActivateButton.click();
	}

	public void createEmploymentChangedFlow(String name, String description,
			String objectName, String criteriaName) throws Exception {

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
		Thread.sleep(2000);

		// Condition
		criteriaOneField.click();
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("tobase__Talent_Profile__c");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//span[text()='tobase__Talent_Profile__c']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		Select operatorOne = new Select(operatorOneSelect);
		operatorOne.selectByVisibleText("Does not equal");
		Thread.sleep(2000);
		Select typeOne = new Select(oneTypeDefineCriteriaConditionSelect);
		typeOne.selectByVisibleText("Global Constant");
		Thread.sleep(2000);
		Select valueOne = new Select(valueOneSelect);
		valueOne.selectByVisibleText("$GlobalConstant.Null");
		Thread.sleep(2000);

		allConditionsType.click();
		Thread.sleep(2000);
		saveCriteriaButton.click();

		waitForElementVisible(saveCriteriaButton, PAUSE_LENGTH.AVG);
		saveCriteriaButton.click();

		// Time to close exception
		Thread.sleep(8000);

		waitForElementVisible(addActionImmideateOneButton, PAUSE_LENGTH.AVG);
		addActionImmideateOneButton.click();
		waitForElementVisible(actionTypeSelect, PAUSE_LENGTH.AVG);
		Select actionType = new Select(actionTypeSelect);
		actionType.selectByVisibleText("Apex");
		waitForElementVisible(actionNameField, PAUSE_LENGTH.AVG);
		actionNameField.sendKeys("Employment Changed");
		apexClassField.sendKeys("Import Talent Data to Contact");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//mark[text()='Import Talent Data to Contact']"))
				.click();
		Thread.sleep(2000);
		Select oneTypeSetApexvariables = new Select(
				oneTypeSetApexVariablesSelect);
		oneTypeSetApexvariables.selectByVisibleText("String");
		waitForElementVisible(oneValueStringField, PAUSE_LENGTH.AVG);
		oneValueStringField.sendKeys("Employment_History__c");

		// Second row
		Thread.sleep(2000);
		Select twoTypeSetApexvariables = new Select(
				twoTypeSetApexVariablesSelect);
		twoTypeSetApexvariables.selectByVisibleText("Reference");
		waitForElementVisible(twoValueField, PAUSE_LENGTH.AVG);
		twoValueField.click();
		waitForElementVisible(selectAFieldField, PAUSE_LENGTH.AVG);
		selectAFieldField.sendKeys("tobase__Talent_Profile__c");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//span[text()='tobase__Talent_Profile__c']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		// Third row
		Thread.sleep(2000);
		addParameterRowButton.click();
		waitForElementVisible(threeField, PAUSE_LENGTH.AVG);
		threeField.sendKeys("Source Child Record API Name");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//span[text()='3 Field']/..//a[contains(text(),'Source Child Record API Name')]"))
				.click();
		Thread.sleep(2000);
		Select threeTypeSetApexvariables = new Select(
				threeTypeSetApexVariablesSelect);
		threeTypeSetApexvariables.selectByVisibleText("String");
		waitForElementVisible(threeValueStringField, PAUSE_LENGTH.AVG);
		threeValueStringField.sendKeys("tobase__Employment_History__c");
		Thread.sleep(2000);
		saveActionButton.click();

		Thread.sleep(6000);
		activateButton.click();

		waitForElementVisible(confirmActivateButton, PAUSE_LENGTH.AVG);
		confirmActivateButton.click();
	}

	public void createImportHeadlineFromTalentProfileToContactFlow(String name,
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
		createdEditedOption.click();
		Thread.sleep(2000);
		saveButton.click();
		Thread.sleep(2000);

		waitForElementVisible(addCriteria, PAUSE_LENGTH.AVG);
		addCriteria.click();
		waitForElementVisible(nameCriteriaField, PAUSE_LENGTH.AVG);
		nameCriteriaField.sendKeys(criteriaName);
		conditionsCriteriaType.click();
		Thread.sleep(2000);

		// First Condition
		criteriaOneField.click();
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Headline");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Headline']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		Select operatorOne = new Select(operatorOneSelect);
		operatorOne.selectByVisibleText("Is changed");
		Thread.sleep(2000);
		Select typeOne = new Select(oneTypeDefineCriteriaBooleanSelect);
		typeOne.selectByVisibleText("Boolean");
		Thread.sleep(2000);
		Select valueOne = new Select(valueOneBooleanSelect);
		valueOne.selectByVisibleText("True");
		Thread.sleep(2000);

		// Second condition
		addConditionRowButton.click();
		Thread.sleep(2000);
		criteriaTwoField.click();
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Headline");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Headline']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Select operatorTwo = new Select(operatorTwoSelect);
		operatorTwo.selectByVisibleText("Does not equal");
		Thread.sleep(2000);
		Select typeTwo = new Select(typeTwoSelect);
		typeTwo.selectByVisibleText("Global Constant");
		Thread.sleep(2000);
		Select valueTwo = new Select(valueTwoSelect);
		valueTwo.selectByVisibleText("$GlobalConstant.Null");

		addConditionRowButton.click();
		Thread.sleep(2000);
		criteriaThreeField.click();
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Headline");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Headline']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Select operatorThree = new Select(operatorThreeSelect);
		operatorThree.selectByVisibleText("Does not equal");
		Thread.sleep(2000);
		Select typeThree = new Select(typeThreeSelect);
		typeThree.selectByVisibleText("Global Constant");
		Thread.sleep(2000);
		Select valueThree = new Select(valueThreeSelect);
		valueThree.selectByVisibleText("$GlobalConstant.EmptyString");

		Thread.sleep(2000);
		allConditionsType.click();
		Thread.sleep(2000);
		saveCriteriaButton.click();

		waitForElementVisible(saveCriteriaButton, PAUSE_LENGTH.AVG);
		saveCriteriaButton.click();

		// Time to close exception
		Thread.sleep(8000);

		waitForElementVisible(addActionImmideateOneButton, PAUSE_LENGTH.AVG);
		addActionImmideateOneButton.click();
		waitForElementVisible(actionTypeSelect, PAUSE_LENGTH.AVG);
		Select actionType = new Select(actionTypeSelect);
		actionType.selectByVisibleText("Apex");
		waitForElementVisible(actionNameField, PAUSE_LENGTH.AVG);
		actionNameField.sendKeys("Copy Headline to Object");
		apexClassField.sendKeys("Import Talent Data to Contact");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//mark[text()='Import Talent Data to Contact']"))
				.click();
		Thread.sleep(2000);
		Select oneTypeSetApexvariables = new Select(
				oneTypeSetApexVariablesSelect);
		oneTypeSetApexvariables.selectByVisibleText("String");
		waitForElementVisible(oneValueStringField, PAUSE_LENGTH.AVG);
		oneValueStringField.sendKeys("Headline__c");

		// Second row
		Thread.sleep(2000);
		Select twoTypeSetApexvariables = new Select(
				twoTypeSetApexVariablesSelect);
		twoTypeSetApexvariables.selectByVisibleText("Reference");
		waitForElementVisible(twoValueField, PAUSE_LENGTH.AVG);
		twoValueField.click();
		waitForElementVisible(selectAFieldField, PAUSE_LENGTH.AVG);
		selectAFieldField.sendKeys("Record ID");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Record ID']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		// Third row
		Thread.sleep(2000);
		addParameterRowButton.click();
		waitForElementVisible(threeField, PAUSE_LENGTH.AVG);
		threeField.sendKeys("Source Field API Name");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//span[text()='3 Field']/..//a[contains(text(),'Source Field API Name')]"))
				.click();
		Thread.sleep(2000);
		Select threeTypeSetApexvariables = new Select(
				threeTypeSetApexVariablesSelect);
		threeTypeSetApexvariables.selectByVisibleText("String");
		waitForElementVisible(threeValueStringField, PAUSE_LENGTH.AVG);
		threeValueStringField.sendKeys("tobase__Headline__c");
		Thread.sleep(2000);
		saveActionButton.click();

		Thread.sleep(6000);
		activateButton.click();

		waitForElementVisible(confirmActivateButton, PAUSE_LENGTH.AVG);
		confirmActivateButton.click();
	}

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][3]//option[@value='true']/parent::select")
	private WebElement threeValueBooleanSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][3]//option[@value='Boolean']/parent::select")
	private WebElement threeTypeDefineCriteriaBooleanSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][4]//option[@value='true']/parent::select")
	private WebElement fourValueBooleanSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][4]//option[@value='Boolean']/parent::select")
	private WebElement fourTypeDefineCriteriaBooleanSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][4]//option[@value='EqualTo']/parent::select")
	private WebElement operatorFourSelect;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][4]//option[text()='Select One']/parent::select")
	private WebElement valueFourSelect;

	@FindBy(xpath = "//span[text() = 'Customize the logic']")
	private WebElement customizeTheLogic;

	@FindBy(xpath = "//label[@class='conditionLogic notParameter uiLabel processuicommonInput processuicommonInputText']//input")
	private WebElement logicField;

	@FindBy(xpath = "//tr[@class='processuicommonItemListRow processuicommonConditionListRow'][4]//span[text()='Find a field...']")
	private WebElement criteriaFourField;

	@FindBy(xpath = "//div[@class='body processuicommonItemList processuicommonParameterList processuicommonApexParameterList']//span[text()='Add Row']")
	private WebElement firstApexAddRow;

	@FindBy(xpath = "//span[text()='1 Field']/..//input")
	private WebElement oneField;

	public void createCopyingApplicationDataToTalentProfileFlow(String name,
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
		createdEditedOption.click();
		Thread.sleep(2000);
		saveButton.click();
		Thread.sleep(2000);

		waitForElementVisible(addCriteria, PAUSE_LENGTH.AVG);
		addCriteria.click();
		waitForElementVisible(nameCriteriaField, PAUSE_LENGTH.AVG);
		nameCriteriaField.sendKeys(criteriaName);
		conditionsCriteriaType.click();
		Thread.sleep(2000);

		// First Condition
		criteriaOneField.click();
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Stage");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Stage']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		Select operatorOne = new Select(operatorOneSelect);
		operatorOne.selectByVisibleText("Equals");
		Thread.sleep(2000);
		Select typeOne = new Select(oneTypeDefineCriteriaSelect);
		typeOne.selectByVisibleText("Picklist");
		Thread.sleep(2000);
		Select valueOne = new Select(valueOneSelect);
		valueOne.selectByVisibleText("Application");
		Thread.sleep(2000);

		// Second condition
		addConditionRowButton.click();
		Thread.sleep(2000);
		criteriaTwoField.click();
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Status");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Status']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Select operatorTwo = new Select(operatorTwoSelect);
		operatorTwo.selectByVisibleText("Equals");
		Thread.sleep(2000);
		Select typeTwo = new Select(twoTypeDefineCriteriaConditionSelect);
		typeTwo.selectByVisibleText("Picklist");
		Thread.sleep(2000);
		Select valueTwo = new Select(valueTwoSelect);
		valueTwo.selectByVisibleText("Completed");

		// Third condition
		Thread.sleep(2000);
		addConditionRowButton.click();
		Thread.sleep(2000);
		criteriaThreeField.click();
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Stage");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Stage']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Select operatorThree = new Select(operatorThreeSelect);
		operatorThree.selectByVisibleText("Is changed");
		Thread.sleep(2000);
		Select typeThree = new Select(threeTypeDefineCriteriaBooleanSelect);
		typeThree.selectByVisibleText("Boolean");
		Thread.sleep(2000);
		Select valueThree = new Select(threeValueBooleanSelect);
		valueThree.selectByVisibleText("True");

		// Fourth condition
		Thread.sleep(2000);
		addConditionRowButton.click();
		Thread.sleep(2000);
		criteriaFourField.click();
		waitForElementVisible(inputContainerField, PAUSE_LENGTH.AVG);
		inputContainerField.sendKeys("Status");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Status']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();
		Select operatorFour = new Select(operatorFourSelect);
		operatorFour.selectByVisibleText("Is changed");
		Thread.sleep(2000);
		Select typeFour = new Select(fourTypeDefineCriteriaBooleanSelect);
		typeFour.selectByVisibleText("Boolean");
		Thread.sleep(2000);
		Select valueFour = new Select(fourValueBooleanSelect);
		valueFour.selectByVisibleText("True");
		Thread.sleep(2000);

		customizeTheLogic.click();
		Thread.sleep(2000);
		logicField.sendKeys("(1 AND 2) AND (3 OR 4)");
		saveCriteriaButton.click();

		waitForElementVisible(saveCriteriaButton, PAUSE_LENGTH.AVG);
		saveCriteriaButton.click();

		// Time to close exception
		Thread.sleep(8000);

		waitForElementVisible(addActionImmideateOneButton, PAUSE_LENGTH.AVG);
		addActionImmideateOneButton.click();
		waitForElementVisible(actionTypeSelect, PAUSE_LENGTH.AVG);
		Select actionType = new Select(actionTypeSelect);
		actionType.selectByVisibleText("Apex");
		waitForElementVisible(actionNameField, PAUSE_LENGTH.AVG);
		actionNameField.sendKeys("Copy Application Data to Talent Profile");
		apexClassField.sendKeys("tobase__to_process_populateTPFromApp");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//mark[text()='tobase__to_process_populateTPFromApp']"))
				.click();
		Thread.sleep(2000);
		firstApexAddRow.click();
		Thread.sleep(2000);
		waitForElementVisible(oneField, PAUSE_LENGTH.AVG);
		oneField.sendKeys("appIds");
		Thread.sleep(2000);
		driver.findElement(
				By.xpath("//span[text()='1 Field']/..//a[contains(text(),'appIds')]"))
				.click();
		Thread.sleep(2000);
		Select oneTypeSetApexvariables = new Select(
				oneTypeSetApexVariablesSelect);
		oneTypeSetApexvariables.selectByVisibleText("Reference");
		waitForElementVisible(oneValueField, PAUSE_LENGTH.AVG);
		oneValueField.click();
		waitForElementVisible(selectAFieldField, PAUSE_LENGTH.AVG);
		selectAFieldField.sendKeys("Record ID");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Record ID']")).click();
		waitForElementVisible(chooseButton, PAUSE_LENGTH.AVG);
		chooseButton.click();

		Thread.sleep(2000);
		saveActionButton.click();

		Thread.sleep(6000);
		activateButton.click();

		waitForElementVisible(confirmActivateButton, PAUSE_LENGTH.AVG);
		confirmActivateButton.click();
	}

}
