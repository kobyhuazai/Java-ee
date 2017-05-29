package dao;


import java.sql.SQLException;
import java.util.List;

import bean.Hero;
import cn.itcast.jdbc.TxQueryRunner;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler; 


public class HeroDAO {
	
	    private QueryRunner qr=new TxQueryRunner();
	  
	    public int getTotal() throws SQLException{
	    	
	    	    String sql="select count(*) from hero";	    	    
	            int total =((Number) qr.query(sql,new ScalarHandler<>())).intValue(); 		            
		        return total;		                       
	    }  
	    
	    public void add(Hero hero) throws SQLException {
	    	  	    	
	    	 	 String sql = "insert into hero values(null,?,?,?)";
	    	 	 Object params[] = {hero.name,hero.hp,hero.damage};
	             qr.update(sql, params);
	             
	             //获取自动生成的id，赋给hero.id
	             sql = "SELECT LAST_INSERT_ID()";
	             int id = ((Number)qr.query(sql,new ScalarHandler<>())).intValue();
	             hero.id = id;		
	             
	    }
	  
	    public void update(Hero hero) throws SQLException{
	    	
	    	    String sql="update hero set name= ?, hp = ? , damage = ? where id = ?";
	    	    Object params[] = {hero.name,hero.hp,hero.damage,hero.id};	    	    
	            qr.update(sql,params);	
	            
	    }
	  
	    public void delete(int id) throws SQLException {	
	    	
	    	     String sql = "delete from hero where id=?";
	             qr.update(sql, id);	  	
	             
	    }
	  
	    public Hero get(int id) throws SQLException {
	    		    	
		    	 String sql = "select * from hero where id=?";		    	     
		    	 Hero hero = (Hero)qr.query(sql,new BeanHandler<Hero>(Hero.class),id);     		    	    	
		    	 return hero;
	        	  	        
	    }
	  
	    public List<Hero> list() throws SQLException {
	        return list(0, Short.MAX_VALUE);
	    }
	  
	    public List<Hero> list(int start, int count) throws SQLException{
	        	      
		    	 String sql = "select * from hero order by id desc limit ?,? ";  
		    	 Object params[] = {start, count };                              
		    	 List<Hero> heros = (List<Hero>) qr.query(sql,new BeanListHandler<Hero>(Hero.class),params);     			          
		    	 return heros;
	    }
}
