Feature: Create Repository
  Feature to create repo

  Scenario Outline: Create a public repository
    Given Header "Authorization" has value "Bearer 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"
    And JSON Payload is as below
    |name|description|private|
    |<name>|<description>|<private>|
    When "POST" request is executed
		Then Verify status code is 201
		And Validate Response body
	
	Examples:
		|name|description|private|
    |Framework_Repo1|This repo is from framework1|true|
    |Framework_Repo2|This repo is from framework2|false|