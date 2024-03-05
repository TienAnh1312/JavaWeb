package buitienanh.servlet.SALARY_GRADE;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import buitienanh.beans.buitienanh_SALARY_GRADE;
import buitienanh.conn.buitienanhConnection_Ontap;
import buitienanh.ulils.buitienanh_SALARY_GRADE_Ultils;

public class buitienanh_SALARY_Create extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public buitienanh_SALARY_Create() {
        super();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/buitienanh_SALARY/buitienanh_SALARY_GRADE_Create.jsp");
        dispatcher.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException , IOException{
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		//lay du lie tren form
		String GRADE =(String) request.getParameter("GRADE");
		String HIGH_SALARY =(String) request.getParameter("HIGH_SALARY");
		String LOW_SALARY = (String) request.getParameter("LOW_SALARY");	
		
		buitienanh_SALARY_GRADE salary = new buitienanh_SALARY_GRADE(GRADE , HIGH_SALARY, LOW_SALARY);
		if(errorString !=null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("salary", salary);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/buitienanh_SALARY/buitienanh_SALARY_GRADE_Edit.jsp");
			dispatcher.forward(request, response);
		}
		Connection conn = null;
		try {
			conn = buitienanhConnection_Ontap.getMSSQLConnection();
			buitienanh_SALARY_GRADE_Ultils.updateSalary(conn, salary);
			response.sendRedirect(request.getContextPath()+"/buitienanh_SALARY_GRADE_List");
		
		}catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			request.setAttribute("salary", salary);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/buitienanh_SALARY/buitienanh_SALARY_GRADE_Edit.jsp");
			dispatcher.forward(request, response);
		}
	}

}
