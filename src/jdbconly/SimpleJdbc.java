package jdbconly;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SimpleJdbc {

	public static void main(String [] args){
	String url = "jdbc:mysql://localhost:3306/CarPractice";
	String DriverManagerString ="com.mysql.jdbc.Driver";
	String username = "root";
	String password = "root";
	
    
    Connection conn = null;
    PreparedStatement pmt = null;
    ResultSet rs = null;
    
    //加载数据库驱动
    try {
		Class.forName(DriverManagerString);
	
  
    //创建连接
    conn = DriverManager.getConnection(url,username,password);
    
    //定义sql
    String sql = "select * from person where id = ?";
    
    //获取预编译的statement
    pmt = conn.prepareStatement(sql);
    pmt.setLong(1,1);
    
    //向数据库发出sql执行查询
    rs = pmt.executeQuery();
    
    //遍历结果集
    while(rs.next()){
        System.out.println("id:" + rs.getString("id") + " name:" + rs.getString("name"));
    }
    
    
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(pmt != null){
			try {
				pmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	}
}