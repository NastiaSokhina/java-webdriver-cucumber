package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class UspsCalculatePrice extends UspsHeader {
    @FindBy(id="CountryID")
    private WebElement countryField;

    @FindBy(xpath="//input[@value='Postcard']")
    private WebElement postcard;

    public void selectCountry(String country) {
        Select countryFieldSelect = new Select(countryField);
        countryFieldSelect.selectByVisibleText(country);
    }

    public void selectOption(String option) {
        switch (option) {
            case "Postcard":
                postcard.click();
                break;
        }
    }

}
