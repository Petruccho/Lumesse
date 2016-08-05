package com.main;

import static org.testng.Assert.fail;

import java.net.InetAddress;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import com.pages.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

/**
 * Main Class for launching Selenium Driver and Browser
 * 
 * 
 */
public abstract class BaseTestCase {
	public QueuePage queuePage;
	public LoginPage loginPage;
	public LeadsPage leadsPage;
	public AccountsPage accountsPage;
	public CommonPage commonPage;
    public SetupPage setupPage;
    public CreateFlowsPage createFlowPage;


	protected WebDriver driver;

	public StringBuffer verificationErrors = new StringBuffer();

	protected final Log log = LogFactory.getLog(getClass());

	public void setup() throws Throwable {
		PropertyConfigurator.configure("properties/log4j.properties");

		log.warn("Starting browser...");
		TimeZone.getDefault();

        //System.setProperty("webdriver.chrome.driver", "e:\\projects\\Lumes\\BlankProject\\BlankProject\\lib\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
		driver = new ChromeDriver();

		initPages();
		generateTestValues();
		getMachineInfo();

		// Choosing default timeout
		int implicitWait = 30;

		driver.manage().timeouts()
				.implicitlyWait(implicitWait, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		log.warn("Start browser - Done");
	}

	/**
	 * Definition of pages, that will be used in test
	 */
	public abstract void initPages();

	/**
	 * The method for ending session of Selenium
	 * 
	 * @throws Exception
	 */
	public String firstName;
	public String lastName;
	public Calendar calendar = Calendar.getInstance();
	public String dateNow;
	public String timestamp;

	private void generateTestValues() {
		log.info("Generating test values...");
		DateFormat dFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		dFormat.setTimeZone(TimeZone.getTimeZone("GMT+3"));
		dateNow = dFormat.format(calendar.getTime());

		DateFormat dateFormat = new SimpleDateFormat("ddMMHHmmSS");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+3"));
		timestamp = dateFormat.format(calendar.getTime());

		firstName = "First_" + timestamp;
		lastName = "Last_" + timestamp;
		log.info("Generate test values - Done");
	}

	public String changeDateByHours(int hourOffset) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+3"));
		calendar.setTime(dateFormat.parse(dateNow));
		calendar.add(Calendar.HOUR_OF_DAY, hourOffset);
		log.info(dateFormat.format(calendar.getTime()));
		return dateFormat.format(calendar.getTime());
	}

	private void getMachineInfo() throws Exception {
		String userName = System.getProperty("user.name");
		InetAddress localMachine = java.net.InetAddress.getLocalHost();
		String hostName = localMachine.getHostName();
		log.info("User name : " + userName);
		log.info("Host name : " + hostName);
	}


	@AfterClass
	public void tearDown() throws Exception {
		try {
			driver.quit();
			log.warn("Quit driver and closed all windows.");
		} catch (Throwable e) {
			log.error(e.getMessage());
		}

		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}

	}
}
