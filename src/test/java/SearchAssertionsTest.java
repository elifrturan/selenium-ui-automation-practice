import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchAssertionsTest {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
    }

    @Test
    public void searchWithKeyword_shouldDisplayResults() {
        driver.get("https://www.shop.demoqa.com");

        driver.findElement(By.cssSelector(".noo-search")).click();

        WebElement searchBox = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("s"))
        );
        searchBox.sendKeys("DRESS");
        searchBox.sendKeys(Keys.ENTER);

        WebElement resultText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.className("woocommerce-result-count")
                )
        );

        Assert.assertTrue(resultText.isDisplayed());
        Assert.assertTrue(resultText.getText().contains("results"));

        // Example of alternative assertion strategies:
        // Assert.assertEquals("Showing all 16 results", resultText.getText());
        // Assert.assertTrue(resultText.getText().contains("16"));
        // Assert.assertFalse(resultText.getText().contains("18"));
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
