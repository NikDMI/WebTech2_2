package by.bsuir.lab2.controller.interf;

import java.util.ArrayList;

import by.bsuir.lab2.controller.exception.ControllerException;
import by.bsuir.lab2.services.exception.ServiceException;
import by.bsuir.lab2.shop.items.ShopItem;

public interface Controller {

	/**
	 * Load basket form file
	 * @param fileName
	 */
	public void loadBasketFromFile(String fileName) throws ControllerException;
	
	
	/**
	 * Save basket to file
	 * @param fileName
	 */
	public void saveBasketToFile(String fileName) throws ControllerException;
	
	
	/**
	 * Add new item to basket
	 * @param item
	 */
	public void addItem(ShopItem item) throws ControllerException;
	
	
	/**
	 * Find the most chip item in the basket
	 * @return
	 */
	public ShopItem getChipestItem();
	
	
	/**
	 * Find all items by unique class name
	 * @param name
	 * @return
	 */
	public ArrayList<ShopItem> getItemsByUniqueName(String name);
}
