package buitienanh.servlet.book;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import buitienanh.beans.book;
import buitienanh.conn.Connection_Ontap2;
import buitienanh.utils.book_Utils;

@WebServlet("/book_Create")
public class book_Creates extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public book_Creates() {
        super();

    }

	public void init(ServletConfig config) throws ServletException {

	}

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/book/book_Create.jsp");
        dispatcher.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException , IOException{
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		//lay du lie tren form
	
		String BookId =(String) request.getParameter("BookId");
		String Title =(String) request.getParameter("Title");
		String Author = (String) request.getParameter("Author");
		int Release = (int) request.getDateHeader("Release");
		String Price =(String) request.getParameter("Price");		
		String Picture =(String) request.getParameter("Picture");		
		int PublisherId = (int) request.getDateHeader("PublisherId");		
		int CategoryId = (int) request.getDateHeader("CategoryId");
		
		book books = new book(BookId , Title, Author, Release, Price, Picture, PublisherId, CategoryId);
		if(errorString !=null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("books", books);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/book/book_Edit.jsp");
			dispatcher.forward(request, response);
		}
		Connection conn = null;
		try {
			conn = Connection_Ontap2.getMSSQLConnection();
			book_Utils.updatebook(conn, books);
			response.sendRedirect(request.getContextPath()+"/book_List");
		
		}catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			request.setAttribute("books", books);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/book/book_Edit.jsp");
			dispatcher.forward(request, response);
		}
	}

}
