package com.randhir.command;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.google.common.util.concurrent.Uninterruptibles;

public class DismissalAlertValidator extends ElementValidator {

	private final WebElement dismissalAlert;

	public DismissalAlertValidator(final WebElement element) {
		this.dismissalAlert = element;
	}

	@Override
	public boolean validate() {
		boolean result1 = this.dismissalAlert.isDisplayed();
		this.dismissalAlert.findElement(By.cssSelector("button.close")).click();
		Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
		boolean result2 = false;
		try {
			result2 = this.dismissalAlert.isDisplayed(); // false;
		} catch (Exception e) {
			// skip
		}

		return result1 && (!result2);
	}

}
