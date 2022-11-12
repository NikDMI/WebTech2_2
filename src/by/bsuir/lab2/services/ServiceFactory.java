package by.bsuir.lab2.services;

import by.bsuir.lab2.services.interf.ShopBasket;

public class ServiceFactory {

	public static ShopBasket getShopBasket() {
		return new ShopBasket();
	}
}
