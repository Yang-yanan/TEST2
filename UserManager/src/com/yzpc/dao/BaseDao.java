package com.yzpc.dao;
import java.sql.*;

public class BaseDao {
	public Connection getConnection(){
		Connection conn=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","123456");
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
public void closeAll(Connection conn,PreparedStatement pstmt,ResultSet rs){
	if(rs!=null){
		try{
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	if(pstmt!=null){
		try{
			pstmt.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	if(conn!=null){
		try{
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

}
