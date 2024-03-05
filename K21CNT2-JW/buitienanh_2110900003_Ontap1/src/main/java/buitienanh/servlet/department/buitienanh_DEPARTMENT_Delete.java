package buitienanh.servlet.department;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import buitienanh.conn.buitienanhConnection_Ontap;
import buitienanh.ulils.buitienanh_DEPARTMENT_Ultils;

public class buitienanh_DEPARTMENT_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public buitienanh_DEPARTMENT_Delete() {
        super();
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException , IOException{
		
		String errorString = null ;
		String DEPT_ID =(String)request.getParameter("DEPT_ID");
		Connection conn = null;		
		
		try {
			conn = buitienanhConnection_Ontap.getMSSQLConnection();
			buitienanh_DEPARTMENT_Ultils.deleteDepartment(conn, DEPT_ID);;
			
		}catch (Exception e) {
			e.printStackTrace();
			errorString= e.getMessage();
		}
		//khi co loi
		if(errorString != null ) {
			request.setAttribute("errString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/buitienanh_DEPARTMENT_Delete.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/buitienanh_DEPARTMENT_List");
		}
	}
	protected void doPost(HttpServletRequest request ,HttpServletResponse response)throws ServletException , IOException{
		doGet(request,response);
	}
}
