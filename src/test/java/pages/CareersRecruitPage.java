package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.*;

public class CareersRecruitPage extends CareersHome {

    public CareersRecruitPage() {
        url = "https://skryabin-careers.herokuapp.com/recruit";
    }

    public WebElement positionCardXButton (String positionName) {
        return getDriver().findElement(By.xpath("//h4[@class='card-title'][text()='"+positionName+"']/../../../div/button/i[@class='fa fa-close']"));

    }

    public void removePositionCard(String positionName) {
        getExecutor().executeScript("arguments[0].click();", positionCardXButton(positionName));
        getWait(3);
    }

    public WebElement positionCard (String positionName) {
    return getByXpath("//h4[@class='card-title'][text()='"+positionName+"']");
    }

    public void findPositionCard(String positionName) {
        assertThat(positionCard(positionName).isDisplayed()).isFalse();
    }
}
