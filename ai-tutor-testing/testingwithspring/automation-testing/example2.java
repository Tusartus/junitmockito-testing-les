/*

Yes, it is possible to use both Google Chrome and Microsoft Edge 
(formerly known as Microsoft Internet Explorer) for your tests with 
Selenium. To use both browsers, you would need to create two separate 
test classes, each with its own setUp and tearDown methods. In each 
setUp method, you would create a different type of WebDriver instance,
 depending on the browser you want to 
use for that test class. For example:


*/




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChromeTest {
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

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}

public class EdgeTest {
  private WebDriver driver;

  @BeforeMethod
  public void setUp() {
    System.setProperty("webdriver.edge.driver", "/path/to/edgedriver");
    driver = new EdgeDriver();
  }

  @Test
  public void testGoogleSearch() {
    driver.get("http://www.google.com");
    // Perform actions on the page
    // ...
    // Verify results
    // ...
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}
