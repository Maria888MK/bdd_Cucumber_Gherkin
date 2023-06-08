Feature: Super Smoothie Loyalty Card Program

  The more smoothies you buy, the more points you earn.

  Background:
    Given the following drink categories:
      | Drink              | Category | Points |
      | Banana             | Regular  | 15     |
      | Triple Berry Blend | Fancy    | 20     |
      | Earl Grey          | Tea      | 10     |

  Scenario Outline: Earning points when purchasing smoothies
    Given Oskar is Morning Freshness Member
    When Oskar purchases <Quantity> <Drink> drinks
    Then he should earn <Points> points

    Examples:
      | Drink              | Quantity | Points |
      | Banana             | 2        | 15     |
      | Triple Berry Blend | 1        | 20     |
      | Earl Grey          | 3        | 30     |
#    to reformat entries in the table- select and press option+shift+command+L