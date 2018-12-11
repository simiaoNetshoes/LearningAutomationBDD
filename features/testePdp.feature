@FullSmoke @ShortSmoke @PDP @Vitrine
Feature: Product Page

  In order to check a product
  A user
  should be able to choose on pdp the attributes that fits better

  @SA-1 @OPEN @QA1 @MANUAL
  Scenario Outline: Change colors and sizes
    Given que estou na loja
    When seleciono o produto "<sku>" [--Pagina de Produto]
    And I check available colors [--ProductPage]
    And I check available sizes [--ProductPage]
    And acesso a pagina de carrinho [--Pagina Carrinho]
    
    Examples:
      | sku    |
      | random |

  @ORPHAN @this @MANUAL
  Scenario: Check persona
    Given que estou na loja
    And seleciono o produto "persona" [--Pagina de Produto]
    And seleciono um tamanho disponivel [--Pagina Produto]
    And I fill my persona product [--ProductPage]
    And acesso a pagina de carrinho [--Pagina Carrinho]
    And my product is successfully customized and properly charged [--CartPage]
    And I click to remove persona [--CartPage]
    Then my customization is successfully removed [--CartPage]

  @ORPHAN @QA1 @ignoreMobile @ignoreTeam
  Scenario Outline: Check size table
    Given que estou na loja
    When I do a search for "<sku>" [--SearchPage]
    And products will be found [--SearchPage]
    And I click on any result [--SearchPage]
    Then I click in the size table [--ProductPage]
    
    Examples:
      | sku   |
      | tenis |

  @ORPHAN @ignoreMobile
  Scenario: Check chaordic carousel
    Given que estou na loja
    When I check all carousel [--ProductPage]
    And I create a new user
    And I go to login page [--MenuUserPage]
    And I use this account to execute the test
    And I am successfully logged [--HomePage]
    And I go to home page
    Then I check all carousel [--ProductPage]

  @ORPHAN @ignoreMobile
  Scenario Outline: Check label free delivery in PDP
    Given que estou na loja
    And I create a new user
    And I go to login page [--MenuUserPage]
    And I use this account to execute the test
    And I am successfully logged [--HomePage]
    And I do a search for "<sku>" [--SearchPage]
    And I check the label free delivery is displayed [--SearchPage]
    And I open the product has a label free delivery [--SearchPage]
    Then I check the label free delivery is displayed [--ProductPage]
    
    Examples:
      | sku    |
      | random |

  @ORPHAN @ignoreMobile
  Scenario Outline: Check header login name
    Given que estou na loja
    When I create a new user
    And I go to login page [--MenuUserPage]
    And I use this account to execute the test
    And I am successfully logged [--HomePage]
    And seleciono o produto "<sku>" [--Pagina de Produto]
    And I check the login name in header is displayed [--ProductPage]
    And I do logout [--HomePage]
    And seleciono o produto "<sku>" [--Pagina de Produto]
    Then I check the login name in header is not displayed [--ProductPage]
    
    Examples:
      | sku    |
      | random |
