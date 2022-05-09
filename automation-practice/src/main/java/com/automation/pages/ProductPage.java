package com.automation.pages;

import com.automation.customlisteners.CustomListeners;
import com.automation.utility.Utility;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Utility {

    //Alt+insert to add constructor
    public ProductPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "quantity_wanted")
    WebElement quantity;

    @FindBy(id = "group_1")
    WebElement size;

    @FindBy(className = "attribute_list")
    WebElement colour;

    @FindBy(xpath = "//button[@name='Submit']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//h2[normalize-space()='Product successfully added to your shopping cart']")
    WebElement popUpDisplay;

    @FindBy(xpath = "//span[@title='Close window']")
    WebElement closeBtn;

    public void clickOnCloseBtn() {
        CustomListeners.test.log(Status.PASS,"Clicking on Close Window "+"<br>");
        clickOnElement(closeBtn);
    }

    public void verifyPopUpDisplayMsg(String text) {
        CustomListeners.test.log(Status.PASS,"verifying pop up message "+"<br>");
        verifyThatTextIsDisplayed(popUpDisplay, text);
    }

    public void clickOnAddToCartBtn() {
        CustomListeners.test.log(Status.PASS,"Clicking on add to cart button "+"<br>");
        clickOnElement(addToCartBtn);

    }

    public void selectColour(String color) {
        CustomListeners.test.log(Status.PASS,"Clicking on Colour "+color+"<br>");
        clickOnElement(colour);
    }

    public void selectSize(String text) {
        CustomListeners.test.log(Status.PASS,"Selecting size "+"<br>");
        selectByVisibleTextFromDropDown(size, text);
    }

    public void changeQuantity(String num) {
        CustomListeners.test.log(Status.PASS,"Adding Quantity "+num+"<br>");
        sendTextToElement(quantity, Keys.BACK_SPACE + num);

   }

}
