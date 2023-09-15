package Test;

import static org.junit.Assert.*;
import org.junit.Test;

import Data.SpecialPrice;

public class SpecialPriceTest {

    @Test
    public void testSpecialPriceCreation() {
        SpecialPrice specialPrice = new SpecialPrice(2, 40);
        assertEquals(2, specialPrice.getSpecialQuantity());
        assertEquals(40, specialPrice.getSpecialPrice());
    }

    @Test
    public void testSpecialPriceUpdate() {
        SpecialPrice specialPrice = new SpecialPrice(2, 40);
        specialPrice.updateSpecialPrice(3, 50);
        assertEquals(3, specialPrice.getSpecialQuantity());
        assertEquals(50, specialPrice.getSpecialPrice());
    }
}
