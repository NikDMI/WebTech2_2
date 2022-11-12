package by.bsuir.lab2.shop.items;

import by.bsuir.lab2.bean.ITransferData;

public interface ShopItemFactory {
	/**
	 * Fabric method to create shop items of different classes
	 * @return
	 */
	public ShopItem createShopItem(ITransferData data);
}
