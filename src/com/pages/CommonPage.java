package com.pages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.constans.PAUSE_LENGTH;

public class CommonPage extends AbstractPage {

	public CommonPage(WebDriver driver) throws Exception {
		super(driver);
	}

	@FindBy(id = "p3")
	private WebElement recordTypeSelect;

	@FindBy(name = "task")
	private WebElement newTaskButton;

	@FindBy(xpath = "//label[text()='Дата контакта']/../following-sibling::td[1]//a")
	private WebElement currentDateLink;

	@FindBy(xpath = "//label[text()='Очередь']/../following-sibling::td[1]//select")
	private WebElement lineSelect;

	@FindBy(xpath = "//label[text()='Comments']/../following-sibling::td[1]//textarea")
	private WebElement commentsField;

	@FindBy(xpath = "//label[text()='Дата контакта']/../following-sibling::td[1]//input")
	private WebElement contactDateField;

	@FindBy(xpath = "//label[text()='Указать точное время']/../following-sibling::td[1]//input")
	private WebElement exactTimeCheckbox;

	@FindBy(xpath = "//label[text()='Priority']/../following-sibling::td[1]//select")
	private WebElement prioritySelect;

	public void createTaskConsole(String lastName, String section,
			String recordType, String date, boolean exactTime, String priority)
			throws Exception {
		log.info("Create Task " + lastName);

		findItem(lastName, section, newTaskButton, 10);

		Thread.sleep(3000);
		waitForElementVisible(newTaskButton, PAUSE_LENGTH.AVG);
		newTaskButton.click();
		log.info("Clicked on New Task");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();

		switchToFrame(recordTypeSelect);

		Select recordTypeSel = new Select(recordTypeSelect);
		recordTypeSel.selectByVisibleText(recordType);

		waitForElementVisible(continueButton, PAUSE_LENGTH.AVG);
		continueButton.click();
		log.info("Clicked on Continue");
		driver.switchTo().defaultContent();

		Thread.sleep(2000);
		switchToFrame(contactDateField);

		contactDateField.sendKeys(date);

		if (exactTime) {
			exactTimeCheckbox.click();
			log.info("Checked Exact Time");
		}

		Select lineSel = new Select(lineSelect);
		lineSel.selectByVisibleText("ИФЛ");

		// Select prioritySel = new Select(prioritySelect);
		// prioritySel.selectByVisibleText(priority);

		commentsField.clear();
		commentsField.sendKeys("Auto Test");

		saveButton.click();
		log.info("Clicked on Save");
		Thread.sleep(5000);

		waitForElementVisible(By.xpath("//h1[contains(text(), 'Task')]"),
				PAUSE_LENGTH.AVG);
		log.info("Create Task " + lastName + " - Done");

		if (priority != "Высокий") {
			try {
				editTask(priority);
			} catch (Exception e) {
				log.error(e.getMessage());
				editTask(priority);
			}
		}

		driver.switchTo().defaultContent();
	}

	public void createTask(String lastName, String section, String recordType,
			String date, boolean exactTime, String priority) throws Exception {
		log.info("Creating Task " + lastName + "...");

		findItem(lastName, section, newTaskButton, 10);

		for (int attempt = 1; attempt <= 5; attempt++) {
			try {
				waitForElementVisible(newTaskButton, PAUSE_LENGTH.AVG);
				newTaskButton.click();
				log.info("Clicked on New Task");
				waitForElementVisible(recordTypeSelect, PAUSE_LENGTH.AVG);
				break;
			} catch (Exception e) {
				if (attempt < 5)
					log.info("Trying to create task for " + (attempt + 1)
							+ " time");
			}
		}

		Select recordTypeSel = new Select(recordTypeSelect);
		recordTypeSel.selectByVisibleText(recordType);

		waitForElementVisible(continueButton, PAUSE_LENGTH.AVG);
		continueButton.click();
		log.info("Clicked on Continue");

		contactDateField.sendKeys(date);

		if (exactTime) {
			exactTimeCheckbox.click();
			log.info("Checked Exact Time");
		}

		Select lineSel = new Select(lineSelect);
		lineSel.selectByVisibleText("ИФЛ");

		commentsField.clear();
		commentsField.sendKeys("Auto Test");

		saveButton.click();
		log.info("Clicked on Save");
		Thread.sleep(3000);

		try {
			waitForElementVisible(
					By.xpath("//div[contains(@class,'taskBlock')]"
							+ "//a[text()='Консультация']"), PAUSE_LENGTH.AVG);
		} catch (Exception e) {
			log.error(e.getMessage());
			driver.navigate().refresh();
			waitForElementVisible(
					By.xpath("//div[contains(@class,'taskBlock')]"
							+ "//a[text()='Консультация']"), PAUSE_LENGTH.AVG);
		}
		log.info("Create Task " + lastName + " - Done");

		if (priority != "Высокий") {
			try {
				editTask(priority);
			} catch (Exception e) {
				log.error(e.getMessage());
				editTask(priority);
			}
		}
		log.info("Create Task " + lastName + " - Done");
	}

	@FindBy(xpath = "//div[contains(@class,'taskBlock')]//a[text()='Edit']")
	private WebElement editButton;

	public void editTask(String priority) throws Exception {
		log.info("Editing Task...");

		waitForElementVisible(editButton, PAUSE_LENGTH.AVG);
		editButton.click();

		waitForElementVisible(prioritySelect, PAUSE_LENGTH.AVG);
		Select prioritySel = new Select(prioritySelect);
		prioritySel.selectByVisibleText(priority);

		saveButton.click();
		log.info("Clicked on Save");
		Thread.sleep(3000);

		waitForElementVisible(By.xpath("//div[contains(@class,'taskBlock')]"
				+ "//a[text()='Консультация']"), PAUSE_LENGTH.AVG);

		log.info("Edit Task - Done");
	}

	public boolean verifyTask(String firstName, String lastName, String section)
			throws Exception {
		log.info("Verifying Task " + lastName + "...");

		findItem(lastName, section, delButton, 10);
		waitForElementVisible(newTaskButton, PAUSE_LENGTH.AVG);
		WebElement taskRecord = driver.findElement(By
				.xpath("//div[contains(@class,'taskBlock')]"
						+ "//a[text()='Консультация']"));
		boolean result = taskRecord.isDisplayed();
		log.info("Verify Task " + lastName + " - Done");
		return result;
	}

	public String[] getDateOfContact() {
		String dateOfContact[] = new String[2];
		Calendar calendar = Calendar.getInstance();
		Date today = Calendar.getInstance().getTime();
		calendar.setTime(today);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		log.info("День недели " + dayOfWeek);
		switch (dayOfWeek) {
		case 5: {
			if (hour < 14) {
				dateOfContact[0] = String.valueOf(dayOfWeek + 1);
				dateOfContact[1] = "15:00";
			} else {
				dateOfContact[0] = String.valueOf(dayOfWeek + 2);
				dateOfContact[1] = "10:00";
			}
			break;
		}
		case 6: {
			if (hour < 14) {
				dateOfContact[0] = String.valueOf(dayOfWeek + 1);
				dateOfContact[1] = "15:00";
			} else {
				dateOfContact[0] = String.valueOf(dayOfWeek + 2);
				dateOfContact[1] = "10:00";
			}
			break;
		}
		case 7: {
			if (hour < 14) {
				dateOfContact[0] = "1";
				dateOfContact[1] = "15:00";
			} else {
				dateOfContact[0] = "2";
				dateOfContact[1] = "9:00";
			}
			break;
		}
		default: {
			if (hour < 14) {
				dateOfContact[0] = String.valueOf(dayOfWeek + 1);
				dateOfContact[1] = "15:00";
			} else {
				dateOfContact[0] = String.valueOf(dayOfWeek + 2);
				dateOfContact[1] = "9:00";
			}
			break;
		}
		}
		log.info(dateOfContact[0] + " " + dateOfContact[1]);
		return dateOfContact;
	}

	public Calendar calendar = Calendar.getInstance();
	DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");

	private String changeDateByDays(int daysOffset, String dateNow)
			throws ParseException {
		calendar.add(Calendar.DATE, daysOffset);
		return dateFormat.format(calendar.getTime());
	}

	public String getDateOfContactOld(String dateNow) throws ParseException {
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+3"));
		calendar.setTime(dateFormat.parse(dateNow));
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int hour = Integer.parseInt(dateNow.substring(11, 13));
		log.info("День недели " + dayOfWeek);
		log.info("Час сейчас  " + hour);
		String result = null;
		switch (dayOfWeek) {
		case 5: {
			if (hour < 14) {
				result = changeDateByDays(1, dateNow);
				result = result.substring(0, 11) + "15:00";
			} else {
				result = changeDateByDays(2, dateNow);
				result = result.substring(0, 11) + "10:00";
			}
			break;
		}
		case 6: {
			if (hour < 14) {
				result = changeDateByDays(1, dateNow);
				result = result.substring(0, 11) + "15:00";
			} else {
				result = changeDateByDays(2, dateNow);
				result = result.substring(0, 11) + "10:00";
			}
			break;
		}
		default: {
			if (hour < 14) {
				result = changeDateByDays(1, dateNow);
				result = result.substring(0, 11) + "15:00";
			} else {
				result = changeDateByDays(2, dateNow);
				result = result.substring(0, 11) + "09:00";
				break;
			}
		}
		}
		log.info(result);
		return result;
	}

	public String getDateOfContact(String dateNow) throws ParseException {
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+3"));
		calendar.setTime(dateFormat.parse(dateNow));
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		int hour = Integer.parseInt(dateNow.substring(11, 13));
		log.info("День недели " + dayOfWeek);
		log.info("Час сейчас  " + hour);
		String result = null;
		switch (dayOfWeek) {
		case 6: {
			if (hour < 14) {
				result = changeDateByDays(0, dateNow);
				result = result.substring(0, 11) + "15:00";
			} else {
				result = changeDateByDays(1, dateNow);
				result = result.substring(0, 11) + "10:00";
			}
			break;
		}
		case 7: {
			if (hour < 14) {
				result = changeDateByDays(0, dateNow);
				result = result.substring(0, 11) + "15:00";
			} else {
				result = changeDateByDays(1, dateNow);
				result = result.substring(0, 11) + "10:00";
			}
			break;
		}
		default: {
			if (hour < 14) {
				result = changeDateByDays(0, dateNow);
				result = result.substring(0, 11) + "15:00";
			} else {
				result = changeDateByDays(1, dateNow);
				result = result.substring(0, 11) + "9:00";
				break;
			}
		}
		}
		log.info(result);
		return result;
	}

	@FindBy(xpath = "//span[text()='Мне повезет!']/ancestor::button")
	private WebElement willGetLuckyButton;

	@FindBy(xpath = "//td[@id='topButtonRow']/input[@name='complete']")
	private WebElement completeButton;

	@FindBy(xpath = "//td[text()='Name']/following-sibling::td[1]//a")
	private WebElement namelabel;

	@FindBy(id = "TCR")
	private WebElement reasonSelect;

	@FindBy(xpath = "//span[text()='Сохранить']")
	private WebElement saveReasonButton;

	public void chooseTask(String firstName, String lastName) throws Exception {
		log.info("Choosing task...");

		for (int i = 1; i <= 8; i++) {
			driver.switchTo().defaultContent();
			closeAllTabs();
			waitForElementVisible(willGetLuckyButton, PAUSE_LENGTH.AVG);
			willGetLuckyButton.click();
			log.info("Clicked on \"Will Get Lucky\"");
			Thread.sleep(5000);

			try {
				switchToFrame(completeButton);
			} catch (Exception e) {
				log.error(e.getMessage());
				Thread.sleep(5000);
				switchToFrame(completeButton);
			}

			String actualName = namelabel.getText();
			log.info("Actual name: " + actualName);
			if (actualName.contains(lastName)) {
				Assert.assertEquals(actualName, firstName + "_" + i + " "
						+ lastName + "_" + i);
			} else {
				log.info("Wrong user in queue. Completing...");
				i--;
			}

			completeButton.click();

			Select reasonSel = new Select(reasonSelect);
			reasonSel.selectByVisibleText("Успешно");
			saveReasonButton.click();
			log.info("Clicked on Save");
			Thread.sleep(3000);
		}
		log.info("Choosing task - Done");
	}

	@FindBy(xpath = "//input[@value='Перезвонить']")
	private WebElement callBackButton;

	@FindBy(xpath = "//div[@class='listRelatedObject taskBlock']//a[text()='Консультация']")
	private WebElement taskLink;

	@FindBy(xpath = "//option[@value='Недозвон']/ancestor::select")
	private WebElement resultSelect;

	@FindBy(xpath = "//input[@value='OK']")
	private WebElement okButton;

	@FindBy(xpath = "//td[text()='Дата контакта']/..//td[2]/div")
	private WebElement contactDateLabel;

	@FindBy(xpath = "//td[text()='Очередь']/..//td[2]/div")
	private WebElement queueLabel;

	@FindBy(xpath = "//td[text()='Priority']/..//td[2]/div")
	private WebElement priorityLabel;

	@FindBy(xpath = "//td[text()='Status']/..//td[2]/div")
	private WebElement statusLabel;

	public void callBack(String lastName, String section, String result)
			throws Exception {
		log.info("Calling back...");
		driver.switchTo().defaultContent();

		findItemInConsole(lastName, section, deleteButton, 10);

		waitForElementVisible(taskLink, PAUSE_LENGTH.AVG);
		taskLink.click();
		log.info("Clicked on Task Link");
		driver.switchTo().defaultContent();

		switchToFrame(callBackButton);

		waitForElementVisible(callBackButton, PAUSE_LENGTH.AVG);
		callBackButton.click();
		log.info("Clicked on Call Back");
		Thread.sleep(3000);

		driver.switchTo().frame(driver.findElement(By.id("iframeContentId")));

		Select resultSel = new Select(resultSelect);
		resultSel.selectByVisibleText(result);

		okButton.click();
		log.info("Clicked on OK");
		Thread.sleep(5000);

		driver.switchTo().defaultContent();

		log.info("Call back - Done");
	}

	public String[] getTaskInfo(String lastName, String section)
			throws Exception {
		log.info("Get task info...");
		String result[] = new String[4];
		findItemInConsole(lastName, section, deleteButton, 10);

		waitForElementVisible(taskLink, PAUSE_LENGTH.AVG);
		taskLink.click();
		log.info("Clicked on Task Link");
		driver.switchTo().defaultContent();
		Thread.sleep(3000);
		switchToFrame(callBackButton);

		waitForElementVisible(callBackButton, PAUSE_LENGTH.AVG);
		result[0] = contactDateLabel.getText();
		result[1] = queueLabel.getText();
		result[2] = priorityLabel.getText();
		result[3] = statusLabel.getText();
		for (int i = 0; i < result.length; i++) {
			log.info(result[i]);
		}
		log.info("Get task info - Done");
		return result;
	}
}