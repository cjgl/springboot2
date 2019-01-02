package cn.cjgl.springboot.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cjgl.springboot.dao.UserDao;
import cn.cjgl.springboot.pojo.User;

@Service
@Transactional
public class UserService {
	
	@Resource(name = "userDao")
	private UserDao userDao;
	
	public void addUser(User user){
		this.userDao.addUser(user);
	}
	
	public void modUser(User user){
		this.userDao.modUser(user);
	}
	
	public void delUser(User user){
		this.userDao.delUser(user);
	}
	
	public List<User> queryUsers(User user){
		return this.userDao.queryUsers(user);
	}
	
}
