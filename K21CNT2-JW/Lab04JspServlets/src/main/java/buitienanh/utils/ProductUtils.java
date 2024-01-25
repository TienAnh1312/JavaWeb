package buitienanh.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import buitienanh.beans.Product;
import buitienanh.beans.UserAccount;

public class ProductUtils {
	//Đọc danh sách sản phẩm 
	public static List<Product> queryProduct(Connection conn) throws SQLException{
		String sql = "Select a.Code, a.Name, a.Price form Product a ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		List<Product> list = new ArrayList<Product>();
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			String code = rs.getString("Code");
			String name = rs.getString("Name");
			float price = rs.getFloat("price");
			Product product = new Product();
			product.setCode(code);
			product.setName(name);
			product.setPrice(price);
			list.add(product);
		}
		return list;
	}

	//Tìm kiếm theo mã sản phẩm (code)
	public static Product findProduct(Connection conn, String code) throws SQLException{
		String sql = "Select a.Code, a.Name, a.Price form Product a where a.Code=?";	
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, code);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			String name = rs.getString("Name");
			float price = rs.getFloat("price");
			Product product = new Product(code, name, price);
			return product;
	}
		return null;
  }
	//Thêm mới sản phẩm
	public static void insertProduct(Connection conn, Product product) throws SQLException {
		String sql = "Insert into Product(code, Name, Price) values (?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, product.getCode());
		pstm.setString(2, product.getName());
		pstm.setFloat(3, product.getPrice());
		pstm.executeUpdate();
	}
	//Cập nhập sản phẩm
	public static void updateProduct(Connection conn, Product product) throws SQLException{
		String sql =  "Update Product set Name =?, Price=? where Code=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, product.getCode());
		pstm.setFloat(2, product.getPrice());
		pstm.setString(3, product.getName());
		pstm.executeUpdate();
	}
	//Xóa một sản phẩm
	public static void deleteProduct (Connection conn ,String code) throws SQLException{
		String sql = "Delete Form Product where Code= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, code);
		pstm.executeUpdate();
	}
}
