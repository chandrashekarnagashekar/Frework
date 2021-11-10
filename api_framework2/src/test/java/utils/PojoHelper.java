package utils;

import java.util.List;
import java.util.Map;

import pojoclasses.GithubCreateRepoPojo;

public class PojoHelper {

	public static GithubCreateRepoPojo getCreateRepoPojoObject(Map<String, String> payloadString) {
		GithubCreateRepoPojo createRepoPojo = new GithubCreateRepoPojo();
		//System.err.println(payloadString.get(0));
		
		createRepoPojo.setName(payloadString.get("name"));
		createRepoPojo.setDescription(payloadString.get("description"));			
		createRepoPojo.setPrivateVal(Boolean.parseBoolean(payloadString.get("private")));
		
		return createRepoPojo;
	}
}
