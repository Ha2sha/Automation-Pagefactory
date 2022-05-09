package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends Utility {

    public CreateAccountPage() {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='id_gender1']" )
    WebElement mrRadioButton;
    @FindBy(xpath = "//input[@id='customer_firstname']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='customer_lastname']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='passwd']")
    WebElement password;
    @FindBy(xpath = "//input[@id='address1']")
    WebElement address;
    @FindBy(xpath = "//input[@id='city']")
    WebElement city;
    @FindBy(xpath = "//select[@id='id_state']")
    WebElement state;
    @FindBy(xpath = "//input[@id='postcode']")
    WebElement postCode;
    @FindBy(xpath = "//select[@id='id_country']")
    WebElement country;
    @FindBy(xpath = "//input[@id='phone_mobile']")
    WebElement mobileNumber;
    @FindBy(xpath = "//input[@id='alias']")
    WebElement alias;
    @FindBy(xpath = "//span[normalize-space()='Register']")
    WebElement registerButton;
    @FindBy(xpath = "//h1[@class='page-heading']")
    WebElement myAccountText;

    public void clickOnMrRadioButton(){
    CustomListeners.test.log(Status.PASS,"Clicking on male radio button "+"<br>");
    clickOnElement(mrRadioButton);
    }
    public void enterFirstName(String fname){
        CustomListeners.test.log(Status.PASS,"Entering First Name "+fname+"<br>");
        sendTextToElement(firstName,fname);
    }
    public void enterLastName(String lname){
        CustomListeners.test.log(Status.PASS,"Entering Last Name "+lname+"<br>");
        sendTextToElement(lastName,lname);
    }
    public void enterPassword(String pass){
        CustomListeners.test.log(Status.PASS,"Entering Password "+pass+"<br>");
        sendTextToElement(password,pass);
    }
    public void enterAddress(String add){
        CustomListeners.test.log(Status.PASS,"Entering Address "+add+"<br>");
        sendTextToElement(address,add);
    }
    public void enterCity(String city1){
        CustomListeners.test.log(Status.PASS,"Entering city "+city1+"<br>");
        sendTextToElement(city,city1);
    }
    public void selectCountry(){
        CustomListeners.test.log(Status.PASS,"Selecting Country "+"<br>");
        selectByVisibleTextFromDropDown(country,"United States");
    }
    public void enterPosCode(String postcode){
        CustomListeners.test.log(Status.PASS,"Entering PostCode "+postcode+"<br>");
        sendTextToElement(postCode,postcode);
    }
    public void selectState(String state1){
        CustomListeners.test.log(Status.PASS,"Selecting State "+state1+"<br>");
        selectByVisibleTextFromDropDown(state,state1);
    }
    public void enterMobileNumber(String mobile){
        CustomListeners.test.log(Status.PASS,"Entering Mobile Number "+mobile+"<br>");
        sendTextToElement(mobileNumber,mobile);
    }
    public void enterAlias(String alias1){
        CustomListeners.test.log(Status.PASS,"Entering Alias "+alias1+"<br>");
        sendTextToElement(alias,alias1);
    }
    public void clickOnRegisterButton(){
        CustomListeners.test.log(Status.PASS,"Clicking on register button "+"<br>");
        clickOnElement(registerButton);
    }
    public String getMyAccountText(){
        CustomListeners.test.log(Status.PASS,"Getting successful registration text "+"<br>");
        return getTextFromElement(myAccountText);
    }





}
