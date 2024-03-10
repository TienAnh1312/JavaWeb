package buitienanh.servlet.publisher;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import buitienanh.beans.publisher;
import buitienanh.conn.Connection_Ontap2;
import buitienanh.utils.publisher_Utils;

@WebServlet("/publisher_Create")
public class publisher_Create extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public publisher_Create() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/publisher/publisher_Create.jsp");
        dispatcher.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException , IOException{
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		//lay du lie tren form
		
		int PublisherId = (int) request.getDateHeader("PublisherId");	
		String PublisherName =(String) request.getParameter("PublisherName");
		String Phone =(String) request.getParameter("Phone");
		String Address = (String) request.getParameter("Address");		
		
		publisher publishers = new publisher(PublisherId , PublisherName, Phone, Address);
		if(errorString !=null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("publishers", publishers);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/publisher/publisher_Edit.jsp");
			dispatcher.forward(request, response);
		}
		Connection conn = null;
		try {
			conn = Connection_Ontap2.getMSSQLConnection();
			publisher_Utils.updatepublisher(conn, publishers);
			response.sendRedirect(request.getContextPath()+"/publisher_List");
		
		}catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			request.setAttribute("publishers", publishers);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/publisher/publisher_Edit.jsp");
			dispatcher.forward(request, response);
		}
	}

}
