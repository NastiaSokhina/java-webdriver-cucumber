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
        Map<String, Map<String, String>> data = getData("credentials");
        Map<String, String> logins = data.get(role);
        usernameField.sendKeys(logins.get("email"));
        passwordField.sendKeys(logins.get("password"));

        submitButton.click();
    }
}
