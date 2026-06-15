package com.randhir.testCases;

import com.randhir.BaseTest.BaseTest;
import com.randhir.srp.main.GoogleMainPage;
import com.randhir.srp.result.GoogleResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {
  private GoogleMainPage googleMainPage;
  private GoogleResultPage googleResultPage;

  @BeforeTest
  public void setUpPages() {
    this.googleMainPage = new GoogleMainPage(driver);
    this.googleResultPage = new GoogleResultPage(driver);
  }

  @Test(dataProvider = "getData")
  public void googleWorkFlow(String keyword, int index) {

    String link = "News";

    googleMainPage.goTo();
    Assert.assertTrue(googleMainPage.getSearchWidget().isDisplayed());

    googleMainPage.getSearchWidget().enterInSearchBox(keyword);
    Assert.assertTrue(googleMainPage.getSearchSuggestion().isDisplayed());

    googleMainPage.getSearchSuggestion().clickSuggestioByIndex(index);
    Assert.assertTrue(googleResultPage.getNavigationBar().isDisplayed());

    googleResultPage.getSearchWidget().enterInSearchBox(keyword);
    googleResultPage.getSearchSuggestion().clickSuggestioByIndex(index);

    googleResultPage.getNavigationBar().goToSelectedoptions(link);
    System.out.println(googleResultPage.getResultStats());
  }

  @DataProvider
  public Object[][] getData() {

    return new Object[][] {{"selenium", 3}, {"docker", 2}};
  }
}
