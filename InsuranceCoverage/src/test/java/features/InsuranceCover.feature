Feature: Insurance Coverage
Scenario Outline: Validate whether Vehicle have Valid insurance coverage
Given Initialize the browser 
And User navigates to Dealer Portal of Volkswagen
When User enters the <Registration number> of vehicle
And Clicks on Find Vehicle
Then Validate the Insurance cover Start date and End Date
Examples:
| Registration number |
|    OV12UYY          |
|    V12UAA           |

