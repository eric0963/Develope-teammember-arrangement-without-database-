package model;

public class PRINTER implements Equipment{

	private String brand;
	private String model;
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public PRINTER() {
		super();
	}

	public PRINTER(String brand, String model) {
		super();
		this.brand = brand;
		this.model = model;
	}

	@Override
	public String getDescription() {
		return brand+"("+model+")";
	}

}
