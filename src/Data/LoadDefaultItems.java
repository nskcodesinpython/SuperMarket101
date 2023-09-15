package Data;

import java.util.ArrayList;
import java.util.List;


public class LoadDefaultItems {
	public List<Item> addDefaultItems(){
		int id = 101;
		List<Item> itemsList = new ArrayList<>();
		SpecialPrice special = new SpecialPrice(2,40);
		Item item1 = new Item(id++,"A",30,special);
		Item item2 = new Item(id++,"B",25,special);
		SpecialPrice special1 = new SpecialPrice(2,30);
		Item item3 = new Item(id++,"C",20,special1);
		itemsList.add(item1);
		itemsList.add(item2);
		itemsList.add(item3);
		return itemsList;
	}
}
