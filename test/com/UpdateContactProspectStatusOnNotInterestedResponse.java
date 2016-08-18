package com;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

import com.main.BaseTestCase;
import com.pages.LoginPage;
import com.pages.SetupPage;
import com.pages.CreateFlowsPage;

public class UpdateContactProspectStatusOnNotInterestedResponse extends
		BaseTestCase {

	@Override
	public void initPages() {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		setupPage = PageFactory.initElements(driver, SetupPage.class);
		createFlowPage = PageFactory
				.initElements(driver, CreateFlowsPage.class);
	}

	@BeforeTest
	public void setup() throws Throwable {
		super.setup();
	}

	@Test(priority = 0)
	public void updateContactProspectStatusOnNotInterestedResponse()
			throws Throwable {
		try {
			loginPage.login();
			setupPage.findSetupElement("Process Builder");
			createFlowPage
					.createUpdateContactProspectStatusOnResponseFlow(
							"Auto Update Contact Prospect Status on \"Not Interested\" Response",
							"Talent Pool Manager Processes 1",
							"Prospect Response", "Prospect Responded",
							"Not Interested", "Not a Fit");
			Thread.sleep(5000);

		} catch (Throwable e) {
			log.error(e.getMessage());
			loginPage.captureScreenshot(timestamp);
			throw e;
		}
	}
}
