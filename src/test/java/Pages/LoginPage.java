package Pages;

import Utulities.DriverManager;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DriverManager {


    public LoginPage()
    {
        PageFactory.initElements(getAppiumDriver(),this);

    }
       public AppiumBy loginMenu = new AppiumBy.ByAccessibilityId("Login");
       public  AppiumBy emailInput = new AppiumBy.ByAccessibilityId("input-email");
       public AppiumBy passwordInput = new AppiumBy.ByAccessibilityId("input-password");
      public  AppiumBy loginButton = new AppiumBy.ByAccessibilityId("button-LOGIN");
      public By successfulLoginMessage = By.id("android:id/message");
      public By loginOkButton = new By.ById("android:id/button1");

}
