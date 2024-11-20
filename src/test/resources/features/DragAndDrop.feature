Feature: Drag and Drop Functionality

  Scenario: Drag from A to B
    Given I open the Drag and Drop page
    When I drag the element from box A to box B
    Then box A should contain "B"
    And box B should contain "A"

  Scenario: Drag from B to A
    Given I open the Drag and Drop page
    When I drag the element from box B to box A
    Then box A should contain "A"
    And box B should contain "B"


  Scenario: Drag from A outside the drag zone
    Given I open the Drag and Drop page
    When I drag the element from box A outside the drag zone
    Then box A should still contain "A"
    And box B should still contain "B"

  Scenario: Drag from B outside the drag zone
    Given I open the Drag and Drop page
    When I drag the element from box B outside the drag zone
    Then box A should still contain "A"
    And box B should still contain "B"