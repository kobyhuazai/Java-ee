package servlet;
 
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import dao.HeroDAO;
 
public class HeroDeleteServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        int id = Integer.parseInt(request.getParameter("id"));
         
        try {
			new HeroDAO().delete(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        response.sendRedirect("Herolist.jsp");
         
    }
}