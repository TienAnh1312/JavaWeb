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

public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = null;
       
    public Employee() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter(); 

		out.println("<html><head><meta charset='UTF-8'><title>InputForm</title></head>");

		out.println("<body style='text-align:center'>");
		out.println("<h1> DEMO tra cứu bằng Servlet </h1>");
		out.println("<form action='' method='post'>");

		out.println("<p> EMP_NAME: ");
		out.println("<input type=text name='EMP_NAME'/>");
		
		out.println("<p> EMP_NO: ");
		out.println("<input type=text name='EMP_NO'/>");
		
		out.println("<p> SALARY: ");
		out.println("<input type=text name='SALARY'/>");
		
		out.println("<p> <input type='submit' value='Search' />");

		out.println("</form>");
		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String sql = "Select * from Employee ";
			Connection conn = ConnectionUtils.getMSSQLConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			out.println("<h2> Danh sách </h2>");
			out.println("<table border=1 align='center' style='width:50%'>");
			out.println("<tr><th>User</th><th>Name</th><th>Phone</th><tr>");
	
			if (rs != null) {
			while (rs.next()) { 
	
				out.println("<tr>");
				out.println("<td>" + rs.getString("EMP_NAME") + "</td>");	
		
				out.println("<td>" + rs.getString("EMP_NO") + "</td>");
				
				out.println("<td>" + rs.getString("SALARY") + "</td>");
		
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
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter(); 
		
		//lấy dữ liệu khi submit form từ useraccount
		String EMP_NAME = request.getParameter("EMP_NAME");
        String EMP_NO = request.getParameter("EMP_NO");
        String SALARY = request.getParameter("SALARY");
		
		out.println("<html><head><meta charset='UTF-8'><title>InputForm</title></head>");
		out.println("<body style='text-align:center'>");
		out.println("<h1> Kết quả tìm kiếm </h1>");
		out.println("<form action='' method='post'>");
		out.println("<p> <input type='submit' value='Back' />");

		out.println("</form>");
		try {
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String sql = "SELECT EMP_NAME, EMP_NO, SALARY FROM Employee";
//			String sql = "Select * from Employee ";
			if(EMP_NAME !=null && EMP_NAME.length()!=0)
				sql += "Where EMP_NAME like '%" + EMP_NAME + "%'";
			
			if(EMP_NO!=null && EMP_NO.length()!=0)
				sql += "Where EMP_NO like '%" + EMP_NO + "%'";
			
			if(SALARY!=null && SALARY.length()!=0)
				sql += "Where SALARY like '%" + SALARY + "%'";
			
			Connection conn = ConnectionUtils.getMSSQLConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			out.println("<h2> Danh sách </h2>");
			out.println("<table border=1 align='center' style='width:50%'>");
			out.println("<tr><th>Name</th><th>No</th><th>SALARY</th><tr>");
	
			if (rs != null) {
			while (rs.next()) { //Đọc dữ liệu và hiển thị
	
				out.println("<tr>");
				out.println("<td>" + rs.getString("EMP_NAME") + "</td>");	
		
				out.println("<td>" + rs.getString("EMP_NO") + "</td>");
				
				out.println("<td>" + rs.getString("SALARY") + "</td>");
		
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
