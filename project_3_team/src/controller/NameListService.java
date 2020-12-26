package controller;

import model.Architect;
import model.Designer;
import model.Employee;
import model.Equipment;
import model.NOTEBOOK;
import model.PC;
import model.PRINTER;
import model.Programmer;


//將data中的數據以Employee[]陣列儲存，並提供相關方法
public class NameListService {

	private Employee[] employees;

	//employees
	public NameListService() {
		//給EMPLOYEES陣列初始化
		employees=new Employee[Data.EMPLOYEES.length];
		
		//用迴圈建立檔案
		for (int i = 0; i < employees.length; i++) {
			//將Data中4個角色的名字拉進來
			//將EMPLOYEES陣列與Data中的常數結合套用在switch中
			int type = Integer.parseInt(Data.EMPLOYEES[i][0]);
			
			//將Data中各角色的屬性拉進來
			int id = Integer.parseInt(Data.EMPLOYEES[i][1]);
			String name = Data.EMPLOYEES[i][2];
			int age = Integer.parseInt(Data.EMPLOYEES[i][3]);
			int salary = Integer.parseInt(Data.EMPLOYEES[i][4]);
			
			//由於Equipment裡又有細分不同種類，故另外做一個class敘述
			Equipment equipment;
			int bonus;
			int stock;
			
			switch(type) {
			//為增加閱讀性，將case數字改為常數名
			case Data.EMPLOYEE:
				employees[i]=new Employee(id, name, age, salary);
				break;
			case Data.PROGRAMMER:
				equipment=createEquipment(i);
				employees[i]=new Programmer(id, name, age, salary, equipment);
				break;
			case Data.DESIGNER:
				equipment=createEquipment(i);
				bonus = Integer.parseInt(Data.EMPLOYEES[i][5]);
				employees[i]=new Designer(id, name, age, salary, equipment, bonus);
				break;
			case Data.ARCHIECT:
				equipment=createEquipment(i);
				bonus = Integer.parseInt(Data.EMPLOYEES[i][5]);
				stock = Integer.parseInt(Data.EMPLOYEES[i][6]);
				employees[i]=new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
				
			}
		}
	}
	
	//獲取Equipment各種資料
	private Equipment createEquipment(int index) {
		//將Data中3個裝備的名字拉進來
		//將EQUIPMENTS陣列與Data中的常數結合套用在switch中
		int type = Integer.parseInt(Data.EQUIPMENTS[index][0]);
		
		//將Data中各裝備的屬性拉進來
		String brand = Data.EQUIPMENTS[index][1];
		String display = Data.EQUIPMENTS[index][2];
		String price=Data.EQUIPMENTS[index][2];
		String model = Data.EQUIPMENTS[index][2];
		
		
		switch(type) {
		//為增加閱讀性，將case數字改為常數名
		case Data.PC:
			return new PC(brand, display);
		case Data.NOTEBOOK:
			return new NOTEBOOK(brand, price);
		case Data.PRINTER:
			return new PRINTER(brand, model);
		}
		return null;
	}

	//取得所有員工資料
	public Employee[] getAllEmployees() {
		return employees;
		
	}
	
	//取得指定員工資料
	public Employee getEmployee(int id) throws TeamException {
		for (int i = 0; i < employees.length; i++) {
			if(id==employees[i].getId()) {
				return employees[i];
			}
		}
		throw new TeamException("查無此編號，請重新輸入！");
	}
}
