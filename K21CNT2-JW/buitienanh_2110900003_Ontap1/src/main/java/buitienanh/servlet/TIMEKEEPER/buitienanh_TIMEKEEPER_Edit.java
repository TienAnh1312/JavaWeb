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

import buitienanh.beans.buitienanh_TIMEKEEPER;
import buitienanh.conn.buitienanhConnection_Ontap;
import buitienanh.ulils.buitienanh_TIMEKEEPER_Ultils;

public class buitienanh_TIMEKEEPER_Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public buitienanh_TIMEKEEPER_Edit() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String errorString = null;
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/buitienanh_BookEdit.jsp");

        // Lay du lieu ma san pham tu request
        String Timekeeper_Id = (String) request.getParameter("Timekeeper_Id");
        if (Timekeeper_Id == null || Timekeeper_Id.isEmpty()) {
            errorString = "Bạn chưa chọn ... cần sửa.";
            request.setAttribute("errorString", errorString);
            dispatcher.forward(request, response);
            return;
        }

        Connection conn = null;
        buitienanh_TIMEKEEPER timekeeper = null;

        try {
            conn = buitienanhConnection_Ontap.getMSSQLConnection();
            timekeeper = buitienanh_TIMEKEEPER_Ultils.findTimekeeper(conn, Timekeeper_Id);

            if (timekeeper == null) {
                errorString = "Không tìm thấy ... có mã " + Timekeeper_Id;
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
        if (errorString != null || timekeeper == null) {
            request.setAttribute("errorString", errorString);
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("timekeeper", timekeeper);
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String errorString = null;

        //lay du lieu tren form
    	String Timekeeper_Id =(String) request.getParameter("Timekeeper_Id");
		String Date_Time =(String) request.getParameter("Date_Time");
		String In_Out = (String) request.getParameter("In_Out");
		String EMP_ID =(String) request.getParameter("EMP_ID");		
		
		buitienanh_TIMEKEEPER timekeeper = new buitienanh_TIMEKEEPER(Timekeeper_Id, Date_Time, In_Out, EMP_ID);

        if (errorString != null) {
            request.setAttribute("errorString", errorString);
            request.setAttribute("timekeeper", timekeeper);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/buitienanh_BookEdit.jsp");
            dispatcher.forward(request, response);
        }

        Connection conn = null;
        try {
            conn = buitienanhConnection_Ontap.getMSSQLConnection();
            buitienanh_TIMEKEEPER_Ultils.updateTimekeeper(conn, timekeeper);
            response.sendRedirect(request.getContextPath() + "/buitienanh_BookList");

        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
            request.setAttribute("errorString", errorString);
            request.setAttribute("timekeeper", timekeeper);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/buitienanh_BookEdit.jsp");
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
