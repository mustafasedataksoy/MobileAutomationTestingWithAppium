package Tests;

import Pages.DragPage;
import Pages.FormsPage;
import Pages.LoginPage;
import Pages.SwipePage;
import Utulities.DriverManager;
import Utulities.PageActionsHelper;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class Tests extends DriverManager {


    AndroidDriver driver;
    WebDriverWait wait;
     LoginPage loginPage = new LoginPage();
     FormsPage formsPage = new FormsPage();
     SwipePage swipePage = new SwipePage();
     PageActionsHelper pageActionsHelper = new PageActionsHelper();
     DragPage dragPage = new DragPage();

    @BeforeTest
    public void setUp() {
        driver = getAppiumDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }

    @Test
    public  void LoginFunctionTest() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(getAppiumDriver(), Duration.ofSeconds(20));
        Thread.sleep(2000);
        getAppiumDriver().findElement(loginPage.loginMenu).click();
        getAppiumDriver().findElement(loginPage.emailInput).sendKeys("username123@gmail.com");
        getAppiumDriver().findElement(loginPage.passwordInput).sendKeys("password1");
        getAppiumDriver().findElement(loginPage.loginButton).click();
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.successfulLoginMessage)).getText();
        System.out.println("Login Message = " + actualText);
        Assert.assertEquals(actualText, "You are logged in!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.loginOkButton));
        getAppiumDriver().findElement(loginPage.loginOkButton).click();
        Thread.sleep(3000);

    }

    @Test
    public  void DropDown() {
        getAppiumDriver().findElement(formsPage.formsButton).click();
        getAppiumDriver().findElement(formsPage.dropDownButton).click();
        getAppiumDriver().findElement(formsPage.secondOption).click();
        System.out.println("Select option is  = " + getAppiumDriver().findElement(formsPage.actualSelectedOption).getText());
        getAppiumDriver().findElement(formsPage.dropDownButton).click();
        String isSelected = getAppiumDriver().findElement(formsPage.secondOption).getAttribute("checked");
        Assert.assertEquals(isSelected, "true");
        System.out.println("is element selected = " +isSelected);


    }

    @Test
    public  void Switch() {

        getAppiumDriver().findElement(formsPage.formsButton).click();
        String switchTextBeforeClick = getAppiumDriver().findElement(formsPage.switchText).getText();
        Assert.assertEquals(switchTextBeforeClick, "Click to turn the switch ON");
        System.out.println("Switch Text Before Click  = " +switchTextBeforeClick);
        getAppiumDriver().findElement(formsPage.switchButton).click();
        String switchTextAfterClick = getAppiumDriver().findElement(formsPage.switchText).getText();
        Assert.assertEquals(switchTextAfterClick, "Click to turn the switch OFF");
        System.out.println("Switch Text  After Click = " + switchTextAfterClick);


    }

    @Test
    public  void ScrollDown()
    {
       getAppiumDriver().findElement(swipePage.swipeMenu).click();
       wait.until(ExpectedConditions.visibilityOfElementLocated(swipePage.swipePageText));
       pageActionsHelper.performScroll("down");
        wait.until(ExpectedConditions.visibilityOfElementLocated(swipePage.logo));
        Assert.assertTrue(getAppiumDriver().findElement(swipePage.logo).isDisplayed());
        if (getAppiumDriver().findElement(By.xpath("//*[@text='You found me!!!']")).isDisplayed());{
            System.out.println("I found you ");
        }


    }


    @Test
    public  void ScrollToRightEnd()
    {
        getAppiumDriver().findElement(swipePage.swipeMenu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(swipePage.swipePageText));

        List<WebElement> listOfButtons = getAppiumDriver().findElements(swipePage.allButtons);
        for (int i = 0; i<listOfButtons.size();i++) {

            pageActionsHelper.performScroll("right");
        }
        Assert.assertTrue(getAppiumDriver().findElement(swipePage.lastElement).isDisplayed());
    }

    @Test
    public void dragAndDrop() throws InterruptedException {

        getAppiumDriver().findElement(dragPage.dragMenu).click();
        pageActionsHelper.dragandDrop();
        wait.until(ExpectedConditions.visibilityOfElementLocated(dragPage.successMessage));
        getAppiumDriver().findElement(dragPage.retryButton).click();
        Thread.sleep(3000);



    }








    @AfterTest
    public void tearDown() {
        if (driver != null) {
            getAppiumDriver().quit();
        }


    }
}
