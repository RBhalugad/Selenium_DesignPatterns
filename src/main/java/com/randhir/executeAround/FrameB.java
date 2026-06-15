package com.randhir.executeAround;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameB {

  @FindBy(name = "fn")
  private WebElement firstName;

  @FindBy(name = "ln")
  private WebElement lastName;

  @FindBy(name = "addr")
  private WebElement address;

  @FindBy(id = "area")
  private WebElement message;

  public void setFirstName(String fName) {
    this.firstName.sendKeys(fName);
  }

  public void setLastName(String lName) {
    this.lastName.sendKeys(lName);
  }

  public void setAddress(String address) {
    this.address.sendKeys(address);
  }

  public void setMessage(String message) {
    this.message.sendKeys(message);
  }
}
