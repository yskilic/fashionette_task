
Feature: Candidate Test

  Background:
    Given the user should be on the home page

  Scenario Outline: User add a product to the cart and login
    When the user navigates to "<Main Category>" page
    And the user can select category as a "<Sub Category>"
    And the user can select one product in current category as "<Product Name>"
    And the user can select product specifications as size "<Size>" and color "<Color>"
    And the user add can a product to the cart
    And the user navigates login page
    And the user should be able to login with valid credentials
    And the user navigates cart page
    Then the added_product should be correctly on page

    Examples:
      | Main Category | Sub Category | Product Name      | Size | Color             |
      | SCHUHE        | SNEAKERS     | ALEXANDER MCQUEEN | 38   | White/Powder Blue |

  @wip
  Scenario Outline: User modify user information
    When the user navigates login page
    And the user should be able to login with valid credentials
    And the user modify name "<First Name>" and lastname "<Last Name>"
    Then Changes should be correctly saved

  Examples:
    | First Name | Last Name |
    | John       | Smith     |


#  Scenario : User apply voucher
#    When the user navigates to "SCHUHE" page

#  Scenario : User apply voucher
#
#    When the user navigates to "SCHUHE" page
#    And the user can select category as a "SNEAKERS"
#    And the user can select one product in current category as "ALEXANDER MCQUEEN"
#    And the user can select product specifications as size "38" and color "White/Powder Blue"
#    And the user add can a product to the cart
#    And the user navigates login page
#    And the user should be able to login with valid credentials
#    And the user navigates cart page
#    And the user apply the voucher "qachallange"
#    Then Voucher should be properly applied



