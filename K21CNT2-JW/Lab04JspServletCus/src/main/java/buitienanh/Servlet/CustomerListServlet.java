package buitienanh.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import buitienanh.beans.Customer;
import buitienanh.dao.CustomerDao;

@WebServlet("/customerList")
public class CustomerListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
        String errorString = null;
        List<Customer> customers = null;

        try {
            customers = CustomerDao.getAllCustomers();
        } catch (ClassNotFoundException | SQLException e) {
            errorString = e.getMessage();
        }

        
        request.setAttribute("errorString", errorString);
        request.setAttribute("customerList", customers);

        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/customerList.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        doGet(request, response);
    }
}
