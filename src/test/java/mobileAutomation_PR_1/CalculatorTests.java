package mobileAutomation_PR_1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CalculatorTests {
    AndroidDriver driver;
    CalculatorPage calculatorPage;
    ExtentReports extent;
    ExtentTest test;

    @BeforeTest
    public void setUp(){
        //Setup ExtentReports
        ExtentSparkReporter spark = new ExtentSparkReporter("Report\\target\\ExtentReports.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);

        // Set DesiredCapabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium:udid", "R9KR701587J");
        capabilities.setCapability("appium:platformVersion", "11");
        capabilities.setCapability("appium:appPackage", "com.bng.calculator");
        capabilities.setCapability("appium:appActivity", "com.bng.calc.MainActivity");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:autoGrantPermissions", "true");
        capabilities.setCapability("appium:selectedElementSearchInProgress", "true");
        capabilities.setCapability("appium:ensureWebviewsHavePages", true);
        capabilities.setCapability("appium:nativeWebScreenshot", true);
        capabilities.setCapability("appium:newCommandTimeout", 3600);
        capabilities.setCapability("appium:connectHardwareKeyboard", true);


        try {
            // Initialize AndroidDriver
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);

            // Wait for the result to appear
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // Initialize CalculatorPage after driver setup
            calculatorPage = new CalculatorPage(driver);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 0)
    public void testSummation(){
        test = extent.createTest("Summation Test").info("Starting Summation Test");
        calculatorPage.clickDigit(9);
        calculatorPage.clickAdd();
        calculatorPage.clickDigit(4);
        calculatorPage.clickEqual();

        String result = calculatorPage.getResult();
        calculatorPage.getResult();
        test.pass("Summation Result: "+result);
        System.out.println("Summation Result: " + result);
        calculatorPage.clickClear();

    }
    @Test(priority = 1)
    public void testSubtraction(){
        test = extent.createTest("Subtraction Test").info("Starting Subtraction Test");

        calculatorPage.clickDigit(9);
        calculatorPage.clickMinus();
        calculatorPage.clickDigit(4);
        calculatorPage.clickEqual();

        String result = calculatorPage.getResult();
        test.pass("Subtraction Result: "+result);
        System.out.println("Subtraction Result: " + result);
        calculatorPage.clickClear();
    }
    @Test(priority = 2)
    public void testMultiplication(){
        test = extent.createTest("Multiplication Test").info("Starting Multiplication Test");

        calculatorPage.clickDigit(9);
        calculatorPage.clickMultiply();
        calculatorPage.clickDigit(4);
        calculatorPage.clickEqual();

        String result = calculatorPage.getResult();
        test.pass("Multiplication Result: "+result);
        System.out.println("Division Result: " + result);
        calculatorPage.clickClear();
    }
    @Test(priority = 3)
    public void testDivision(){
        test = extent.createTest("Division Test").info("Starting Division Test");

        calculatorPage.clickDigit(9);
        calculatorPage.clickDivide();
        calculatorPage.clickDigit(4);
        calculatorPage.clickEqual();

        String result = calculatorPage.getResult();
        test.pass("Division Result: "+result);
        System.out.println("Division Result: " + result);
        calculatorPage.clickClear();
    }
    @AfterClass
    public void tearDown() {
        driver.quit();

        extent.flush();// Generate the report

    }
}
