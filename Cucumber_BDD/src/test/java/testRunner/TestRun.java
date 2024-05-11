package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import cucumber.api.CucumberOptions;
//import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions
(
		features=".//Features/Customers.feature",
		glue="stepDefinitions",
		dryRun=false,
		monochrome=true, // it will remove the unnecessary chahracter from console window 
		publish = true, // for report and How to disable cucumber message in eclipse
		plugin= {"pretty","html:test-output"}
		
		
)
public class TestRun
{

}
