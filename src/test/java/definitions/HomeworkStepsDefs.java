package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.data.Percentage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import static java.lang.Thread.*;
import static org.assertj.core.api.Assertions.*;

import static support.TestContext.*;

public class HomeworkStepsDefs {
    @Then("I click on {string} tab")
    public void iClickOnTab(String tab) {
        getDriver().findElement(By.xpath("//li/a[text()='"+tab+"']")).click();
    }

    @Then("I select to convert from {string} to {string}")
    public void iSelectToConvertFromTo(String from, String to) {
        WebElement fromElement = getDriver().findElement(By.xpath("//select[@name='calFrom']"));
        Select fromSelect = new Select(fromElement);
        fromSelect.selectByVisibleText(from);

        WebElement toElement = getDriver().findElement(By.xpath("//select[@id='calTo']"));
        Select toSelect = new Select(toElement);
        toSelect.selectByVisibleText(to);
    }

    @Then("I calculate for the value of {string} and see the result")
    public void iCalculateForTheValueOfAndSeeTheResult(String value) {
        getDriver().findElement(By.xpath("//input[@name='fromVal']")).sendKeys(value);
        System.out.println(getDriver().findElement(By.xpath("//input[@name='toVal']")).getText());
    }

    @When("I navigate to {string}")
    public void iNavigateTo(String loanCalculator) {
        getDriver().findElement(By.xpath("//a[contains(@href,'auto-loan')]")).click();
    }

    @And("I clear all calculator fields")
    public void iClearAllCalculatorFields() {
        getDriver().findElement(By.xpath("//input[@name='cloanamount']")).clear();
        getDriver().findElement(By.xpath("//input[@name='cloanterm']")).clear();
        getDriver().findElement(By.xpath("//input[@name='cinterestrate']")).clear();
        getDriver().findElement(By.xpath("//input[@name='cdownpayment']")).clear();
        getDriver().findElement(By.xpath("//input[@name='ctradeinvalue']")).clear();
        getDriver().findElement(By.xpath("//input[@name='csaletax']")).clear();
        getDriver().findElement(By.xpath("//input[@name='ctitlereg']")).clear();
    }

    @And("I calculate")
    public void iCalculate() {
        getDriver().findElement(By.xpath("//input[@value='Calculate']")).click();
    }

    @Then("I verify {string} calculator error")
    public void iVerifyCalculatorError(String errorText) {
        WebElement result = getDriver().findElement(By.xpath("(//td[@valign='top'])[2]"));
        getWait().until(ExpectedConditions.textToBePresentInElement(result, errorText));
    }

    @And("I enter {string} price, {string} months, {string} interest, {string} downpayment, {string} trade-in, {string} state, {string} percent tax, {string} fees")
    public void iEnterPriceMonthsInterestDownpaymentTradeInStatePercentTaxFees(String price, String months, String interest, String downpayment, String tradeIn, String state, String tax, String fees) {
        getDriver().findElement(By.xpath("//input[@name='cloanamount']")).sendKeys(price);
        getDriver().findElement(By.xpath("//input[@name='cloanterm']")).sendKeys(months);
        getDriver().findElement(By.xpath("//input[@name='cinterestrate']")).sendKeys(interest);
        getDriver().findElement(By.xpath("//input[@name='cdownpayment']")).sendKeys(downpayment);
        getDriver().findElement(By.xpath("//input[@name='ctradeinvalue']")).sendKeys(tradeIn);
        getDriver().findElement(By.xpath("//input[@name='csaletax']")).sendKeys(tax);
        getDriver().findElement(By.xpath("//input[@name='ctitlereg']")).sendKeys(fees);

        WebElement stateElement = getDriver().findElement(By.xpath("//select[@name='cstate']"));
        Select stateSelect = new Select(stateElement);
        stateSelect.selectByVisibleText(state);
    }

    @Then("I verify monthly pay is {string}")
    public void iVerifyMonthlyPayIs(String payValue) {
        WebElement resultField = getDriver().findElement(By.xpath("//h2[@class='h2result']"));
        assertThat(resultField.getText().contains(payValue));

    }

    @When("I go to {string} under {string}")
    public void iGoToUnder(String option, String tab) {

        WebElement tabElement = getDriver().findElement(By.xpath("//a[@role='menuitem'][(text()='"+tab+"')]"));
//        WebElement optionElement = getDriver().findElement(By.xpath("//a[@role='menuitem'][contains(text(),'"+option+"')]"));
        getActions().moveToElement(tabElement).perform();
       getDriver().findElement(By.xpath("//a[@role='menuitem'][(text()='"+option+"')]")).click();
//        getActions().click(optionElement).perform();


       // getWait(3);


    }

    @And("I search for {string}")
    public void iSearchFor(String address) {
        getDriver().findElement(By.xpath("//input[@id='address']")).sendKeys(address);
        getDriver().findElement(By.xpath("//input[@id='address']")).sendKeys(Keys.ENTER);
    }

    @And("I click {string} on the map")
    public void iClickOnTheMap(String resultsView) throws InterruptedException {
        WebElement spinner = getDriver().findElement(By.xpath("//div[@id='eddm_overlay-progress']"));
        getWait().until(ExpectedConditions.invisibilityOf(spinner));
        WebElement resultsToggle = getDriver().findElement(By.xpath("//a[contains(text(),'"+resultsView+"')]"));
        getExecutor().executeScript("arguments[0].click()", resultsToggle);
        getWait(8);

    }

    @When("I click {string} on the table")
    public void iClickOnTheTable(String selectAll) {
        getDriver().findElement(By.xpath("//a[@class='totalsArea']")).click();
    }

    @And("I close modal window")
    public void iCloseModalWindow() {
        getDriver().findElement(By.xpath("//div[@id='modal-box-closeModal']")).click();
    }

    @Then("I verify that summary of all rows of Cost column is equal Approximate Cost in Order Summary")
    public void iVerifyThatSummaryOfAllRowsOfCostColumnIsEqualApproximateCostInOrderSummary() throws ParseException {
        String totalCountString = getDriver().findElement(By.xpath("//a[contains(@class, 'totalsArea')]")).getText();
        int totalCount = Integer.parseInt(totalCountString.replaceAll("\\D*", ""));

        By costListSelector = By.xpath("//td[@idx='7']");
        List<WebElement> costList = getDriver().findElements(costListSelector);
        System.out.println("Expected elements size: " + totalCount);

        // dealing with infinite scroll
        while (costList.size() < totalCount) {
            System.out.println("Actual elements size: " + costList.size());
            int lastIndex = costList.size() - 1;
            getActions().moveToElement(costList.get(lastIndex)).perform();
            costList = getDriver().findElements(costListSelector);
        }
        System.out.println("Actual elements size: " + costList.size());

        Locale locale = new Locale("en", "US");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        double actualTotal = 0;
        for (WebElement cost : costList) {
            double costTotal = formatter.parse(cost.getText()).doubleValue();
            actualTotal += costTotal;
        }
        System.out.println("Actual total " + actualTotal);

        String expectedTotalString = getDriver().findElement(By.xpath("//span[@class='approx-cost']")).getText();
        double expectedTotal = Double.parseDouble(expectedTotalString);
        System.out.println("Expected total " + expectedTotal);

        assertThat(actualTotal).isCloseTo(expectedTotal, Percentage.withPercentage(1));
    }
}
