package pages;

import org.junit.rules.ExpectedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static support.TestContext.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

public class CareersHome extends Page {
    public CareersHome() {
        url = "https://skryabin-careers.herokuapp.com/";
    }

    @FindBy(xpath="//button[contains(text(),'Login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@class='mr-2 text-white text-decoration-none']")
    private WebElement userName;

    @FindBy(xpath="//button[contains(text(),'Recruit')]")
    private WebElement recruitTab;

    public void clickLoginButton() {
        loginButton.click();
    }

    Map<String, String> logins = getData("logins");
    public void verifyLogin(String role) {
        String name = userName.getText();
        switch (role) {
            case "recruiter":
                assertThat(name.equals(logins.get("recruiterName"))).isTrue();
                assertThat(recruitTab.isDisplayed()).isTrue();
                break;
        }

    }

    public void clickRecruit() {
        recruitTab.click();
    }

}
