package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Do;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.ShipmentForm;
import pages.UpsForm;
import pages.UspsHome;

import java.util.Map;

import static support.TestContext.*;
import static org.assertj.core.api.Assertions.*;

public class UpsStepsDefs {
    @And("I open Shipping menu")
    public void iOpenShippingMenu() {
        if (getDriver().findElement(By.xpath("//div[@class='implicit_privacy_prompt_content']")).isDisplayed()) {
            getDriver().findElement(By.xpath("//span[@class='icon ups-icon-x']")).click();
        }
        getDriver().findElement(By.xpath("//a[@id='ups-menuLinks2'][contains(text(),'Shipping')]")).click();
    }

    @And("I go to Create a Shipment")
    public void iGoToCreateAShipment() {
        WebElement createAShipment = getDriver().findElement(By.xpath("//a[contains(text(),'Create a Shipment')]"));
        getExecutor().executeScript("arguments[0].click();", createAShipment);
        getWait(5);
    }

    @When("I fill out origin shipment fields")
    public void iFillOutOriginShipmentFields() {
        Map<String, String> address = getData("address");
        getDriver().findElement(By.xpath("//input[@id='originname']")).sendKeys(address.get("name"));
        getDriver().findElement(By.xpath("//input[@id='originaddress1']")).sendKeys(address.get("street"));
        getDriver().findElement(By.xpath("//input[@id='originpostal']")).sendKeys(address.get("zip"));
        getDriver().findElement(By.xpath("//input[@id='originemail']")).sendKeys("email123@test.com");
        getDriver().findElement(By.xpath("//input[@id='originphone']")).sendKeys("3462846432");

        WebElement cityResult = getDriver().findElement(By.xpath("//input[@id='origincity']"));
        WebElement stateResult = getDriver().findElement(By.xpath("//select[@id='originstate']"));


        getWait().until(ExpectedConditions.textToBePresentInElementValue(cityResult, address.get("city")));
        getWait().until(ExpectedConditions.textToBePresentInElement(stateResult, address.get("state")));

    }

    @And("I submit the shipment form")
    public void iSubmitTheShipmentForm() {
        getExecutor().executeScript("arguments[0].click();", getDriver().findElement(By.xpath("//button[text()='Continue']")));
        getWait(8);
    }

    @Then("I verify origin shipment fields submitted")
    public void iVerifyOriginShipmentFieldsSubmitted() {
        Map<String, String> address = getData("address");
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryName']")).getText()).isEqualTo(address.get("name"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryAddressLine1']")).getText()).isEqualTo(address.get("street"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryCity']")).getText()).isEqualTo(address.get("city"));
        assertThat(getDriver().findElement(By.xpath("//span[@id='originnbsAgentSummaryPostalCode']")).getText()).isEqualTo(address.get("zip"));
    }

    @And("I cancel the shipment form")
    public void iCancelTheShipmentForm() {
        WebElement cancelButton = getDriver().findElement(By.xpath("//button[@type='button'][text()='Cancel Shipment']"));
        getExecutor().executeScript("arguments[0].click();", cancelButton);
        WebElement cancelConfirm = getDriver().findElement(By.xpath("//button[@id='nbsCancelShipmentWarningYes']"));
        getExecutor().executeScript("arguments[0].click();", cancelConfirm);
    }

    @Then("I verify shipment form is reset")
    public void iVerifyShipmentFormIsReset() {
        assertThat(getDriver().findElement(By.xpath("//input[@id='originname']")).getText()).isEmpty();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originaddress1']")).getText()).isEmpty();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originpostal']")).getText()).isEmpty();
        assertThat(getDriver().findElement(By.xpath("//input[@id='origincity']")).getText()).isEmpty();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originemail']")).getText()).isEmpty();
        assertThat(getDriver().findElement(By.xpath("//input[@id='originphone']")).getText()).isEmpty();
    }

    @When("I fill out destination shipment fields")
    public void iFillOutDestinationShipmentFields() {
        Map<String, String> address = getData("address");
        getDriver().findElement(By.xpath("//input[@id='destinationname']")).sendKeys(address.get("destinationName"));
        getDriver().findElement(By.xpath("//input[@id='destinationaddress1']")).sendKeys(address.get("destinationStreet"));
        getDriver().findElement(By.xpath("//input[@id='destinationpostal']")).sendKeys(address.get("destinationZIP"));

        WebElement cityField = getDriver().findElement(By.xpath("//input[@id='destinationcity']"));
        WebElement stateField = getDriver().findElement(By.xpath("//select[@id='destinationstate']"));

        getWait().until(ExpectedConditions.textToBePresentInElementValue(cityField, address.get("destinationCity")));
        getWait().until(ExpectedConditions.textToBePresentInElement(stateField, address.get("destinationState")));
    }

    @And("I set packaging type and weight")
    public void iSetPackagingTypeAndWeight() {
        System.out.println(getDriver().getCurrentUrl());
        WebElement packagingTypeElement = getDriver().findElement(By.xpath("//select[contains(@name,'PackagingType')]"));
        Select packagingTypeSelect = new Select(packagingTypeElement);
        packagingTypeSelect.selectByVisibleText("UPS Tube");
        getDriver().findElement(By.xpath("//input[@id='nbsPackagePackageWeightField0']")).sendKeys("3");

    }

    @Then("I verify total charges appear")
    public void iVerifyTotalChargesAppear() {
        getWait().until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//span[@id='nbsBalanceBarTotalCharges']"))));
    }

    @And("I select cheapest delivery option")
    public void iSelectCheapestDeliveryOption() {
        WebElement cheapestOption = getDriver().findElement(By.xpath("//div[@id='Cheapest']/input[@id='nbsServiceTileServiceRadio7']"));
        getExecutor().executeScript("arguments[0].click();", cheapestOption);
    }

    @And("I set description and check Saturday Delivery type")
    public void iSetDescriptionAndCheckSaturdayDeliveryType() {
        getDriver().findElement(By.xpath("//input[@id='nbsShipmentDescription']")).sendKeys("art");
        WebElement saturdayCheckbox = getDriver().findElement(By.xpath("//saturday-delivery-option[@class='ng-star-inserted']//label[@class='ups-lever ups-checkbox-custom-label section-checkbox-label']"));
        getExecutor().executeScript("arguments[0].click();", saturdayCheckbox);
        getWait(5);
    }

    @Then("I verify total charges changed")
    public void iVerifyTotalChargesChanged() {
        WebElement prices = getDriver().findElement(By.xpath("//span[@class='icon ups-icon-chevronup']"));
        getExecutor().executeScript("arguments[0].click();", prices);

        WebElement totalCharges = getDriver().findElement(By.xpath("//span[@id='total-charges-spinner']"));
        String totalChargesString = totalCharges.getText().replace("$", "");
        Double totalChargesDouble = Double.parseDouble(totalChargesString);
        System.out.println("Total charges: "+totalChargesDouble);

       WebElement additionalCharges = getDriver().findElement(By.xpath("//div[@id='nbsBalanceBarOptionsChargesSubtotals']"));
       String additionalChargesString = additionalCharges.getText().replace("Additional Option Fees\n" +
               "$", "");
       Double additionalChargesDouble = Double.parseDouble(additionalChargesString);
       System.out.println("Additional charges: "+additionalChargesDouble);


       WebElement shippingFees = getDriver().findElement(By.xpath("//div[@id='nbsBalanceBarShippingChargesSubtotals']"));
       String shippingFeesString = shippingFees.getText().replace("Shipping Fees\n" +
               "$", "");
       Double shippingFeesDouble = Double.parseDouble(shippingFeesString);
       System.out.println("Shipping Fees: "+shippingFeesDouble);

       Double calculatedTotal = shippingFeesDouble+additionalChargesDouble;

       assertThat(calculatedTotal.equals(totalChargesDouble));

    }

    @And("I select Paypal payment type")
    public void iSelectPaypalPaymentType() {
        WebElement paypalRadio = getDriver().findElement(By.xpath("//div[@id='tile-5']//label[@class='ups-radio-custom-label ups-payment_type_content']"));
        paypalRadio.click();
    }

    @Then("I review all recorded details on the review page")
    public void iReviewAllRecordedDetailsOnTheReviewPage() {
        WebElement reviewButton = getDriver().findElement(By.xpath("//button[text()='Review']"));
        getExecutor().executeScript("arguments[0].click();", reviewButton);

        String senderInfo = getDriver().findElement(By.xpath("(//section[@class='ups-section col-md-6'])[1]")).getText();
        System.out.println(senderInfo);

        String recieverInfo = getDriver().findElement(By.xpath("(//section[@class='ups-section col-md-6'])[2]")).getText();
        System.out.println(recieverInfo);

    }

    UpsForm form = new UpsForm();

    @And("I open Shipping menu oop")
    public void iOpenShippingMenuOop() {
        form.openShippingTab();
    }

    @And("I go to Create a Shipment oop")
    public void iGoToCreateAShipmentOop() {
        form.clickCreateAShipment();
    }

    @When("I fill out origin shipment fields oop")
    public void iFillOutOriginShipmentFieldsOop() {
        Map<String, String> info = getData("address");
        form.fillInName(info.get("name"));
        form.fillAddress(info.get("street"), info.get("city"), info.get("zip"), info.get("state"));
        form.fillEmail(info.get("email"));
        form.fillPhoneNumber(info.get("phone"));
    }

    @And("I submit the shipment form oop")
    public void iSubmitTheShipmentFormOop() {

        form.clickContinue();
    }

    ShipmentForm shipmentForm = new ShipmentForm();

    @Then("I verify origin shipment fields submitted oop")
    public void iVerifyOriginShipmentFieldsSubmittedOop() {
        Map<String, String> info = getData("address");
        String name = shipmentForm.getNameText();
        assertThat(name).contains(info.get("name"));
        String street = shipmentForm.getStreetText();
//        assertThat(street).contains(info.get("street"));
        String city = shipmentForm.getCityText();
        assertThat(city).contains(info.get("city"));

        String zip = shipmentForm.getZipText();
        assertThat(zip).contains(info.get("zip"));
        String email = shipmentForm.getEmailtext();
        assertThat(email).contains(info.get("email"));
        String phone = shipmentForm.getPhonetext();
        assertThat(phone).contains(info.get("phone"));

    }

    @And("I cancel the shipment form oop")
    public void iCancelTheShipmentFormOop() {
        shipmentForm.clickCancelButton();
    }

    @Then("I verify shipment form is reset oop")
    public void iVerifyShipmentFormIsResetOop() {
        form.isNameEmpty();
        form.isStreetEmpty();
        form.isZipEmpty();
        form.isEmailEmpty();
        form.isPhoneEmpty();

    }


}
