package Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Data.Item;
import Data.LoadDefaultItems;

public class SuperMarket {
	 // Member variable declarations
	private Cart cart;
	private LoadDefaultItems loadDefaultItems;
	private PrintToTerminal printToTerminal;
	private ItemsService itemsService;
	private GatherInputFromTerminal gatherInputFromTerminal;
	private InventoryService inventoryService;
	private List<Item> itemsList;
	private static boolean inventoryMangement = false;
	Scanner sc;
	
	public static void main(String args[]) {
		SuperMarket superMarket = null;
		while(true) {		
			if(inventoryMangement==false) {
			superMarket = new SuperMarket();
			}
			superMarket.start();
		}
	}
	// Constructor to initialize objects and load default items
	public SuperMarket() {
		/*Initializing objects of classes 
		 * Cart, LoadDefaultItems, PrintToTerminal, ItemsService, GatherInputFromTerminal 
		 */
		cart = new Cart();
		loadDefaultItems = new LoadDefaultItems();
		printToTerminal = new PrintToTerminal();
		itemsService = new ItemsService();
		gatherInputFromTerminal = new GatherInputFromTerminal();
		inventoryService = new InventoryService();
		sc = new Scanner(System.in);
		//initialize ArrayList which takes Item class object as an input
		itemsList = new ArrayList<>();
		//load the default items with few being SpecialPrice
		itemsList=loadDefaultItems.addDefaultItems();
		
	}
	// Method to start the supermarket application
	public void start() {
		printToTerminal.welcomeText();
		int choice = gatherInputFromTerminal.getOption(sc, printToTerminal, 
															"start",c-> c ==1 || c==2 || c==3);
		if(choice == 1)
			scanningItems();
		else if(choice ==2)
			inventoryManagement();
		else
			System.exit(0);
	}
	// Method for inventory management
	public void inventoryManagement() {
		inventoryMangement = true;
		int choice = gatherInputFromTerminal.getOption(sc, printToTerminal, 
											"inventory", c-> c ==1 || c==2 || c ==3);
		if(choice == 1) {
			itemsList = inventoryService.addItemInInventory(sc, printToTerminal, 
										gatherInputFromTerminal, itemsList);
		}else if (choice == 2){
			itemsList = inventoryService.updateItemInInventory(sc, printToTerminal, 
										gatherInputFromTerminal, itemsList);
		}else {
			itemsList = inventoryService.deleteItemFromInventory(sc,printToTerminal, 
										gatherInputFromTerminal, itemsList);
		}
	}
	// Method for scanning items and managing the shopping cart
	public void scanningItems() {
		int choice=-1;
		while(true) {
			if(choice !=3) {
				printToTerminal.printScanItems(itemsList);
				String itemName = sc.next();
				if(itemsService.checkIfPresent(itemsList,itemName)) {
					cart.scanItem(itemsService.getItemByName(itemsList, itemName));
					printToTerminal.printCheckout(cart);
					choice = gatherInputFromTerminal.getOption
										(sc, printToTerminal, "after_scanning", c-> c ==1 || c==2 || c==3);
					if(choice==1)
						continue;
					else if(choice==2) {
						printToTerminal.printCheckout(cart);
						printToTerminal.thankingText();
						break;
					}else {
						gatherInputFromTerminal.deleteItem(cart, printToTerminal, sc);
						continue;
					}
				}
				else {
					printToTerminal.printItemNotFound();
				}
			}else {
				choice = gatherInputFromTerminal.getOption
						(sc, printToTerminal, "after_scanning", c-> c ==1 || c==2 || c==3);
				if(choice==1) {
					continue;
				}
				else if(choice==2) {
					printToTerminal.printCheckout(cart);
					break;
				}else {
					gatherInputFromTerminal.deleteItem(cart, printToTerminal, sc);	
				}
			}
		}
	}
}
