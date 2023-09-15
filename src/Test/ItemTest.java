package Test;

import static org.junit.Assert.*;
import org.junit.Test;

import Data.Item;
import Data.SpecialPrice;

public class ItemTest {

    @Test
    public void testItemCreation() {
        Item item = new Item(1, "A", 30);
        assertEquals(1, item.getID());
        assertEquals("A", item.getItemName());
        assertEquals(30, item.getItemPrice());
        assertNull(item.getSpecialPrice());
    }

    @Test
    public void testItemUpdate() {
        Item item = new Item(1, "A", 30);
        item.updateItem("B", 40, new SpecialPrice(2, 35));
        assertEquals("B", item.getItemName());
        assertEquals(40, item.getItemPrice());
        assertNotNull(item.getSpecialPrice());
    }
}