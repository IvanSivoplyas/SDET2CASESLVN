package com.qa.browserstack.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestOneCase {

  WebDriver driver;
  Properties prop;

  @Test
  public void login() {
    System.setProperty(
        "webdriver.chrome.driver",
        "C:\\Users\\ADMIN\\Documents\\chromedriver.exe");
    // Instantiate a ChromeDriver class.
    WebDriver driver = new ChromeDriver();

    // Maximize the browser
    driver.manage().window().maximize();

    // Launch Website
    driver.get("https://www.geeksforgeeks.org/");
  }

  public WebDriver initDriver(Properties prop) {

    String browser = prop.getProperty("browser");

    if(browser.equals("chrome"))
    {
      ChromeOptions option = new ChromeOptions();
      option.addArguments("incognito");
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver(option);

    }else if(browser.equals("firefox"))
    {

      WebDriverManager.firefoxdriver().setup();
      driver = new FirefoxDriver();

    }
    else
    {
      System.out.println("Please provide a proper browser value..");
    }

    driver.manage().window().fullscreen();
    driver.manage().deleteAllCookies();
    driver.get(prop.getProperty("url"));

    return driver;
  }

  public Properties initProperties()
  {
    prop = new Properties();
    try {
      FileInputStream ip = new FileInputStream("Properties File Path");
      prop.load(ip);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }catch (IOException e)
    {
      e.printStackTrace();
    }

    return prop;


  }
}