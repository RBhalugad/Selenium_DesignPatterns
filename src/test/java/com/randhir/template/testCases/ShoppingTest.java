package com.randhir.template.testCases;

import com.randhir.BaseTest.BaseTest;
import com.randhir.template.DemoShopping;
import com.randhir.template.PcommerceShopping;
import com.randhir.template.ShoppingTemplate;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest {

  @Test(dataProvider = "getData")
  public void shoppintTest(ShoppingTemplate shoppingTemplate) {
    shoppingTemplate.shop();
  }

  @DataProvider
  public Object[] getData() {
    return new Object[] {
      new DemoShopping(driver, "laptop"), new PcommerceShopping(driver, "iphone")
    };
  }
}
