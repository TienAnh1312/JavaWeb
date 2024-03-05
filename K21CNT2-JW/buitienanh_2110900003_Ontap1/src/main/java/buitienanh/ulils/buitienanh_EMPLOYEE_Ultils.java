package buitienanh.ulils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import buitienanh.beans.buitienanh_EMPLOYEE;



public class buitienanh_EMPLOYEE_Ultils {

	//Đọc danh sách sản phẩm 
	public static List<buitienanh_EMPLOYEE> queryEmployee(Connection conn) throws SQLException{
		String sql = "Select a.EMP_ID, a.EMP_NAME, a.EMP_NO, a.HIRE_DATE, a.IMAGE, a.JOB, a.SALARY, a.DEPT_ID, a.MNG_ID form buitienanh_EMPLOYEE a ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		List<buitienanh_EMPLOYEE> list = new ArrayList<buitienanh_EMPLOYEE>();
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			String EMP_ID = rs.getString("EMP_ID");
			String EMP_NAME = rs.getString("EMP_NAME");
			String EMP_NO = rs.getString("EMP_NO");
			String HIRE_DATE = rs.getString("HIRE_DATE");
			String IMAGE = rs.getString("IMAGE");
			String JOB = rs.getString("JOB");
			String SALARY = rs.getString("SALARY");
			String MNG_ID = rs.getString("MNG_ID");
			
		
			buitienanh_EMPLOYEE employee = new buitienanh_EMPLOYEE();
			employee.setEMP_ID(EMP_ID);
			employee.setEMP_NAME(EMP_NAME);
			employee.setEMP_NO(EMP_NO);
			employee.setHIRE_DATE(HIRE_DATE);
			employee.setIMAGE(IMAGE);
			employee.setJOB(JOB);
			employee.setSALARY(SALARY);
			employee.setMNG_ID(MNG_ID);
			
			list.add(employee);
		}
		return list;
	}

	//Tìm kiếm theo mã sản phẩm (code)
	public static buitienanh_EMPLOYEE findEmployee(Connection conn, String EMP_ID) throws SQLException{
		String sql = "Select a.EMP_ID, a.EMP_NAME, a.EMP_NO, a.HIRE_DATE, a.IMAGE, a.JOB, a.SALARY, a.DEPT_ID, a.MNG_ID  form buitienanh_EMPLOYEE a where a.Code=?";	
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, EMP_ID);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			String EMP_NAME = rs.getString("EMP_NAME");
			String EMP_NO = rs.getString("EMP_NO");
			String HIRE_DATE = rs.getString("HIRE_DATE");
			String IMAGE = rs.getString("IMAGE");
			String LOCATION = rs.getString("LOCATION");
			String JOB = rs.getString("JOB");
			String SALARY = rs.getString("SALARY");
			String MNG_ID = rs.getString("MNG_ID");
			
			buitienanh_EMPLOYEE employee = new buitienanh_EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, IMAGE, LOCATION, JOB, SALARY, MNG_ID);
			return employee;
	}
		return null;
  }
	
	//Thêm mới sản phẩm
	public static void insertEmployee(Connection conn, buitienanh_EMPLOYEE employee) throws SQLException {
		String sql = "Insert into buitienanh_EMPLOYEE (EMP_ID, EMP_NAME, EMP_NO, HIRE_DATE, IMAGE, JOB, SALARY, MNG_ID) values (?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, employee.getEMP_ID());
		pstm.setString(2, employee.getEMP_NAME());
		pstm.setString(3, employee.getEMP_NO());
		pstm.setString(4, employee.getHIRE_DATE());
		pstm.setString(5, employee.getIMAGE());
		pstm.setString(6, employee.getJOB());
		pstm.setString(7, employee.getSALARY());
		pstm.setString(8, employee.getMNG_ID());
		
		pstm.executeUpdate();
	}
	
	//Cập nhập sản phẩm
	public static void updateEmployee(Connection conn, buitienanh_EMPLOYEE employee) throws SQLException{
		String sql =  "Update buitienanh_EMPLOYEE set EMP_ID =?, EMP_NAME=?, EMP_NO=?, HIRE_DATE=?, IMAGE=?, JOB=?, SALARY=?, MNG_ID=?   where EMP_ID=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, employee.getEMP_ID());
		pstm.setString(2, employee.getEMP_NAME());
		pstm.setString(3, employee.getEMP_NO());
		pstm.setString(4, employee.getHIRE_DATE());
		pstm.setString(5, employee.getIMAGE());
		pstm.setString(6, employee.getJOB());
		pstm.setString(7, employee.getSALARY());
		pstm.setString(8, employee.getMNG_ID());
		pstm.executeUpdate();
	}
	
	//Xóa một sản phẩm
	public static void deleteEmployee (Connection conn ,String EMP_ID) throws SQLException{
		String sql = "Delete Form buitienanh_EMPLOYEE where EMP_ID= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, EMP_ID);;
		pstm.executeUpdate();
	}
	
}
