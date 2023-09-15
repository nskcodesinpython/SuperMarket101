package Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Data.Item;
import Service.GatherInputFromTerminal;
import Service.InventoryService;
import Service.PrintToTerminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryServiceTest {
    private InventoryService inventoryService;
    private List<Item> itemsList;

    @Before
    public void setUp() {
        inventoryService = new InventoryService();
        itemsList = new ArrayList<>();
        itemsList.add(new Item(1, "A", 30));
    }

    @Test
    public void testAddItemInInventory() {
        itemsList = inventoryService.addItemInInventory(new Scanner(System.in), new PrintToTerminal(), new GatherInputFromTerminal(), itemsList);
        assertTrue(inventoryService.checkIfItemPresentInInventory(itemsList, "D"));
    }

    @Test
    public void testUpdateItemInInventory() {
        itemsList = inventoryService.updateItemInInventory(new Scanner(System.in), new PrintToTerminal(), new GatherInputFromTerminal(), itemsList);
        assertEquals(20, inventoryService.getItemByItemName(itemsList,"A").getItemPrice());
    }

    @Test
    public void testDeleteItemFromInventory() {
        itemsList = inventoryService.deleteItemFromInventory(new Scanner(System.in), new PrintToTerminal(), new GatherInputFromTerminal(), itemsList);
        assertFalse(inventoryService.checkIfItemPresentInInventory(itemsList, "A"));
    }
}

