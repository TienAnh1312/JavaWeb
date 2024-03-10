package buitienanh.servlet.category;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import buitienanh.conn.Connection_Ontap2;
import buitienanh.utils.category_Utils;

@WebServlet("/category_Delete")
public class category_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public category_Delete() {
        super();
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException , IOException{
		
		String errorString = null ;
		int CategoryId =(int)request.getDateHeader("CategoryId");
		Connection conn = null;		
		
		try {
			conn = Connection_Ontap2.getMSSQLConnection();
			category_Utils.deletecategory(conn, CategoryId);;
			
		}catch (Exception e) {
			e.printStackTrace();
			errorString= e.getMessage();
		}
		//khi co loi
		if(errorString != null ) {
			request.setAttribute("errString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/category/category_Delete.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/category_List");
		}
	}
	protected void doPost(HttpServletRequest request ,HttpServletResponse response)throws ServletException , IOException{
		doGet(request,response);
	}

}
