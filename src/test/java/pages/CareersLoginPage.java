package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

import static support.TestContext.getData;

public class CareersLoginPage extends CareersHome {

    @FindBy(xpath="//input[@placeholder='Please enter an Email']")
    private WebElement usernameField;

    @FindBy(xpath="//input[@placeholder='Please enter a Password']")
    private WebElement passwordField;

    @FindBy(id="loginButton")
    private WebElement submitButton;

    public void enterCredentials(String role) {
        Map<String, String> logins = getData("logins");
        switch (role) {
            case "recruiter":
                usernameField.sendKeys(logins.get("recruiterEmail"));
                passwordField.sendKeys(logins.get("recruiterPassword"));
                break;
        }
        submitButton.click();
    }
}
