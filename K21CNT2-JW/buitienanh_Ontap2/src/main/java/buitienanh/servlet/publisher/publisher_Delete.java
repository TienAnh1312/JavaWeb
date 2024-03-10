package buitienanh.servlet.publisher;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

import buitienanh.conn.Connection_Ontap2;
import buitienanh.utils.publisher_Utils;

@WebServlet("/publisher_Delete")
public class publisher_Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public publisher_Delete() {
        super();
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException , IOException{
		
		String errorString = null ;
		int PublisherId =(int)request.getDateHeader("PublisherId");
		Connection conn = null;		
		
		try {
			conn = Connection_Ontap2.getMSSQLConnection();
			publisher_Utils.deletepublisher(conn, PublisherId);;
			
		}catch (Exception e) {
			e.printStackTrace();
			errorString= e.getMessage();
		}
		//khi co loi
		if(errorString != null ) {
			request.setAttribute("errString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/publisher/publisher_Delete.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/publisher_List");
		}
	}
	protected void doPost(HttpServletRequest request ,HttpServletResponse response)throws ServletException , IOException{
		doGet(request,response);
	}


}
