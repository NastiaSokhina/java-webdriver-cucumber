package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.QuoteForm;
import pages.QuoteResult;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class QuoteStepsDefs {

    QuoteForm form = new QuoteForm();
    QuoteResult result = new QuoteResult();

    @Given("I open {string} page")
    public void iOpenPage(String page) {
        switch (page) {
            case "quote":
                form.openPage();
                break;
            default:
                throw new RuntimeException("Unknown page: "+page);
        }

    }

    @When("I fill out required fields for {string} oop")
    public void iFillOutRequiredFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        form.fillUsername(user.get("username"));
        form.fillEmail(user.get("email"));
        form.fillBothPasswords(user.get("password"));
        form.fillName(user.get("firstName"), user.get("lastName"));
        form.checkWithPrivacyPolicy();

        
    }


    @And("I submit the form oop")
    public void iSubmitTheFormOop() {
        form.submit();
    }

    @Then("I verify required fields for {string} oop")
    public void iVerifyRequiredFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        String resultText = result.getResultText();
        assertThat(resultText).contains(user.get("username"));
        assertThat(resultText).contains(user.get("email"));
        assertThat(resultText).contains(user.get("firstName"));
        assertThat(resultText).contains(user.get("lastName"));

        assertThat(result.isAgreedToPrivacyPolicy()).isTrue();
        assertThat(result.getPasswordText()).isEqualTo("[entered]");

    }

    @When("I fill out optional fields for {string} oop")
    public void iFillOutOptionalFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        form.fillAddress(user.get("address"));
        form.fillPhoneNumber(user.get("phoneNumber"));

    }

    @Then("I verify optional fields for {string} oop")
    public void iVerifyOptionalFieldsForOop(String role) {
        Map<String, String> user = getData(role);
        String resultText = result.getResultText();
        assertThat(resultText).contains(user.get("address"));
        assertThat(resultText).contains(user.get("phoneNumber"));


    }

    @Then("I see {string} error message {string}")
    public void iSeeErrorMessage(String field, String errorMessage) {
        assertThat(form.getErrorFieldText(field).equals(errorMessage)).isTrue();
    }

    @When("I fill out {string} field with {string}")
    public void iFillOutFieldWith(String field, String text) {
        switch (field) {
            case "username":
                form.fillUsername(text);
                break;
            case "email":
                form.fillEmail(text);
                break;
            case "password":
                form.fillPassword(text);
                break;
            case "confirmPassword":
                form.fillConfirmPassword(text);
                break;
            default:
                System.out.println("Unknown field: "+field);
        }
    }

    @Then("I don't see {string} error message")
    public void iDonTSeeErrorMessage(String field) {
                assertThat(form.isErrorFieldDisplayed(field)).isFalse();
    }

    @When("I fill out name field with first name {string} and last name {string}")
    public void iFillOutNameFieldWithFirstNameAndLastName(String firstName, String lastName) {
        form.fillName(firstName, lastName);
    }

    @Then("I verify {string} field value {string}")
    public void iVerifyFieldValue(String field, String value) {
        switch (field) {
            case "name":
                assertThat(form.getNameText().equals(value));
                break;
            default:
                System.out.println("Unknown field: "+field);

        }
    }

    @When("I fill out name field with first name {string}, middle name {string}, last name {string}")
    public void iFillOutNameFieldWithFirstNameMiddleNameLastName(String firstName, String middleName, String lastName) {
        form.fillName(firstName, middleName, lastName);
    }
}
