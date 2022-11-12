package by.bsuir.lab2.console;

import javax.xml.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import java.io.*;
import java.util.ArrayList;

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
			ArrayList<ITransferData> data = itemData.readData();
			ITransferData data2 = data.get(0);
			data.clear();
			int a = 10;
			data.add(new MapTransferData());
			
		} catch (Exception e) {
			String ssString  = e.getMessage();
			ssString+="a";
		}
		
	}
}
