package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/java/features/new_account.feature", glue = {
		"steps" }, dryRun = false, monochrome = true, plugin = { "pretty", "html:test-output" })
public class NewAccountRunner {
	
}

//features: path of the feature file
//glue: path of the step definition package
//format: manage report
//monochrome: display the console output in proper readable format
//strict: fail the execution if there any undefined step definition
//dryRun: to check the mapping is good between feature file and step def
//tags: "@ , @" OR operator // "@","@" AND operator //~ don't run
