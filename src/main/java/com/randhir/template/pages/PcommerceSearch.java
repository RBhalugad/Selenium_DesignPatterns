package com.randhir.template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PcommerceSearch {

  private WebDriver driver;

  @FindBy(id = "small-searchterms")
  private WebElement searchBox;

  @FindBy(css = "button.search-box-button")
  private WebElement searchButton;

  public PcommerceSearch(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  public void goTo() {
    this.driver.get("https://demo.nopcommerce.com");
  }

  public void searchProduct(String product) {
    this.searchBox.sendKeys(product);
    this.searchButton.click();
  }
}
