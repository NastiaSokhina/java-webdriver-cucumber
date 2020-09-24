package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;

public class ShipmentForm extends UpsForm {

    private String url;
    private String title;

    public ShipmentForm() {
        url = "https://www.ups.com/ship/guided/destination?tx=5013686037333110&loc=en_US";
        title = "Shipping | UPS - United States";
        PageFactory.initElements(getDriver(), this);
    }


    @FindBy(id="originnbsAgentSummaryName")
    private WebElement senderName;

    @FindBy(xpath="//span[@id='originnbsAgentSummaryAddressLine1']")
    private WebElement senderStreet;

    @FindBy(id="originnbsAgentSummaryCity")
    private WebElement senderCity;

    @FindBy(id="originnbsAgentSummaryState")
    private WebElement senderState;

    @FindBy(id="originnbsAgentSummaryPostalCode")
    private WebElement senderZip;

    @FindBy(id="originnbsAgentSummaryEmail")
    private WebElement senderEmail;

    @FindBy(xpath="//span[@id='originnbsAgentSummaryPhone']")
    private WebElement senderPhone;

    @FindBy(xpath="//button[@type='button'][text()='Cancel Shipment']")
    private WebElement cancelButton;

    @FindBy(xpath = "//button[@id='nbsCancelShipmentWarningYes']")
    private WebElement cancelConfirm;

    public String getNameText() {
        return senderName.getText();
    }
    public String getStreetText() { return senderStreet.getText();}
    public String getCityText() {
        return senderCity.getText();
    }
    public String getStateText() {
        return senderState.getText();
    }
    public String getZipText() {
        return senderZip.getText();
    }
    public String getEmailtext() {
        return senderEmail.getText();
    }
    public String getPhonetext() {
        return senderPhone.getText();
    }

    public void clickCancelButton() {
        getExecutor().executeScript("arguments[0].click();", cancelButton);
        cancelConfirm.click();
    }



}
