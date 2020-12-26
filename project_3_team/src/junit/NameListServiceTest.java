package junit;

import org.junit.Test;

import controller.NameListService;
import controller.TeamException;
import model.Employee;

public class NameListServiceTest {

	@Test
	public void testDetEmployee()  {
		NameListService service=new NameListService();
		Employee employee=null;;
		int id=13;
		try {
			 employee = service.getEmployee(id);
			 System.out.println(employee);
		} catch (TeamException e) {
			System.out.println(e.getMessage());
		}
	}
	
//	@Test
//	public void testGetAllEmployee() {
//		NameListService service=new NameListService();
//		Employee[] all = service.getAllEmployees();
//		for (int i = 0; i < all.length; i++) {
//			System.out.println(all[i]);
//		}
//	}
	
}
