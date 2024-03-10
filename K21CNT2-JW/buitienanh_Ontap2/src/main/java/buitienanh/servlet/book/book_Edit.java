package buitienanh.servlet.book;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import buitienanh.beans.book;
import buitienanh.conn.Connection_Ontap2;
import buitienanh.utils.book_Utils;

@WebServlet("/book_Edit")
public class book_Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public book_Edit() {
        super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String errorString = null;
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/book/book_Edit.jsp");

        // Lay du lieu ma san pham tu request
        String BookId = (String) request.getParameter("BookId");
        if (BookId == null || BookId.isEmpty()) {
            errorString = "Bạn chưa chọn ... cần sửa.";
            request.setAttribute("errorString", errorString);
            dispatcher.forward(request, response);
            return;
        }

        Connection conn = null;
        book books = null;

        try {
            conn = Connection_Ontap2.getMSSQLConnection();
            books = book_Utils.findbook(conn, BookId);

            if (books == null) {
                errorString = "Không tìm thấy ... có mã " + BookId;
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
        if (errorString != null || books == null) {
            request.setAttribute("errorString", errorString);
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("books", books);
            dispatcher.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String errorString = null;

        //lay du lieu tren form
        String BookId =(String) request.getParameter("BookId");
		String Title =(String) request.getParameter("Title");
		String Author = (String) request.getParameter("Author");
		int Release = (int) request.getDateHeader("Release");
		String Price =(String) request.getParameter("Price");		
		String Picture =(String) request.getParameter("Picture");		
		int PublisherId = (int) request.getDateHeader("PublisherId");		
		int CategoryId = (int) request.getDateHeader("CategoryId");
		
        book books = new book(BookId, Title, Author, Release, Price, Picture, PublisherId, CategoryId);

        if (errorString != null) {
            request.setAttribute("errorString", errorString);
            request.setAttribute("books", books);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/book/book_Edit.jsp");
            dispatcher.forward(request, response);
        }

        Connection conn = null;
        try {
            conn = Connection_Ontap2.getMSSQLConnection();
            book_Utils.updatebook(conn, books);
            response.sendRedirect(request.getContextPath() + "/book_list");

        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
            request.setAttribute("errorString", errorString);
            request.setAttribute("books", books);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/book/book_Edit.jsp");
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
