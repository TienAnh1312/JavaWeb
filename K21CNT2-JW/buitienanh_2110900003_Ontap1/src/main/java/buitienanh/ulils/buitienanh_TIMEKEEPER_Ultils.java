package buitienanh.ulils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import buitienanh.beans.buitienanh_TIMEKEEPER;


public class buitienanh_TIMEKEEPER_Ultils {

	//Đọc danh sách sản phẩm 
	public static List<buitienanh_TIMEKEEPER> queryTimekeeper(Connection conn) throws SQLException{
		String sql = "Select a.Timekeeper_Id, a.Date_Time, a.In_Out, a.EMP_ID form buitienanh_TIMEKEEPER a ";
		PreparedStatement pstm = conn.prepareStatement(sql);
		List<buitienanh_TIMEKEEPER> list = new ArrayList<buitienanh_TIMEKEEPER>();
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			String Timekeeper_Id = rs.getString("Timekeeper_Id");
			String Date_Time = rs.getString("Date_Time");
			String In_Out = rs.getString("In_Out");
			String EMP_ID = rs.getString("EMP_ID");
		
			buitienanh_TIMEKEEPER timekeeper = new buitienanh_TIMEKEEPER();
			timekeeper.setTimekeeper_Id(Timekeeper_Id);
			timekeeper.setDate_Time(Date_Time);
			timekeeper.setIn_Out(In_Out);
			timekeeper.setEMP_ID(EMP_ID);
			
			list.add(timekeeper);
		}
		return list;
	}

	//Tìm kiếm theo mã sản phẩm (code)
	public static buitienanh_TIMEKEEPER findTimekeeper(Connection conn, String Timekeeper_Id) throws SQLException{
		String sql = "Select a.Timekeeper_Id, a.Date_Time, a.In_Out, a.EMP_ID  form buitienanh_TIMEKEEPER a where a.Code=?";	
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, Timekeeper_Id);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			String Date_Time = rs.getString("Date_Time");
			String In_Out = rs.getString("In_Out");
			String EMP_ID = rs.getString("EMP_ID");
			buitienanh_TIMEKEEPER timekeeper = new buitienanh_TIMEKEEPER(Timekeeper_Id, Date_Time, In_Out, EMP_ID);
			return timekeeper;
	}
		return null;
  }
	
	//Thêm mới sản phẩm
	public static void insertTimekeeper(Connection conn, buitienanh_TIMEKEEPER timekeeper) throws SQLException {
		String sql = "Insert into buitienanh_TIMEKEEPER (Timekeeper_Id, Date_Time, In_Out, EMP_ID) values (?,?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, timekeeper.getTimekeeper_Id());
		pstm.setString(2, timekeeper.getDate_Time());
		pstm.setString(3, timekeeper.getIn_Out());
		pstm.setString(4, timekeeper.getEMP_ID());
		
		pstm.executeUpdate();
	}
	
	//Cập nhập sản phẩm
	public static void updateTimekeeper(Connection conn, buitienanh_TIMEKEEPER timekeeper) throws SQLException{
		String sql =  "Update buitienanh_TIMEKEEPER set Timekeeper_Id =?, Date_Time=?, In_Out=?, EMP_ID=?  where Timekeeper_Id=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, timekeeper.getTimekeeper_Id());
		pstm.setString(2, timekeeper.getDate_Time());
		pstm.setString(3, timekeeper.getIn_Out());
		pstm.setString(4, timekeeper.getEMP_ID());
		pstm.executeUpdate();
	}
	
	//Xóa một sản phẩm
	public static void deleteTimekeeper (Connection conn ,String Timekeeper_Id) throws SQLException{
		String sql = "Delete Form buitienanh_TIMEKEEPER where Timekeeper_Id= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, Timekeeper_Id);;
		pstm.executeUpdate();
	}
	
}
