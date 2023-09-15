package Service;

import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import Data.Item;

public class GatherInputFromTerminal {
	private ItemsService itemService;
	private InventoryService inventoryService; 
	public GatherInputFromTerminal() {
		itemService = new ItemsService();
		inventoryService = new InventoryService();
	}
	//to improve reusability of code, method printBasedOnStringInput is used to redirect to the specific print function
	public void printBasedOnStringInput(String input, PrintToTerminal printToTerminal) {
		if(input.equals("start"))
			printToTerminal.startMenu();
		else if(input.equals("after_scanning"))
			printToTerminal.printAfterScanning();
		else if(input.equals("inventory"))
			printToTerminal.printInventory();
		else if(input.equals("delete_item_inventory"))
			printToTerminal.printDeletionItems();
		else if(input.equals("update_item_inventory"))
			printToTerminal.printUpdateItem();
		else if(input.equals("add_item_inventory"))
			printToTerminal.printAddItem();
		else if(input.equals("update_item_quantity_inventory"))
			printToTerminal.printUpdateQuantity();
		else if(input.equals("update_item_price_inventory"))
			printToTerminal.printUpdatePrice();
		else if(input.equals("add_item_price_inventory"))
			printToTerminal.printUpdatePrice();
		else if(input.equals("special_offer_check"))
			printToTerminal.printSpecialOfferCheck();
		else if(input.equals("update_item_offer_price_inventory"))
			printToTerminal.printUpdateOfferPrice();
	}
	/*To improve reusability of code, method printBasedOnStringInputInvalid is used
	 * to redirect to the specific print function when the user's input is invalid
	*/
	public void printBasedOnStringInputInvalid(String input, PrintToTerminal printToTerminal) {
		if(input.equals("update_item_quantity_inventory"))
			printToTerminal.printInvalidQuantity();
		else if(input.equals("update_item_price_inventory"))
			printToTerminal.printInvalidPrice();
		else if(input.equals("special_offer_check"))
			printToTerminal.printSpecialOfferCheck();
		else if(input.equals("update_item_offer_price_inventory"))
			printToTerminal.printInvalidOfferPrice();
		
	}
	// get the choice which is an integer from the user 
	public int getOption(Scanner sc, PrintToTerminal printToTerminal,  String inputFor, Predicate<Integer> validate) {
		int choice;
		do {
			synchronized(this){
				printBasedOnStringInput(inputFor, printToTerminal);
				while (!sc.hasNextInt()){
	                System.err.println("Invalid option.\n");
	                printBasedOnStringInput(inputFor, printToTerminal);
	                sc.next();
	            }
	            choice = sc.nextInt();
	            if (!validate.test(choice)) {
	            	System.err.println("Invalid option.\n");
	            }
			}
		}while(!validate.test(choice));
		return choice;
	}
	// get the price, quantities which is an integer from the user 
	public int getItemPriceAndQuantity(Scanner sc, PrintToTerminal printToTerminal, String inputFor, Predicate<Integer> validate) {
		int choice;
		do {
			synchronized(this){
				printBasedOnStringInput(inputFor, printToTerminal);
				while (!sc.hasNextInt()) {
					printBasedOnStringInputInvalid(inputFor, printToTerminal);
	                printToTerminal.printAfterScanning();
	                sc.next();
	            }
	            choice = sc.nextInt();
	            if (!validate.test(choice)) {
	            	printBasedOnStringInputInvalid(inputFor, printToTerminal);
	            }
			}
		}while(!validate.test(choice));
		return choice;
	}
	//delete an item from the cart
	public boolean deleteItem(Cart cart, PrintToTerminal printToTerminal, Scanner sc) {
		String deletionItem = getItemToDelete(cart,printToTerminal, sc);
		int deletionQuantity = getQuantity(cart, deletionItem,printToTerminal, sc);
		return cart.removeItem(deletionItem, deletionQuantity);
	}
	//get the itemName to delete from the user
	public String getItemToDelete(Cart cart,PrintToTerminal printToTerminal, Scanner sc) {
		String itemName;
		do {
			printToTerminal.printDeletionItems();
			itemName = sc.next();
            if (!itemService.checkIfItemPresentInCart(cart, itemName)) {
            	System.err.println("Item not present in the cart.\n");
            }
		}while(!itemService.checkIfItemPresentInCart(cart, itemName));
		return itemName;
	}
	//get the itemName from the user for the updating the item in the inventory
	public String getItemForInventoryChange(PrintToTerminal printToTerminal, Scanner sc, String inputFor, List<Item> itemsList) {
		String itemName;
		do {
			printBasedOnStringInput(inputFor, printToTerminal);
			itemName = sc.next();
            if (!inventoryService.checkIfItemPresentInInventory(itemsList, itemName)) {
            	System.err.println("Item not present in the inventory.\n");
            }
		}while(!inventoryService.checkIfItemPresentInInventory(itemsList, itemName));
		return itemName;
	}
	//get the itemName from the user for the adding the item in the inventory
	public String getItemForInventoryAdd(PrintToTerminal printToTerminal, Scanner sc, String inputFor, List<Item> itemsList) {
		String itemName;
		do {
			printBasedOnStringInput(inputFor, printToTerminal);
			itemName = sc.next();
            if (inventoryService.checkIfItemPresentInInventory(itemsList, itemName)) {
            	System.err.println("Item already present in the inventory\n");
            }
            if(itemName.length() !=1) {
            	System.err.println("Item name needs to be a single character\n");
            }
		}while(inventoryService.checkIfItemPresentInInventory(itemsList, itemName) || itemName.length()!=1);
		return itemName;
	}
	//getting quantity to delete the item in the cart
	public int getQuantity(Cart cart, String itemName, PrintToTerminal printToTerminal, Scanner sc) {
		int quantity;
		do {
			printToTerminal.printDeletionQuantity(cart, itemName, itemService);
			while (!sc.hasNextInt()) {
                System.err.println("Invalid Quantity.\n");
                printToTerminal.printDeletionQuantity(cart, itemName, itemService);
                sc.next();
            }
            quantity = sc.nextInt();
            if (!itemService.checkQuantityIsValid(cart, itemName, quantity)) {
            	System.err.println("Invalid Quantity.\n");
            }
		}while(!itemService.checkQuantityIsValid(cart, itemName, quantity));
		return quantity;
	}
}
