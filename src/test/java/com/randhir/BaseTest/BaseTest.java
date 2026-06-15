package com.randhir.BaseTest;

import com.google.common.util.concurrent.Uninterruptibles;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

  protected WebDriver driver;

  @BeforeTest
  public void setUpDriver() {
    // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
    // + "//Driver//chromedriver.exe");
    WebDriverManager.chromedriver().setup();
    this.driver = new ChromeDriver();
    this.driver.manage().window().maximize();
  }

  @AfterTest
  public void quitDriver() {
    Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
    this.driver.quit();
  }
}
