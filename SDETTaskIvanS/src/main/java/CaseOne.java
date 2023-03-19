import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CaseOne {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:/SelDriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(option);
    }
}
