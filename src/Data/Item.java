package Data;

public class Item {
	private int itemID;
	private String itemName;
	private int itemPrice;
	private SpecialPrice specialPrice;
	
	public Item(int itemID, String itemName, int itemPrice) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.specialPrice=null;
	}
	
	public Item(int itemID, String itemName, int itemPrice, SpecialPrice specialPrice) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.specialPrice = specialPrice;
	}
	
	public void updateItem(String itemName, int itemPrice, SpecialPrice specialPrice) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.specialPrice = specialPrice;
	}
	
	public int getID() {
		return itemID;
	}
	
	public String getItemName() {
		return itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public SpecialPrice getSpecialPrice() {
		return specialPrice;
	}	
}
