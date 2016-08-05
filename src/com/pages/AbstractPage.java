package com.pages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.constans.PAUSE_LENGTH;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class AbstractPage {

	@FindBy(css = "input[name = 'go']")
	protected WebElement goButton;

	@FindBy(name = "save")
	protected WebElement saveButton;

	@FindBy(name = "edit")
	protected WebElement editButton;

	@FindBy(css = "img[class = allTabsArrow]")
	protected WebElement allTabsButton;

	@FindBy(id = "setupLink")
	protected WebElement setupLink;

	@FindBy(xpath = "//div[@id='tsidButton']")
	protected WebElement appSelector;

	@FindBy(xpath = "//em[@class='x-btn-split']")
	protected WebElement sectionDropdown;

	@FindBy(xpath = "//span[text()='Page']")
	protected WebElement pageLabel;

	@FindBy(xpath = "//td[@id='bottomButtonRow']//input[@name='del']")
	protected WebElement delButton;

	@FindBy(css = "input[title = 'New']")
	protected WebElement newButton;

	@FindBy(xpath = "//td[@id='bottomButtonRow']//input[@name='delete']")
	protected WebElement deleteButton;

	@FindBy(xpath = "//input[@title='Continue']")
	protected WebElement continueButton;

	/**
	 * Definition of logger
	 */
	protected final Log log = LogFactory.getLog(getClass());

	protected WebDriver driver;

	public int defaultTimeout = 30;
	public int defaultSleep;
	public String hostname;
	public String port;
	public String baseURL;
	public String logURL;
	public String login;
	public String password;

	public AbstractPage(WebDriver driver) throws Exception {
		log.debug("Created page abstraction for " + getClass().getName());
		this.driver = driver;
		Properties properties = new Properties();
		InputStream orgProperties = new FileInputStream(
				"properties/config.properties");
		properties.load(orgProperties);
		baseURL = properties.getProperty("baseURL");
		logURL = properties.getProperty("logURL");
		login = properties.getProperty("login");
		password = properties.getProperty("password");
		orgProperties.close();
	}

	/**
	 * Method asserts element on the page
	 * 
	 * @param by
	 *            - By, web element locator
	 * @return - boolean, true if element is present
	 */
	protected boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Method asserts element on the page
	 * 
	 * @param pElement
	 *            - WebElement, element
	 * @return - boolean, true if element is present
	 */
	protected boolean isElementPresent(WebElement pElement) {
		try {
			pElement.isDisplayed();
			return true;
		} catch (Throwable e) {
			log.info("Element with locator: " + pElement + " wasn't found");
			return false;
		}
	}

	/**
	 * Method waits for element to be visible
	 * 
	 * @param by
	 *            - By, element locator
	 * @param time
	 *            - PAUSE_LENGTH, timeout
	 */
	public void waitForElementVisible(By by, PAUSE_LENGTH time) {
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() < start + time.value()) {
			if (driver.findElement(by).isDisplayed()) {
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				log.error(e.getMessage());
				throw new AssertionError(e);
			}
		}
		throw new ElementNotVisibleException("---------- The element " + by
				+ " still isn't visible");
	}

	/**
	 * Method waits for element to be visible
	 * 
	 * @param pWebElement
	 *            - WebElement, element locator
	 * @param time
	 *            - PAUSE_LENGTH, timeout
	 */
	public void waitForElementVisible(WebElement pWebElement, PAUSE_LENGTH time) {
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() < start + time.value()) {
			if (pWebElement.isDisplayed()) {
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				log.error(e.getMessage());
				throw new AssertionError(e);
			}
		}
		throw new ElementNotVisibleException("---------- WebElement "
				+ pWebElement + " still isn't visible");
	}

	/**
	 * Method waits for element to be not present
	 * 
	 * @param by
	 *            - By, locator of Element to wait for
	 * @param time
	 *            - PAUSE_LENGTH, timeout
	 */

	public void waitForElementNotPresent(By by, PAUSE_LENGTH time) {
		log.info("Wait for element with locator: " + by + " to be not present");
		driver.manage().timeouts()
				.implicitlyWait(time.value(), TimeUnit.MILLISECONDS);
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() < start + time.value()) {
			if (!isElementPresent(by)) {
				driver.manage().timeouts()
						.implicitlyWait(defaultTimeout, TimeUnit.SECONDS);
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				log.error(e.getMessage());
				throw new AssertionError(e);
			}
		}
		throw new ElementNotFoundException("The element with locator ",
				by.toString(), " is still present.");
	}

	/**
	 * Method waits for element to be not present
	 * 
	 * @param pWebElement
	 *            - WebElement, Element to wait for
	 * @param time
	 *            - PAUSE_LENGTH, timeout
	 */

	public void waitForElementNotPresent(WebElement pWebElement,
			PAUSE_LENGTH time) {
		log.info("Wait for element with locator: " + pWebElement
				+ " to be not present");
		driver.manage().timeouts()
				.implicitlyWait(time.value(), TimeUnit.MILLISECONDS);
		long start = System.currentTimeMillis();
		while (System.currentTimeMillis() < start + time.value()) {
			if (!isElementPresent(pWebElement)) {
				driver.manage().timeouts()
						.implicitlyWait(defaultTimeout, TimeUnit.SECONDS);
				return;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				log.error(e.getMessage());
				throw new AssertionError(e);
			}
		}
		throw new ElementNotFoundException("The element with locator ",
				pWebElement.toString(), " is still present.");
	}

	/**
	 * Method waits for element to be not visible
	 * 
	 * @param by
	 *            - By, element locator
	 * @param time
	 *            - PAUSE_LENGTH, timeout
	 */
	public void waitForElementNotVisible(By by, PAUSE_LENGTH time) {
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		long start = System.currentTimeMillis();
		String exceptionType = "NotVisible";
		while (System.currentTimeMillis() < start + time.value()) {
			try {
				if (isElementPresent(by)) {
					if (!driver.findElement(by).isDisplayed()) {
						driver.manage()
								.timeouts()
								.implicitlyWait(defaultTimeout,
										TimeUnit.SECONDS);
						return;
					}
				}
			} catch (NoSuchElementException e1) {
				exceptionType = "NotFound";
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				log.error(e.getMessage());
				throw new AssertionError(e);
			}
		}
		driver.manage().timeouts()
				.implicitlyWait(defaultTimeout, TimeUnit.SECONDS);
		if (exceptionType.equals("NotFound")) {
			throw new ElementNotFoundException("The element with locator " + by
					+ " was not found", null, null);
		} else {
			throw new ElementNotVisibleException(
					"---------- The element with locator " + by
							+ " is still visible");
		}
	}

	/**
	 * Method waits for element to be not visible
	 * 
	 * @param pWebElement
	 *            - WebElement, element locator
	 * @param time
	 *            - PAUSE_LENGTH, timeout
	 */
	public void waitForElementNotVisible(WebElement pWebElement,
			PAUSE_LENGTH time) {
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		long start = System.currentTimeMillis();
		String exceptionType = "NotVisible";
		while (System.currentTimeMillis() < start + time.value()) {
			try {
				if (isElementPresent(pWebElement)) {
					if (pWebElement.isDisplayed()) {
						driver.manage()
								.timeouts()
								.implicitlyWait(defaultTimeout,
										TimeUnit.SECONDS);
						return;
					}
				}
			} catch (NoSuchElementException e1) {
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				log.error(e.getMessage());
				throw new AssertionError(e);
			}
		}
		driver.manage().timeouts()
				.implicitlyWait(defaultTimeout, TimeUnit.SECONDS);
		if (exceptionType.equals("NotFound")) {
			throw new ElementNotFoundException("The element with locator "
					+ pWebElement + " was not found", null, null);
		} else {
			throw new ElementNotVisibleException("The element with locator "
					+ pWebElement + " is still visible");
		}
	}

	public void timeout(int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	/**
	 * Method for taking screenshots
	 * 
	 * @param date
	 *            - String, class name
	 * @throws Throwable
	 */
	public void captureScreenshot(String date) throws Throwable {
		File screenshot = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		String path = "reports/screenshots/screenshot" + date + ".jpg";
		FileUtils.copyFile(screenshot, new File(path));
	}

	@FindBy(xpath = "//div[contains(@class,'searchBox')]/input")
	protected WebElement searchBox;

	@FindBy(id = "searchAllSummaryView")
	protected WebElement searchAllButton;

	@FindBy(id = "secondSearchButton")
	protected WebElement searchAgain;

	@FindBy(id = "phSearchInput")
	private WebElement searchField;

	@FindBy(id = "phSearchButton")
	private WebElement searchButton;

	public void findItem(String itemName, String categoryName,
			WebElement element, int maxAttempt) throws Exception {
		log.info("Find: " + itemName);

		int attempt = 1;
		while (attempt <= maxAttempt) {
			try {
				timeout(5);
				searchField.clear();
				searchField.sendKeys(itemName);
				searchButton.click();

				Thread.sleep(3000);

				WebElement itemLink = driver
						.findElement(By
								.xpath("//span[contains(text(),'"
										+ categoryName
										+ "')]"
										+ "/ancestor::div[@class='bPageBlock brandSecondaryBrd"
										+ " secondaryPalette']//a[contains(text(), '"
										+ itemName + "')]"));

				waitForElementVisible(itemLink, PAUSE_LENGTH.AVG);
				itemLink.click();
				waitForElementVisible(element, PAUSE_LENGTH.AVG);
				break;
			} catch (Throwable ex) {
				driver.navigate().refresh();
				attempt++;
				log.error(ex.getMessage());
				if (attempt < maxAttempt)
					log.error("---------- Searching for item for the "
							+ attempt + " time");
			} finally {
				timeout(defaultTimeout);
			}
		}
		log.info("Find: " + itemName + " - Done");
	}

	public void findItemInConsole(String itemName, String categoryName,
			WebElement element, int maxAttempt) throws Exception {
		log.info("Find: " + itemName);

		int attempt = 1;
		while (attempt <= maxAttempt) {
			try {
				timeout(5);
				driver.switchTo().defaultContent();

				closeAllTabs();
				searchField.clear();
				searchField.sendKeys(itemName);
				searchButton.click();

				switchToFrame(searchAgain);
				timeout(5);

				Thread.sleep(3000);

				WebElement itemLink = driver
						.findElement(By
								.xpath("//span[contains(text(),'"
										+ categoryName
										+ "')]"
										+ "/ancestor::div[@class='bPageBlock brandSecondaryBrd"
										+ " secondaryPalette']//a[contains(text(), '"
										+ itemName + "')]"));

				waitForElementVisible(itemLink, PAUSE_LENGTH.AVG);
				itemLink.click();
				log.info("Looking for frame with element...");
				Thread.sleep(7000);
				driver.switchTo().defaultContent();
				switchToFrame(element);
				timeout(5);

				waitForElementVisible(element, PAUSE_LENGTH.AVG);
				break;
			} catch (Throwable ex) {
				driver.navigate().refresh();
				attempt++;
				log.error(ex.getMessage());
				if (attempt < maxAttempt)
					log.error("---------- Searching for item for the "
							+ attempt + " time");
			} finally {
				timeout(defaultTimeout);
			}
		}
		log.info("Find: " + itemName + " - Done");
	}

	public void closeAllTabs() {
		try {
			timeout(5);
			driver.switchTo().defaultContent();
			driver.findElement(
					By.xpath("//div[@class='x-plain-header sd_primary_tabstrip x-unselectable']//div[@class='x-tab-tabmenu-right']"))
					.click();
			WebElement allPrimaryTabs = driver.findElement(By
					.xpath("//span[text()='Close all primary tabs']"));
			waitForElementVisible(allPrimaryTabs, PAUSE_LENGTH.AVG);
			allPrimaryTabs.click();
			Thread.sleep(2000);

			try {
				WebElement dontSaveButton = driver.findElement(By
						.xpath("//button[contains(text(),'Don')]"));
				dontSaveButton.click();
				Thread.sleep(3000);
			} catch (Exception e) {
				log.info("No unsaved data is present");
			}

			log.info("Closed all primary tabs");
		} catch (Exception e) {
			log.error(e.getMessage());
		} finally {
			timeout(defaultTimeout);
		}
	}

	private WebElement selectIFrame(List<WebElement> frames, WebElement element) {
		WebElement frame = null;

		timeout(1);

		for (WebElement item : frames) {
			try {
				driver.switchTo().frame(item);
				waitForElementVisible(element, PAUSE_LENGTH.AVG);
				frame = item;
				break;
			} catch (Throwable e) {
				driver.switchTo().defaultContent();
			}
		}

		driver.switchTo().defaultContent();
		timeout(defaultTimeout);
		return frame;
	}

	public void notInViewClick(WebElement element) {
		Actions builder = new Actions(driver);
		builder.moveToElement(element).click(element).perform();
	}

	public void switchToFrame(WebElement element) throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> frames = driver.findElements(By
				.xpath("//iframe[contains(@id,'ext-comp')]"));
		driver.switchTo().frame(selectIFrame(frames, element));
	}

	public String logLastLines(String localPath) throws FileNotFoundException,
			IOException {
		String result = "<br>";
		FileInputStream fis = new FileInputStream(localPath);
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String line = null;
		int lineCount = 0;
		int lineNumber = 0;
		while ((line = br.readLine()) != null) {
			lineCount++;
		}
		br.close();
		lineNumber = lineCount - 25;
		lineCount = 0;
		FileInputStream fis2 = new FileInputStream(localPath);
		BufferedReader br2 = new BufferedReader(new InputStreamReader(fis2));
		while ((line = br2.readLine()) != null) {
			lineCount++;
			if (lineCount >= lineNumber) {
				result += line + "</br>";
			}
		}
		br2.close();
		return result;
	}

	public void selectApp(String app) {
		log.warn("Selecting " + app + "...");
		driver.switchTo().defaultContent();

		timeout(5);
		WebElement appMenu = driver.findElement(By.xpath("//div[@id='tsid']"));
		String title = appMenu.getAttribute("title");

		if (title.equals("Force.com App Menu")) {
			log.info("Old UI app selector");
			try {
				waitForElementVisible(
						By.xpath("//span[@id='tsidLabel'][text()='" + app
								+ "']"), PAUSE_LENGTH.AVG);
				log.info(app + " selected already");
			} catch (Exception e) {
				timeout(defaultTimeout);
				waitForElementVisible(appSelector, PAUSE_LENGTH.AVG);
				appSelector.click();
				WebElement menuLink = driver
						.findElement(By
								.xpath("//a[contains(@class,'menuButtonMenuLink')][text()='"
										+ app + "']"));
				menuLink.click();
			}
		} else {
			log.info("New UI app selector");
			int selected = driver.findElements(
					By.xpath("//div[@id='tsid'][@title='" + app + "']")).size();
			if (selected != 1) {
				timeout(defaultTimeout);
				waitForElementVisible(appSelector, PAUSE_LENGTH.AVG);
				appSelector.click();
				WebElement menuLink = driver
						.findElement(By
								.xpath("//a[contains(@class,'menuButtonMenuLink')][text()='"
										+ app + "']"));
				menuLink.click();
			}
			timeout(defaultTimeout);
		}
		log.warn("Selecting " + app + " - Done");
	}

	public void openPage(String name) throws Exception {
		log.warn("Opening " + name + " page...");
		try {
			waitForElementVisible(allTabsButton, PAUSE_LENGTH.AVG);
			allTabsButton.click();
			waitForElementVisible(By.linkText(name), PAUSE_LENGTH.AVG);
			Thread.sleep(5000);
		} catch (Throwable ex) {
			log.error(ex.getMessage());
			log.error("Script for oppening all tabs hasn't worked at first time");
			driver.navigate().refresh();
			waitForElementVisible(By.cssSelector("img[class = allTabsArrow]"),
					PAUSE_LENGTH.AVG);
			allTabsButton.click();
			waitForElementVisible(By.linkText(name), PAUSE_LENGTH.MAX);
		}
		WebElement pageLink = driver.findElement(By.linkText(name));
		pageLink.click();
		waitForElementVisible(By.cssSelector("input[title = 'New']"),
				PAUSE_LENGTH.AVG);
		log.warn("Open " + name + " page - Done");
	}

	public void deleteRecords(String recordName, String page) throws Exception {
		log.info("Deleting all " + page + "...");
		openPage(page);
		goButton.click();

		timeout(3);

		int i = 0;
		int recordsCount = driver.findElements(
				By.xpath("//span[contains(text(),'" + recordName
						+ "')]/../../../..//span[contains(text(),'Del')]"))
				.size();
		while (recordsCount > 0) {
			log.info("Records count = " + recordsCount);
			try {
				waitForElementVisible(By.xpath("//span[contains(text(),'"
						+ recordName
						+ "')]/../../../..//span[contains(text(),'Del')]"),
						PAUSE_LENGTH.MIN);
				driver.findElement(
						By.xpath("//span[contains(text(),'"
								+ recordName
								+ "')]/../../../..//span[contains(text(),'Del')]"))
						.click();
				Alert alert = driver.switchTo().alert();
				alert.accept();
				Thread.sleep(4000);
			} catch (Throwable e) {
				driver.navigate().refresh();
			} finally {
				recordsCount = driver
						.findElements(
								By.xpath("//span[contains(text(),'"
										+ recordName
										+ "')]/../../../..//span[contains(text(),'Del')]"))
						.size();
			}
			i++;
			log.info("Records deleted " + i);
		}
		log.info("Deleting all " + page + " - Done");
	}
}