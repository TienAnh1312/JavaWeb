package buitienanh.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import buitienanh.beans.category;



public class category_Utils {
	//Đọc danh sách sản phẩm 
		public static List<category> querycategory (Connection conn) throws SQLException{
			String sql = "Select a.CategoryId, a.CategoryName form category a ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			List<category> list = new ArrayList<category>();
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
					
				int CategoryId = rs.getInt("CategoryId");
				String CategoryName = rs.getString("CategoryName");
			
				category categories = new category();
				categories.setCategoryId(CategoryId);
				categories.setCategoryName(CategoryName);
				
				list.add(categories);
			}
			return list;
		}

		//Tìm kiếm theo mã sản phẩm (code)
		public static category findcategory (Connection conn, int CategoryId) throws SQLException{
			String sql = "Select a.CategoryId, a.CategoryName form category a where a.Code=?";	
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, CategoryId);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				String CategoryName = rs.getString("CategoryName");
				
				category categories = new category(CategoryId, CategoryName);
				return categories;
		}
			return null;
	  }
		
		//Thêm mới sản phẩm
		public static void insertcategory (Connection conn, category categories) throws SQLException {
			String sql = "Insert into category (CategoryId, CategoryName) values (?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, categories.getCategoryId());
			pstm.setString(2, categories.getCategoryName());
			
			pstm.executeUpdate();
		}
		
		//Cập nhập sản phẩm
		public static void updatecategory (Connection conn, category categories) throws SQLException{
			String sql =  "Update category set CategoryId =?, CategoryName =?   where CategoryId=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, categories.getCategoryId());
			pstm.setString(2, categories.getCategoryName());
			
			pstm.executeUpdate();
		}
		
		//Xóa một sản phẩm
		public static void deletecategory (Connection conn ,int CategoryId) throws SQLException{
			String sql = "Delete Form category where CategoryId= ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, CategoryId);
			pstm.executeUpdate();
		}
}
