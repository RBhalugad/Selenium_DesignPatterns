package com.randhir.srp.result;

import com.randhir.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultStats extends AbstractComponent {

  @FindBy(xpath = "//div[@id='search']")
  private WebElement searchResult;

  public ResultStats(WebDriver driver) {
    super(driver);
  }

  @Override
  public boolean isDisplayed() {
    return this.wait.until((d) -> this.searchResult.isDisplayed());
  }
}
