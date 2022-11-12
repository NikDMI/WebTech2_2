package by.bsuir.lab2.services.interf;

import by.bsuir.lab2.shop.items.*;
import java.util.*;

import by.bsuir.lab2.bean.ITransferData;
import by.bsuir.lab2.dao.ItemDataFactory;
import by.bsuir.lab2.dao.exception.DaoException;
import by.bsuir.lab2.dao.interf.ItemData;
import by.bsuir.lab2.services.exception.*;
import by.bsuir.lab2.dao.exception.*;

public final class ShopBasket {
	
	public enum SaveType {XML};
	
	public void addShopItem(ShopItem item) {
		if (item == null) {
			new ServiceException("Null ptr argument");
		}
		basket.add(item);
	}
	
	
	/**
	 * Save shop basket in corresponding format
	 * @param saveType
	 */
	public void saveBasket(SaveType saveType, String fileName) throws ServiceException {
		ItemData daoItemData;
		switch (saveType) {
		case XML:
			daoItemData = ItemDataFactory.getXmlItemDataParser(fileName);
			break;
		default:
			throw new ServiceException("Bad save format");
		}
		//Create list of properties
		ArrayList<ITransferData> transferDataList = new ArrayList<>();
		for (ShopItem shopItem: basket) {
			ITransferData transferData = shopItem.getItemTransferData();
			transferData.addProperty(UNIQUE_TAG_NAME, shopItem.getUniqueStringId());
			transferDataList.add(transferData);
		}
		try {
		daoItemData.writeData(transferDataList);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
	
	
	public void loadBasket(SaveType saveType, String fileName) throws ServiceException {
		ItemData daoItemData;
		switch (saveType) {
		case XML:
			daoItemData = ItemDataFactory.getXmlItemDataParser(fileName);
			break;
		default:
			throw new ServiceException("Bad save format");
		}
		//Create list of properties
		try {
			ArrayList<ITransferData> transferDataList = daoItemData.readData();
			for (ITransferData transferData: transferDataList) {
				try {
					String uniqueId = (String)transferData.getProperty(UNIQUE_TAG_NAME);
					transferData.removeProperty(UNIQUE_TAG_NAME);
					basket.add(ShopItem.createShopItemByUniqueId(uniqueId, transferData));
				} catch (IllegalArgumentException e) {
					throw new ServiceException(e);
				}
			}
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
	
	
	private ArrayList<ShopItem> basket = new ArrayList<>();
	private final String UNIQUE_TAG_NAME = "UniqueShopItemId";
}
