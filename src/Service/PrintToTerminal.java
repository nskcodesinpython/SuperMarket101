package Service;

import java.util.List;

import Data.Item;

public class PrintToTerminal {
	public void welcomeText() {
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		System.out.println("===============    Welcome to Super Market!!!   ===============\n");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
	}
	public void printInventory() {
		System.out.print("What would you like to do with the inventory?\n"
				+"1. Add item\n"
				+"2. Update item\n"
				+"3. Delete item\n"
				+"Enter your choice: ");
	}
	public void printSpecialOfferCheck() {
		System.out.print("Would you like to add Special offer to this item?\n"
				+"1. Yes\n"
				+"2. No\n"
				+"Enter your choice: ");
	}
	public void startMenu() {
		System.out.print("What would you like to do?\n"
				+"1. Scan items to the cart\n"
				+"2. Inventory management\n"
				+"3. Exit\n"
				+"Enter your choice: ");
	}
	
	public void printItemsList(List<Item> itemsList) {
		System.out.println("=================================");
		System.out.printf("%-10s%-10s%-15s%n",centerAlign("Item Name",10),
							centerAlign("Item Price",10),
							centerAlign("Offer Code",15));
		System.out.println("=================================\n");
		for(Item i : itemsList) {
			if(i.getSpecialPrice()!=null){
				System.out.printf("%-10s%-10s%-15s%n", centerAlign(i.getItemName(),10),
								  rightAlign(String.valueOf(i.getItemPrice()),10), 
								  centerAlign(i.getSpecialPrice().getOffer(),15));
			}
			else {
				System.out.printf("%-10s%-10s%n", centerAlign(i.getItemName(),10),
						  	 	  rightAlign(String.valueOf(i.getItemPrice()),10));
			}
		}
		System.out.println("\n=================================");
	}
	
	public void printChechout(String itemName, String itemQuantity, String unitPrice, String rowTotal){
		System.out.printf("%-10s%-10s%-12s%-12s%n", 
				centerAlign(itemName,10), rightAlign(itemQuantity,10), 
				rightAlign(unitPrice,12),rightAlign(rowTotal,12));
	}
	
	public void printChechout(String itemName, String itemQuantity, String unitPrice, String rowTotal, String offerName){
		System.out.printf("%-10s%-10s%-12s%-12s%-20s%n", 
				centerAlign(itemName,10), rightAlign(itemQuantity,10), 
				rightAlign(unitPrice,12), rightAlign(rowTotal,12),centerAlign(offerName,20));
	}
	
	public void printCheckout(Cart cart) {
		System.out.println("===============================================================");
		printChechout("Item Name","Quantity","Unit Price","Row Total","Offer Code");
		System.out.println("===============================================================\n");
		String grandTotal = "                   Grand Total: £"+cart.calculateTotal();
		System.out.println("\n===============================================================");
		System.out.println(grandTotal);
		System.out.println("===============================================================\n");
	}
	
	public void thankingText() {
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		System.out.println("=============== Thank you for your purchase!!! ===============\n");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	public void printScanItems(List<Item> items) {
		printItemsList(items);
		System.out.print("Enter item name: ");
	}
	
	public void printAfterScanning() {
		System.out.print("What would you like to do?\n"
						+"1. Add more items\n"
						+"2. Checkout items\n"
						+"3. Delete item\n"
						+"Enter your choice: ");
	}
	public void printDeletionItems() {
		System.out.print("To delete item \n"
						+"Enter item name: ");
	}
	public void printUpdateItem() {
		System.out.print("To update item \n"
						+"Enter item name: ");
	}
	public void printAddItem() {
		System.out.print("To add item \n"
						+"Enter item name: ");
	}
	public void printInvalidPrice(){
		System.err.println("Invalid price.\n");
	}
	public void printInvalidOfferPrice(){
		System.err.println("Invalid price.\n");
	}
	public void printInvalidQuantity(){
		System.err.println("Invalid quantity.\n");
	}
	public void printUpdateQuantity() {
		System.out.print("To add special offfer \n"
						+"Please enter the quantity: ");
	}
	public void printUpdatePrice() {
		System.out.print(" \nPlease enter the price: ");
	}
	public void printUpdateOfferPrice() {
		System.out.print(" \nPlease enter the offer price: ");
	}
	public void printDeletionQuantity(Cart cart, String itemName, ItemsService itemService) {
		System.out.print("\n Available Quantity for item: "+itemName
				+ " -----> "+itemService.returnQuantityForItemInCart(cart, itemName)
				+ "\nEnter quantity to delete: ");
	}
	public void printItemNotFound() {
	    System.err.print("Item not found!!!\n");
	}
	public void printRunningTotal(Cart cart) {
		System.out.println("Running Total : £"+cart.calculateRunningTotal()+"\n");
	}
	private String centerAlign(String text, int width) {
	    int padding = Math.max(0, (width - text.length()) / 2);
	    StringBuilder centeredText = new StringBuilder(width);
	    
	    for (int i = 0; i < width; i++) {
	        if (i < padding || i >= padding + text.length()) {
	            centeredText.append(" ");
	        } else {
	            centeredText.append(text.charAt(i - padding));
	        }
	    }
	    
	    return centeredText.toString();
	}
	
	private String rightAlign(String text, int width) {
	    int padding = Math.max(0, width - text.length());
	    StringBuilder alignedText = new StringBuilder(width);
	    
	    for (int i = 0; i < width; i++) {
	        if (i < padding) {
	            alignedText.append(" ");
	        } else {
	            alignedText.append(text.charAt(i - padding));
	        }
	    }
	    
	    return alignedText.toString();
	}
}
