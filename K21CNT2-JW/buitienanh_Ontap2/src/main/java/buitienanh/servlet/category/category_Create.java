package buitienanh.servlet.category;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import buitienanh.beans.category;
import buitienanh.conn.Connection_Ontap2;
import buitienanh.utils.category_Utils;

@WebServlet("/category_Create")
public class category_Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public category_Create() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/category/category_Create.jsp");
        dispatcher.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException , IOException{
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		//lay du lie tren form
		int CategoryId = (int) request.getDateHeader("CategoryId");
		String CategoryName =(String) request.getParameter("CategoryName");		
		
		category categories = new category(CategoryId, CategoryName);
		if(errorString !=null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("categories", categories);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/category/category_Edit.jsp");
			dispatcher.forward(request, response);
		}
		Connection conn = null;
		try {
			conn = Connection_Ontap2.getMSSQLConnection();
			category_Utils.updatecategory(conn, categories);
			response.sendRedirect(request.getContextPath()+"/category_List");
		
		}catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			request.setAttribute("categories", categories);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/category/category_Edit.jsp");
			dispatcher.forward(request, response);
		}
	}

}
