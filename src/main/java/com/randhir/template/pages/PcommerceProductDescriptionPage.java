package com.randhir.template.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PcommerceProductDescriptionPage {

	private WebDriverWait wait;

	@FindBy(css = "span#price-value-47")
	private WebElement price;

	@FindBy(id = "add-to-cart-button-47")
	private WebElement addToCart;

	public PcommerceProductDescriptionPage(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	public void buy() {
		this.wait.until((d) -> this.price.isDisplayed());
		System.out.println(this.price.getText());
		this.addToCart.click();

	}

}
