package com.pet.qa.testcases;

import com.pet.qa.base.TestBase;
import com.pet.qa.pages.*;
import com.pet.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OwnerFindPageTest extends TestBase{

	HomePage homePage;
	TestUtil testUtil;
	OwnerFindPage ownerFindPage;

	String sheetName = "owners";


	public OwnerFindPageTest(){
			super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		ownerFindPage = new OwnerFindPage();
		ownerFindPage = homePage.clickOnOwnersTab();
	}

	@Test (priority = 11)
	public void verifyOwnerSearchSuccess (){
		ownerFindPage.searchOwner("RK");
	}

	@Test (priority = 12)
	public void verifyOwnerSearchFAIL (){
		ownerFindPage.searchOwner("RM");
	}

	@Test (priority = 13)
	public void verifyAddNewOwnerLink (){
		ownerFindPage.clickAddOwner();
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
