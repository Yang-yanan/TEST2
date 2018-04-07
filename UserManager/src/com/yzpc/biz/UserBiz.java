package com.yzpc.biz;
import java.util.List;
import com.yzpc.bean.User;
public interface UserBiz {
	public List<User> getAllUser();
	public User getUserById(int id);
	public int addUser(User u);
	public int updateUser(User u);
	public int deleteUser(int id);


}
