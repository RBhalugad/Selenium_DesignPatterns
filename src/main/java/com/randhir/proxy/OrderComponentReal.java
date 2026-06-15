package com.randhir.proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderComponentReal implements OrderComponent {

  @FindBy(id = "buy")
  private WebElement buyNowbutton;

  @FindBy(id = "ordernumber")
  private WebElement orderNumber;

  public OrderComponentReal(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  @Override
  public String placeOrder() {
    this.buyNowbutton.click();
    return this.orderNumber.getText();
  }
}
