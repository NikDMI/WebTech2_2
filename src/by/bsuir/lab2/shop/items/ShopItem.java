package by.bsuir.lab2.shop.items;

import by.bsuir.lab2.bean.ITransferData;
import by.bsuir.lab2.bean.MapTransferData;
import by.bsuir.lab2.dao.interf.ItemData;

import java.util.*;

/**
 * Represent abstraction of items in some shop
 * @author nikmi
 *
 */
public abstract class ShopItem {
	
	protected ShopItem(String itemName, int itemPrice) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}
	
	protected ShopItem(ITransferData data) {
		itemName = (String)data.getProperty("itemName");
		itemPrice = Integer.valueOf((String)data.getProperty("itemPrice"));
	}
	
	@Override
	public String toString() {
		return "Item: " + itemName + " Price: " + itemPrice;
	}
	
	
	public int getPrice() {
		return itemPrice;
	}
	
	
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
	
	
	public static ShopItem createShopItemByUniqueId(String uniqueId, ITransferData data) throws IllegalArgumentException{
		if (!registeredShopItems.containsKey(uniqueId)) {
			throw new IllegalArgumentException("There is no registered class "+uniqueId);
		}
		ShopItem item = registeredShopItems.get(uniqueId).createShopItem(data);
		return item;
	}
	
	
	/**
	 * Returns unique id (class name?) of shop item
	 * @return
	 */
	public abstract String getUniqueStringId();
	
	
	/**
	 * When dynamicly add new class of shop item, this method must be called to register
	 * this class in the table
	 * @param shopItemUniqueId
	 * @param itemFactory - lambda, that can create corresponding shop item
	 */
	protected static void registerNewShopItem(String shopItemUniqueId, ShopItemFactory itemFactory) {
		if (registeredShopItems.containsKey(shopItemUniqueId)) {
			throw new IllegalArgumentException("Class " + shopItemUniqueId + " had been registered yet");
		}
		registeredShopItems.put(shopItemUniqueId, itemFactory);
	}
	
	
	
	protected String itemName = "Item";
	protected int itemPrice;	//Price in 0.01 BYN
	
	private static HashMap<String, ShopItemFactory> registeredShopItems = new HashMap<String, ShopItemFactory>();
}
