package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuoteForm {

    private String url;
    private String title;

    public QuoteForm() {
        url = "http://skryabin.com/market/quote.html";
        title = "Get a Quote";
        PageFactory.initElements(getDriver(), this);
    }

    public void openPage() {
        getDriver().get(url);
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(name = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement name;

    // name dialog
    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName;
    @FindBy(name = "middleName")
    private WebElement middleName;
    @FindBy(xpath="//input[@id='lastName']")
    private WebElement lastName;
    @FindBy(xpath = "//span[text()='Save']")
    private WebElement saveButton;

    @FindBy(name = "agreedToPrivacyPolicy")
    private WebElement privacy;

    @FindBy(id = "formSubmit")
    private WebElement submit;

    // additional info iFrame

    @FindBy(name = "additionalInfo")
    private WebElement additionalInfoFrame;
    @FindBy(id = "contactPersonName")
    private WebElement contactPersonName;
    @FindBy(id = "contactPersonPhone")
    private WebElement contactPersonPhone;

    //optional fields
    @FindBy(name="address")
    private WebElement address;
    @FindBy(name="phone")
    private WebElement phoneNumber;


    @FindBy(id = "username-error")
    private WebElement usernameError;
    @FindBy(id = "email-error")
    private WebElement emailError;

    // dynamic field
    private WebElement errorElement(String fieldName) {
        return getDriver().findElement(By.id(fieldName + "-error"));
    }

    // methods

    public String getErrorFieldText(String fieldName) {
        return errorElement(fieldName).getText();
    }

    public boolean isErrorFieldDisplayed(String fieldName) {
        boolean isDisplayed;
        try {
            isDisplayed = errorElement(fieldName).isDisplayed();
        } catch (NoSuchElementException e) {
            isDisplayed = false;
        }
        return isDisplayed;
    }

    public String getUsernameErrorText() {
        return usernameError.getText();
    }

    public String getEmailErrorText() {
        return emailError.getText();
    }

    public String getNameText() {
        return name.getText();
    }


    public void fillContactInfo(String nameValue, String phoneValue) {
        getDriver().switchTo().frame(additionalInfoFrame);
        contactPersonName.sendKeys(nameValue);
        contactPersonPhone.sendKeys(phoneValue);
        getDriver().switchTo().defaultContent();
    }

    public void fillAddress(String value) {
        address.sendKeys(value);
    }

    public void fillPhoneNumber(String value) {
        phoneNumber.sendKeys(value);
    }

    public void fillUsername(String value) {
        username.clear();
        username.sendKeys(value);
    }

    public void fillEmail(String value) {
        email.clear();
        email.sendKeys(value);
    }

    public void fillPassword(String value) {
        password.clear();
        password.sendKeys(value);
    }

    public void fillConfirmPassword(String value) {
        confirmPassword.clear();
        confirmPassword.sendKeys(value);
    }

    public void fillBothPasswords(String value) {
        password.sendKeys(value);
        confirmPassword.sendKeys(value);
    }

    public void fillName(String firstNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
        assertThat(name.getAttribute("value")).isEqualTo(firstNameValue + " " + lastNameValue);
    }

    public void fillName(String firstNameValue, String middleNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        middleName.sendKeys(middleNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
        assertThat(name.getAttribute("value")).isEqualTo(firstNameValue + " " + middleNameValue + " " + lastNameValue);
    }

    public void checkWithPrivacyPolicy() {
        if (!privacy.isSelected()) {
            privacy.click();
        }
    }

    public void uncheckPrivacyPolicy() {
        if (privacy.isSelected()) {
            privacy.click();
        }
    }

    public void submit() {
        submit.click();
    }


}
