package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Hero;
import dao.HeroDAO;

import cn.itcast.servlet.BaseServlet;

public class HeroServlet extends BaseServlet{
	
    public void add(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {

    	 Hero hero = new Hero();
         
         hero.setName(request.getParameter("name"));
         hero.setHp(Float.parseFloat(request.getParameter("hp")));
         hero.setDamage(Integer.parseInt(request.getParameter("damage"))); 
         try {
			new HeroDAO().add(hero);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         response.sendRedirect("Herolist.jsp");
    }
 
    public void delete(HttpServletRequest request, HttpServletResponse response) 
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

    public void update(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {

    	 Hero hero = new Hero();
         hero.setId(Integer.parseInt(request.getParameter("id")));
         hero.setName(request.getParameter("name"));
         hero.setHp(Float.parseFloat(request.getParameter("hp")));
         hero.setDamage(Integer.parseInt(request.getParameter("damage")));
  
         try {
 			new HeroDAO().update(hero);
 		
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
  
         response.sendRedirect("Herolist.jsp");
    }
	
	
	
}
