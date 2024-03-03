package buitienanh.edu.vn.main;

import buitienanh.edu.vn.dao.ProductDaoImpl;
import buitienanh.edu.vn.entity.Product;

public class TestUpdate {

	public static void main(String[] args) {
	
		Product p = new ProductDaoImpl().getProductById("P005");
		p.setMaSP("P005");
		p.setTenSanPham("Kệ để giày hàn quốc");
		p.setAnhSanPham("P005.jpg");
		p.setSoLuong(150);
		p.setDonGia(2990000d);
		
		boolean flag = new ProductDaoImpl().updateProduct(p);
		if(flag == true) {
			System.out.println("Sửa đổi dữ liệu thành công!");
		}else {
			System.out.println("Xảy ra lỗi sửa mới sản phẩm");
		}
	}

}
