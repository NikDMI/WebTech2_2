package by.bsuir.lab2.controller.impl;

import java.nio.channels.ByteChannel;
import java.util.ArrayList;

import by.bsuir.lab2.controller.exception.ControllerException;
import by.bsuir.lab2.controller.interf.*;
import by.bsuir.lab2.services.ServiceFactory;
import by.bsuir.lab2.services.exception.ServiceException;
import by.bsuir.lab2.services.interf.ShopBasket;
import by.bsuir.lab2.services.interf.ShopBasket.SaveType;
import by.bsuir.lab2.shop.items.ShopItem;
import by.bsuir.lab2.services.exception.*;

public class Controller implements by.bsuir.lab2.controller.interf.Controller {
	
	public Controller() {
		basket = ServiceFactory.getShopBasket();
	}
	
	
	/**
	 * Load basket form file
	 * @param fileName
	 */
	public void loadBasketFromFile(String fileName) throws ControllerException {
		try {
			basket.loadBasket(SaveType.XML, fileName);
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}
	}
	
	
	/**
	 * Save basket to file
	 * @param fileName
	 */
	public void saveBasketToFile(String fileName) throws ControllerException{
		try {
			basket.saveBasket(SaveType.XML, fileName);
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}
	}
	
	
	/**
	 * Add new item to basket
	 * @param item
	 */
	public void addItem(ShopItem item) throws ControllerException{
		basket.addShopItem(item);
	}
	
	
	/**
	 * Find the most chip item in the basket
	 * @return
	 */
	public ShopItem getChipestItem() {
		return basket.getChipestItem();
	}
	
	
	/**
	 * Find all items by unique class name
	 * @param name
	 * @return
	 */
	public ArrayList<ShopItem> getItemsByUniqueName(String name){
		return basket.getItemsByUniqueName(name);
	}
	
	
	private ShopBasket basket;
}
