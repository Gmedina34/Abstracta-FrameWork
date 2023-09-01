Feature: Validate Competitive Prices on MercadoLibre

@Test1
Scenario: Obtain price information for shirts on MercadoLibre
Given that I am on the MercadoLibre homepage "https://www.mercadolibre.com"
When I select the search country
When I perform a search for "camisetas"
Then I obtain the item information from the first three pages
 