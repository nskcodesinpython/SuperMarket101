package Service;

import java.util.HashMap;
import java.util.Map;

import Data.Item;
import Data.SpecialPrice;

public class Cart {
	
	Map<Item, Integer> items;
	PrintToTerminal printToTerminal = new PrintToTerminal();
	
	public Cart(){
		items = new HashMap<>();
	}
	//add item to the cart
	public void scanItem(Item item) {
		items.put(item,(items.getOrDefault(item, 0))+1);
	}
	//get all the items in the cart
	public Map<Item, Integer> getItems(){
		return items;
	}
	//remove item from the cart based on itemQuantity and itemName
	public boolean removeItem(String itemName, int itemQuantity) {
        for (Item item : items.keySet()) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
            	if(items.get(item)-itemQuantity==0) {
            		items.remove(item);
            	}else {
            		items.put(item,items.get(item)-itemQuantity);
            	}
            	return true;
            }
        }
        return false;
	}
	//calculate Total for the items in the cart
	public String calculateTotal() {
		int totalPrice=0;
		for(Item item : items.keySet()) {
			SpecialPrice specialPriceOb=item.getSpecialPrice();
			if(specialPriceOb==null) {
				int rowTotal = item.getItemPrice()*items.get(item);
				printToTerminal.printChechout(item.getItemName(),
						  					  String.valueOf(items.get(item)),
						  					  String.valueOf(item.getItemPrice()),
						  					  String.valueOf(rowTotal));
				totalPrice+=rowTotal;
			}else {
				int specialQuantity = specialPriceOb.getSpecialQuantity();
				int specialPrice = specialPriceOb.getSpecialPrice();
				int itemQuantity = items.get(item);
				
				int numOfItemsEligibleForSpecialPrice = Math.floorDiv(itemQuantity,specialQuantity);
				int numOfItemsNotEligibleForSpecialPrice = itemQuantity%specialQuantity;
				
				
				int rowTotal=specialPrice*numOfItemsEligibleForSpecialPrice;
				if(numOfItemsEligibleForSpecialPrice>0) {
					totalPrice+=rowTotal;
					printToTerminal.printChechout(item.getItemName(),
												  String.valueOf(numOfItemsEligibleForSpecialPrice*specialQuantity),
							  					  String.valueOf(item.getItemPrice()),
												  String.valueOf(rowTotal),
												  item.getSpecialPrice().getOffer());
				}
				if(numOfItemsNotEligibleForSpecialPrice>0) {
					rowTotal=item.getItemPrice()*numOfItemsNotEligibleForSpecialPrice;
					totalPrice+=rowTotal;
					printToTerminal.printChechout(item.getItemName(),
												  String.valueOf(numOfItemsNotEligibleForSpecialPrice),
							  					  String.valueOf(item.getItemPrice()),
												  String.valueOf(rowTotal));
				}
			}
		}
		return String.valueOf(formatAmount(((float)totalPrice)/100));
	}
	//convert the float to string and format it with 2 decimal points  
    public String formatAmount(float amount){
        return String.format("%.02f", amount);
    } 
	
}
