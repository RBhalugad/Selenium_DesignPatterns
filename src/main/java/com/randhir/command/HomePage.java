package com.randhir.command;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public final WebDriver driver;

	@FindBy(xpath = "//button[@class='tst1 btn btn-info']")
	private WebElement infoBtn;

	@FindBy(xpath = "//button[@class='tst2 btn btn-warning']")
	private WebElement warnBtn;

	@FindBy(xpath = "//button[@class='tst3 btn btn-success']")
	private WebElement successBtn;

	@FindBy(xpath = "//button[@class='tst4 btn btn-danger']")
	private WebElement dangerBtn;

	@FindBy(xpath = "//div[contains(@class,'jq-icon-info')]")
	private WebElement infoAlert;

	@FindBy(xpath = "//div[contains(@class,'jq-icon-warning')]")
	private WebElement warnAlert;

	@FindBy(xpath = "//div[contains(@class,'jq-icon-success')]")
	private WebElement successAlert;

	@FindBy(xpath = "//div[contains(@class,'jq-icon-error')]")
	private WebElement dangerAlert;

	// dismissal alert
	@FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-info")
	private WebElement dismissInfoAlert;

	@FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-success")
	private WebElement dismissSuccessAlert;

	@FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-danger")
	private WebElement dismissDangerAlert;

	@FindBy(css = "#main-wrapper > div > div > div:nth-child(3) > div > div > div > div > div:nth-child(2) > div.alert-warning")
	private WebElement dismissWarnAlert;

	public HomePage(final WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goTo() {
		this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/admin-template/admin-template.html");
	}

	public List<ElementValidator> getElementvalidators() {
		return Arrays.asList(new NotificationValidator(infoBtn, infoAlert),
				new NotificationValidator(successBtn, successAlert), new NotificationValidator(warnBtn, warnAlert),
				new NotificationValidator(dangerBtn, dangerAlert),

				new DismissalAlertValidator(dismissInfoAlert), new DismissalAlertValidator(dismissSuccessAlert),
				new DismissalAlertValidator(dismissWarnAlert), new DismissalAlertValidator(dismissDangerAlert));
	}

}
