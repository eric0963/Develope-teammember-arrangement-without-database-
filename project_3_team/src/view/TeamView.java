package view;

import controller.NameListService;
import controller.TeamException;
import controller.TeamService;
import dao.TUtility;
import model.Employee;
import model.Programmer;

public class TeamView {

	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();

	public void enterMainMenu() {
		boolean isFlag = true;
		char read =0;
		while (isFlag) {
			if (read!='1' ) {
				listAllEmployee();
			}
			System.out.println("1.團隊總表 2.添加團隊成員 3.刪除團隊成員 4.退出 ");
			System.out.println("請輸入 1-4 ");
			read = TUtility.readMenuSelection();
			switch (read) {
			case '1':
				getTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMemebr();
				System.out.println("3");
				break;
			case '4':
				System.out.println("是否確定要退出？(Y/N) ");
				char isExit = TUtility.readConfirmSelection();
				if (isExit == 'Y') {
					System.out.println("下次見！！ ");
					isFlag = false;
				}

			}
		}
	}

	private void listAllEmployee() {
		System.out.println("--------------------開發團隊配置表-------------------");
		System.out.println();
		System.out.println("ID\t姓名\t年齡\t薪水\t職位\t\t狀態\t獎金\t股票\t領取裝備");
		Employee[] all = listSvc.getAllEmployees();
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
		System.out.println("--------------------------------------------------");

	}

	private void getTeam() {
		Programmer[] team = teamSvc.getTeam();
		if (team == null || team.length == 0) {
			System.out.println("------------------新開發團隊表-----------------");
			System.out.println("目前開發團隊沒有成員！");
		} else {
			System.out.println("------------------新開發團隊表-----------------");
			System.out.println("TID/ID\t姓名\t年齡\t薪水\t職位\t\t獎金\t股票");
			for (int i = 0; i < team.length; i++) {
				System.out.println(team[i].getTeamDetails());
			}
		}
		System.out.println("--------------------------------------------------");
	}

	private void addMember() {
		System.out.println("----------------------添加成員---------------------");

		System.out.println("請輸入要添加的ID編號:");
		int number = TUtility.readInt();
		try {
			Employee newMem = listSvc.getEmployee(number);
			teamSvc.addMember(newMem);
			System.out.println("*** 添加成員成功! ***");
		} catch (TeamException e) {
			System.out.println("添加失敗："+e.getMessage());
		} catch(ClassCastException e) {
			System.out.println("*** 該員經驗不夠，無法增加！***");
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("*** 成為最多5位，無法再增加！***");
		}
		TUtility.readReturn();
	}

	private void deleteMemebr() {
		System.out.println("----------------------刪除成員---------------------");
		System.out.println("請輸入要刪除的團隊編號: (TID)");
		int number = TUtility.readInt();
		try {
			System.out.println("確定要刪除? (Y/N)");
			char isDelete = TUtility.readConfirmSelection();
			if(isDelete=='Y') {
				teamSvc.removeMember(number);
				System.out.println("*** 刪除成功！ ***");
			}else {
				return;
			}
		} catch (TeamException e) {
			System.out.println("刪除失敗："+e.getMessage());
		}
		TUtility.readReturn();

	}

	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();
	}
}
