package servlet;
 
import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import bean.Hero;
import dao.HeroDAO;
 
public class HeroAddServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        request.setCharacterEncoding("UTF-8");
 
        Hero hero = new Hero();
        hero.setName(request.getParameter("name"));
        System.out.println("setname process finished");
        hero.setHp(Float.parseFloat(request.getParameter("hp")));
        hero.setDamage(Integer.parseInt(request.getParameter("damage")));
        System.out.println("setdamage process finished");
        new HeroDAO().add(hero);
        System.out.println("add Hero finished");
        response.sendRedirect("listHero");
        System.out.println("jumped");
         
    }
}
