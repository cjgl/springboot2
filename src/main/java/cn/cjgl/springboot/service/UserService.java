package cn.cjgl.springboot.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cjgl.springboot.dao.UserDao;
import cn.cjgl.springboot.pojo.User;

@Service
@Transactional
public class UserService {
	private static final Logger log = LoggerFactory.getLogger(UserService.class);
	
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
	
	/**
	 * 测试事务
	 */
	public void testTransaction() {
		showUserList();
		User user = new User();
		user.setName("Jack");
		this.userDao.addUser(user);
		showUserList();
		int i = 1/0;
		log.info(""+i);
	}
	
	public void showUserList() {
		User user = new User();
		List<User> userList = this.userDao.queryUsers(user);
		for(User u : userList) {
			log.info(u.getId() + " : " + u.getName());
		}
	}
}
