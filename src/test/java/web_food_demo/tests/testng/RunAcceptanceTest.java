package web_food_demo.tests.testng;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"classpath:/feature"})
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {
}

