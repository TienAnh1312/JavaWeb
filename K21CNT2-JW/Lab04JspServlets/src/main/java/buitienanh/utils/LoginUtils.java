package buitienanh.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import buitienanh.beans.UserAccount;

public class LoginUtils {
	public static UserAccount findUser(Connection conn, 
			String userName, String password) throws SQLException{
		String sql = "Select a.User_Name, a.Password, a.Gender form User_Account a "
				+ "where a.User_Name =? and a.password= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()) {
			String gender = rs.getString("Gender");
			UserAccount user = new UserAccount();
			user.setUserName(userName);
			user.setPassword(password);
			user.setGender(gender);
			return user;
		}
		return null;
	}
}