package com.randhir.template;

public abstract class ShoppingTemplate {

	public abstract void launchSite();

	public abstract void searchProduct();

	public abstract void selectProduct();

	public abstract void buy();

	public void shop() {
		launchSite();
		searchProduct();
		selectProduct();
		buy();
	}

}
