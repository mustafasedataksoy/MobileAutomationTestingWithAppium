package StepDefinitions;

import Pages.DragPage;
import Pages.FormsPage;
import Utulities.PageActionsHelper;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utulities.DriverManager.getAppiumDriver;


public class _04_DragSteps {

    WebDriverWait wait = new WebDriverWait(getAppiumDriver() , Duration.ofSeconds(20));
    DragPage dragPage = new DragPage();
    PageActionsHelper pageActionsHelper = new PageActionsHelper();



    @When("Navigate to Drage Page")
    public void navigateToDragePage() {

        getAppiumDriver().findElement(dragPage.dragMenu).click();

    }

    @When("User Completes Drag And Drop")
    public void userCompletesDragAndDrop() {
        pageActionsHelper.dragandDrop();

    }

    @Then("Success Message Should Display")
    public void successMessageShouldDisplay() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(dragPage.successMessage));
        getAppiumDriver().findElement(dragPage.retryButton).click();
        Thread.sleep(3000);

    }
}
