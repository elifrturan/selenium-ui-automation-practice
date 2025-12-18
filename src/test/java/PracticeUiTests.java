import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PracticeUiTests {
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
    public void loginWithValidCredentials_shouldLoginSuccessfully() {
        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        wait.until(ExpectedConditions.urlContains("logged-in-successfully"));
        Assert.assertTrue(driver.getCurrentUrl().contains("logged-in-successfully"));
    }

    @Test
    public void exceptionPage_shouldAddNewRowSuccessfully() {
        driver.get("https://practicetestautomation.com/practice-test-exceptions/");

        driver.findElement(By.id("edit_btn")).click();
        driver.findElement(By.id("add_btn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("row2")));
        Assert.assertTrue(driver.findElement(By.id("row2")).isDisplayed());
    }

    // Example of temporarily disabling a test when it is blocked by an issue
    // @Ignore("Disabled due to known issue: TEST-123")

    // Example of JUnit timeout usage (not preferred for UI tests)
    // @Test(timeout = 2000)

    @Test
    public void googleHomePage_shouldHaveCorrectTitle() {
        driver.get("https://www.google.com");

        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
