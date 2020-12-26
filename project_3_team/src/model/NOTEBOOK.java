package model;

public class NOTEBOOK implements Equipment{

	private String brand;
	private String price;
	
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public NOTEBOOK() {
		super();
	}
	
	public NOTEBOOK(String brand, String price) {
		super();
		this.brand = brand;
		this.price = price;
	}

	@Override
	public String getDescription() {
		return brand+"("+price+")";
	}

}
