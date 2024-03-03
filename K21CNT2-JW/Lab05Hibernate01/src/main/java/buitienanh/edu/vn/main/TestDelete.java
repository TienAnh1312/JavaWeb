package buitienanh.edu.vn.main;

import buitienanh.edu.vn.dao.ProductDaoImpl;

public class TestDelete {

	public static void main(String[] args) {

		boolean flag = new ProductDaoImpl().deleteProduct("P005");
		if(flag == true) {
			System.out.println("Xóa sản phẩm có mã P005!");
		}else {
			System.out.println("Xảy ra lỗi xóasản phẩm");
		}

	}

}
