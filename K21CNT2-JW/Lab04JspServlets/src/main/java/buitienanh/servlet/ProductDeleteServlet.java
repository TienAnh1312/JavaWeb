package buitienanh.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import buitienanh.conn.ConnectionUtils;
import buitienanh.servlet.RequestDispatcher;
import buitienanh.utils.ProductUtils;

@WebServlet("/productDelete")
public class ProductDeleteServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public ProductDeleteServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException , IOException{
		
		String errorString = null ;
		String code =(String)request.getParameter("code");
		Connection conn = null;		
		
		try {
			conn = ConnectionUtils.getMySQLConnection();
			ProductUtils.deleteProduct(conn, code);
			
		}catch (Exception e) {
			e.printStackTrace();
			errorString= e.getMessage();
		}
		//khi co loi
		if(errorString != null ) {
			request.setAttribute("errString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/productDeleteError.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/productList");
		}
	}
	protected void doPost(HttpServletRequest request ,HttpServletResponse response)throws ServletException , IOException{
		doGet(request,response);
	}
}

