package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
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
	}

}
