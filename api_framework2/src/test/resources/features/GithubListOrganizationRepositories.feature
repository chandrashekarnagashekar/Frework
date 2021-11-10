Feature: List the organization repositories
	Description of the feature.
	
	Scenario Outline: List repositories of organization
		This scenario will list all the repositories of an organization with GET request
		
		Given Header "Authorization" has value "<Auth>"
		And Query parameter "type" has value "<type>"
		And Query parameter "per_page" has value "<per_page>"		
		And Query parameter "page" has value "<page>"
		When "GET" request is executed
		Then Verify status code is 200
		
		Examples:
			|Auth|type|per_page|page|count|
			|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|private|||5|
			|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|public|||10|
			|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|private|2|1|0|
			|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|public|2|1|2|