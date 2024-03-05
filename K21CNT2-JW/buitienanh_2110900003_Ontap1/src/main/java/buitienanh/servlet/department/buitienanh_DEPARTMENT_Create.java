package buitienanh.servlet.department;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import buitienanh.beans.buitienanh_DEPARTMENT;
import buitienanh.conn.buitienanhConnection_Ontap;
import buitienanh.ulils.buitienanh_DEPARTMENT_Ultils;

public class buitienanh_DEPARTMENT_Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public buitienanh_DEPARTMENT_Create() {
        super();
  
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/buitienanh_DEPARTMENT/buitienanh_DEPARTMENT_Create.jsp");
        dispatcher.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException , IOException{
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		//lay du lie tren form
		String DEPT_ID =(String) request.getParameter("DEPT_ID");
		String DEPT_NAME =(String) request.getParameter("DEPT_NAME");
		String DEPT_NO = (String) request.getParameter("DEPT_NO");
		String LOCATION =(String) request.getParameter("LOCATION");		
		
		buitienanh_DEPARTMENT derpartment = new buitienanh_DEPARTMENT(DEPT_ID , DEPT_NAME, DEPT_NO, LOCATION);
		if(errorString !=null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("derpartment", derpartment);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/buitienanh_DEPARTMENT/buitienanh_DEPARTMENT_Edit.jsp");
			dispatcher.forward(request, response);
		}
		Connection conn = null;
		try {
			conn = buitienanhConnection_Ontap.getMSSQLConnection();
			buitienanh_DEPARTMENT_Ultils.updateDepartment(conn, derpartment);
			response.sendRedirect(request.getContextPath()+"/buitienanh_DEPARTMENT_List");
		
		}catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			request.setAttribute("book", derpartment);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/buitienanh_DEPARTMENT/buitienanh_DEPARTMENT_Edit.jsp");
			dispatcher.forward(request, response);
		}
	}
}
