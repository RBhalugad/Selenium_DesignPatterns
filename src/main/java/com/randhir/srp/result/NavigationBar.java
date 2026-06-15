package com.randhir.srp.result;

import com.randhir.srp.common.AbstractComponent;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractComponent {

  @FindBy(css = "#hdtb-msb a, div.YmvwI, div[role='navigation'] a")
  private List<WebElement> navigationBarOptions;

  public NavigationBar(final WebDriver driver) {
    super(driver);
  }

  public void goToSelectedoptions(String option) {
    if (navigationBarOptions.size() >= 3)
      this.navigationBarOptions.stream()
          .filter(o -> o.getText().trim().equalsIgnoreCase(option))
          .collect(Collectors.toList())
          .get(0)
          .click();
  }

  @Override
  public boolean isDisplayed() {
    return this.wait.until((d) -> this.navigationBarOptions.size() >= 3);
  }
}
