package com.randhir.strategy;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Paypal implements PaymentOption {

	@FindBy(id = "paypal_username")
	private WebElement pp_Uname;

	@FindBy(id = "paypal_password")
	private WebElement pp_Pwd;

	@Override
	public void enterPaymentinformation(Map<String, String> paymentDetails) {
		this.pp_Uname.sendKeys(paymentDetails.get("pp_uname"));
		this.pp_Pwd.sendKeys(paymentDetails.get("pp_pwd"));

	}

}
