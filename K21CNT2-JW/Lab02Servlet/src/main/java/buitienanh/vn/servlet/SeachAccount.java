package buitienanh.vn.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SeachAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = null;

    public SeachAccount() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter(); 
		
		//lấy dữ liệu khi submit form từ useraccount
		String phone = request.getParameter("phone");
		
		out.println("<html><head><meta charset='UTF-8'><title>InputForm</title></head>");
		out.println("<body style='text-align:center'>");
		out.println("<h1> Kết quả tìm kiếm </h1>");
		out.println("<form action='SearchAccount' method='post'>");

		out.println("<p> Input phone: ");
		out.println("<input type=text name='phone' value='"+ phone +"'/>");
		out.println("<p> <input type='submit' value='Search' />");

		out.println("</form>");
		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String sql = "Select * from USER_ACCOUNT ";
			if(phone!=null && phone.length()!=0)
				sql += "Where CusPhone like '%" + phone + "%'";
			
			Connection conn = ConnectionUtils.getMSSQLConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			out.println("<h2> Danh sách </h2>");
			out.println("<table border=1 align='center' style='width:50%'>");
			out.println("<tr><th>User</th><th>Name</th><th>Phone</th><tr>");
	
			if (rs != null) {
			while (rs.next()) { //Đọc dữ liệu và hiển thị
	
				out.println("<tr>");
				out.println("<td>" + rs.getString("CusUser") + "</td>");	
		
				out.println("<td>" + rs.getString("CusName") + "</td>");
				
				out.println("<td>" + rs.getString("CusPhone") + "</td>");
		
				out.println("</tr>");
			}
		}
		rs.close();
		out.println("</table>");
		
		} catch (Exception ex) {
			out.println("<h1>" + ex.getMessage() + " </h1>");
			out.println("<p>" + ex.toString() + " </p>");
		}
		out.println("</body>");
		out.println("</html>");
	}

}
