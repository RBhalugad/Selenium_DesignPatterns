package com.randhir.template;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoShopping extends ShoppingTemplate {

	private WebDriver driver;
	private WebDriverWait wait;
	private String product;

	@FindBy(xpath = "//input[@id='small-searchterms']")
	private WebElement searchBox;

	@FindBy(css = "input.search-box-button")
	private WebElement searchButton;

	@FindBy(xpath = "(//div[@class='search-results']//a)[2]")
	private WebElement item;

	@FindBy(css = "span.price-value-31")
	private WebElement price;

	@FindBy(css = "input#add-to-cart-button-31")
	private WebElement addToCart;

	public DemoShopping(WebDriver driver, String product) {
		this.driver = driver;
		this.product = product;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}

	@Override
	public void launchSite() {
		this.driver.get("https://demowebshop.tricentis.com");
	}

	@Override
	public void searchProduct() {
		this.wait.until((d) -> this.searchBox.isDisplayed());
		this.searchBox.click();
		this.searchBox.sendKeys(this.product);
		this.searchButton.click();
	}

	@Override
	public void selectProduct() {
		this.wait.until((d) -> this.item.isDisplayed());
		this.item.click();
	}

	@Override
	public void buy() {
		this.wait.until((d) -> this.price.isDisplayed());
		System.out.println(this.price.getText());
		this.addToCart.click();

	}

}
