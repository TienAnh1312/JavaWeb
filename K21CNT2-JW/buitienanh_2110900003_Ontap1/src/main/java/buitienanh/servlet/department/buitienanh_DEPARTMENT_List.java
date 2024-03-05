package buitienanh.servlet.department;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import buitienanh.beans.buitienanh_DEPARTMENT;
import buitienanh.conn.buitienanhConnection_Ontap;
import buitienanh.ulils.buitienanh_DEPARTMENT_Ultils;



public class buitienanh_DEPARTMENT_List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public buitienanh_DEPARTMENT_List() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errString = null;
        List<buitienanh_DEPARTMENT> list = null;

        try (Connection conn = buitienanhConnection_Ontap.getMSSQLConnection()) {
            // Retrieve product list
            list = buitienanh_DEPARTMENT_Ultils.queryDepartment(conn);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            errString = e.getMessage();
        }

        // Set attributes and forward to the appropriate view
        request.setAttribute("errorString", errString);
        request.setAttribute("buitienanh_DEPARTMENT_List", list);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/buitienanh_DEPARTMENT/buitienanh_DEPARTMENT_List.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
