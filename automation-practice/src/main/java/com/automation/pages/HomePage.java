package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@title='Women']")
    WebElement womenLink;
    @FindBy(xpath = "//li[@class='sfHover']//a[@title='Dresses'][normalize-space()='Dresses']")
    WebElement dressesLink;
    @FindBy(xpath = "//li[@class='sfHover']//a[@title='T-shirts'][normalize-space()='T-shirts']")
    WebElement tShirtsLink;
    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    WebElement signInLink;
    @FindBy(xpath = "//img[@alt='My Store']")
    WebElement logoLink;

    public void clickWomenLink() {
        CustomListeners.test.log(Status.PASS,"Clicking on Women Tab "+"<br>");
        clickOnElement(womenLink);
    }
    public void clickDressesLink() {
        CustomListeners.test.log(Status.PASS,"Clicking on Dress Link "+"<br>");
        clickOnElement(dressesLink);
    }
    public void clickTShirtsLink() {
        CustomListeners.test.log(Status.PASS,"Clicking on T-Shirts Link "+"<br>");
        clickOnElement(tShirtsLink);
    }
    public void clickSignInLink() {
        CustomListeners.test.log(Status.PASS,"Clicking on Sign in Link "+"<br>");
        clickOnElement(signInLink);
    }
    public void clickLogoLink() {
        CustomListeners.test.log(Status.PASS,"Clicking on Logo "+"<br>");
        clickOnElement(logoLink);
    }
    public void checkSignInLinkIsDisplayed(){
        CustomListeners.test.log(Status.PASS,"Verifying signIn is displayed "+"<br>");
        verifyThatElementIsDisplayed(signInLink);

    }
}
