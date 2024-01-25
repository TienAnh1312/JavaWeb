package buitienanh.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import buitienanh.beans.Customer;
import buitienanh.dao.CustomerDao;
import java.io.IOException;

@WebServlet("/customerDetail")
public class CustomerDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cusID = Integer.parseInt(request.getParameter("cusID"));

        try {
            Customer customer = CustomerDao.getCustomerByID(cusID);
            request.setAttribute("customer", customer);
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý lỗi và chuyển hướng lại trang danh sách khách hàng với thông báo lỗi
            request.setAttribute("errorString", e.getMessage());
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/customerList.jsp");
            dispatcher.forward(request, response);
            return;
        }

        // Chuyển hướng đến trang hiển thị thông tin chi tiết của khách hàng
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/customerDetail.jsp");
        dispatcher.forward(request, response);
    }
}