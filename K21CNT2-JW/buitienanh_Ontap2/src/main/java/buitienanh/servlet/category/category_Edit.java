package buitienanh.servlet.category;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import buitienanh.beans.category;
import buitienanh.conn.Connection_Ontap2;
import buitienanh.utils.category_Utils;

@WebServlet("/category_Edit")
public class category_Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public category_Edit() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String errorString = null;
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/category/category_Edit.jsp");

     // Lấy dữ liệu mã sản phẩm từ request
        String categoryIdString = request.getHeader("CategoryId");

        if (categoryIdString == null || categoryIdString.isEmpty()) {
            errorString = "Bạn chưa chọn ... cần sửa.";
            request.setAttribute("errorString", errorString);
            dispatcher.forward(request, response);
            return;
        }

        // Chuyển đổi categoryIdString sang kiểu int
        int categoryId = 0;  // Giá trị mặc định hoặc xử lý khi chuyển đổi thất bại
        try {
            categoryId = Integer.parseInt(categoryIdString);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        category categories = null;

        try {
            conn = Connection_Ontap2.getMSSQLConnection();
            categories = category_Utils.findcategory(conn, categoryId);

            if (categories == null) {
                errorString = "Không tìm thấy ... có mã " + categoryId;
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
        if (errorString != null || categories == null) {
            request.setAttribute("errorString", errorString);
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("categories", categories);
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String errorString = null;

        //lay du lieu tren form
        int CategoryId = (int) request.getDateHeader("CategoryId");
		String CategoryName =(String) request.getParameter("CategoryName");	
		
        category categories = new category(CategoryId, CategoryName);

        if (errorString != null) {
            request.setAttribute("errorString", errorString);
            request.setAttribute("categories", categories);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/category/category_Edit.jsp");
            dispatcher.forward(request, response);
        }

        Connection conn = null;
        try {
            conn = Connection_Ontap2.getMSSQLConnection();
            category_Utils.updatecategory(conn, categories);
            response.sendRedirect(request.getContextPath() + "/category_list");

        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
            request.setAttribute("errorString", errorString);
            request.setAttribute("categories", categories);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/category/category_Edit.jsp");
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
