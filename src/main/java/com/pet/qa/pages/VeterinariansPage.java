package com.pet.qa.pages;

import com.pet.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VeterinariansPage extends TestBase {
    @FindBy(xpath = "/html/body/div/div/h2")
    WebElement pageHeader;

    @FindBy(xpath = "//*[@id=\"vets\"]/thead/tr/th[1]")
    WebElement vetName;

    @FindBy(xpath = "//*[@id=\"vets\"]/thead/tr/th[2]")
    WebElement vetSpecialties;


    // Initializing the Page Objects:
    public VeterinariansPage() {
        PageFactory.initElements(driver, this);
    }

    public String verifyHomePageTitle(){
        return driver.getTitle();
    }

    public String verifyVetHeader (){
        return pageHeader.getText();
    }

    public String verifyVetNameColumn (){
        return vetName.getText();
    }
    public String verifyVetSpecialitiesColumn (){
        return vetSpecialties.getText();
    }

}
