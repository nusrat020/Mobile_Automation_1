package mobileAutomation_PR_1;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CalculatorPage {
    AndroidDriver driver;

    //Constructor for initialization
    public CalculatorPage(AndroidDriver driver){
        this.driver = driver;
    }

    // Page Elements (Encapsulation: elements are private)
    By addButton = By.id("plus");
    By minusButton = By.id("minus");
    By divideButton = By.id("divi");
    By multiplyButton = By.id("multi");
    By resultField = By.id("formula");
    By clearField = By.id("btn_clear");
    By equalButton = By.id("equal");

    // Page Actions (Abstraction)
    public void clickDigit(int digit){
        driver.findElement(By.id("btn_" +digit)).click();
    }

    public void clickAdd() {
        driver.findElement(addButton).click();
    }
    public void clickMinus() {
        driver.findElement(minusButton).click();
    }
    public void clickDivide() {
        driver.findElement(divideButton).click();
    }

    public void clickMultiply() {
        driver.findElement(multiplyButton).click();
    }

    public void clickEqual() {
        driver.findElement(equalButton).click();
    }

    public void clickClear() {
        driver.findElement(clearField).click();
    }

    public String getResult(){
        String result = driver.findElement(resultField).getText();
        return result;
    }



}
