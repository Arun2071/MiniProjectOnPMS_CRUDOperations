package com.pms.ui;

import com.pms.entity.*;
import com.pms.exception.ProductNotFoundException;
import com.pms.service.*;
import com.pms.util.DBUtil;
import com.pms.dao.*;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean flag = true;

		Scanner scanner = new Scanner(System.in);
		IProductService service = new ProductServiceImp();
		ProductDAO dao = new ProductDAO();

		while (flag) {

			System.out.println("WELCOME TO PMS");
			System.out.println("1. ADD Product");
			System.out.println("2. UPDATE Product");
			System.out.println("3. DELETE Product");
			System.out.println("4. SELECT Product");
			System.out.println("5. SELECT ALL");
			System.out.println("0. EXIT");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:

				System.out.println("Enter Product No:");
				int pno1 = scanner.nextInt();
				System.out.println("Enter Product Name");
				String pname1 = scanner.next();
				System.out.println("Enter Price");
				Double price = scanner.nextDouble();
				System.out.println("Enter Product manufacturing date : ");
				String dom1 = scanner.next();
				Date date = Date.valueOf(dom1);
				Product pro1 = new Product();

				Product prodt1 = new Product();

				prodt1.setPno(pno1);
				prodt1.setPname(pname1);
				prodt1.setPrice(price);
				prodt1.setDom(dom1);
				
				boolean isValid = ProductServiceImp.dataInputValidation(prodt1);

				if (isValid == true) {
					int count = dao.addProd(prodt1);
				

					System.out.println(count + " records inserted");
				} else {

		System.err.println("Invalid Inputs , Please Enter Correct Data");

				}
				break;
			case 2:

				System.out.println("Enter Product No:");
				int pno2 = scanner.nextInt();
				System.out.println("Enter Product Name");
				String pname2 = scanner.next();
				System.out.println("Enter Price");
				Double price2 = scanner.nextDouble();
				System.out.println("Enter the Date Of Manufacturing:");
				String dom2 = scanner.next();
				Date date2 = Date.valueOf(dom2);
				Product prod2 = new Product();

				prod2.setPno(pno2);
				prod2.setPname(pname2);
				prod2.setPrice(price2);
				prod2.setDom(dom2);
				int count1 = dao.updateProd(prod2);

				System.out.println(count1 + " records updated");

				break;
			case 3:

				System.out.println("Enter ProductNo to delete one record");

				int pno3 = scanner.nextInt();

				int count3 = dao.deleteProdByNo(pno3);

				System.out.println(count3 + " record deleted");
                 if(count3 == 0) {
					
					try {
					throw new ProductNotFoundException();
					}
					catch (Exception e) {

					System.err.println("Product Not Found , Cant delete record");
					}
				}
				break;
			case 4:

				System.out.println("Enter Pno to select record");
				int pno4 = scanner.nextInt();

				Product prodObj = dao.getProdByNo(pno4);

				System.out.println(prodObj);
				
          if(prodObj  == null) 
          {
					
					try {
					throw new ProductNotFoundException();
					}
					catch (Exception e) {

	System.err.println("Product Not Found , Can't search record");
					}
				
					}
				break;

			case 5:

				List<Product> list = dao.getAll();

				for (Product pr : list) {
					System.out.println(pr);

				}

				break;

			case 0:

				flag = false;
				DBUtil.closeConncetion();
				System.out.println("Thank you visit again..");
				break;

			default:
				System.err.println("Invalid input");
				break;
			}

		}

	}

}
