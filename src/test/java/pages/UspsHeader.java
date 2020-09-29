package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static support.TestContext.getExecutor;

public class UspsHeader extends Page {

    @FindBy(id="mail-ship-width")
    private WebElement mailAndShip;

    @FindBy(xpath="//li[@class='tool-zip']/a")
    private WebElement lookupByZip;

    @FindBy(xpath="//li[@class='tool-calc']/a[contains(@href,'post')]")
    private WebElement calculatePrice;


    public UspsLookupByZip goToLookupByZip() {
        mouseOver(mailAndShip);
        click(lookupByZip);
        return new UspsLookupByZip();
    }

    public UspsCalculatePrice goToCalculatePrice() {
        mouseOver(mailAndShip);
        calculatePrice.click();
        return new UspsCalculatePrice();
    }

}