package Data;

public class SpecialPrice {
	private int specialQuantity;
	private int specialPrice;
	
	public SpecialPrice(int specialQuantity, int specialPrice) {
		this.specialQuantity = specialQuantity;
		this.specialPrice = specialPrice;
	}
	
	public void updateSpecialPrice(int specialQuantity, int specialPrice) {
		this.specialQuantity = specialQuantity;
		this.specialPrice = specialPrice;
	}
	
	public int getSpecialQuantity() {
		return specialQuantity;
	}

	public int getSpecialPrice() {
		return specialPrice;
	}
	public String getOffer() {
		return specialQuantity+" for "+specialPrice;
	}
}
