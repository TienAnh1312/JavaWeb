package buitienanh.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import buitienanh.beans.publisher;


public class publisher_Utils {
	//Đọc danh sách sản phẩm 
			public static List<publisher> querypublisher (Connection conn) throws SQLException{
				String sql = "Select a.PublisherId, a.PublisherName, a.Phone, a.Address form publisher a ";
				PreparedStatement pstm = conn.prepareStatement(sql);
				List<publisher> list = new ArrayList<publisher>();
				ResultSet rs = pstm.executeQuery();
				while(rs.next()) {
						
					int PublisherId = rs.getInt("PublisherId");
					String PublisherName = rs.getString("PublisherName");
					String Phone = rs.getString("Phone");
					String Address = rs.getString("Address");
				
					publisher publishers = new publisher();
					publishers.setPublisherId(PublisherId);
					publishers.setPublisherName(PublisherName);
					publishers.setPhone(Phone);
					publishers.setAddress(Address);
					
					list.add(publishers);
				}
				return list;
			}

			//Tìm kiếm theo mã sản phẩm (code)
			public static publisher findpublisher (Connection conn, int PublisherId) throws SQLException{
				String sql = "Select a.PublisherId, a.PublisherName, a.Phone, a.Address form publisher a where a.Code=?";	
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, PublisherId);
				ResultSet rs = pstm.executeQuery();
				while(rs.next()) {
					String PublisherName = rs.getString("PublisherName");
					String Phone = rs.getString("Phone");
					String Address = rs.getString("Address");
					
					publisher publishers = new publisher(PublisherId, PublisherName, Phone, Address);
					return publishers;
			}
				return null;
		  }
			
			//Thêm mới sản phẩm
			public static void insertpublisher (Connection conn, publisher publishers) throws SQLException {
				String sql = "Insert into publisher (PublisherId, PublisherName, Phone, Address) values (?,?,?)";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, publishers.getPublisherId());
				pstm.setString(2, publishers.getPublisherName());
				pstm.setString(3, publishers.getPhone());
				pstm.setString(4, publishers.getAddress());
				
				pstm.executeUpdate();
			}
			
			//Cập nhập sản phẩm
			public static void updatepublisher (Connection conn, publisher publishers) throws SQLException{
				String sql =  "Update publisher set PublisherId =?, PublisherName =?, Phone =?, Address =?  where PublisherId=?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, publishers.getPublisherId());
				pstm.setString(2, publishers.getPublisherName());
				pstm.setString(3, publishers.getPhone());
				pstm.setString(4, publishers.getAddress());
				
				pstm.executeUpdate();
			}
			
			//Xóa một sản phẩm
			public static void deletepublisher (Connection conn ,int PublisherId) throws SQLException{
				String sql = "Delete Form publisher where PublisherId= ?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, PublisherId);
				pstm.executeUpdate();
			}
}
