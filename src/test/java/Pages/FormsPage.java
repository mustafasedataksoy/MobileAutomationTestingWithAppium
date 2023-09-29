package Pages;

import Utulities.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class FormsPage extends DriverManager {

    public FormsPage(){

        PageFactory.initElements(getAppiumDriver(),this);
    }

    // dropdown Locators
    public AppiumBy formsButton = (AppiumBy) AppiumBy.accessibilityId("Forms");
    public AppiumBy dropDownButton = (AppiumBy) AppiumBy.accessibilityId("Dropdown");
    public By secondOption = By.xpath("//*[@text='Appium is awesome']");
    public By actualSelectedOption = By.xpath("//android.view.ViewGroup[@content-desc=\"Dropdown\"]/android.view.ViewGroup/android.widget.EditText");

  // switch locators
    public AppiumBy switchText = (AppiumBy) AppiumBy.accessibilityId("switch-text");
    public AppiumBy switchButton = (AppiumBy) AppiumBy.accessibilityId("switch");








}
