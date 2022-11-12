package by.bsuir.lab2.shop.items;

import by.bsuir.lab2.bean.ITransferData;
import by.bsuir.lab2.bean.MapTransferData;

public class LaptopItem extends ShopItem{

	public LaptopItem(int numberOfCores, double displayRatio) {
		super("Laptop", numberOfCores * 15000 + (int)(displayRatio * 1000));
		this.numberOfCores = numberOfCores;
		this.displayRatio = displayRatio;
	}
	
	@Override
	public ITransferData getItemTransferData() {
		MapTransferData transferData = new MapTransferData();
		transferData.addProperties(super.getItemTransferData());
		transferData.addProperty("numberOfCores", numberOfCores);
		transferData.addProperty("displayRatio", displayRatio);
		return transferData;
	}
	
	
	public String getUniqueStringId() {
		return uniqueClassID;
	}
	
	
	protected LaptopItem(ITransferData data) {
		super(data);
		numberOfCores = Integer.valueOf((String)data.getProperty("numberOfCores"));
		displayRatio = Double.valueOf((String)data.getProperty("displayRatio"));
	}
	
	
	protected int numberOfCores = 1;
	protected double displayRatio = 1280/720;
	
	private static String uniqueClassID = LaptopItem.class.getName();
	
	static {	//Register new shop item class in the table
		ShopItem.registerNewShopItem(uniqueClassID, new ShopItemFactory() {
			
			@Override
			public ShopItem createShopItem(ITransferData data) {
				return new LaptopItem(data);
			}
		});
	}
}
