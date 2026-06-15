package com.randhir.BaseTest;

import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

  protected WebDriver driver;

  @BeforeTest
  public void setUpDriver() {
    // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
    // + "//Driver//chromedriver.exe");
    
    // We can rely on Selenium 4.6.0+ built-in Selenium Manager to handle drivers automatically!
    ChromeOptions options = new ChromeOptions();
    // In GitHub Actions (CI), we typically need some extra arguments to ensure Chrome doesn't crash
    if (System.getenv("GITHUB_ACTIONS") != null) {
        options.addArguments("--headless=new");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
    }
    
    this.driver = new ChromeDriver(options);
    this.driver.manage().window().maximize();
  }

  @AfterTest
  public void quitDriver() {
    Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    this.driver.quit();
  }
}
