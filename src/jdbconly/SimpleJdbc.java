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
    
    //�������ݿ�����
    try {
		Class.forName(DriverManagerString);
	
  
    //��������
    conn = DriverManager.getConnection(url,username,password);
    
    //����sql
    String sql = "select * from person where id = ?";
    
    //��ȡԤ�����statement
    pmt = conn.prepareStatement(sql);
    pmt.setLong(1,1);
    
    //�����ݿⷢ��sqlִ�в�ѯ
    rs = pmt.executeQuery();
    
    //���������
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