package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import utils.PropertiesHelper;

public class TestBase {
	
	@Before
	public void executeBeforeScenario() {
		String baseUrl = PropertiesHelper.getProperty("BASE_URI");
		RestAssured.baseURI = baseUrl;
		System.out.println("---- Before scenario ----");
	}
	
	@After
	public void executeAfterScenario() {
		System.out.println("---- After scenario ----");
	}
}
