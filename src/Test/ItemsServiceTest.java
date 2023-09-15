package Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import Data.Item;
import Service.Cart;
import Service.ItemsService;
import java.util.ArrayList;
import java.util.List;

public class ItemsServiceTest {
    private List<Item> itemsList;
    private ItemsService itemsService;

    @Before
    public void setUp() {
        itemsList = new ArrayList<>();
        itemsList.add(new Item(101, "A", 30));
        itemsList.add(new Item(102, "B", 25));
        itemsService = new ItemsService();
    }

    @Test
    public void testCheckIfPresent() {
        assertTrue(itemsService.checkIfPresent(itemsList, "A"));
        assertFalse(itemsService.checkIfPresent(itemsList, "C"));
    }

    @Test
    public void testGetItemByName() {
        Item item = itemsService.getItemByName(itemsList, "B");
        assertNotNull(item);
        assertEquals("B", item.getItemName());
    }

    @Test
    public void testCheckIfItemPresentInCart() {
        Cart cart = new Cart();
        cart.scanItem(itemsList.get(0));
        assertTrue(itemsService.checkIfItemPresentInCart(cart, "A"));
        assertFalse(itemsService.checkIfItemPresentInCart(cart, "B"));
    }

    @Test
    public void testReturnQuantityForItemInCart() {
        Cart cart = new Cart();
        cart.scanItem(itemsList.get(0));
        cart.scanItem(itemsList.get(0));
        assertEquals(2, itemsService.returnQuantityForItemInCart(cart, "A"));
    }
}
