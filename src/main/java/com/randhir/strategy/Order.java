package com.randhir.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Order {

  @FindBy(id = "buy")
  private WebElement buyNowbutton;

  @FindBy(id = "ordernumber")
  private WebElement orderNumber;

  public Order(final WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public String getOrderNumber() {
    this.buyNowbutton.click();
    return this.orderNumber.getText();
  }
}
