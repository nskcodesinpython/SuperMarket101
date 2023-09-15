package Service;

import java.util.List;

import Data.Item;

public class ItemsService {
	public boolean checkIfPresent(List<Item> itemsList, String itemName) {
		for(Item i : itemsList) {
			if(itemName.equals(i.getItemName())) {
				return true;
			}
		}
		return false;
	}
	public Item getItemByName(List<Item> itemsList, String itemName) {
		for(Item i : itemsList) {
			if(itemName.equals(i.getItemName())) {
				return i;
			}
		}
		return null;
	}
	public boolean checkIfItemPresentInCart(Cart cart, String itemName) {
		for(Item item : cart.items.keySet()) {
			if (item.getItemName().equals(itemName)) {
				return true;
			}
		}
		return false;
	} 
	public Item getItemForDeletion(Cart cart, String itemName) {
		for(Item item : cart.items.keySet()) {
			if (item.getItemName().equals(itemName)) {
				return item;
			}
		}
		return null;
	}
	public boolean checkQuantityIsValid(Cart cart, String itemName, int itemQuantity) {
		int quantity = cart.items.get(getItemForDeletion(cart,itemName));
		if(itemQuantity <= quantity &&  itemQuantity>0) {
			return true;
		}
		return false;
	}
	public int returnQuantityForItemInCart(Cart cart, String itemName) {
		return cart.items.get(getItemForDeletion(cart,itemName));
	}
}
