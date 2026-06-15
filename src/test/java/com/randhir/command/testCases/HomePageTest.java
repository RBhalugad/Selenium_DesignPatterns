package com.randhir.command.testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.randhir.BaseTest.BaseTest;
import com.randhir.command.HomePage;

public class HomePageTest extends BaseTest {
	private HomePage homepage;

	@BeforeTest
	public void setHomePage() {
		this.homepage = new HomePage(driver);
	}

	@Test
	public void homePageTest() {
		this.homepage.goTo();
		this.homepage.getElementvalidators().stream().parallel().map(ev -> ev.validate())
				.forEach(b -> Assert.assertTrue(b));
	}

}
