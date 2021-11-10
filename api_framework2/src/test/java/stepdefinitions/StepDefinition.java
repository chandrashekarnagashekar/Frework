package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojoclasses.GithubCreateRepoPojo;
import pojoclasses.GithubCreateResponsePojo;
import utils.PojoHelper;

public class StepDefinition{
		
	RequestSpecification reqSpecification;	
	Response resp;		
	
	@Given("Header {string} has value {string}")
	public void header_has_value(String string, String string2) {		
		reqSpecification = RestAssured.given();
		reqSpecification.header(string, string2);
	    System.out.println("Executing Given");	    
	}
	@And("Query parameter {string} has value {string}")
	public void query_parameter_has_value(String string, String string2) {
		if(!string2.isEmpty())
			reqSpecification.queryParam(string, string2);
	}
	@And("^JSON Payload is as below$")
	public void json_payload(DataTable table) {
		List<Map<String, String>> paramMaps = table.asMaps();
		String nm = paramMaps.get(0).get("name");
		Map<String, String> mapData = paramMaps.get(0);
		System.out.println(nm);
		
		List<String> payloadList = table.asList();
//		String nm = payloadList.get(0);
//		System.out.println(nm);
//		String desc = payloadList.get(1);
//		System.out.println(desc);
		GithubCreateRepoPojo obj = PojoHelper.getCreateRepoPojoObject(mapData);

//		List<List<String>> payloadData = table.asLists();
//		GithubCreateRepoPojo obj = new GithubCreateRepoPojo();
//		obj.setName(payloadData.get(1).get(0));
//		obj.setDescription(payloadData.get(1).get(1));
		reqSpecification.body(obj);
	}
	
	@When("{string} request is executed")
	public void request_is_executed(String string) {
		switch(string) {
			case "GET":
				resp = reqSpecification					
				.when()
					.log().all()
					.get("orgs/orgchandra/repos");
				break;
			case "POST":
				resp = reqSpecification					
				.when()
					.log().all()
					.post("orgs/orgchandra/repos");
				break;
		}
		
	    System.out.println("Executing When");
	}
	@Then("Verify status code is {int}")
	public void verify_status_code_is(Integer int1) {
		//resp.then().log().all();
		ExtentCucumberAdapter.addTestStepLog("---------------Response Header -----------------");
		ExtentCucumberAdapter.addTestStepLog(resp.getHeaders().toString());
		ExtentCucumberAdapter.addTestStepLog("---------------Response Body -----------------");
		ExtentCucumberAdapter.addTestStepLog(resp.body().asPrettyString());
		MatcherAssert.assertThat(resp.statusCode(), Matchers.equalTo(int1));
	    System.out.println("Executing Then");
	}	
	
	@And("Validate Response body")
	public void validate_resp_body() {
		GithubCreateResponsePojo respObj = resp.as(GithubCreateResponsePojo.class);
//		MatcherAssert.assertThat(resp.statusCode(), Matchers.equalTo(int1));
//		respObj.getName()
	}
	
}
