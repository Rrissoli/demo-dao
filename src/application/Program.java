package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		SellerDao sellerdao = DaoFactory.createSellerDao();
		
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerdao.findById(3);
		System.out.println(seller);
		
		System.out.println("=== TEST 2: seller findByDepartment === \n");
		Department departament = new Department(2, null);
		List <Seller> list = sellerdao.findByDepartment(departament);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 3: seller findAll ===\n");
		List <Seller> list2 = sellerdao.findAll();
		for (Seller obj : list2) {
			System.out.println(obj);
		}
		
		System.out.println("=== TEST 4: seller Insert ===\n");
		Seller newSeller = new Seller(null, "greg", "geg@gmail.com", new Date(), 4000.00, departament);
		sellerdao.insert(newSeller);
		System.out.println("Inserted ! new id=" + newSeller.getId());
		
		System.out.println("=== TEST 5: seller Update ===\n");
		seller = sellerdao.findById(1);
		seller.setName("marta waine");
		seller.setBaseSalary(8000000.00);
		sellerdao.update(seller);
		
		System.out.println("update completed");
		System.out.println("=== TEST 6: seller Delete ===\n");
		System.out.println("Enter id for delete seller");
		int id = sc.nextInt();	
		sellerdao.deleteById(id);
		System.out.println("deleted");
		
		DepartmentDao departamentdao = DaoFactory.createDepartmentDao();
		System.out.println("=== TEST 7: department insert ===\n");
		Department dep = new Department(10, "roça");
		departamentdao.insert(dep);
		System.out.println("Inserted department");
	}

}
