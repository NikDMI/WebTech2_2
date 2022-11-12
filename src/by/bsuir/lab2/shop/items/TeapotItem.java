package by.bsuir.lab2.shop.items;

import by.bsuir.lab2.bean.*;

public class TeapotItem extends ShopItem {
	
	public TeapotItem(int volume) {
		super("Teapot", volume * 128);
		this.volume = volume;
	}
	
	@Override
	public ITransferData getItemTransferData() {
		MapTransferData transferData = new MapTransferData();
		transferData.addProperties(super.getItemTransferData());
		transferData.addProperty("volume", volume);
		return transferData;
	}
	
	
	public String getUniqueStringId() {
		return uniqueClassID;
	}
	
	
	protected TeapotItem(ITransferData data) {
		super(data);
		volume = Integer.valueOf((String)data.getProperty("volume"));
	}
	
	
	protected int volume;	//Volume in mililiters
	
	private static String uniqueClassID = TeapotItem.class.getName();
	
	static {	//Register new shop item class in the table
		ShopItem.registerNewShopItem(uniqueClassID, new ShopItemFactory() {
			
			@Override
			public ShopItem createShopItem(ITransferData data) {
				return new TeapotItem(data);
			}
		});
	}
}
