package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
			features = "src/test/resources/features",
			glue = {"stepdefinitions"},
			plugin = { "pretty","html:target/reports/cucumber-reports.html", 
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"pretty", "summary"},
			monochrome = true,
			dryRun = false,
			snippets = SnippetType.CAMELCASE
		)
public class TestRunner {
	
}
