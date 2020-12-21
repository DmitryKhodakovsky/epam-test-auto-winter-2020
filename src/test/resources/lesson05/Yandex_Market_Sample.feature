Feature: Yandex Marker Sample
  In order to find certain products
  As a user
  I want to search products by name

  Background:
    Given I am on Yandex Market page

  Scenario: Search iphone product
    When I search 'iPhone' in Search bar on Yandex Market page
    Then product titles should contain 'iPhone' on Yandex Market Catalog page

  Scenario: Add products to compare
    Given I open 'Ноутбуки' subcategory in 'Компьютеры' category in Top level menu on the Yandex Market page
    When I add 1,2 products to compare list on Yandex Market Catalog page
    Then added products should be displayed on Yandex Market Compare page

  Scenario Outline: Add products to compare
    Given I open '<subcategory>' subcategory in '<category>' category in Top level menu on the Yandex Market page
    When I add <compare items> products to compare list on Yandex Market Catalog page
    Then added products should be displayed on Yandex Market Compare page

    Examples:
      | category        | subcategory  | compare items |
      | Компьютеры      | Ноутбуки     | 1,2           |
      | Бытовая техника | Холодильники | 1,2,3         |
      | Электроника     | Смартфоны    | 1,2,3,4       |
