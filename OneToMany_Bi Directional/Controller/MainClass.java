package org.jsp.OneToMany2.Controller;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.jsp.OneToMany2.dao.MerchantDao;
import org.jsp.OneToMany2.dao.ProductDao;
import org.jsp.OneToMany2.dto.Merchant;
import org.jsp.OneToMany2.dto.Product;

public class MainClass {
	private static Scanner input = new Scanner(System.in);
	private static MerchantDao mdao = new MerchantDao();
	private static ProductDao pdao = new ProductDao();

	public static void main(String[] args) {
		System.err.println("Choose The Below Options:");
		System.out.println(
				"1.Save Merchant \n2.Update Merchant\n3.Find Merchant By Id\n4.Verify Merchant By Phone And Password\n5.Verify Merchant By Email And Password\n6.Add Product\n7.Update Product\n8.Find Products By Merchant Id\n9.Find Products By Brand\n10.Find Products By Category");
		switch (input.nextInt()) {
		case 1: {
			SaveMerchant();
			break;
		}
		case 2: {
			updateMerchant();
			break;
		}
		case 3: {
			FindById();
			break;
		}
		case 4: {
			VerifyPhoneandPassword();
			break;
		}
		case 5: {
			VerifyEmailandPassword();
			break;
		}
		case 6: {
			saveproduct();
			break;
		}
		case 7: {
			UpdateProduct();
			break;
		}
		case 8: {
			FindByMerchantId();
			break;
		}
		case 9: {
			FindByBrand();
			break;
		}
		case 10: {
			FindBycategory();
			break;
		}
		default: {
			System.err.println("Invalid Choice...!!!");
		}

		}
	}

	public static void SaveMerchant() {
		System.out.println("Enter The Name,Phone,Email,GsT No and Password To Save The Merchant:");
		Merchant m = new Merchant();
		m.setName(input.next());
		m.setPhone(input.nextLong());
		m.setEmail(input.next());
		m.setGst(input.next());
		m.setPassword(input.next());
		Merchant m1 = mdao.SaveMerchant(m);
		System.out.println("Merchant Saved With The Id Of : " + m1.getId());
	}

	public static void updateMerchant() {
		System.out.println("Enter The Id To Update The Merchant");
		int id = input.nextInt();
		Merchant m = new Merchant();
		System.out.println("Enter The Name,Phone,Email,GsT No and Password To Update The Merchant:");
		m.setId(id);
		m.setName(input.next());
		m.setPhone(input.nextLong());
		m.setEmail(input.next());
		m.setGst(input.next());
		m.setPassword(input.next());
		Merchant M = mdao.updateMerchant(m);
		if (M != null) {
			System.out.println("Merchant Saved With The Id Of : " + M.getId());
		} else {
			System.err.println(" Invalid Merchant Id..!!!");
		}
	}

	public static void FindById() {
		System.out.println("Enter The Id To Find The Merchant :");
		int id = input.nextInt();
		Merchant M = mdao.findMerchantByid(id);
		if (M != null) {
			System.out.println(M.getName());
			System.out.println(M.getPhone());
			System.out.println(M.getEmail());
			System.out.println(M.getGst());
		} else {
			System.err.println("Invalid merchant Id");
		}
	}

	public static void VerifyPhoneandPassword() {
		System.out.println("Enter The Phone Number :");
		long phone = input.nextLong();
		System.out.println("Enter The password :");
		String password = input.next();
		Merchant M = mdao.veriftByPhone(phone, password);
		if (M != null) {
			System.out.println(M.getName());
			System.out.println(M.getPhone());
			System.out.println(M.getEmail());
			System.out.println(M.getGst());
		} else {
			System.err.println("Invalid merchant ...!!!");
		}
	}

	public static void VerifyEmailandPassword() {
		System.out.println("Enter The Email Id :");
		String email = input.next();
		System.out.println("Enter The password :");
		String password = input.next();
		Merchant M = mdao.veriftByEmail(email, password);
		if (M != null) {
			System.out.println(M.getName());
			System.out.println(M.getPhone());
			System.out.println(M.getEmail());
			System.out.println(M.getGst());
		} else {
			System.err.println("Invalid merchant ...!!!");
		}
	}

	public static void saveproduct() {
		System.out.println("Enter The Merchant Id To Save Tha product :");
		int admin_id = input.nextInt();
		System.out.println("Enter The Name,Brand,Category,Description,Cost,Url To save The Product");
		Product p = new Product();
		p.setName(input.next());
		p.setBrand(input.next());
		p.setCategory(input.next());
		p.setDescription(input.next());
		p.setCost(input.nextDouble());
		p.setURL(input.next());
		Product P = pdao.Saveproduct(admin_id, p);
		if (P != null) {
			System.out.println("Product Saved with The Id Of " + P.getId());
		} else {
			System.err.println("Invalid Merchant Id..!!!");
		}
	}

	public static void UpdateProduct() {
		System.out.println("Enter The  Id,Name,Brand,Category,Description,Cost,Url To Update The Product");
		Product p = new Product();
		p.setId(input.nextInt());
		p.setName(input.next());
		p.setBrand(input.next());
		p.setCategory(input.next());
		p.setDescription(input.next());
		p.setCost(input.nextDouble());
		p.setURL(input.next());
		Product P = pdao.UpdateProduct(p);
		if (P != null) {
			System.out.println("Product Updated With The id Of : " + P.getId());
		} else {
			System.err.println("Product Not Updated");
		}
	}

	public static void FindByMerchantId() {
		System.out.println("Enter The merchant id :");
		int mid = input.nextInt();
		List<Product> p = pdao.FindByMerchantId(mid);
		if (p.size() > 0) {
			for (Product pro : p) {
				System.out.println(pro.getName());
				System.out.println(pro.getBrand());
				System.out.println(pro.getCategory());
				System.out.println(pro.getDescription());
				System.out.println(pro.getURL());
			}
		} else {
			System.err.println("Product Not Found..!!!");
		}
	}

	public static void FindByBrand() {
		System.out.println("Enter The Brand to Find product ");
		String brand = input.next();
		Product p = pdao.FindBybrand(brand);
		if (p != null) {
			System.out.println(p.getName());
			System.out.println(p.getBrand());
			System.out.println(p.getCategory());
			System.out.println(p.getDescription());
			System.out.println(p.getURL());
		} else {
			System.err.println("Product Not Found..!!!");
		}
	}

	public static void FindBycategory() {
		System.out.println("Enter The Category to Find product ");
		String category = input.next();
		Product p = pdao.FindByCategory(category);
		if (p != null) {
			System.out.println(p.getName());
			System.out.println(p.getBrand());
			System.out.println(p.getCategory());
			System.out.println(p.getDescription());
			System.out.println(p.getURL());
		} else {
			System.err.println("Product Not Found..!!!");
		}

	}
}
