package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends Utility {

    public SignInPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailAddress;

    @FindBy(xpath = "//input[@id='passwd']")
    WebElement password;

    @FindBy(xpath = "//span[normalize-space()='Sign in']")
    WebElement signInButton;

    @FindBy(xpath = "//input[@id='email_create']")
    WebElement createEmail;

    @FindBy(xpath = "//span[normalize-space()='Create an account']")
    WebElement createAnAccountButton;

    @FindBy(xpath = "//h1[@class='page-heading']")
    WebElement authenticationText;

    @FindBy(xpath = "//h3[normalize-space()='Create an account']")
    WebElement createAnAccountText;

    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement signOutLink;

    @FindBy(css = "#center_column>div.alert")
    WebElement invalidSignInErrorMessage;

    public void loginToApplication(String email, String password1) {
        enterEmailAddress(email);
        enterPassword(password1);
        clickOnSignInButton();
    }

    public void enterEmailAddress(String username) {
        CustomListeners.test.log(Status.PASS, "Entering email " + username + "<br>");
        sendTextToElement(emailAddress, username);
    }

    public void enterPassword(String password1) {
        CustomListeners.test.log(Status.PASS, "Entering Passowrd " + password1 + "<br>");
        sendTextToElement(password, password1);
    }

    public void clickOnSignInButton() {
        CustomListeners.test.log(Status.PASS, "Clicking on signIn Button " + "<br>");
        clickOnElement(signInButton);
    }

    public void enterEmailForCreateAccount(String email1) {
        CustomListeners.test.log(Status.PASS, "Entering email " + email1 + "<br>");
        sendTextToElement(createEmail, email1);
    }

    public void clickOnCreateAnAccountButton() {
        CustomListeners.test.log(Status.PASS, "Clicking on create Account button " + "<br>");
        clickOnElement(createAnAccountButton);
    }

    public String getAuthenticationText() {
        CustomListeners.test.log(Status.PASS, "Getting Authentication text " + "<br>");
        return getTextFromElement(authenticationText);
    }

    public String getCreateAnAccountText() {
        CustomListeners.test.log(Status.PASS, "Getting create account text " + "<br>");
        return getTextFromElement(createAnAccountText);
    }

    public void checkSignOutLinkIsDisplayed() {
        CustomListeners.test.log(Status.PASS, "Checking signout link is displayed " + "<br>");
        verifyThatElementIsDisplayed(signOutLink);
    }

    public void clickOnSignOutLink() {
        CustomListeners.test.log(Status.PASS, "Clicking on signout link " + "<br>");
        clickOnElement(signOutLink);
    }

    public String getErrorAtInvalidSignIn() {
        CustomListeners.test.log(Status.PASS, "Getting error message for invalid credentials " + "<br>");
        return getTextFromElement(invalidSignInErrorMessage);
    }


}
