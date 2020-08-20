package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import support.TestContext;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.Thread.*;
import static support.TestContext.getDriver;

public class MarketStepsDefs {
    @Given("I go to {string} page")
    public void iGoToPage(String page) throws InterruptedException {

        switch (page) {
            case "quote" -> getDriver().get("http://skryabin.com/market/quote.html");
            case "google" -> getDriver().get("https://www.google.com/");
            default -> System.out.println("page out of scope");
        }
    }

    @And("I get page info")
    public void iGetPageInfo() {
            System.out.println(getDriver().getCurrentUrl());
            System.out.println(getDriver().getTitle());
            System.out.println(getDriver().getWindowHandle());
            System.out.println(getDriver().getPageSource());
    }

    @And("I go back and forward")
    public void iGoBackAndForward() {
        getDriver().navigate().back();
        getDriver().navigate().forward();
    }

    @And("I refresh the page")
    public void iRefreshThePage() {
        getDriver().navigate().refresh();
    }

    @And("I change resolution to {string}")
    public void iChangeResolutionTo(String mode) throws InterruptedException {

        switch (mode) {
            case "phone" -> getDriver().manage().window().setSize(new Dimension(400, 768));
            case "desktop" -> getDriver().manage().window().setSize(new Dimension(1024, 768));
        }
                sleep(3000);
    }

    @And("I fill out required fields")
    public void iFillOutRequiredFields() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='username']")).click();
        getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys("User55");
        getDriver().findElement(By.xpath("//input[@name='email']")).click();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("Nastia123@grr.la");
        getDriver().findElement(By.xpath("//input[@id='password']")).click();
        getDriver().findElement(By.xpath("//input[@id='password']")).sendKeys("Welcome1");
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).click();
        getDriver().findElement(By.xpath("//input[@id='confirmPassword']")).sendKeys("Welcome1");
        getDriver().findElement(By.xpath("//input[@name='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys("Nastia");
        getDriver().findElement(By.xpath("//input[@id='lastName']")).click();
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys("Sokhina");
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();

        getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']")).click();
        sleep(2000);
    }

    @And("I submit the page")
    public void iSubmitThePage() throws InterruptedException {
        getDriver().findElement(By.xpath("//button[@id='formSubmit']")).click();
        sleep(2000);
    }

    @And("I verify email behavior")
    public void iVerifyEmailBehavior() throws InterruptedException {
        getDriver().findElement(By.xpath("//input[@name='email']")).click();
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("wrong email format");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("//input[@name='email']")).clear();
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("Nastia123@grr.la");
        Thread.sleep(2000);

    }

    @Then("I verify that fields values recorded correctly")
    public void iVerifyThatFieldsValuesRecordedCorrectly() {
        assert(getDriver().getTitle().equalsIgnoreCase("get a quote"));
//        assert(getDriver().findElement(By.xpath("//b[@name='firstName']").getText()));
    }

}
