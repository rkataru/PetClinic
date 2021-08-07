package com.pet.qa.testcases;

import com.pet.qa.base.TestBase;
import com.pet.qa.pages.*;
import com.pet.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OwnerInformationPageTest extends TestBase{

	HomePage homePage;
	TestUtil testUtil;
	OwnerFindPage ownerFindPage;
	OwnerAddEditPage ownerAddEditPage;
	OwnerInformationPage ownerInformationPage;

	String sheetName = "owners";

	public OwnerInformationPageTest(){
			super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		ownerFindPage = new OwnerFindPage();
		ownerFindPage = homePage.clickOnOwnersTab();
		ownerAddEditPage = new OwnerAddEditPage();
		ownerInformationPage = new OwnerInformationPage();
	}

	@Test(priority= 31)
	public void verifyOwnerInfoUpdate(){
		ownerFindPage.searchOwner("RK");
		ownerInformationPage.clickEditOwner();
		ownerAddEditPage.updateExistingOwner("Ram", "K", "Al Reem", "Abu Dhabi", "11111");
		Assert.assertEquals(ownerInformationPage.verifyTelephone(), "11111");
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
