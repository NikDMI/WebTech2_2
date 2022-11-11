package by.bsuir.lab2.console;

import javax.xml.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import java.io.*;
import by.bsuir.lab2.bean.*;
import by.bsuir.lab2.dao.*;
import by.bsuir.lab2.dao.interf.ItemData;

import by.bsuir.lab2.shop.items.*;

public class ConsoleOutput {

	public static void main(String[] args) {
		try {
			ItemData itemData = ItemDataFactory.getXmlItemDataParser("test.txt");
			TeapotItem teapotItem = new TeapotItem();
			itemData.writeData(teapotItem.getItemTransferData());
			
		} catch (Exception e) {
			
		}
		
	}
}
