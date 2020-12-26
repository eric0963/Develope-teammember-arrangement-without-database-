package dao;
/*
 * 
 * char c = 'a';
		boolean b = true;
		while (b) {
			String str = readKeyboard(1, false);
			c = str.charAt(0);
			if (c != '1' && c != '2' && c != '3' && c != '4' && c != '5') {
				System.out.println("請輸入 1-5");
			} else {
				b = false;
				break;
			}
		}
		return c;
 */

import java.util.Scanner;

public class TUtility {
	
	private static Scanner scan=new Scanner(System.in);
	
	//讀取客戶輸入的數字進行選單
	public static char readMenuSelection() {
		char c='a';
		boolean b=true;
		while(b) {
			String str=readKeyboard(1, false);
			c = str.charAt(0);
			if(c!='1' && c!='2' && c!='3' && c!='4') {
				System.out.println("無法辨識，請輸入1-4!!");
			}else {
				b=false;
				break;
			}
		}
		return c;
	}
	
	//按Enter繼續
	public static void readReturn() {
		System.out.println("按Enter繼續...");
		readKeyboard(100, true);
	}
	
	//讀取客戶輸入的2位數字
	public static int readInt() {
		int i;
		for(;;) {
			String str=readKeyboard(2, false);
			try {
				i = Integer.parseInt(str);
				break;
			} catch (NumberFormatException e) {
				System.out.print("數字輸入錯誤，請重新輸入！");
			}
		}
		return i;
	}
	
	//yes or no
	public static char readConfirmSelection() {
		char c;
		for(;;) {
			String str=readKeyboard(1, false).toUpperCase();
			c = str.charAt(0);
			if(c=='Y' || c=='N') {
				break;
			}else {
				System.out.print("無法辨識！請重新輸入。");
			}
		}
		return c;
	}

	//讀取客戶輸入的限制長度內容
	private static String readKeyboard(int limit, boolean b) {
		String str = "";

		while (scan.hasNextLine()) {
			str = scan.nextLine();
			if (str.length() == 0) {
				if (b) {
					return str;
				} else {
					continue;
				}
			}
			if (str.length() < 1 || str.length() > limit) {
				System.out.println("輸入長度不可多於"+limit+"!!無法辨識！！！");
				continue;
			}
			break;
		}
		return str;
	}

}
