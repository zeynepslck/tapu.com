package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Features/checkInformation.feature",
		glue = "StepDefinition"
		)

public class testRunner {
	

}
