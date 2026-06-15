package com.randhir.factory.testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.randhir.BaseTest.BaseTest;
import com.randhir.factory.GoogleFactory;
import com.randhir.factory.GooglePage;

public class GoogleSearchTest extends BaseTest {

	private GooglePage googlepage;

	@Test(dataProvider = "getData")
	public void searchTest(String language, String keyword) {
		this.googlepage = GoogleFactory.get(language, this.driver);
		this.googlepage.launchSite();
		this.googlepage.search(keyword);
		int resultCount = this.googlepage.getResultCount();
		System.out.println("Result Count :" + resultCount);
	}

	@DataProvider
	public Object[][] getData() {

		return new Object[][] { { "ENG", "selenium" }, { "FR", "docker" }, { "SA", "python" } };

	}

}
