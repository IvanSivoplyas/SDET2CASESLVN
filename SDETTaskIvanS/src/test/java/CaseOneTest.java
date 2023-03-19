import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
public class CaseOneTest {
  WebDriver driver = new ChromeDriver();
  @Test
  public void testExamplePageOnMultipleBrowsersOnChrome () {
    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    ChromeOptions option = new ChromeOptions();
    option.addArguments("--remote-allow-origins=*");
    WebDriver driver = new ChromeDriver(option);
    //WebDriverManager.chromedriver().setup();

    driver.get("https://www.saucedemo.com/");
    WebElement inputLogin = driver.findElement(By.id("user-name"));
    WebElement inputPass = driver.findElement(By.id("password"));
    inputLogin.sendKeys("standard_user");
    inputPass.sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();
    WebElement inventoryList = driver.findElement(By.className("inventory_list"));
    WebElement firstElement = inventoryList.findElements(By.className("inventory_item")).stream().findFirst()
        .orElseThrow(() -> new NotFoundException("No such element!"));
    firstElement.findElement(By.className("btn")).click();
    driver.findElement(By.id("shopping_cart_container")).click();
    driver.findElement(By.id("checkout")).click();
    driver.findElement(By.id("first-name")).sendKeys("test");
    driver.findElement(By.id("last-name")).sendKeys("test");
    driver.findElement(By.id("postal-code")).sendKeys("test");
    driver.findElement(By.id("continue")).click();
    driver.findElement(By.id("finish")).click();
    System.out.println("Chrome: " + driver.getTitle());
  }
  @Test
  public void testExamplePageOnMultipleBrowsersOnFirefox () {
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get("https://www.saucedemo.com/");
    WebElement inputLogin = driver.findElement(By.id("user-name"));
    WebElement inputPass = driver.findElement(By.id("password"));
    inputLogin.sendKeys("standard_user");
    inputPass.sendKeys("secret_sauce");
    driver.findElement(By.id("login-button")).click();
    WebElement inventoryList = driver.findElement(By.className("inventory_list"));
    WebElement firstElement = inventoryList.findElements(By.className("inventory_item")).stream().findFirst()
            .orElseThrow(() -> new NotFoundException("No such element!"));
    firstElement.findElement(By.className("btn")).click();
    driver.findElement(By.id("shopping_cart_container")).click();
    driver.findElement(By.id("checkout")).click();
    driver.findElement(By.id("first-name")).sendKeys("test");
    driver.findElement(By.id("last-name")).sendKeys("test");
    driver.findElement(By.id("postal-code")).sendKeys("test");
    driver.findElement(By.id("continue")).click();
    driver.findElement(By.id("finish")).click();
    System.out.println("Chrome: " + driver.getTitle());
  }
//
//  @Test
//  public void testExamplePageOnMultipleBrowsersOnEdge () {
//    WebDriverManager.edgedriver().setup();
//    driver = new EdgeDriver();
//    driver.manage().window().maximize();
//    driver.get("https://www.saucedemo.com/");
//    WebElement inputLogin = driver.findElement(By.className("input_error form_input"));
//    inputLogin.sendKeys("standard_user");
//
//    System.out.println("Chrome: " + driver.getTitle());
//  }
}

