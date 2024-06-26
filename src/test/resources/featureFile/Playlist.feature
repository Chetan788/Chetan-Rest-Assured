Feature: validating Playlist API

  Scenario: Varify Create Playlist is working
    Given Create Playlist API Payload
    When User call with POST https request
    Then API call executed with 201 status code

  Scenario: Varify fetch Scenario Functionality is Working
    Given Get Palylist payload
    When user call with GET https request
    Then API Call should executed with 200 status code

  Scenario: varify update playlist functionality is working
    Given update plalist payload
    When user call  PUT https request
    Then API call executes with 200 status code
