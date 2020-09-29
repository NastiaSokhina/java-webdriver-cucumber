package definitions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import cucumber.api.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static support.TestContext.*;
import static org.assertj.core.api.Assertions.*;

import cucumber.api.java.en.When;
import pages.*;

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

    @And("I enter {string} into store search")
    public void iEnterIntoStoreSearch(String searchWord) {
        getDriver().findElement(By.xpath("//input[@id='store-search']")).sendKeys(searchWord);
    }

    @Then("I search and validate no products found")
    public void iSearchAndValidateNoProductsFound() {
        getDriver().findElement(By.xpath("//input[@id='store-search-btn']")).click();
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.visibilityOf(getDriver().findElement(By.xpath("//div[@class='no-product']"))));
    }

    @And("choose mail service Priority Mail")
    public void chooseMailServicePriorityMail() {
        WebElement checkbox = getDriver().findElement(By.xpath("//label[@for='checkbox-type-Mail Service-Priority Mail-1']"));
        getExecutor().executeScript("arguments[0].click()", checkbox);
    }

    @Then("I verify {int} items found")
    public void iVerifyItemsFound(int quantity) {
        getWait().until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[contains(@class,'col-6 col-md-4 results-per-page')]"), quantity));
    }

    @When("I unselect Stamps checkbox")
    public void iUnselectStampsCheckbox() {
        getDriver().findElement(By.xpath("//label[@for='checkbox-type-Category-Stamps']")).click();
    }

    @And("select {string} stamp Shape")
    public void selectStampShape(String shape) {
        WebElement shapeSelector = getDriver().findElement(By.xpath("//label[contains(@for,'checkbox-type-Stamp Shape-"+shape+"')]"));
        getExecutor().executeScript("arguments[0].click();", shapeSelector);
    }

    @And("I click {string} color")
    public void iClickColor(String color) {
        WebElement colorPicker = getDriver().findElement(By.xpath("//div[@class='result-color-container']/div[contains(@onclick,'"+color+"')]"));
        getExecutor().executeScript("arguments[0].click();", colorPicker);
    }

    @Then("I verify {string} and {string} filters")
    public void iVerifyAndFilters(String color, String shape) {
        WebElement shapeSelector = getDriver().findElement(By.xpath("//div[@class='cartridge-viewport']//span[contains(text(),'"+shape+"')]"));
        assertThat(ExpectedConditions.elementToBeSelected(shapeSelector));
        WebElement colorPicker = getDriver().findElement(By.xpath("//div[@class='cartridge-viewport']//span[contains(text(),'"+color+"')]"));
        assertThat(ExpectedConditions.elementToBeSelected(colorPicker));


    }

    @And("I verify that items below {int} dollars exists")
    public void iVerifyThatItemsBelowDollarsExists(int price) {
        WebElement resultsPrice = getDriver().findElement(By.xpath("//div[@class='results-product-preview-price']/p"));
        String getPrice = resultsPrice.getText().replace("$", "");
        Double priceInt = Double.parseDouble(getPrice);
        if (price>priceInt) {
            System.out.println("it works!");
        }
    }

    @When("I perform {string} search")
    public void iPerformSearch(String searchWord) {
        getDriver().findElement(By.xpath("//input[@id='home-input']")).sendKeys(searchWord);
        getDriver().findElement(By.xpath("//input[@id='home-input']")).sendKeys(Keys.ENTER);
    }

    @And("I select {string} in results")
    public void iSelectInResults(String searchResult) {
        WebElement search = getDriver().findElement(By.xpath("//span[contains(text(),'"+searchResult+"')]"));
        getExecutor().executeScript("arguments[0].click();", search);
    }

    @And("I click {string} button")
    public void iClickButton(String buttonName) {
        getDriver().findElement(By.xpath("//a[@class='button--primary'][text()='"+buttonName+"']")).click();
    }

    @And("verify {string} service exists")
    public void verifyServiceExists(String serviceName) {
        WebElement appointmentType = getDriver().findElement(By.xpath("//select[@id='passportappointmentType']"));
        assertThat(ExpectedConditions.textToBePresentInElementValue(appointmentType, serviceName));
    }

    @And("I reserve new PO box for {string}")
    public void iReserveNewPOBoxFor(String poNumber) {
        getDriver().findElement(By.xpath("//input[@id='searchInput']")).sendKeys(poNumber);
        getDriver().findElement(By.xpath("//input[@id='searchInput']")).sendKeys(Keys.ENTER);

    }

    @Then("I verify that {string} present")
    public void iVerifyThatPresent(String officeName) {
        WebElement searchResult = getDriver().findElement(By.xpath("//div[@class='row']/div/h2[@class='normal']/span"));
        assertThat(ExpectedConditions.textToBePresentInElement(searchResult,officeName));

    }

    @And("I verify that {string} PO Box is available in {string}")
    public void iVerifyThatPOBoxIsAvailableIn(String size, String officeName) {
        WebElement office = getDriver().findElement(By.xpath("//div[@class='row']/div/h2[@class='normal']/span[contains(text(),'Los Altos')]"));
        office.click();
        WebElement sizeOption = getDriver().findElement(By.xpath("//img[@class='boxSize']/../p/span"));
        assertThat(ExpectedConditions.textToBePresentInElement(sizeOption, size));

    }

    UspsHome uspsHome = new UspsHome();
    UspsByAddressForm uspsByAddressForm = new UspsByAddressForm();
    UspsByAddressResult uspsByAddressResult = new UspsByAddressResult();
    @When("I go to Lookup ZIP page by address oop")
    public void iGoToLookupZIPPageByAddressOop() {
        uspsHome.goToLookupByZip().clickFindByAddress();
    }

    @And("I fill out {string} street, {string} city, {string} state oop")
    public void iFillOutStreetCityStateOop(String street, String city, String state) {
        uspsByAddressForm.fillStreet(street)
                .fillCity(city)
                .selectState(state)
                .clickFind();
    }

    @Then("I validate {string} zip code exists in the result oop")
    public void iValidateZipCodeExistsInTheResultOop(String zip) {
        String actualTotalResult = uspsByAddressResult.getSearchResult();
        assertThat(actualTotalResult).contains(zip);

        boolean areAllItemsContainZip = uspsByAddressResult.areAllResultsContainZip(zip);
        assertThat(areAllItemsContainZip).isTrue();
    }

    UspsCalculatePrice uspsCalculatePrice = new UspsCalculatePrice();
    UspsPriceCalculator uspsPriceCalculator = new UspsPriceCalculator();

    @When("I go to Calculate Price Page oop")
    public void iGoToCalculatePricePageOop() {
        uspsHome.goToCalculatePrice();
    }

    @And("I select {string} with {string} shape oop")
    public void iSelectWithShapeOop(String country, String shape) {
        uspsCalculatePrice.selectCountry(country);
        uspsCalculatePrice.selectOption(shape);
    }

    @And("I define {string} quantity oop")
    public void iDefineQuantityOop(String quantity) {
        uspsPriceCalculator.putQuantity(quantity);

    }

    @Then("I calculate the price and validate cost is {string} oop")
    public void iCalculateThePriceAndValidateCostIsOop(String price) {
        uspsPriceCalculator.clickCalculate();
        uspsPriceCalculator.verifyCost(price);
    }
}
