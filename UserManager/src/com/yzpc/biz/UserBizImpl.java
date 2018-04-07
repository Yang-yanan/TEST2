package com.yzpc.biz;
import java.util.List;
import com.yzpc.bean.User;
import com.yzpc.dao.UserDao;
import com.yzpc.dao.UserDaoImpl;
public class UserBizImpl implements UserBiz{
	UserDao userDao = new UserDaoImpl();

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	@Override
	public int addUser(User u) {
		// TODO Auto-generated method stub
		return userDao.addUser(u);
	}

	@Override
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		return userDao.updateUser(u);
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(id);
	}
	
}
