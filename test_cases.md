# Drag and Drop Functionality Test Cases  

## Overview  
This document outlines the test cases for the drag-and-drop functionality on the specified web page. The tests are designed to validate the behavior of dragging elements between two boxes and ensure that the application behaves as expected.  

## Test Environment  
- **Test Page URL**: [Drag and Drop Page](https://the-internet.herokuapp.com/drag_and_drop)  
- **WebDriver**: ChromeDriver  
- **Browser**: Google Chrome  

## Test Cases  

### Test Case 1: Drag from Box A to Box B  
- **Test Case ID**: DD_00  
- **Description**: Validate that an item can be successfully dragged from Box A to Box B.  
- **Preconditions**:   
  - Box A contains "A"  
  - Box B contains "B"  
- **Steps**:  
  1. Open the Drag and Drop page.  
  2. Drag the element from Box A to Box B.  
- **Expected Result**:   
  - Box A should contain "B".  
  - Box B should contain "A".  

### Test Case 2: Drag from Box B to Box A  
- **Test Case ID**: DD_01  
- **Description**: Ensure that an item can be dragged back from Box B to Box A.  
- **Preconditions**:   
  - Box A contains "B"  
  - Box B contains "A"  
- **Steps**:  
  1. Open the Drag and Drop page.  
  2. Drag the element from Box B to Box A.  
- **Expected Result**:   
  - Box A should contain "A".  
  - Box B should contain "B".  

### Test Case 3: Drag Box A Outside the Drag Zone  
- **Test Case ID**: DD_02 
- **Description**: Test the behavior when attempting to drag Box A outside the designated drag area.   
- **Steps**:  
  1. Open the Drag and Drop page.  
  2. Drag Box A outside the drag zone.  
- **Expected Result**:   
  - Box A should still contain "A".  
  - No error message should appear.  

### Test Case 4: Drag Box B Outside the Drag Zone  
- **Test Case ID**: DD_03 
- **Description**: Test the behavior when attempting to drag Box B outside the designated drag area.  
- **Steps**:  
  1. Open the Drag and Drop page.  
  2. Drag Box B outside the drag zone.  
- **Expected Result**:   
  - Box B should still contain "B".  
  - No error message should appear.  


