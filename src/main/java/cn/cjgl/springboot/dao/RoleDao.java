package cn.cjgl.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.cjgl.springboot.pojo.Role;

@Mapper
public interface RoleDao {
	public void addRole(Role role);
	public void modRole(Role role);
	public void delRole(Role role);
	public Role queryRole(Role role);
	public List<Role> queryRoleList(Role role);
	public Integer checkRole(Role role);
}
