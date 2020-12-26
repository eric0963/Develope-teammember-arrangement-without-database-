package model;

public class Designer extends Programmer {
	private int bonus;

	public Designer() {
		super();
	}

	public Designer(int id, String name, int age, int salary, Equipment equipment, int bonus) {
		super(id, name, age, salary, equipment);
		this.bonus = bonus;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		return getDetail()+"\tDesigner"+"\t"+getStatus()+"\t"+bonus+"\t\t"+getEquipment().getDescription();
	}
	
	@Override
	public String getTeamDetails() {
		return getMemberId()+"/"+getDetail()+"\tDesigner\t"+getBonus();
	}
	
}
