package buitienanh.edu.vn.main;

import buitienanh.edu.vn.dao.ProductDaoImpl;
import buitienanh.edu.vn.entity.Product;

public class TestInstert {

	public static void main(String[] args) {
		Product p = new Product();
		p.setMaSP("P005");
		p.setTenSanPham("Kệ để giày");
		p.setAnhSanPham("P005.jpg");
		p.setSoLuong(150);
		p.setDonGia(1990000d);
		
		boolean flag = new ProductDaoImpl().insertProduct(p);
		if(flag == true) {
			System.out.println("Thêm mới thành công!");
		}else {
			System.out.println("Xảy ra lỗi thêm mới sản phẩm");
		}
	}

}
