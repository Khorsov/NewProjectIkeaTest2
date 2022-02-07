Feature: Validate invalid message discount functionality


  Scenario: Validate amount of products added to Shipping Cart
    Given User on the Shipping Cart page
    Then User can see correct amount of products that added

  Scenario: User picks the table
    Given the user on the main page search table at the bar
    When User clicks on Use a discount code
    And User add discount code
    And User Click Apply discount
    Then Invalid coupon code error message is displayed


