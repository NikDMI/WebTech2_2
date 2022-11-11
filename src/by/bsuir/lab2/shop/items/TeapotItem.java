package by.bsuir.lab2.shop.items;

import by.bsuir.lab2.bean.*;

public class TeapotItem extends ShopItem {
	
	@Override
	public ITransferData getItemTransferData() {
		MapTransferData transferData = new MapTransferData();
		transferData.addProperties(super.getItemTransferData());
		transferData.addProperty("volume", volume);
		return transferData;
	}
	
	protected int volume;	//Volume in mililiters
}
