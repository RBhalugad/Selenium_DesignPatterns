package com.randhir.template.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PcommerceResultPage {

	private WebDriverWait wait;

	@FindBy(xpath = "(//div[@class='search-results']//a)[2]")
	private WebElement item;

	public PcommerceResultPage(WebDriver driver) {
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public void selectProduct() {
		this.wait.until((d) -> this.item.isDisplayed());
		this.item.click();
	}

}
