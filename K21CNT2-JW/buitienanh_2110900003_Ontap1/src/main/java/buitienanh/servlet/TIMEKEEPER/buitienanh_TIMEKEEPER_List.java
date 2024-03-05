package buitienanh.servlet.TIMEKEEPER;

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

import buitienanh.beans.buitienanh_TIMEKEEPER;
import buitienanh.conn.buitienanhConnection_Ontap;
import buitienanh.ulils.buitienanh_TIMEKEEPER_Ultils;

public class buitienanh_TIMEKEEPER_List extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public buitienanh_TIMEKEEPER_List() {
        super();
    
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errString = null;
        List<buitienanh_TIMEKEEPER> list = null;

        try (Connection conn = buitienanhConnection_Ontap.getMSSQLConnection()) {
            // Retrieve product list
            list = buitienanh_TIMEKEEPER_Ultils.queryTimekeeper(conn);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            errString = e.getMessage();
        }

        // Set attributes and forward to the appropriate view
        request.setAttribute("errorString", errString);
        request.setAttribute("buitienanh_TIMEKEEPER_List", list);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/buitienanh_BookList.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


}
