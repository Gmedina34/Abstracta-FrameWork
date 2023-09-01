package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/FeatureFiles/Challenge.feature/", 
                 glue = "Steps", 
                 tags = "@Test1")

public class SearchTshirts {

}
