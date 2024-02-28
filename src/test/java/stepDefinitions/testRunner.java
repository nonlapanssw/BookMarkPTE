package stepDefinitions;

import io.cucumber.junit.*;
import org.junit.runner.*;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/FeatureFile", glue={"StepDefinitions"})

public class testRunner {

}
