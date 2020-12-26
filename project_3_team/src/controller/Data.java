package controller;

public class Data {
	public static final int EMPLOYEE=10;
	public static final int PROGRAMMER=11;
	public static final int DESIGNER=12;
	public static final int ARCHIECT=13;
	
	public static final int PC=21;
	public static final int NOTEBOOK=22;
	public static final int PRINTER=23;

	//EMPLOYEE   : 10, id, name, age, salary
	//PROGRAMMER : 11, id, name, age, salary
	//DESIGNER   : 12, id, name, age, salary, bonus
	//ARCHIECT   : 13, id, name, age, salary, bonus, stock
	
	public static final String[][]EMPLOYEES= {
			{"10","1", "Alex",  "23","25000"},
			{"13","2", "Brian", "34","50000","15000","20000"},
			{"11","3", "Chris", "29","30000"},
			{"11","4", "David", "29","31000"},
			{"12","5", "Eric",  "29","30000","5000"},
			{"11","6", "Frank", "28","31000"},
			{"12","7", "George","30","31000","6000"},
			{"13","8", "Henry", "33","51000","15000","15000"},
			{"12","9", "Iven",  "26","32000","4000"},
			{"11","10","Jack",  "21","25000"},
			{"11","11","Kevin", "22","27000"},
			{"12","12","Larry", "28","32000","3000"},
	};
	
	//PC       : 21, brand, display
	//NOTEBOOK : 22, brand, price
	//PRINTER  : 23, brand, model 
	
	public static final String[][] EQUIPMENTS= {
			{},
			{"22","Apple","48000"},
			{"21","Dell", "17吋"},
			{"21","Dell", "17吋"},
			{"23","Epson","EP-123"},
			{"21","Asus", "17吋"},
			{"21","Asus", "17吋"},
			{"23","Epson","EP-123"},
			{"22","Acer", "39000"},
			{"21","Asus", "17吋"},
			{"21","Asus", "17吋"},
			{"22","Apple","43000"},
	};
}
