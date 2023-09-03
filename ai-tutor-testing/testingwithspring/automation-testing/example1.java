import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumTest {
  private WebDriver driver;

  @BeforeMethod
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
    driver = new ChromeDriver();
  }

  @Test
  public void testGoogleSearch() {
    driver.get("http://www.google.com");
    // Perform actions on the page
    // ...
    // Verify results
    // ...
  }















  /*

In this example, we are using the Chrome browser for our test. The setUp 
method is annotated with @BeforeMethod and it is used to set up the WebDriver 
before each test method is executed. The tearDown method is annotated 
with @AfterMethod and it is used to clean up the
 WebDriver after each test method is executed.

The testGoogleSearch method is annotated with @Test and it is where we 
write our actual test logic. In this case, we are navigating to the 
Google homepage and performing some actions on the page.

When you run this test class with TestNG, the setUp method will be 
executed before each test method, and the tearDown method will be executed 
after each test method. This allows you to write tests that are isolated
 from each other and ensures that the state of the browser is reset between tests.



  */

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}
