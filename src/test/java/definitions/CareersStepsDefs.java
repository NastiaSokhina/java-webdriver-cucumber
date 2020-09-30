package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.Ca;
import pages.CareersHome;
import pages.CareersLoginPage;
import pages.CareersRecruitPage;

public class CareersStepsDefs {
    CareersHome careersHome = new CareersHome();
    CareersLoginPage careersLoginPage = new CareersLoginPage();
    CareersRecruitPage careersRecruitPage = new CareersRecruitPage();

    @And("I login as {string}")
    public void iLoginAs(String role) {
        careersHome.clickLoginButton();
        careersLoginPage.enterCredentials(role);
    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String role) {
        careersHome.verifyLogin(role);
    }

    @When("I remove {string} position")
    public void iRemovePosition(String positionName) {
        careersHome.clickRecruit();
        careersRecruitPage.removePositionCard(positionName);
    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String positionName) {
        careersRecruitPage.findPositionCard(positionName);
    }
}
