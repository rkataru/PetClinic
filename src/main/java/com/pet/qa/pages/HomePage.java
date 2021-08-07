package com.pet.qa.pages;

import com.pet.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

	@FindBy(partialLinkText = "HOME")
	WebElement homeTab;

	@FindBy(partialLinkText = "FIND OWNERS")
	WebElement ownersTab;

	@FindBy(partialLinkText = "VETERINARIANS")
	WebElement veterinariansTab;

	@FindBy(partialLinkText = "ERRORS")
	WebElement errorsTab;

	@FindBy(xpath = "/html/body/div/div/h2")
	WebElement welcomeText;

	@FindBy(xpath = "/html/body/div/div/div[1]/div/img")
	WebElement petImage;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle(){
		return driver.getTitle();
	}

	public OwnerFindPage clickOnOwnersTab(){
		ownersTab.click();
		return new OwnerFindPage();
	}

	public VeterinariansPage clickOnVeterinariansTab(){
		veterinariansTab.click();
		return new VeterinariansPage();
	}

	public ServerErrorsPage clickOnErrorsTab(){
		ownersTab.click();
		return new ServerErrorsPage();
	}

	public Boolean validatePetClinicImage() {
		if (petImage.isDisplayed()) {
			System.out.println("Logo present");
		} else {
			System.out.println("Logo not present");
		}
		return petImage.isDisplayed();
	}

}
