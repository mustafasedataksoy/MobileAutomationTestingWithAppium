package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Utulities.DriverManager.getAppiumDriver;


public class _01_LoginSteps {

    WebDriverWait wait = new WebDriverWait(getAppiumDriver() , (Duration.ofSeconds(20)));
    LoginPage loginPage = new LoginPage();

    @Given("Open Application")
    public void open_application() {

        getAppiumDriver();
    }

    @When("Navigate to Login  Page")
    public void navigate_to_login_page() {

        getAppiumDriver().findElement(loginPage.loginMenu).click();

    }

    @When("Enter Valid Credentials And Click Login Button")
    public void enter_cedentials_and_click_login_button() {
        getAppiumDriver().findElement(loginPage.emailInput).sendKeys("username123@gmail.com");
        getAppiumDriver().findElement(loginPage.passwordInput).sendKeys("password1");
        getAppiumDriver().findElement(loginPage.loginButton).click();

    }

    @Then("User Should Login Successfully")
    public void user_should_login_successfully() {
        String actualText = wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.successfulLoginMessage)).getText();
        System.out.println("Login Message = " + actualText);
        Assert.assertEquals(actualText, "You are logged in!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.loginOkButton));
        getAppiumDriver().findElement(loginPage.loginOkButton).click();

    }


}
