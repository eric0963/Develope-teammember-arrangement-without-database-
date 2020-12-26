package model;

public class Architect extends Designer {

	private int stock;

	public Architect() {
		super();
	}

	public Architect(int id, String name, int age, int salary, Equipment equipment, int bonus, int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		return getDetail()+"\tArchitect"+"\t"+getStatus()+"\t"+getBonus()+"\t"+stock+"\t"+getEquipment().getDescription();
	}
	
	@Override
	public String getTeamDetails() {
		return getMemberId()+"/"+getDetail()+"\tArchitect\t"+getBonus()+"\t"+getStock();
	}
	
	
}
