package Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Data.Item;
import Data.LoadDefaultItems;
import Service.Cart;

public class CartTest {
    private Cart cart;
    private LoadDefaultItems loadDefaultItems;
    List<Item> items;
    @Before
    public void setUp() {
        cart = new Cart();
        loadDefaultItems = new LoadDefaultItems();
        items = loadDefaultItems.addDefaultItems();
    }

    @Test
    public void testScanItem() {
        Item item = new Item(1, "A", 30);
        cart.scanItem(item);
        assertTrue(cart.getItems().containsKey(item));
    }

    @Test
    public void testRemoveItem() {
        Item item = new Item(1, "A", 30);
        cart.scanItem(item);
        cart.removeItem("A", 1);
        assertFalse(cart.getItems().containsKey(item));
    }
}
