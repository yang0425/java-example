Feature: Hello World

  Background:
    * url helloWorldUrl

  Scenario: hello world
    Given request
    When method get
    Then status 200
    And match response == { message: 'Hello World!' }