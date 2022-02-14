Feature: Candidate Test

  Background:
    Given the user should be on the home page

  @scen1 @all
  Scenario Outline: User add a product to the cart and login
    When the user navigates to "<Main Category>" page
    And the user can select category as a "<Sub Category>"
    And the user can select one product in current category as "<Product Name>"
    And the user can select product specifications as size "<Size>"
    And the user add can a product to the cart
    And the user navigates login page
    And the user should be able to login with valid credentials
    And the user navigates cart page
    Then the added_product should be correctly on page

    Examples:
      | Main Category | Sub Category | Product Name | Size |
      | SCHUHE        | SNEAKERS     | BALENCIAGA   | 40   |

  @scen2 @all
  Scenario Outline: User modify user information
    When the user navigates login page
    And the user should be able to login with valid credentials
    And the user modify name "<First Name>" and lastname "<Last Name>"
    Then Changes should be correctly saved

    Examples:
      | First Name | Last Name |
      | John       | Smith     |

  @scen3 @all
  Scenario Outline: User apply voucher
    When the user navigates to "<Main Category>" page
    And the user can select one product as "<Product Brand>"
    And the user verify product and add to the cart
    And the user navigates login page
    And the user should be able to login with valid credentials
    And the user navigates cart page
    And the selected_tasche on cart page
    And the user can apply "<Voucher Code>"
    Then voucher should be properly applied

    Examples:
      | Main Category | Product Brand | Voucher Code |
      | TASCHEN       | SAINT LAURENT | qachallenge  |





