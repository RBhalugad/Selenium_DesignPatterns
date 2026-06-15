package com.randhir.factory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

class GoogleEnglish extends GooglePage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	@FindBy(name = "q")
	private WebElement searchBox;

	@FindBy(name = "btnK")
	private WebElement searchButton;

	@FindBy(css = "div.MjjYud")
	private List<WebElement> searchResults;

	public GoogleEnglish(final WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}

	@Override
	public void launchSite() {
		this.driver.get("https://www.google.com");
	}

	@Override
	public void search(String keyword) {
		this.searchBox.sendKeys(keyword);
		this.wait.until((d) -> this.searchButton.isDisplayed());
		this.searchButton.click();
	}

	@Override
	public int getResultCount() {
		this.wait.until((d) -> this.searchResults.size() > 1);
		return this.searchResults.size();
	}

}
