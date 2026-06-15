package com.randhir.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GoogleArabic extends GoogleEnglish {

  @FindBy(css = "div#SIvCob>*:first-child")
  private WebElement arabic;

  @FindBy(css = "span.ly0Ckb, .hpuQDe, span.FIt7M")
  private WebElement keyBoardButton;

  @FindBy(css = "div#kbd")
  private WebElement keyBoard;

  @FindBy(css = "button#K84")
  private WebElement keyBoardKey;

  public GoogleArabic(WebDriver driver) {
    super(driver);
  }

  @Override
  public void launchSite() {
    this.driver.get("https://www.google.com.sa");
    this.wait.until((d) -> this.arabic.isDisplayed());
    this.arabic.click();
  }

  @Override
  public void search(String keyword) {
    try {
      this.wait.until((d) -> this.keyBoardButton.isDisplayed());
      this.keyBoardButton.click();
      this.wait.until((d) -> this.keyBoard.isDisplayed());
    } catch (Exception e) {
      // Ignore if virtual keyboard isn't present
    }
    super.search(keyword);
  }
}
