package com.randhir.executeAround.testCases;

import com.randhir.BaseTest.BaseTest;
import com.randhir.executeAround.MainPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

  private MainPage mainPage;

  @BeforeTest
  public void setmainpage() {
    this.mainPage = new MainPage(driver);
  }

  @Test
  public void frametest() {
    this.mainPage.goTo();
    this.mainPage.onFrameA(
        a -> {
          a.setFirstName("fn1");
          a.setLastName("ln2");
          a.setAddress("ad1");
          a.setMessage("msg1");
        });
    this.mainPage.onFrameB(
        b -> {
          b.setFirstName("fn2");
          b.setLastName("ln2");
          b.setAddress("ad2");
          b.setMessage("msg2");
        });
    this.mainPage.onFrameC(
        c -> {
          c.setFirstName("fn3");
          c.setLastName("ln3");
          c.setAddress("ad3");
          c.setMessage("msg3");
        });
  }
}
