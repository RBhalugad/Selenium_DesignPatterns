package com.randhir.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GoogleFrench extends GoogleEnglish {

  @FindBy(xpath = "//a[contains(text(),'Fran') or contains(text(),'fran')]")
  private WebElement french;

  public GoogleFrench(WebDriver driver) {
    super(driver);
  }

  @Override
  public void launchSite() {
    this.driver.get("https://www.google.fr");
    this.wait.until((d) -> this.french.isDisplayed());
    this.french.click();
  }

  @Override
  public int getResultCount() {
    return 0;
  }
}
