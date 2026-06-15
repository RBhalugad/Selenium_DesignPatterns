package com.randhir.template;

import com.randhir.template.pages.PcommerceProductDescriptionPage;
import com.randhir.template.pages.PcommerceResultPage;
import com.randhir.template.pages.PcommerceSearch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PcommerceShopping extends ShoppingTemplate {

  private String product;

  private PcommerceSearch pcommerceSearch;
  private PcommerceResultPage pcommerceResultPage;
  private PcommerceProductDescriptionPage productDescriptionPage;

  public PcommerceShopping(WebDriver driver, String product) {
    this.product = product;

    this.pcommerceSearch = PageFactory.initElements(driver, PcommerceSearch.class);
    this.pcommerceResultPage = PageFactory.initElements(driver, PcommerceResultPage.class);
    this.productDescriptionPage =
        PageFactory.initElements(driver, PcommerceProductDescriptionPage.class);
  }

  @Override
  public void launchSite() {
    pcommerceSearch.goTo();
  }

  @Override
  public void searchProduct() {
    pcommerceSearch.searchProduct(this.product);
  }

  @Override
  public void selectProduct() {
    pcommerceResultPage.selectProduct();
  }

  @Override
  public void buy() {
    productDescriptionPage.buy();
  }
}
