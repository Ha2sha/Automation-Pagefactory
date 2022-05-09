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
import resources.testdata.TestData;
@Listeners(CustomListeners.class)
public class SignInPageTest extends TestBase {
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
    public void userShouldNavigateToSignInPageSuccessFully(){
    homePage.clickSignInLink();
    String expectedText="AUTHENTICATION";
    String actualText=signInPage.getAuthenticationText();
    Assert.assertEquals(actualText,expectedText,"Authentication Text not Displayed");
    }

    @Test(groups = {"smoke", "regression"},dataProvider = "invalid credentials",dataProviderClass = TestData.class)

    public void verifyTheErrorMessageWithInValidCredentials(String username, String password, String message){
        homePage.clickSignInLink();
        signInPage.loginToApplication(username,password);
        String expectedText="There is 1 error\n"+message;
        String actualText=signInPage.getErrorAtInvalidSignIn();
        Assert.assertEquals(actualText,expectedText);

    }
    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials()
    {
        homePage.clickSignInLink();
        signInPage.enterEmailAddress("harry28@gmail.com");
        signInPage.enterPassword("Test123");
        signInPage.clickOnSignInButton();
        signInPage.checkSignOutLinkIsDisplayed();
    }
    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogOutSuccessFully(){
        homePage.clickSignInLink();
        signInPage.enterEmailAddress("harry28@gmail.com");
        signInPage.enterPassword("Test123");
        signInPage.clickOnSignInButton();
        signInPage.clickOnSignOutLink();
        homePage.checkSignInLinkIsDisplayed();
    }
}
