package cn.cjgl.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.cjgl.springboot.pojo.User;

@Mapper
public interface UserDao {
	public void addUser(User user);
	public void modUser(User user);
	public void delUser(User user);
	public List<User> queryUsers(User user);
	public List<User> queryUsers1(User user);
}
