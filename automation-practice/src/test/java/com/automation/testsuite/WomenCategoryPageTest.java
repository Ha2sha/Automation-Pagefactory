package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.HomePage;
import com.automation.pages.ProductPage;
import com.automation.pages.WomenCategoryPage;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class WomenCategoryPageTest extends TestBase {
    HomePage homePage;
    WomenCategoryPage womenCategoryPage;
    ProductPage productPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage=new HomePage();
        womenCategoryPage=new WomenCategoryPage();
        productPage=new ProductPage();
    }
    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToWomenCategoryPageSuccessfully(){
        womenCategoryPage.selectMenu("Women");
        womenCategoryPage.verifyWomenTxt("Women");
    }

    @Test(groups = {"smoke", "regression"},dataProvider = "cart",dataProviderClass = TestData.class)
    public void verifyUserShouldAddProductToTheCartSuccessfully(String product, String qty, String size, String colour){
        womenCategoryPage.selectMenu("Women");
        womenCategoryPage.selectProduct(product);
        productPage.changeQuantity(qty);
        productPage.selectSize(size);
        productPage.selectColour(colour);
        productPage.clickOnAddToCartBtn();
        productPage.verifyPopUpDisplayMsg("Product successfully added to your shopping cart");
        productPage.clickOnCloseBtn();


    }
}
