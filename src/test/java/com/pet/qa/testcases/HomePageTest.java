package com.pet.qa.testcases;

import com.pet.qa.base.TestBase;
import com.pet.qa.pages.*;
import com.pet.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase{
	HomePage homePage;
	OwnerFindPage ownerFindPage;
	VeterinariansPage veterinariansPage;
	ServerErrorsPage serverErrorsPage;
	TestUtil testUtil;

	public HomePageTest(){
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		veterinariansPage = new VeterinariansPage();
		serverErrorsPage = new ServerErrorsPage();
	}
	
	@Test(priority=1)
	public void launchPageTitleTest(){
		String title = homePage.verifyHomePageTitle();
		Assert.assertEquals(title, "PetClinic :: a Spring Framework demonstration");
	}

	@Test(priority=2)
	public void verifyPetClinicLogoImageTest(){
		Assert.assertNotNull(homePage.validatePetClinicImage());
	}

	@Test(priority=3)
	public void verifyOwnsersTabTest(){
		ownerFindPage = homePage.clickOnOwnersTab();
	}

	@Test(priority=4)
	public void verifyVeterinariansTabTest(){
		veterinariansPage = homePage.clickOnVeterinariansTab();
	}

	@Test(priority=5)
	public void verifyErrorsTabTest(){
		serverErrorsPage = homePage.clickOnErrorsTab();
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
