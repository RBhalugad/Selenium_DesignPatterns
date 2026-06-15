package com.randhir.decorator.testCases;

import com.randhir.decorator.DashboardPage;
import java.util.List;
import java.util.function.Consumer;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Decorators {

  private static void shouldDisplay(List<WebElement> elements) {
    elements.forEach(element -> Assert.assertTrue(element.isDisplayed()));
  }

  private static void shouldNotDisplay(List<WebElement> elements) {
    elements.forEach(element -> Assert.assertFalse(element.isDisplayed()));
  }

  // Ingredients
  private static final Consumer<DashboardPage> adminComponentPresent =
      (dp) -> shouldDisplay(dp.getAdminComponents());
  private static final Consumer<DashboardPage> guestComponentPresent =
      (dp) -> shouldDisplay(dp.getGuestComponents());
  private static final Consumer<DashboardPage> superuserComponentPresent =
      (dp) -> shouldDisplay(dp.getSuperUserComponents());

  private static final Consumer<DashboardPage> adminComponentNotPresent =
      (dp) -> shouldNotDisplay(dp.getAdminComponents());

  private static final Consumer<DashboardPage> superuserComponentNotPresent =
      (dp) -> shouldNotDisplay(dp.getSuperUserComponents());

  // role Selection
  private static final Consumer<DashboardPage> adminSelection = (dp) -> dp.selectRole("admin");
  private static final Consumer<DashboardPage> guestSelection = (dp) -> dp.selectRole("guest");
  private static final Consumer<DashboardPage> superUserSelection =
      (dp) -> dp.selectRole("superuser");

  // user role pages
  public static final Consumer<DashboardPage> guestPage =
      guestSelection
          .andThen(guestComponentPresent)
          .andThen(adminComponentNotPresent)
          .andThen(superuserComponentNotPresent);
  public static final Consumer<DashboardPage> suPage =
      superUserSelection
          .andThen(superuserComponentPresent)
          .andThen(guestComponentPresent)
          .andThen(adminComponentNotPresent);
  public static final Consumer<DashboardPage> adminPage =
      adminSelection
          .andThen(guestComponentPresent)
          .andThen(superuserComponentPresent)
          .andThen(adminComponentPresent);
}
