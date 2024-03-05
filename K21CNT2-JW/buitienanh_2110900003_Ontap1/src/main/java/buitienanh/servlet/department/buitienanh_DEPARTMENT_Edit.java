package buitienanh.servlet.department;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import buitienanh.beans.buitienanh_DEPARTMENT;
import buitienanh.conn.buitienanhConnection_Ontap;
import buitienanh.ulils.buitienanh_DEPARTMENT_Ultils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class buitienanh_DEPARTMENT_Edit {

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.setCharacterEncoding("UTF-8");
	        String errorString = null;
	        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/buitienanh_DEPARTMENT/buitienanh_DEPARTMENT_Edit.jsp");

	        // Lay du lieu ma san pham tu request
	        String DEPT_ID = (String) request.getParameter("DEPT_ID");
	        if (DEPT_ID == null || DEPT_ID.isEmpty()) {
	            errorString = "Bạn chưa chọn ... cần sửa.";
	            request.setAttribute("errorString", errorString);
	            dispatcher.forward(request, response);
	            return;
	        }

	        Connection conn = null;
	        buitienanh_DEPARTMENT department = null;

	        try {
	            conn = buitienanhConnection_Ontap.getMSSQLConnection();
	            department = buitienanh_DEPARTMENT_Ultils.findDepartment(conn, DEPT_ID);

	            if (department == null) {
	                errorString = "Không tìm thấy ... có mã " + DEPT_ID;
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        } finally {
	            try {
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }

	        // Khi co loi
	        if (errorString != null || department == null) {
	            request.setAttribute("errorString", errorString);
	            dispatcher.forward(request, response);
	        } else {
	            request.setAttribute("book", department);
	            dispatcher.forward(request, response);
	        }
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.setCharacterEncoding("UTF-8");
	        String errorString = null;

	        //lay du lieu tren form
	    	String DEPT_ID =(String) request.getParameter("DEPT_ID");
			String DEPT_NAME =(String) request.getParameter("DEPT_NAME");
			String DEPT_NO = (String) request.getParameter("DEPT_NO");
			String LOCATION =(String) request.getParameter("LOCATION");	
			
	        buitienanh_DEPARTMENT department = new buitienanh_DEPARTMENT(DEPT_ID, DEPT_NAME, DEPT_NO, LOCATION);

	        if (errorString != null) {
	            request.setAttribute("errorString", errorString);
	            request.setAttribute("department", department);
	            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/buitienanh_DEPARTMENT/buitienanh_DEPARTMENT_Edit.jsp");
	            dispatcher.forward(request, response);
	        }

	        Connection conn = null;
	        try {
	            conn = buitienanhConnection_Ontap.getMSSQLConnection();
	            buitienanh_DEPARTMENT_Ultils.updateDepartment(conn, department);
	            response.sendRedirect(request.getContextPath() + "/buitienanh_DEPARTMENT_list");

	        } catch (Exception e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	            request.setAttribute("errorString", errorString);
	            request.setAttribute("department", department);
	            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/buitienanh_DEPARTMENT/buitienanh_DEPARTMENT_Edit.jsp");
	            dispatcher.forward(request, response);
	        } finally {
	            try {
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	
}
