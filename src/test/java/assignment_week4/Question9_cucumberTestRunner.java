package assignment_week4;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
	 features = { "src\\test\\java\\assignment_week4" },
	//	glue= {"CucumberTest", "Stepdefinition.java"},
		format= {"pretty","html:target/cucumber"},
		tags= {"@multiplication,@login"}
		)

public class Question9_cucumberTestRunner {

}
