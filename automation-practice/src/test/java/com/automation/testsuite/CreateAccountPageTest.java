package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.CreateAccountPage;
import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class CreateAccountPageTest extends TestBase {
    HomePage homePage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage=new HomePage();
        signInPage=new SignInPage();
        createAccountPage=new CreateAccountPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully(){
        homePage.clickSignInLink();
        signInPage.enterEmailForCreateAccount("harry18924@gmail.com");//use harry244
        signInPage.clickOnCreateAnAccountButton();
        createAccountPage.clickOnMrRadioButton();
        createAccountPage.enterFirstName("Harry");
        createAccountPage.enterLastName("Patel");
        createAccountPage.enterPassword("Test123");
        createAccountPage.enterAddress("10 Shiv Krupa");
        createAccountPage.enterCity("San Diego");
        createAccountPage.selectState("California");
        createAccountPage.enterPosCode("91942");
        createAccountPage.selectCountry();
        createAccountPage.enterMobileNumber("09192587945");
        createAccountPage.enterAlias("Harry@shiv.com");
        createAccountPage.clickOnRegisterButton();
        String expectedText="MY ACCOUNT";
        String actualText=createAccountPage.getMyAccountText();
        Assert.assertEquals(actualText,expectedText,"My Account text is not displayed");

    }
}
