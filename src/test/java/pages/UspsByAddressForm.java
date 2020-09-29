package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UspsByAddressForm extends UspsHeader {

    @FindBy(id="tAddress")
    private WebElement street;

    @FindBy(id="tCity")
    private WebElement city;

    @FindBy(id="tState")
    private WebElement state;

    @FindBy(id="zip-by-address")
    private WebElement find;


    public UspsByAddressForm fillStreet(String value) {
        street.sendKeys(value);
        return this;
    }

    public UspsByAddressForm fillCity(String value) {
        city.sendKeys(value);
        return this;
    }

    public void clickFind() {
        find.click();
    }

    public UspsByAddressForm selectState(String value) {
        new Select(state).selectByValue(value);
        return this;
    }

}