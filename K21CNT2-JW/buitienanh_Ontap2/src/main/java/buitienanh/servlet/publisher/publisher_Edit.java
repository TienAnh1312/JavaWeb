package buitienanh.servlet.publisher;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import buitienanh.beans.publisher;
import buitienanh.conn.Connection_Ontap2;
import buitienanh.utils.publisher_Utils;

@WebServlet("/publisher_Edit")
public class publisher_Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public publisher_Edit() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String errorString = null;
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/publisher/publisher_Edit.jsp");

     // Lấy dữ liệu mã sản phẩm từ request
        String PublisherIdString = request.getHeader("PublisherId");

        if (PublisherIdString == null || PublisherIdString.isEmpty()) {
            errorString = "Bạn chưa chọn ... cần sửa.";
            request.setAttribute("errorString", errorString);
            dispatcher.forward(request, response);
            return;
        }

        // Chuyển đổi categoryIdString sang kiểu int
        int PublisherId = 0;  // Giá trị mặc định hoặc xử lý khi chuyển đổi thất bại
        try {
        	PublisherId = Integer.parseInt(PublisherIdString);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        Connection conn = null;
        publisher publishers = null;

        try {
            conn = Connection_Ontap2.getMSSQLConnection();
            publishers = publisher_Utils.findpublisher(conn, PublisherId);

            if (publishers == null) {
                errorString = "Không tìm thấy ... có mã " + PublisherId;
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
        if (errorString != null || publishers == null) {
            request.setAttribute("errorString", errorString);
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("publishers", publishers);
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String errorString = null;

        //lay du lieu tren form
        int PublisherId = (int) request.getDateHeader("PublisherId");	
		String PublisherName =(String) request.getParameter("PublisherName");
		String Phone =(String) request.getParameter("Phone");
		String Address = (String) request.getParameter("Address");		
		
		publisher publishers = new publisher(PublisherId , PublisherName, Phone, Address);

        if (errorString != null) {
            request.setAttribute("errorString", errorString);
            request.setAttribute("publishers", publishers);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/publisher/publisher_Edit.jsp");
            dispatcher.forward(request, response);
        }

        Connection conn = null;
        try {
            conn = Connection_Ontap2.getMSSQLConnection();
            publisher_Utils.updatepublisher(conn, publishers);
            response.sendRedirect(request.getContextPath() + "/publisher_list");

        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
            request.setAttribute("errorString", errorString);
            request.setAttribute("publishers", publishers);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/publisher/publisher_Edit.jsp");
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
