package insuranceQA_VW;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import resources.Base;
import org.openqa.selenium.By;
import resources.Assertion;

//@RunWith(Cucumber.class)
public class InsuranceCoverTest extends Base {
   public String registration_number;	

    @Given("^Initialize the browser$")
    public void initialize_the_browser() throws Throwable {
    	driver=InitializeDriver();   
    }
    @And("^User navigates to Dealer Portal of Volkswagen$")
    public void user_navigates_to_dealer_portal_of_volkswagen() throws Throwable {
    	driver.get(prop.getProperty("Dealer_Portal"));
          }
    @When("^User enters the (.+) of vehicle$")
    public void user_enters_the_of_vehicle(String registrationnumber) throws Throwable {
    	driver.findElement(By.id("vehicleReg")).sendKeys(registrationnumber);
    	registration_number=registrationnumber;
    }
    @And("^Clicks on Find Vehicle$")
    public void clicks_on_find_vehicle() throws Throwable {
        driver.findElement(By.name("btnfind")).click();
    }

    @Then("^Validate the Insurance cover Start date and End Date$")
    public void validate_the_insurance_cover_start_date_and_end_date() throws Throwable {
    	String Actual_Result=driver.findElement(By.className("result")).getText();
    	System.out.println("Actual Result is "+Actual_Result);
    	String Expected_Result="Result for : "+registration_number;
    	System.out.println("Expected Result is : "+Expected_Result);
    	Assertion.assert_result(Actual_Result, Expected_Result);
        driver.close();
    	}
}
