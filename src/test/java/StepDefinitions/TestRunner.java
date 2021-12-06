package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;




@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "StepDefinitions" },
monochrome = true,
plugin ={"pretty", "html:target/reports"
		, "junit:target/JunitReports/reports.xml" , "json:target/JsonReports/reports.json"},
 tags= {"@Smoke"}


	
)
public class TestRunner {

}
