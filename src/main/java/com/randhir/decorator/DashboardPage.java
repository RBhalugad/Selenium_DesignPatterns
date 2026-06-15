package com.randhir.decorator;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DashboardPage {
	private WebDriver driver;

	@FindBy(xpath = "//select[@id='role']")
	private WebElement roleSelector;

	@FindBy(css = "div.guest")
	private List<WebElement> guestComponent;

	@FindBy(css = "div.superuser")
	private List<WebElement> superUserComponent;

	@FindBy(css = "div.admin")
	private List<WebElement> adminComponent;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goTo() {
		driver.get("https://vins-udemy.s3.amazonaws.com/ds/decorator.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void selectRole(String role) {
		Select select = new Select(this.roleSelector);
		select.selectByValue(role);
	}

	public List<WebElement> getAdminComponents() {
		return this.adminComponent;
	}

	public List<WebElement> getSuperUserComponents() {
		return this.superUserComponent;
	}

	public List<WebElement> getGuestComponents() {
		return this.guestComponent;
	}

}
