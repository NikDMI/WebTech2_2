package by.bsuir.lab2.test;

import javax.xml.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import java.io.*;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.Random;

import by.bsuir.lab2.bean.*;
import by.bsuir.lab2.controller.ControllerFactory;
import by.bsuir.lab2.controller.impl.Controller;
import by.bsuir.lab2.dao.*;
import by.bsuir.lab2.dao.interf.ItemData;

import by.bsuir.lab2.shop.items.*;
import by.bsuir.lab2.services.interf.*;
import by.bsuir.lab2.services.interf.ShopBasket.SaveType;

public class ConsoleOutput {

	public static void main(String[] args) {
		try {
			by.bsuir.lab2.controller.interf.Controller controller = ControllerFactory.getController();
			Random random = new Random();
			//Fill basket
			for (int i = 0; i < 3; ++i) {
				controller.addItem(new TeapotItem(random.nextInt(500, 2500)));
				controller.addItem(new LaptopItem(random.nextInt(1,16), 1280f/720f));
			}
			//Find chipest item
			ShopItem chipestItem = controller.getChipestItem();
			System.out.println("Chipest item: " + chipestItem.getPrice());
			//Find all teapots
			TeapotItem teapotItem = new TeapotItem(1);
			ArrayList<ShopItem> teapots = controller.getItemsByUniqueName(teapotItem.getUniqueStringId());
			System.out.println("Teapots: " + teapots.size());
			//Save -- load -- save operations
			controller.saveBasketToFile("XmlExample1.txt");
			controller.loadBasketFromFile("XmlExample1.txt");
			controller.saveBasketToFile("XmlExample2.txt");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
