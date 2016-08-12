package com;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

import com.main.BaseTestCase;
import com.pages.CommonPage;
import com.pages.LeadsPage;
import com.pages.LoginPage;
import com.pages.SetupPage;
import com.pages.CreateFlowsPage;

public class GenerateTalentProspectDataWorkflow extends BaseTestCase {

	@Override
	public void initPages() {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		leadsPage = PageFactory.initElements(driver, LeadsPage.class);
		commonPage = PageFactory.initElements(driver, CommonPage.class);
		setupPage = PageFactory.initElements(driver, SetupPage.class);
		createFlowPage = PageFactory
				.initElements(driver, CreateFlowsPage.class);
	}

	@BeforeTest
	public void setup() throws Throwable {
		super.setup();
	}

	@Test(priority = 0)
	public void generateTalentProspectDataWorkflow() throws Throwable {
		try {
			loginPage.login();
			setupPage.findSetupElement("Process Builder");
			createFlowPage.creategenerateTalentProspectDataFlow(
					"Auto Generate Talent Prospect Data Workflow",
					"Generate Talent Prospect Data Workflow", "Contact",
					"Contact Created");
			Thread.sleep(5000);
		} catch (Throwable e) {
			log.error(e.getMessage());
			loginPage.captureScreenshot(timestamp);
			throw e;
		}
	}
}
