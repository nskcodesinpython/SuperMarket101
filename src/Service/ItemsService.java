package Service;

import java.util.List;

import Data.Item;

public class ItemsService {
	//check if the item is present in the inventory
	public boolean checkIfPresent(List<Item> itemsList, String itemName) {
		for(Item i : itemsList) {
			if(itemName.equals(i.getItemName())) {
				return true;
			}
		}
		return false;
	}
	//get the Item object with teh itemName
	public Item getItemByName(List<Item> itemsList, String itemName) {
		for(Item i : itemsList) {
			if(itemName.equals(i.getItemName())) {
				return i;
			}
		}
		return null;
	}
	//check if the item is present in the cart
	public boolean checkIfItemPresentInCart(Cart cart, String itemName) {
		for(Item item : cart.items.keySet()) {
			if (item.getItemName().equals(itemName)) {
				return true;
			}
		}
		return false;
	} 
	//get the Item object with the itemName from the cart
	public Item getItemForDeletion(Cart cart, String itemName) {
		for(Item item : cart.items.keySet()) {
			if (item.getItemName().equals(itemName)) {
				return item;
			}
		}
		return null;
	}
	//check if the quantity is valid
	public boolean checkQuantityIsValid(Cart cart, String itemName, int itemQuantity) {
		int quantity = cart.items.get(getItemForDeletion(cart,itemName));
		if(itemQuantity <= quantity &&  itemQuantity>0) {
			return true;
		}
		return false;
	}
	//returning item back to the inventory
	public int returnQuantityForItemInCart(Cart cart, String itemName) {
		return cart.items.get(getItemForDeletion(cart,itemName));
	}
}
