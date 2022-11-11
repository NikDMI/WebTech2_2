package by.bsuir.lab2.dao;

import by.bsuir.lab2.dao.*;
import by.bsuir.lab2.dao.interf.ItemData;
import by.bsuir.lab2.dao.impl.*;

public class ItemDataFactory {

	public static ItemData getXmlItemDataParser(String fileName) {
		return new XmlItemData(fileName);
	}
}
