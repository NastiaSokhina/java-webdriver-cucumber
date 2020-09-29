package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.assertj.core.api.Assertions.assertThat;

public class UspsPriceCalculator extends UspsCalculatePrice {
    @FindBy(id="quantity-0")
    private WebElement quantityField;

    @FindBy(xpath="//input[@class='btn btn-pcalc btn-default']")
    private WebElement calculateButton;

    @FindBy(id="cost-0")
    private WebElement costField;

    @FindBy(id="price-0")
    private WebElement priceField;

    public void putQuantity(String num) {
        quantityField.sendKeys(num);
    }

    public void clickCalculate() {
        calculateButton.click();
    }

    public void verifyCost(String cost) {
        assertThat(costField.getText().equals(cost)).isTrue();

    }
}
