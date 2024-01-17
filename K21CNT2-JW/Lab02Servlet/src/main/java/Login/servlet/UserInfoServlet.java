package Login.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import buitienanh.vn.servlet.ConnectionUtils;

public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserInfoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Lấy thông tin người dùng từ parameter
        String CusUser = request.getParameter("CusUser");

        // Hiển thị thông tin người dùng
        out.println("<h2>User Information</h2>");
        out.println("<p>Welcome, " + CusUser + "!</p>");

        // Hiển thị thông tin từ cơ sở dữ liệu
        displayUserInfo(CusUser, out);
    }

    private void displayUserInfo(String CusUser, PrintWriter out) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
        	   // Kết nối đến cơ sở dữ liệu
        	String sql = "SELECT * FROM USER_ACCOUNT WHERE username = ?";
			Connection conn = ConnectionUtils.getMSSQLConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
            
            String dbUser = "CusUser";
            String dbPassword = "CusPass";
            connection = DriverManager.getConnection(sql, dbUser, dbPassword);

            // Truy vấn cơ sở dữ liệu để kiểm tra thông tin đăng nhập
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, CusUser);
            resultSet = preparedStatement.executeQuery();

            // Hiển thị thông tin người dùng
            while (resultSet.next()) {
                out.println("<p>User ID: " + resultSet.getInt("userID") + "</p>");
                out.println("<p>Email: " + resultSet.getString("email") + "</p>");
                // Thêm các thông tin khác tùy thuộc vào cấu trúc bảng của bạn
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tất cả các resource
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
