package model;

public class PC implements Equipment{

	private String brand;
	private String display;
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}
	
	public PC() {
		super();
	}

	public PC(String brand, String display) {
		super();
		this.brand = brand;
		this.display = display;
	}

	@Override
	public String getDescription() {
		return brand+"("+display+")";
	}

}
