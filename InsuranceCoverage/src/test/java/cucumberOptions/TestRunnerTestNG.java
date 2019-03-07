package cucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
@CucumberOptions(
		features="src/test/java/features",
		glue= "insuranceQA_VW")
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {

}
