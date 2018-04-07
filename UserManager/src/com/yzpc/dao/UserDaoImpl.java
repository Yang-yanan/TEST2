package com.yzpc.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.yzpc.bean.User;
public class UserDaoImpl extends BaseDao implements UserDao{
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//查询所有的用户信息，并以id正序排序
	public List<User> getAllUser(){
		List<User> list = new ArrayList<User>();
		String sql = "select * from userinfo order by id";
		try{
			con=this.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			User u=null;
			while(rs.next()){
				u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setTelephone(rs.getString("telephone"));
				u.setEmail(rs.getString("email"));
				u.setSpecialty(rs.getString("specialty"));
				u.setSchool(rs.getString("school"));
				u.setAddress(rs.getString("address"));
				list.add(u);
			}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.closeAll(con, pstmt, rs);
			}
			return list;	
	}
	
	//根据id号查询用户信息
	public User getUserById(int id){
		User u=null;
		String sql = "select * from userinfo where id =" + id;
		try{
			con=this.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			u = new User();
			while(rs.next()){
				u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setTelephone(rs.getString("telephone"));
				u.setEmail(rs.getString("email"));
				u.setSpecialty(rs.getString("specialty"));
				u.setSchool(rs.getString("school"));
				u.setAddress(rs.getString("address"));
			}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.closeAll(con, pstmt, rs);
			}
			return u;	
	}
	
	//增加一条用户信息
	public int addUser(User u){
		int result = 0;
		String sql = "insert into userinfo(name,sex,age,telephone,email,specialty,school,address) values(?,?,?,?,?,?,?,?)";
		try{
			con=this.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,u.getName());
			pstmt.setString(2, u.getSex());
			pstmt.setInt(3,u.getAge());
			pstmt.setString(4, u.getTelephone());
			pstmt.setString(5, u.getEmail());
			pstmt.setString(6,u.getSpecialty());
			pstmt.setString(7, u.getSchool());
			pstmt.setString(8, u.getAddress());
			result = pstmt.executeUpdate();
			if(result!=0){
				System.out.println("添加了一条用户信息！");
			}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.closeAll(con, pstmt, rs);
			}
			return result;
	}	
	
	//修改一条用户信息
	public int updateUser(User u){
		int result=0;
		String sql = "update userinfo set name=?,sex=?,age=?,telephone=?,email=?,specialty=?,school=?,address=? where id=" +u.getId();
		try{
			con=this.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,u.getName());
			pstmt.setString(2, u.getSex());
			pstmt.setInt(3,u.getAge());
			pstmt.setString(4, u.getTelephone());
			pstmt.setString(5, u.getEmail());
			pstmt.setString(6,u.getSpecialty());
			pstmt.setString(7, u.getSchool());
			pstmt.setString(8, u.getAddress());
			result = pstmt.executeUpdate();
			if(result!=0){
				System.out.println("修改了一条用户信息！");
			}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				this.closeAll(con, pstmt, rs);
			}
			return result;
	}
	
	//根据id号删除用户信息
	public int deleteUser(int id){
		int result=0;
		String sql="delete from userinfo where id =?";
		try{
			con = this.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
			if(result!=0){
				System.out.println("删除了id为"+id+"的记录！");
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			this.closeAll(con, pstmt, rs);
		}
		return result;
	}

}
