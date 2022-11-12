package by.bsuir.lab2.console;

import javax.xml.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import java.io.*;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;

import by.bsuir.lab2.bean.*;
import by.bsuir.lab2.dao.*;
import by.bsuir.lab2.dao.interf.ItemData;

import by.bsuir.lab2.shop.items.*;
import by.bsuir.lab2.services.interf.*;
import by.bsuir.lab2.services.interf.ShopBasket.SaveType;

public class ConsoleOutput {

	public static void main(String[] args) {
		try {
			ShopBasket basket = new ShopBasket();
			basket.addShopItem(new TeapotItem());
			basket.addShopItem(new TeapotItem());
			basket.saveBasket(SaveType.XML, "out.txt");
			//basket.loadBasket(SaveType.XML, "out.txt");
			//basket.saveBasket(SaveType.XML, "out2.txt");
			
		} catch (Exception e) {
			String ssString  = e.getMessage();
			System.out.print(ssString);
		}
		
	}
}
