Feature: Test Google UI
  Background:
    Given Web browser is accessed
    And browser navigates to Google.com
    Scenario: Verify Google logo, search bar, icons location
      Given Google website is opened
      Then Verify Google logo location
      And Search box location
      And Mic is displayed in its location
      And Mic is clickable
      And Arabic language option is available
      And Google sign in is clickable

    Scenario Outline: Verify that search box accepts letters and doing search
      Given User enter "<Data>" in search box
      Then click on google submit
      Then click on first link shown in results page
      Then Get url of this page
      Examples:
        | Data    |
        | youtube |

    Scenario Outline: Verify that I'm lucky button is working right
      Given User enter "<Data>" in search box
      Then Click on lucky button
      Then Get url of this page
      Examples:
        | Data    |
        | youtube |
    Scenario Outline: Verify that pagination tab is working
      Given User enter "<Data>" in search box
      Then click on google submit
      Then click on next page
      Examples:
        | Data    |
        | youtube |
    Scenario Outline: Testing Google image UI
      Given User click on images
      Then User enter "<Data>" in search box
      Then press enter
      Then Verify filter bar is displayed
      Examples:
        | Data |
        | Cars |

    Scenario: Verify that Google show user location
      Given Google website is opened
      Then show user location

