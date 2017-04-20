package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bean.Hero;
 
import org.apache.commons.dbutils.DbUtils; 
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler; 


public class HeroDAO {
	 public HeroDAO() {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	  
	    public Connection getConnection() throws SQLException {
	        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/how2java?characterEncoding=UTF-8", "root",
	                "admin");
	    }
	  
	    public int getTotal() throws SQLException{
	      
		        //创建连接 
	            Connection c = this.getConnection();
	            //创建SQL执行工具 
		        QueryRunner runner = new QueryRunner(); 
		        String sql = "select count(*) from hero";
		        int total = ((Long)runner.query(c,sql, new ScalarHandler(1))).intValue();
		        //关闭数据库连接 
		        DbUtils.closeQuietly(c);    
		        System.out.println("total:" + total);
		            
		        return total;
		        
                
	    }
	  
	    public void add(Hero hero) throws SQLException {
	         
		    	 //创建连接
		    	 Connection c = this.getConnection(); 
		    	 //创建执行工具
		    	 QueryRunner runner = new QueryRunner();
		    	 String sql = "insert into hero values(null,?,?,?)";		    		    	     
		    	 Object params[] = {hero.name,hero.hp,hero.damage};
		    	 runner.update(c,sql, params);
	    		    		        
	             PreparedStatement ps = c.prepareStatement(sql);	            	  
	             ResultSet rs = ps.getGeneratedKeys();
	             if (rs.next()) {
	                int id = rs.getInt(1);
	                hero.id = id;
	             }    
	             DbUtils.closeQuietly(c); 
	    }
	  
	    public void update(Hero hero) throws SQLException{
	  
		    	 //创建连接
		    	 Connection c = this.getConnection(); 
		    	 //创建执行工具
		    	 QueryRunner runner = new QueryRunner();
		    	 String sql = "update hero set name= ?, hp = ? , damage = ? where id = ?";		    		    	     
		    	 Object params[] = {hero.name,hero.hp,hero.damage,hero.id};
		    	 runner.update(c,sql, params);    	 	    
		    	 DbUtils.closeQuietly(c); 
	    }
	  
	    public void delete(int id) throws SQLException {
	    		 
		    	 //创建连接
		    	 Connection c = this.getConnection(); 
		    	 //创建执行工具
		    	 QueryRunner runner = new QueryRunner();
		    	 String sql = "delete from hero where id=?";		    		    	     
		    	 runner.update(c,sql, id);
		    	 DbUtils.closeQuietly(c); 
	  	        	           
	    }
	  
	    public Hero get(int id) throws SQLException {
	    	
		    	 //创建连接
		    	 Connection c = this.getConnection(); 
		    	 //创建执行工具
		    	 QueryRunner runner = new QueryRunner();
		    	 String sql = "select * from hero where id=?";		    	     
		    	 Hero hero = (Hero) runner.query(c,sql, id, new BeanHandler(Hero.class));     
		    	 //关闭
		    	 DbUtils.closeQuietly(c); 	    	
		    	 return hero;
	        	  	        
	    }
	  
	    public List<Hero> list() throws SQLException {
	        return list(0, Short.MAX_VALUE);
	    }
	  
	    public List<Hero> list(int start, int count) throws SQLException{
	        
	     	          
		         //创建连接
		    	 Connection c = this.getConnection(); 
		    	 //创建执行工具
		    	 QueryRunner runner = new QueryRunner();
		    	 String sql = "select * from hero order by id desc limit ?,? ";  
		    	 Object params[] = {start, count };                              
		    	 List<Hero> heros = (List<Hero>) runner.query(c,sql,new BeanListHandler(Hero.class),params);     
		    	 //关闭
		    	 DbUtils.closeQuietly(c); 	 
	          
		    	 return heros;
	    }
}
