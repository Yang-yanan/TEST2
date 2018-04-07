package com.yzpc.action;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import com.yzpc.bean.User;
import com.yzpc.biz.UserBiz;
import com.yzpc.biz.UserBizImpl;
public class UserAction extends ActionSupport{
	private List<User> list;

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}
	public String toList() throws Exception{
		UserBiz userBiz=new UserBizImpl();
		list = userBiz.getAllUser();
		return "toList";
	}
	
	private String[] sexs = new String[]{"男","女"};

	public String[] getSexs() {
		return sexs;
	}

	public void setSexs(String[] sexs) {
		this.sexs = sexs;
	}
	
	//跳转到添加页面的逻辑视图，返回"toadd"字符串
	public String toAdd() throws Exception{
		return "toAdd";
	}
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	//添加用户，把接收到的数据添加到数据库
	public String add() throws Exception{
		UserBiz userBiz=new UserBizImpl();
		userBiz.addUser(user);
		return this.toList();
	}
	
	//跳转到修改页面的逻辑视图
	public String toUpdate() throws Exception{
		UserBiz userBiz = new UserBizImpl();
		user = userBiz.getUserById(user.getId());
		return "toUpdate";
	}
	
	//修改用户信息
	public String update() throws Exception{
		UserBiz userBiz = new UserBizImpl();
		userBiz.updateUser(user);
		return this.toList();
	}
	
	//根据id，删除用户
	public String delete() throws Exception{
		UserBiz userBiz = new UserBizImpl();
		userBiz.deleteUser(user.getId());
		return this.toList(); 
	}
	
	//跳转到显示用户详情页面
	public String toDetail() throws Exception{
		UserBiz userBiz = new UserBizImpl();
		user = userBiz.getUserById(user.getId());
		return "toDetail";
	}

}
 