package buitienanh.vn.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class UserAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = null;
       
    
    public UserAccount() {
        super();
    }

	
	public void init(ServletConfig config) throws ServletException {
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter(); 

		out.println("<html><head><meta charset='UTF-8'><title>InputForm</title></head>");

		out.println("<body style='text-align:center'>");
		out.println("<h1> DEMO tra cứu bằng Servlet </h1>");
		out.println("<form action='SeachAccount' method='post'>");

		out.println("<p> Input phone: ");
		out.println("<input type=text name='phone'/>");
		out.println("<p> <input type='submit' value='Seach' />");

		out.println("</form>");
		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String sql = "Select * from USER_ACCOUNT ";
			Connection conn = ConnectionUtils.getMSSQLConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			out.println("<h2> Danh sách </h2>");
			out.println("<table border=1 align='center' style='width:50%'>");
			out.println("<tr><th>User</th><th>Name</th><th>Phone</th><tr>");
	
			if (rs != null) {
			while (rs.next()) { 
	
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
