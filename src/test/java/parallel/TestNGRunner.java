package parallel;

import org.testng.annotations.*;
import dsutilities.ConfigReader;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/parallel"},
        glue = { "parallel"},
        monochrome = true,
        plugin = {"pretty",
        		"html:target/report.html",
        		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        		"timeline:test-output-thread/",
        		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
		
public class TestNGRunner extends AbstractTestNGCucumberTests {
    @BeforeTest
	@Parameters({"browser"})
	public void defineBrowser(String browser) throws Throwable{
		ConfigReader.setBrowserType(browser);
		System.out.println(browser);
	}
    
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}
