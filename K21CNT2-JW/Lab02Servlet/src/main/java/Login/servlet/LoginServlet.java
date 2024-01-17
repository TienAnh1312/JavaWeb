package Login.servlet;

import jakarta.servlet.ServletException;
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


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Hiển thị form đăng nhập
        out.println("<html><head><title>Login Page</title></head><body>");
        out.println("<h2>Login</h2>");
        out.println("<form method=\"post\" action=\"LoginServlet\">");
        out.println("Username: <input type=\"text\" name=\"username\"><br>");
        out.println("Password: <input type=\"password\" name=\"password\"><br>");
        out.println("<input type=\"submit\" value=\"Login\">");
        out.println("</form>");
        out.println("</body></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Lấy thông tin đăng nhập từ form
        String CusUser = request.getParameter("CusUser");
        String CusPass = request.getParameter("CusPass");

        // Kiểm tra thông tin đăng nhập
        if (checkLogin(CusUser, CusPass)) {
            // Nếu đúng, chuyển hướng đến servlet hiển thị thông tin người dùng
            response.sendRedirect("UserInfoServlet?username=" + CusUser);
        } else {
            // Nếu sai, hiển thị thông báo lỗi
            out.println("<h2>Login Failed. Incorrect username or password.</h2>");
        }
    }

    private boolean checkLogin(String CusUser, String CusPass) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Kết nối đến cơ sở dữ liệu
        	String sql = "SELECT * FROM USER_ACCOUNT WHERE username = ? AND password = ?";
			Connection conn = ConnectionUtils.getMSSQLConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
            
            String dbUser = "CusUser";
            String dbPassword = "CusPass";
            connection = DriverManager.getConnection(sql, dbUser, dbPassword);

            // Truy vấn cơ sở dữ liệu để kiểm tra thông tin đăng nhập
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, CusUser);
            preparedStatement.setString(2, CusPass);
            resultSet = preparedStatement.executeQuery();

            // Nếu có kết quả từ truy vấn, tức là thông tin đăng nhập chính xác
            return resultSet.next();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
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
}


