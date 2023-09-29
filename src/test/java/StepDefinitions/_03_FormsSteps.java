package StepDefinitions;

import Pages.FormsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static Utulities.DriverManager.getAppiumDriver;

public class _03_FormsSteps {

    WebDriverWait wait = new WebDriverWait(getAppiumDriver() , Duration.ofSeconds(20));
    FormsPage formsPage = new FormsPage();

    @When("Navigate to Forms Page")
    public void navigateToFormsPage() {

        getAppiumDriver().findElement(formsPage.formsButton).click();

    }

    @When("User Turns On Switch")
    public void userTurnsOnSwitch() {
        String switchTextBeforeClick = getAppiumDriver().findElement(formsPage.switchText).getText();
        Assert.assertEquals(switchTextBeforeClick, "Click to turn the switch ON");
        System.out.println("Switch Text Before Click  = " +switchTextBeforeClick);
        getAppiumDriver().findElement(formsPage.switchButton).click();

    }

    @Then("The Switch Should Be Turned On")
    public void theSwitchShouldBeTurnedOn() {
        String switchTextAfterClick = getAppiumDriver().findElement(formsPage.switchText).getText();
        Assert.assertEquals(switchTextAfterClick, "Click to turn the switch OFF");
        System.out.println("Switch Text  After Click = " + switchTextAfterClick);
    }

    @When("User Opens DropDown Menu")
    public void userOpensDropDownMenu() {
        getAppiumDriver().findElement(formsPage.dropDownButton).click();


    }

    @And("Selects Second Option")
    public void selectsSecondOption() {
        getAppiumDriver().findElement(formsPage.secondOption).click();



    }

    @Then("Second Option Should Be Selected")
    public void secondOptionShouldBeSelected() {
        System.out.println("Select option is  = " + getAppiumDriver().findElement(formsPage.actualSelectedOption).getText());
        getAppiumDriver().findElement(formsPage.dropDownButton).click();
        String isSelected = getAppiumDriver().findElement(formsPage.secondOption).getAttribute("checked");
        Assert.assertEquals(isSelected, "true");
        System.out.println("is element selected = " +isSelected);


    }
}
