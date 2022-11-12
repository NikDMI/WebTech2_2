package by.bsuir.lab2.shop.items;

import by.bsuir.lab2.bean.ITransferData;
import by.bsuir.lab2.bean.MapTransferData;

/**
 * Represent abstraction of items in some shop
 * @author nikmi
 *
 */
public abstract class ShopItem {
	
	/**
	 * Get data to transfer throught dao layer
	 * @return
	 */
	public ITransferData getItemTransferData() {
		MapTransferData transferData = new MapTransferData();
		transferData.addProperty("itemName", itemName);
		transferData.addProperty("itemPrice", itemPrice);
		return transferData;
	}
	
	
	@Override
	public String toString() {
		return "Item: " + itemName + " Price: " + itemPrice;
	}
	
	
	protected String itemName = "Item";
	protected int itemPrice;	//Price in 0.01 BYN
}
