package com.randhir.srp.common;

import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchWidget extends AbstractComponent {

  @FindBy(name = "q")
  private WebElement searchBox;

  public SearchWidget(final WebDriver driver) {
    super(driver);
  }

  public void enterInSearchBox(String keyword) {
    this.searchBox.clear();
    for (char ch : keyword.toCharArray()) {
      Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MILLISECONDS);
      this.searchBox.sendKeys(ch + "");
    }
  }

  @Override
  public boolean isDisplayed() {
    return this.wait.until((d) -> this.searchBox.isDisplayed());
  }
}
