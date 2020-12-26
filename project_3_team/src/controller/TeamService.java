package controller;

import model.Architect;
import model.Designer;
import model.Employee;
import model.Programmer;

//開發團隊的添加與取消
public class TeamService {
	
	//給予開發團隊成員編號
	private static int counter=1;
	//開發團隊最大人數
	private final int MAX_MEMBER=5;
	//開發團隊陣列
	private Programmer[] team=new Programmer[MAX_MEMBER];
	//開發團隊實際人數
	private int total;
	
	
	
	public int getTotal() {
		return total;
	}

	public TeamService() {
		super();
	}
	
	//獲取開發團隊所有成員
	public Programmer[] getTeam() {
		Programmer[]arr=new Programmer[total];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=team[i];
		}
		return arr;
	}
	
	//加入開發團隊成員
	public void addMember(Employee e) throws TeamException {
		
		Programmer p=(Programmer)e;
		
		if(isExist(e)){
			throw new TeamException("該人員已在開發團隊中！");
		}
		if("BUSY".equalsIgnoreCase(p.getStatus().getNAME())) {
			throw new TeamException("該人員已在別的開發團隊中！");
		}else if("VOCATION".equalsIgnoreCase(p.getStatus().getNAME())) {
			throw new TeamException("該人員目前休假中！");
		}
		
		//先獲取團隊中各角色的人數
		int numOfArch=0,numOfDes=0,numOfPro=0;
		for (int i = 0; i < total; i++) {
			if(team[i] instanceof Architect) {
				numOfArch++;
			}else if(team[i] instanceof Designer) {
				numOfDes++;
			}else if(team[i] instanceof Programmer) {
				numOfPro++;
			}
		}
		if(p instanceof Architect) {
			if(numOfArch>=1) {
				throw new TeamException("團隊只能有一名架構師！");
			}
		}else if(p instanceof Designer) {
			if(numOfDes>=2) {
				throw new TeamException("團隊只能有二名設計師！");
			}
		}else if(p instanceof Programmer) {
			if(numOfPro>=3) {
				throw new TeamException("團隊只能有三名工程師！");
			}
		}
		
		//添加至團隊名單
		team[total]=p;
		total++;
		
		//選取後需改狀態及編號
		p.setStatus(Status.BUSY);
		p.setMemberId(counter++);
	}
	
		private boolean isExist(Employee e) {
			for (int i = 0; i < total; i++) {
				return team[i].getId()==e.getId();
			}
			return false;
		}

	//移除開發團隊成員
	public void removeMember(int memberId) throws TeamException{
		
		int i = 0;
		for (; i < total; i++) {
			if(team[i].getMemberId()==memberId) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		
		if(i==total) {
			throw new TeamException("團隊中無此編號，請重新輸入！");
		}
		
//		for (int j = 0; j <total; j++) {
//			if(memberId!=team[i].getMemberId()) {
//				throw new TeamException("團隊中無此編號，請重新輸入！");
//			}
//		}
		
		//若減掉一位，實際在團隊中的人數只有4位，不減1會出現NullPointerException
		for (int j = i; j < total-1; j++) {
			team[j]=team[j+1];
		}
		team[total-1]=null;
		total--;
		
		
		
	}
	
	

}
