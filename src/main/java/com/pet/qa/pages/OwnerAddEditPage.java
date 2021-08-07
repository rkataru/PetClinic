package com.pet.qa.pages;

import com.pet.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OwnerAddEditPage extends TestBase {

	@FindBy (id = "firstName")
	WebElement firstName;

	@FindBy (id="lastName")
	WebElement lastName;

	@FindBy (id="address")
	WebElement address;

	@FindBy (id="city")
	WebElement city;

	@FindBy (id="telephone")
	WebElement telephone;

	@FindBy (xpath = "//*[@id=\"add-owner-form\"]/div[2]/div/button")
	WebElement addOwnerBtn;
	@FindBy(xpath = "//*[@id=\"add-owner-form\"]/div[2]/div/button" )
	WebElement updateOwnerBtn;

	// Initializing the Page Objects:
	public OwnerAddEditPage() {
		PageFactory.initElements(driver, this);
	}

	public void createNewOwner(String ftName, String ltName, String addr, String cty, String telephoneNumber){
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		address.sendKeys(addr);
		city.sendKeys(cty);
		telephone.sendKeys(telephoneNumber);
		addOwnerBtn.click();
	}

	public void updateExistingOwner(String ftName, String ltName, String addr, String cty, String telephoneNumber){
		if (!ftName.isEmpty()) firstName.sendKeys(ftName);
		if (!ltName.isEmpty()) lastName.sendKeys(ltName);
		if (!addr.isEmpty()) address.sendKeys(addr);
		if (!cty.isEmpty()) city.sendKeys(cty);
		if (!telephoneNumber.isEmpty()){ telephone.clear(); telephone.sendKeys(telephoneNumber);
		}
		updateOwnerBtn.click();
	}

}
