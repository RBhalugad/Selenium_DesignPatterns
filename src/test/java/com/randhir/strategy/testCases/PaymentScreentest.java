package com.randhir.strategy.testCases;

import com.beust.jcommander.internal.Maps;
import com.google.common.util.concurrent.Uninterruptibles;
import com.randhir.BaseTest.BaseTest;
import com.randhir.strategy.PaymentOptionFactory;
import com.randhir.strategy.PaymentScreen;
import java.time.Duration;
import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PaymentScreentest extends BaseTest {

  private PaymentScreen paymentScreen;

  @BeforeTest
  public void setPaymentScreen() {
    this.paymentScreen = new PaymentScreen(this.driver);
  }

  @Test(dataProvider = "getData")
  // public void paymentTest(PaymentOption paymentoption, Map<String, String>
  // paymentDetails) {
  public void paymentTest(String option, Map<String, String> paymentDetails) {
    this.paymentScreen.goTo();
    this.paymentScreen.getUserInformation().enterDetails("randhir", "patel", "test@test.com");
    this.paymentScreen.setPaymentoption(PaymentOptionFactory.get(option));
    this.paymentScreen.Pay(paymentDetails);

    String ordernumber = this.paymentScreen.geOrder().getOrderNumber();
    System.out.println("Order Number : " + ordernumber);

    Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
  }

  @DataProvider
  public Object[][] getData() {
    Map<String, String> cc = Maps.newHashMap();
    cc.put("cc", "12345678");
    cc.put("year", "2025");
    cc.put("cvv", "760");

    Map<String, String> nb = Maps.newHashMap();
    nb.put("bank", "WELLS FARGO");
    nb.put("accountNumber", "myaccount123");
    nb.put("pin", "999");

    Map<String, String> pp = Maps.newHashMap();
    pp.put("pp_uname", "RP009");
    pp.put("pp_pwd", "adjlkajd123");

    return new Object[][] {
      // { new CreditCard(), cc }, { new Netbanking(), nb }, { new Paypal(), pp }
      {"CC", cc}, {"NB", nb}, {"PP", pp}
    };
  }
}
