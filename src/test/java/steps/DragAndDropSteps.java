package steps;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class DragAndDropSteps {
    private static WebDriver driver;
    private static final String BASE_URL = "https://the-internet.herokuapp.com/drag_and_drop"; // Test page URL

    @BeforeAll
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/PC/Downloads/chromedriver-win32/chromedriver.exe");//Add path for chromedriver
        driver = new ChromeDriver();
        driver.get(BASE_URL); // Navigate to the Drag and Drop page
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit(); // Close the browser after tests
        }
    }

    @Given("I open the Drag and Drop page")
    public void i_open_the_drag_and_drop_page() {
        // Initial setup is handled in setUp()
    }

    @When("I drag the element from box A to box B")
    public void i_drag_the_element_from_box_A_to_box_B() {
        // Perform drag-and-drop action from box A to box B
        WebElement sourceElement = driver.findElement(By.id("column-a"));
        WebElement targetElement = driver.findElement(By.id("column-b"));
        new Actions(driver).dragAndDrop(sourceElement, targetElement).perform();
        waitForAction(); // Wait for the action to complete
    }

    @When("I drag the element from box B to box A")
    public void i_drag_the_element_from_box_B_to_box_A() {
        // Perform drag-and-drop action from box B to box A
        WebElement sourceElement = driver.findElement(By.id("column-b"));
        WebElement targetElement = driver.findElement(By.id("column-a"));
        new Actions(driver).dragAndDrop(sourceElement, targetElement).perform();
        waitForAction(); // Wait for the action to complete
    }

    @When("I drag the element from box A outside the drag zone")
    public void i_drag_the_element_from_box_A_outside_the_drag_zone() {
        // Perform drag action of box A outside the valid drop area
        WebElement sourceElement = driver.findElement(By.id("column-a"));
        new Actions(driver).clickAndHold(sourceElement).moveByOffset(100, 100).release().perform();
    }

    @When("I drag the element from box B outside the drag zone")
    public void i_drag_the_element_from_box_B_outside_the_drag_zone() {
        // Perform drag action of box B outside the valid drop area
        WebElement sourceElement = driver.findElement(By.id("column-b"));
        new Actions(driver).clickAndHold(sourceElement).moveByOffset(100, 100).release().perform();
    }

    @Then("box A should contain {string}")
    public void box_A_should_contain(String expectedValue) {
        // Assert that box A contains the expected value after the drag-and-drop action
        String boxAValue = driver.findElement(By.id("column-a")).getText();
        Assert.assertEquals(expectedValue, boxAValue);
    }

    @Then("box B should contain {string}")
    public void box_B_should_contain(String expectedValue) {
        // Assert that box B contains the expected value after the drag-and-drop action
        String boxBValue = driver.findElement(By.id("column-b")).getText();
        Assert.assertEquals(expectedValue, boxBValue);
    }

    @Then("box A should still contain {string}")
    public void box_A_should_still_contain(String expectedValue) {
        // Verify box A still contains the expected value after further actions
        String boxAValue = driver.findElement(By.id("column-a")).getText();
        Assert.assertEquals(expectedValue, boxAValue);
    }

    @Then("box B should still contain {string}")
    public void box_B_should_still_contain(String expectedValue) {
        // Verify box B still contains the expected value after further actions
        String boxBValue = driver.findElement(By.id("column-b")).getText();
        Assert.assertEquals(expectedValue, boxBValue);
    }

    private void waitForAction() {
        // Pause execution to allow for UI updates after actions
        try {
            Thread.sleep(3000); // Wait for 3 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }
}