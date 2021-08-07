package com.pet.qa.pages;

import com.pet.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OwnerFindPage extends TestBase {

	@FindBy(name = "lastName")
	WebElement searchName;


	@FindBy(xpath = "//*[@id=\"search-owner-form\"]/div[2]/div/button")
	WebElement findOwnerBtn;

	@FindBy (xpath = "/html/body/div/div/a")
	WebElement addOwnerBtn;

	// Initializing the Page Objects:
	public OwnerFindPage() {
		PageFactory.initElements(driver, this);
	}

	public void searchOwner(String ownerLastName) {
		searchName.sendKeys(ownerLastName);
		findOwnerBtn.click();
	}
	public void clickAddOwner() {
		addOwnerBtn.click();
	}

}
