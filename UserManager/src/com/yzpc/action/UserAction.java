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
	
	private String[] sexs = new String[]{"��","Ů"};

	public String[] getSexs() {
		return sexs;
	}

	public void setSexs(String[] sexs) {
		this.sexs = sexs;
	}
	
	//��ת�����ҳ����߼���ͼ������"toadd"�ַ���
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
	
	//����û����ѽ��յ���������ӵ����ݿ�
	public String add() throws Exception{
		UserBiz userBiz=new UserBizImpl();
		userBiz.addUser(user);
		return this.toList();
	}
	
	//��ת���޸�ҳ����߼���ͼ
	public String toUpdate() throws Exception{
		UserBiz userBiz = new UserBizImpl();
		user = userBiz.getUserById(user.getId());
		return "toUpdate";
	}
	
	//�޸��û���Ϣ
	public String update() throws Exception{
		UserBiz userBiz = new UserBizImpl();
		userBiz.updateUser(user);
		return this.toList();
	}
	
	//����id��ɾ���û�
	public String delete() throws Exception{
		UserBiz userBiz = new UserBizImpl();
		userBiz.deleteUser(user.getId());
		return this.toList(); 
	}
	
	//��ת����ʾ�û�����ҳ��
	public String toDetail() throws Exception{
		UserBiz userBiz = new UserBizImpl();
		user = userBiz.getUserById(user.getId());
		return "toDetail";
	}

}
 