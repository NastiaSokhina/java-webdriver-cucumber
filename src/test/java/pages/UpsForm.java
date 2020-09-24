package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class UpsForm {

    private String url;
    private String title;

    public UpsForm() {
        url = "https://www.ups.com/us/en/Home.page";
        title = "Global Shipping & Logistics Services | UPS - United States";
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath="//a[@role='button'][@id='ups-menuLinks2']")
    private WebElement shippingTab;

    @FindBy(xpath="//div[@role='alert']")
    private WebElement privacyConsent;

    @FindBy(xpath = "//span[@class='icon ups-icon-x']")
    private WebElement privacyConsentX;

    @FindBy(xpath="//a[@class='ups-analytics'][contains(text(),'Create a Shipment')]")
    private WebElement createAShipping;

    @FindBy(id="originname")
    private WebElement name;

    @FindBy(name="address1")
    private WebElement street;

    @FindBy(name="postal")
    private WebElement zip;

    @FindBy(name="city")
    private WebElement city;

    @FindBy(name = "stateDropdown")
    private WebElement stateDropdown;

    @FindBy(name="email")
    private WebElement email;

    @FindBy(xpath="//input[@id='originphone']")
    private WebElement phone;

    @FindBy(xpath="//button[@id='nbsBackForwardNavigationContinueButton']")
    private WebElement continueButton;

    public void openPage() {
        getDriver().get(url);
    }

    public void openShippingTab() {
        if (privacyConsent.isDisplayed()) {
            privacyConsentX.click();
        }
        shippingTab.click();
    }

    public void clickCreateAShipment() {
        createAShipping.click();
        getWait(5);

    }

    public void fillInName(String value) {
        name.click();
        name.clear();
        name.sendKeys(value);
    }

    public void fillAddress(String streetValue, String cityValue, String zipValue, String stateValue) {
        street.click();
        street.clear();
        street.sendKeys(stateValue);

        zip.click();
        zip.clear();
        zip.sendKeys(zipValue);

        getWait().until(ExpectedConditions.textToBePresentInElementValue(city, cityValue));
    }

    public void fillEmail(String value) {
        email.click();
        email.clear();
        email.sendKeys(value);
    }

    public void fillPhoneNumber(String value) {
        phone.click();
        phone.clear();
        phone.sendKeys(value);
    }

    public void clickContinue() {
        getExecutor().executeScript("arguments[0].click();", continueButton);
        getWait(5);
    }

    public void isNameEmpty() {
        assertThat(name.getText().isEmpty()).isTrue();
    }
    public void isStreetEmpty() {
        assertThat(street.getText().isEmpty()).isTrue();
    }
    public void isZipEmpty() {
        assertThat(zip.getText().isEmpty()).isTrue();
    }
    public void isEmailEmpty() {
        assertThat(email.getText().isEmpty()).isTrue();
    }
    public void isPhoneEmpty() {
        assertThat(phone.getText().isEmpty()).isTrue();
    }


}
