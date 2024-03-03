package buitienanh.edu.vn.main;

import java.util.List;

import buitienanh.edu.vn.dao.ProductDaoImpl;
import buitienanh.edu.vn.entity.Product;

public class TestSelect {

	public TestSelect() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<Product> list = new ProductDaoImpl().getallproduct();
		if(list == null)
			return;
		for(Product item:list) {
			System.out.printf("\n%-10s", item.getMaSP());
			System.out.printf("%-15s", item.getTenSanPham());
			System.out.printf("% 15d", item.getSoLuong());
			System.out.printf("% 15.)f", item.getDonGia());
		}
	}

}
