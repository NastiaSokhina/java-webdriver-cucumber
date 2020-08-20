package definitions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import support.TestContext;
import static org.assertj.core.api.Assertions.*;
import static support.TestContext.getDriver;

import cucumber.api.java.en.When;

public class UspsStepsDefs {
    @When("I look up ZIP by address")
    public void iLookUpZIPByAddress() throws InterruptedException {
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//h2[@class='header-2 center']//a[contains(text(),'Look Up a ZIP Code')]")).click();
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//a[@class='zip-code-address zip-code-home']")).click();

    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);
        String xpathState = String.format("//select[@id='tState']/option[@value='" +state+ "']");
        getDriver().findElement(By.xpath(xpathState)).click();

    }

    @Then("I validate {string} ZIP code exists in the result")
    public void iValidateZIPCodeExistsInTheResult(String zip) {
        assertThat(getDriver().findElement(By.xpath("//div[@class='zipcode-result-address']")).getText().contains(zip));

    }

    @And("I submit the form")
    public void iSubmitTheForm() throws InterruptedException  {
        getDriver().findElement(By.xpath("//a[@class='btn-primary'][@id='zip-by-address']")).click();
        Thread.sleep(2000);
    }
}
