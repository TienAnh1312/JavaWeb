package buitienanh.ulils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import buitienanh.beans.buitienanh_SALARY_GRADE;

public class buitienanh_SALARY_GRADE_Ultils {

	//Đọc danh sách sản phẩm 
		public static List<buitienanh_SALARY_GRADE> querySalary(Connection conn) throws SQLException{
			String sql = "Select a.GRADE, a.HIGH_SALARY, a.LOW_SALARY form buitienanh_SALARY_GRADE a ";
			PreparedStatement pstm = conn.prepareStatement(sql);
			List<buitienanh_SALARY_GRADE> list = new ArrayList<buitienanh_SALARY_GRADE>();
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				String GRADE = rs.getString("GRADE");
				String HIGH_SALARY = rs.getString("HIGH_SALARY");
				String LOW_SALARY = rs.getString("LOW_SALARY");
			
				buitienanh_SALARY_GRADE salary = new buitienanh_SALARY_GRADE();
				salary.setGRADE(GRADE);
				salary.setHIGH_SALARY(HIGH_SALARY);
				salary.setLOW_SALARY(LOW_SALARY);
						
				list.add(salary);
			}
			return list;
		}

		//Tìm kiếm theo mã sản phẩm (code)
		public static buitienanh_SALARY_GRADE findSalary(Connection conn, String GRADE) throws SQLException{
			String sql = "Select a.GRADE, a.HIGH_SALARY, a.LOW_SALARY  form buitienanh_SALARY_GRADE a where a.Code=?";	
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, GRADE);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				String HIGH_SALARY = rs.getString("HIGH_SALARY");
				String LOW_SALARY = rs.getString("LOW_SALARY");
				
				buitienanh_SALARY_GRADE salary = new buitienanh_SALARY_GRADE(GRADE, HIGH_SALARY, LOW_SALARY);
				return salary;
		}
			return null;
	  }
		
		//Thêm mới sản phẩm
		public static void insertSalary(Connection conn, buitienanh_SALARY_GRADE salary) throws SQLException {
			String sql = "Insert into buitienanh_SALARY_GRADE (GRADE, HIGH_SALARY, LOW_SALARY) values (?,?,?)";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, salary.getGRADE());
			pstm.setString(2, salary.getHIGH_SALARY());
			pstm.setString(3, salary.getLOW_SALARY());
	
			pstm.executeUpdate();
		}
		
		//Cập nhập sản phẩm
		public static void updateSalary(Connection conn, buitienanh_SALARY_GRADE salary) throws SQLException{
			String sql =  "Update buitienanh_SALARY_GRADE set GRADE =?, HIGH_SALARY=?, EMP_NO=?, LOW_SALARY=? where GRADE=?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, salary.getGRADE());
			pstm.setString(2, salary.getHIGH_SALARY());
			pstm.setString(3, salary.getLOW_SALARY());
			
			pstm.executeUpdate();
		}
		
		//Xóa một sản phẩm
		public static void deleteSalary (Connection conn ,String GRADE) throws SQLException{
			String sql = "Delete Form buitienanh_SALARY_GRADE where GRADE= ?";
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, GRADE);;
			pstm.executeUpdate();
		}
	
}
