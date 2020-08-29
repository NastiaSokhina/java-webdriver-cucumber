package definitions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.TestContext;
import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.*;

import cucumber.api.java.en.When;

public class UspsStepsDefs {
    @When("I look up ZIP by address")
    public void iLookUpZIPByAddress() {
        getDriver().findElement(By.xpath("//a[@id='mail-ship-width']")).click();
        getDriver().findElement(By.xpath("//h2[@class='header-2 center']//a[contains(text(),'Look Up a ZIP Code')]")).click();
        getDriver().findElement(By.xpath("//a[@class='zip-code-address zip-code-home']")).click();

    }

    @And("I fill out {string} street, {string} city, {string} state")
    public void iFillOutStreetCityState(String street, String city, String state) throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@id='tAddress']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='tCity']")).sendKeys(city);

        WebElement stateXpath = getDriver().findElement(By.xpath("//select[@id='tState']"));
        Select stateSelect = new Select(stateXpath);
        stateSelect.selectByValue(state);
    }

    @Then("I validate {string} ZIP code exists in the result")
    public void iValidateZIPCodeExistsInTheResult(String zip) {
        //explicit wait
        WebDriverWait wait = new WebDriverWait(getDriver(),5);
        WebElement result = getDriver().findElement(By.xpath("//div[@id='zipByAddressDiv']"));
        wait.until(ExpectedConditions.textToBePresentInElement(result, zip));

//        assertThat(getDriver().findElement(By.xpath("//div[@class='zipcode-result-address']")).getText().contains(zip));

    }

    @And("I submit the form")
    public void iSubmitTheForm() {
        getDriver().findElement(By.xpath("//a[@class='btn-primary'][@id='zip-by-address']")).click();
    }

    @When("I go to Calculate Price Page")
    public void iGoToCalculatePricePage() {
        Actions actions = new Actions(getDriver());
        WebElement quickTools = getDriver().findElement(By.xpath("//*[contains(@class, 'first-element')]"));
        WebElement calculatePrice = getDriver().findElement(By.xpath("//a/img[contains(@alt,'Price')]"));
        actions.moveToElement(quickTools).click(calculatePrice).perform();
    }

    @When("I navigate to Find a Location page")
    public void iNavigateToFindALocationPage() {
        Actions actions = new Actions(getDriver());
        WebElement quickTools = getDriver().findElement(By.xpath("//*[contains(@class, 'first-element')]"));
        WebElement findLocations = getDriver().findElement(By.xpath("//li[@class='qt-nav menuheader']//li[3]//a[1]//img[1]"));
        actions.moveToElement(quickTools).click(findLocations).perform();
    }

    @And("I select {string} with {string} shape")
    public void iSelectWithShape(String country, String optionType) {

        WebElement countryXpath = getDriver().findElement(By.xpath("//select[@id='CountryID']"));
        Select countrySelect = new Select(countryXpath);
        countrySelect.selectByVisibleText(country);

        getDriver().findElement(By.xpath("//input[@id='option_1']")).click();

    }

    @When("I go to {string} tab")
    public void iGoToTab(String tab) {
        getDriver().findElement(By.xpath("//a[@class='menuitem'][contains(text(),'"+tab+"')]")).click();
    }

    @And("I perform {string} help search")
    public void iPerformHelpSearch(String item) {
        getDriver().findElement(By.xpath("//input[@id='137:0']")).sendKeys(item);
        getDriver().findElement(By.xpath("//input[@id='137:0']")).sendKeys(Keys.ENTER);
    }

    @Then("I verify that no results of {string} available in help search")
    public void iVerifyThatNoResultsOfAvailableInHelpSearch(String item) {
        String searchResult = getDriver().findElement(By.xpath("//div[@class='listContent']")).getText();
        assertThat(searchResult).doesNotContain(item);
    }

    @And("I filter by {string} location types, {string} services, {string} available services")
    public void iFilterByLocationTypesServicesAvailableServices(String locationType, String service, String availableServices) {

        Actions actions = new Actions(getDriver());
        WebElement locationTypeElement = getDriver().findElement(By.xpath("//button[@id='post-offices-select']"));
        WebElement locationOption = getDriver().findElement(By.xpath("//a[@data-value='po']"));
        actions.click(locationTypeElement).click(locationOption).perform();

        WebElement serviceElement = getDriver().findElement(By.xpath("//button[@id='service-type-select']"));
        WebElement serviceOption = getDriver().findElement(By.xpath("//li[@id='pickupPo']//a[contains(text(),'"+service+"')]"));
        actions.click(serviceElement).click(serviceOption).perform();

        WebElement availableServicesElement = getDriver().findElement(By.xpath("//button[@id='available-service-select']"));
        WebElement availableServicesOption = getDriver().findElement(By.xpath("//a[contains(text(),'"+availableServices+"')]"));
        actions.click(availableServicesElement).click(availableServicesOption).perform();

    }

    @And("I define {string} quantity")
    public void iDefineQuantity(String quantity) {
        getDriver().findElement(By.xpath("//input[@id='quantity-0']")).sendKeys(quantity);
    }

    @Then("I calculate the price and validate cost is {string}")
    public void iCalculateThePriceAndValidateCostIs(String cost) {
        getDriver().findElement(By.xpath("//input[@class='btn btn-pcalc btn-default']")).click();
        assertThat(getDriver().findElement(By.xpath("//div[@id='total']")).getText().contains(cost));
    }

    @And("I provide data as {string} street, {string} city, {string} state")
    public void iProvideDataAsStreetCityState(String street, String city, String state) {
        getDriver().findElement(By.xpath("//input[@id='search-input']")).click();

        getDriver().findElement(By.xpath("//input[@id='addressLineOne']")).sendKeys(street);
        getDriver().findElement(By.xpath("//input[@id='cityOrZipCode']")).sendKeys(city);
        WebElement stateXpath = getDriver().findElement(By.xpath("//select[@id='servicesStateSelect']"));
        Select stateSelect = new Select(stateXpath);
        stateSelect.selectByValue(state);

        getDriver().findElement(By.xpath("//a[contains(text(),'Go to Results')]")).click();
    }

    @Then("I verify phone number is {string}")
    public void iVerifyPhoneNumberIs(String phoneNumber) {
        getDriver().findElement(By.xpath("(//div[@class='list-item-location popover-trigger'])[1]")).click();

        WebDriverWait wait = new WebDriverWait(getDriver(),5);
        WebElement result = getDriver().findElement(By.xpath("//div[@id='po-location-detail']"));
        wait.until(ExpectedConditions.textToBePresentInElement(result, phoneNumber));
    }
}
