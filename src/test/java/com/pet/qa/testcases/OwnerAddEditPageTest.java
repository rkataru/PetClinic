package com.pet.qa.testcases;

import com.pet.qa.base.TestBase;
import com.pet.qa.pages.*;
import com.pet.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OwnerAddEditPageTest extends TestBase{
	HomePage homePage;
	TestUtil testUtil;
	OwnerFindPage ownerFindPage;
	OwnerAddEditPage ownerAddEditPage;
	OwnerInformationPage ownerInformationPage;

	String sheetName = "owners";
	public OwnerAddEditPageTest(){
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

	@DataProvider
	public Object[][] getPetOwnerTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}


	@Test (priority = 21)
	public void verifyAddNewOwner (){
		ownerFindPage.clickAddOwner();
		ownerAddEditPage.createNewOwner("Ram", "K", "Al Reem", "Abu Dhabi", "+971-123-456");
	}

	@Test (priority = 22)
	public void verifyAddExistingOwner (){
		ownerFindPage.clickAddOwner();
		ownerAddEditPage.createNewOwner("Ram", "K", "Al Reem", "Abu Dhabi", "+971-123-456");
	}

	@Test(priority= 23, dataProvider="getPetOwnerTestData")
	public void validateCreateNewContact(String firstname, String lastname, String address, String city, String telephone){
		ownerFindPage.clickAddOwner();
		ownerAddEditPage.createNewOwner(firstname, lastname,address,city, telephone);
	}
	@Test (priority = 24)
	public void verifyAddOwnerWithOutRequiredFields (){
		ownerFindPage.clickAddOwner();
		ownerAddEditPage.createNewOwner("", "", "", "", "+971-123-456");
		//Move element identifiers to Page class
//		String errorMessage=driver.findElement(By.xpath("//*[@id=add-owner-form]/div[1]/div[1]/div/span[2]")).getText();
//		Assert.assertEquals(errorMessage,"must not be empty" );
	}

	@Test (priority = 25)
	public void verifyAddNewOwnerWithSpeicalCharacters (){
		ownerFindPage.clickAddOwner();
		ownerAddEditPage.createNewOwner("!@#$%^(*(", ")(*", "Al Reem", "Abu Dhabi", "+971-123-456");
	}

	@Test (priority = 26)
	public void verifyUpdateExistingOwner (){
		ownerFindPage.searchOwner("RK");
		ownerInformationPage.clickEditOwner();
		ownerAddEditPage.updateExistingOwner("Ram", "K", "Al Reem", "Abu Dhabi", "55555");
		Assert.assertEquals(ownerInformationPage.verifyTelephone(), "55555");
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
