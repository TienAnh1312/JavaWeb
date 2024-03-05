package buitienanh.ulils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import buitienanh.beans.buitienanh_DEPARTMENT;

public class buitienanh_DEPARTMENT_Ultils {

	//Đọc danh sách sản phẩm 
			public static List<buitienanh_DEPARTMENT> queryDepartment(Connection conn) throws SQLException{
				String sql = "Select a.DEPT_ID, a.DEPT_NAME, a.DEPT_NO, a.LOCATION form buitienanh_DEPARTMENT a ";
				PreparedStatement pstm = conn.prepareStatement(sql);
				List<buitienanh_DEPARTMENT> list = new ArrayList<buitienanh_DEPARTMENT>();
				ResultSet rs = pstm.executeQuery();
				while(rs.next()) {
					String DEPT_ID = rs.getString("DEPT_ID");
					String DEPT_NAME = rs.getString("DEPT_NAME");
					String DEPT_NO = rs.getString("DEPT_NO");
					String LOCATION = rs.getString("LOCATION");
				
					buitienanh_DEPARTMENT department = new buitienanh_DEPARTMENT();
					department.setDEPT_ID(DEPT_ID);
					department.setDEPT_NAME(DEPT_NAME);
					department.setDEPT_NO(DEPT_NO);
					department.setLOCATION(LOCATION);
					
					list.add(department);
				}
				return list;
			}

			//Tìm kiếm theo mã sản phẩm (code)
			public static buitienanh_DEPARTMENT findDepartment(Connection conn, String DEPT_ID) throws SQLException{
				String sql = "Select a.DEPT_ID, a.DEPT_NAME, a.DEPT_NO, a.LOCATION  form buitienanh_DEPARTMENT a where a.Code=?";	
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, DEPT_ID);
				ResultSet rs = pstm.executeQuery();
				while(rs.next()) {
					String DEPT_NAME = rs.getString("DEPT_NAME");
					String DEPT_NO = rs.getString("DEPT_NO");
					String LOCATION = rs.getString("LOCATION");
					buitienanh_DEPARTMENT department = new buitienanh_DEPARTMENT(DEPT_ID, DEPT_ID, DEPT_NO, LOCATION);
					return department;
			}
				return null;
		  }
			
			//Thêm mới sản phẩm
			public static void insertDepartment(Connection conn, buitienanh_DEPARTMENT department) throws SQLException {
				String sql = "Insert into buitienanh_DEPARTMENT (DEPT_ID, DEPT_NAME, DEPT_NO, LOCATION) values (?,?,?)";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, department.getDEPT_ID());
				pstm.setString(2, department.getDEPT_NAME());
				pstm.setString(3, department.getDEPT_NO());
				pstm.setString(4, department.getLOCATION());
				
				pstm.executeUpdate();
			}
			
			//Cập nhập sản phẩm
			public static void updateDepartment(Connection conn, buitienanh_DEPARTMENT department) throws SQLException{
				String sql =  "Update buitienanh_DEPARTMENT set DEPT_ID =?, DEPT_NAME=?, DEPT_NO, LOCATION  where DEPT_ID=?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, department.getDEPT_ID());
				pstm.setString(2, department.getDEPT_NAME());
				pstm.setString(3, department.getDEPT_NO());
				pstm.setString(4, department.getLOCATION());
				pstm.executeUpdate();
			}
			
			//Xóa một sản phẩm
			public static void deleteDepartment (Connection conn ,String DEPT_ID) throws SQLException{
				String sql = "Delete Form buitienanh_DEPARTMENT where DEPT_ID= ?";
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setString(1, DEPT_ID);;
				pstm.executeUpdate();
			}
	
}
