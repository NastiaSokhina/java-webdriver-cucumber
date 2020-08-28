package definitions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() throws InterruptedException  {

        Actions actions = new Actions(getDriver());
        WebElement quickTools = getDriver().findElement(By.xpath("//*[contains(@class, 'first-element')]"));
        WebElement calculatePrice = getDriver().findElement(By.xpath("//a/img[contains(@alt,'Price')]"));
        actions.moveToElement(quickTools).click(calculatePrice);
        Thread.sleep(2000);
    }

    @When("I navigate to Find a Location page")
    public void iNavigateToFindALocationPage() {
        Actions actions = new Actions(getDriver());
        WebElement quickTools = getDriver().findElement(By.xpath("//*[contains(@class, 'first-element')]"));
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String optionType) throws InterruptedException  {
        Thread.sleep(2000);
        System.out.println(getDriver().findElement(By.xpath("//select[@id='CountryID']")).getText());


    }
}
