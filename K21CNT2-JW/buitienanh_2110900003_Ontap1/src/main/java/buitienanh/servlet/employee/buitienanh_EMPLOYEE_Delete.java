package buitienanh.servlet.employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import buitienanh.conn.buitienanhConnection_Ontap;
import buitienanh.ulils.buitienanh_EMPLOYEE_Ultils;


public class buitienanh_EMPLOYEE_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public buitienanh_EMPLOYEE_Delete() {
        super();

    }

protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException , IOException{
		
		String errorString = null ;
		String EMP_ID =(String)request.getParameter("EMP_ID");
		Connection conn = null;		
		
		try {
			conn = buitienanhConnection_Ontap.getMSSQLConnection();
			buitienanh_EMPLOYEE_Ultils.deleteEmployee(conn, EMP_ID);;
			
		}catch (Exception e) {
			e.printStackTrace();
			errorString= e.getMessage();
		}
		//khi co loi
		if(errorString != null ) {
			request.setAttribute("errString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/buitienanh_EMPLOYEE/buitienanh_EMPLOYEE_Delete.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/buitienanh_EMPLOYEE_List");
		}
	}
	protected void doPost(HttpServletRequest request ,HttpServletResponse response)throws ServletException , IOException{
		doGet(request,response);
	}


}
