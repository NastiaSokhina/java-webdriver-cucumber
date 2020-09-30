package definitions;

import cucumber.api.java.en.Given;
import pages.CareersHome;
import pages.QuoteForm;
import pages.UspsHome;


public class CommonStepDefs {

    @Given("I open {string} page oop")
    public void iOpenPageOop(String website) throws InterruptedException {
        switch (website) {
            case "quote":
                new QuoteForm().openPage();
                break;
            case "usps":
                new UspsHome().openPage();
                break;
            case "careers":
                new CareersHome().openPage();
                break;
            default:
                throw new RuntimeException("Unexpected value: " + website);
        }
    }
}
