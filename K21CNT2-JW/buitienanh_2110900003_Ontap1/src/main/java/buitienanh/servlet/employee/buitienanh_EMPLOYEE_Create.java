package buitienanh.servlet.employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import buitienanh.beans.buitienanh_EMPLOYEE;
import buitienanh.conn.buitienanhConnection_Ontap;
import buitienanh.ulils.buitienanh_EMPLOYEE_Ultils;


public class buitienanh_EMPLOYEE_Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public buitienanh_EMPLOYEE_Create() {
        super();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/buitienanh_EMPLOYEE/buitienanh_EMPLOYEE_Create.jsp");
        dispatcher.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException , IOException{
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		//lay du lie tren form
		String EMP_ID =(String) request.getParameter("EMP_ID");
		String EMP_NAME =(String) request.getParameter("EMP_NAME");
		String EMP_NO = (String) request.getParameter("EMP_NO");
		String HIRE_DATE =(String) request.getParameter("HIRE_DATE");		
		String IMAGE =(String) request.getParameter("IMAGE");		
		String JOB =(String) request.getParameter("JOB");		
		String SALARY =(String) request.getParameter("SALARY");		
		String DEPT_ID =(String) request.getParameter("DEPT_ID");		
		String MNG_ID =(String) request.getParameter("MNG_ID");		
		
		buitienanh_EMPLOYEE employee = new buitienanh_EMPLOYEE(EMP_ID , EMP_NAME, EMP_NO, HIRE_DATE, IMAGE, JOB, SALARY, DEPT_ID, MNG_ID);
		if(errorString !=null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("derpartment", employee);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/buitienanh_EMPLOYEE/buitienanh_EMPLOYEE_Edit.jsp");
			dispatcher.forward(request, response);
		}
		Connection conn = null;
		try {
			conn = buitienanhConnection_Ontap.getMSSQLConnection();
			buitienanh_EMPLOYEE_Ultils.updateEmployee(conn, employee);
			response.sendRedirect(request.getContextPath()+"/buitienanh_EMPLOYEE_List");
		
		}catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			request.setAttribute("employee", employee);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/buitienanh_EMPLOYEE/buitienanh_EMPLOYEE_Edit.jsp");
			dispatcher.forward(request, response);
		}
	}

}
