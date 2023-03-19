import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaseTwoTest {




    WebDriver driver = new ChromeDriver();


    @Test
    public void entranceShouldBeFalseOnChrome(){
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(option);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement inputLogin = driver.findElement(By.id("user-name"));
        WebElement inputPass = driver.findElement(By.id("password"));
        inputLogin.sendKeys("test");
        inputPass.sendKeys("test");
        driver.findElement(By.id("login-button")).click();
    }
    @Test
    public void entranceShouldBeFalseOnFirefox () {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement inputLogin = driver.findElement(By.id("user-name"));
        WebElement inputPass = driver.findElement(By.id("password"));
        inputLogin.sendKeys("test");
        inputPass.sendKeys("test");
        driver.findElement(By.id("login-button")).click();
        System.out.println("Chrome: " + driver.getTitle());
    }

    @Test
    public void entranceShouldBeFalseOnEdge () {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebElement inputLogin = driver.findElement(By.id("user-name"));
        WebElement inputPass = driver.findElement(By.id("password"));
        inputLogin.sendKeys("test");
        inputPass.sendKeys("test");
        driver.findElement(By.id("login-button")).click();
        System.out.println("Chrome: " + driver.getTitle());
    }
  }

