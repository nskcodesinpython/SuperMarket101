package Service;

import java.util.List;
import java.util.Scanner;

import Data.Item;
import Data.SpecialPrice;

public class InventoryService {

	//add item to the inventory
	public List<Item> addItemInInventory(Scanner sc, PrintToTerminal printToTerminal,
			GatherInputFromTerminal gatherInputFromTerminal, List<Item> itemsList) {
		String itemName = gatherInputFromTerminal.getItemForInventoryAdd(printToTerminal, sc, 
				"add_item_inventory", itemsList);
		int itemPrice = gatherInputFromTerminal.getItemPriceAndQuantity(sc, printToTerminal, 
						"add_item_price_inventory",c -> c > 0 );
		int choice = gatherInputFromTerminal.getOption
		(sc, printToTerminal, "special_offer_check", c-> c ==1 || c==2 );
		SpecialPrice specialPrice=null;
		if(choice ==1) {
		int offerQuantity = gatherInputFromTerminal.getItemPriceAndQuantity(sc, printToTerminal,
						"update_item_quantity_inventory",c -> c > 0 );
		int offerPrice = gatherInputFromTerminal.getItemPriceAndQuantity(sc, printToTerminal, 
						"update_item_offer_price_inventory",c -> (c/offerQuantity < itemPrice) && c>0);
		specialPrice = new SpecialPrice(offerQuantity,offerPrice);
		}
		int id = itemsList.get(itemsList.size()-1).getID()+1;
		Item newItem = new Item(id, itemName,itemPrice,specialPrice);
		itemsList.add(newItem);
		return itemsList;
	}
	//update item to the inventory
	public List<Item> updateItemInInventory(Scanner sc, PrintToTerminal printToTerminal,
				GatherInputFromTerminal gatherInputFromTerminal, List<Item> itemsList){
		String itemName = gatherInputFromTerminal.getItemForInventoryChange(printToTerminal, sc, 
									"update_item_inventory", itemsList);
		int itemPrice = gatherInputFromTerminal.getItemPriceAndQuantity(sc, printToTerminal, 
									"update_item_price_inventory",c -> c > 0 );
		int choice = gatherInputFromTerminal.getOption
		(sc, printToTerminal, "special_offer_check", c-> c ==1 || c==2 );
		SpecialPrice specialPrice=null;
		if(choice ==1) {
			int offerQuantity = gatherInputFromTerminal.getItemPriceAndQuantity(sc, printToTerminal,
									"update_item_quantity_inventory",c -> c > 0 );
			int offerPrice = gatherInputFromTerminal.getItemPriceAndQuantity(sc, printToTerminal, 
									"update_item_offer_price_inventory",c -> (c/offerQuantity < itemPrice) && c>0);
			specialPrice = new SpecialPrice(offerQuantity,offerPrice);
		}
		Item item = getItemByItemName(itemsList,itemName);
		itemsList.remove(item);
		int id = itemsList.get(itemsList.size()-1).getID()+1;
		Item newItem = new Item(id, itemName,itemPrice,specialPrice);
		itemsList.add(newItem);
		return itemsList;
	}
	//delete item from the inventory
	public List<Item> deleteItemFromInventory(Scanner sc, PrintToTerminal printToTerminal, 
			GatherInputFromTerminal gatherInputFromTerminal, List<Item> itemsList) {
		
		String itemName = gatherInputFromTerminal.getItemForInventoryChange(printToTerminal, sc, 
															"delete_item_inventory", itemsList);
		itemsList.remove(getItemByItemName(itemsList, itemName));
		return itemsList;
	}
	//get the Item object with itemName 
	public Item getItemByItemName(List<Item> itemsList, String itemName) {
		for(Item i : itemsList) {
			if(i.getItemName().equals(itemName)) {
				return i;
			}
		}
		return null;
	}
	//check if the item is presnt in the inventory or not
	public boolean checkIfItemPresentInInventory(List<Item> itemsList, String itemName){
		for(Item i : itemsList) {
			if(i.getItemName().equals(itemName)) {
				return true;
			}
		}
		return false;
	}
}
