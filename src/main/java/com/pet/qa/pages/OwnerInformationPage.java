package com.pet.qa.pages;

import com.pet.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OwnerInformationPage extends TestBase {

	@FindBy (xpath = "/html/body/div/div/table[1]/tbody/tr[1]/td/b")
	WebElement fullName;

	@FindBy (id="address")
	WebElement address;

	@FindBy (id="city")
	WebElement city;

	@FindBy (xpath = "/html/body/div/div/table[1]/tbody/tr[4]/td")
	WebElement telephone;

	@FindBy(xpath = "/html/body/div/div/a[1]")
	WebElement editOwnerBtn;

	@FindBy(xpath = "Add New Pet")
	WebElement addNewPetBtn;

	// Initializing the Page Objects:
	public OwnerInformationPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickEditOwner() {
		editOwnerBtn.click();
	}

	public void clickAddNewPet() {
		addNewPetBtn.click();
	}

	public String verifyOwnerName(){
		return fullName.getText();
	}

	public String verifyOwnerAddress(){
		return address.getText();
	}

	public String verifyOwnerCity(){
		return city.getText();
	}

	public String verifyTelephone(){
		return telephone.getText();
	}

}
