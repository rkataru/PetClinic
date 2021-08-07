package com.pet.qa.testcases;

import com.pet.qa.base.TestBase;
import com.pet.qa.pages.ServerErrorsPage;
import com.pet.qa.pages.HomePage;
import com.pet.qa.pages.OwnerFindPage;
import com.pet.qa.pages.VeterinariansPage;
import com.pet.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VeterinariansPageTest extends TestBase{
	HomePage homePage;
	OwnerFindPage ownerFindPage;
	VeterinariansPage veterinariansPage;
	ServerErrorsPage serverErrorsPage;
	TestUtil testUtil;

	public VeterinariansPageTest(){
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
		veterinariansPage = homePage.clickOnVeterinariansTab();
		serverErrorsPage = new ServerErrorsPage();
	}

	@Test(priority= 41)
	public void verifyVetPageHeader(){
		Assert.assertEquals(veterinariansPage.verifyVetHeader(), "Veterinarians");
	}

	@Test(priority= 42)
	public void verifyVetDetailsTable(){
		Assert.assertEquals(veterinariansPage.verifyVetNameColumn(), "Name");
		Assert.assertEquals(veterinariansPage.verifyVetSpecialitiesColumn(), "Specialties");
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
