package Test;

import static org.junit.Assert.*;
import org.junit.Test;

import Data.Item;
import Data.LoadDefaultItems;

import java.util.List;

public class LoadDefaultItemsTest {

    @Test
    public void testAddDefaultItems() {
        LoadDefaultItems loader = new LoadDefaultItems();
        List<Item> itemsList = loader.addDefaultItems();
        assertNotNull(itemsList);
        assertFalse(itemsList.isEmpty());
    }
}
