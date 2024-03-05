package buitienanh.servlet.SALARY_GRADE;

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

import buitienanh.beans.buitienanh_SALARY_GRADE;
import buitienanh.conn.buitienanhConnection_Ontap;
import buitienanh.ulils.buitienanh_SALARY_GRADE_Ultils;

public class buitienanh_SALARY_List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public buitienanh_SALARY_List() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errString = null;
        List<buitienanh_SALARY_GRADE> list = null;

        try (Connection conn = buitienanhConnection_Ontap.getMSSQLConnection()) {
            // Retrieve product list
            list = buitienanh_SALARY_GRADE_Ultils.querySalary(conn);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            errString = e.getMessage();
        }

        // Set attributes and forward to the appropriate view
        request.setAttribute("errorString", errString);
        request.setAttribute("buitienanh_SALARY_List", list);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/buitienanh_BookList.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
