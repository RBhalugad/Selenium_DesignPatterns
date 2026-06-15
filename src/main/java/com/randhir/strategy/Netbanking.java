package com.randhir.strategy;

import java.util.Map;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Netbanking implements PaymentOption {

  @FindBy(id = "bank")
  private WebElement selectBank;

  @FindBy(id = "acc_number")
  private WebElement accountNumber;

  @FindBy(id = "pin")
  private WebElement pin;

  @Override
  public void enterPaymentinformation(Map<String, String> paymentDetails) {

    Select bankDropDown = new Select(this.selectBank);
    bankDropDown.selectByValue(paymentDetails.get("bank"));
    this.accountNumber.sendKeys(paymentDetails.get("accountNumber"));
    this.pin.sendKeys(paymentDetails.get("pin"));
  }
}
