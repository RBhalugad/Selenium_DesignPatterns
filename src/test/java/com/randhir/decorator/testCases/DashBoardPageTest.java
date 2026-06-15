package com.randhir.decorator.testCases;

import com.google.common.util.concurrent.Uninterruptibles;
import com.randhir.BaseTest.BaseTest;
import com.randhir.decorator.DashboardPage;
import java.time.Duration;
import java.util.function.Consumer;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DashBoardPageTest extends BaseTest {

  private DashboardPage dashboardPage;

  @BeforeTest
  public void setDashboardPage() {
    this.dashboardPage = new DashboardPage(driver);
  }

  @Test(dataProvider = "getData")
  public void roleTest(Consumer<DashboardPage> role) {
    this.dashboardPage.goTo();
    role.accept(this.dashboardPage);
    Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(5));
  }

  @DataProvider
  public Object[] getData() {
    return new Object[] {Decorators.adminPage, Decorators.guestPage, Decorators.suPage};
  }
}
