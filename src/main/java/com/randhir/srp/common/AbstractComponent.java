package com.randhir.srp.common;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public abstract class AbstractComponent {

	protected Wait<WebDriver> wait;

	public AbstractComponent(final WebDriver driver) {
		this.wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class);
		PageFactory.initElements(driver, this);
	}

	public abstract boolean isDisplayed();

}
