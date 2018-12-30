package cn.cjgl.springboot.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cjgl.springboot.dao.RoleDao;
import cn.cjgl.springboot.pojo.Role;

@Service
@Transactional
public class RoleService {
	
	@Resource(name = "roleDao")
	private RoleDao roleDao;
	
	public int addRole(Role role) {
		int nResult = 0;
		if((nResult = this.roleDao.checkRole(role)) == 0) {
			this.roleDao.addRole(role);
		}
		return nResult;
	}
	
	public int modRole(Role role) {
		int nResult = 0;
		if((nResult = this.roleDao.checkRole(role)) == 0) {
			this.roleDao.modRole(role);
		}
		return nResult;
	}
	
	public void delRole(Role role) {
		this.roleDao.delRole(role);
	}
	
	public Role queryRole(Role role) {
		return this.roleDao.queryRole(role);
	}
	
	public List<Role> queryRoleList(Role role){
		return this.roleDao.queryRoleList(role);
	}
	
	public Integer checkRole(Role role) {
		return this.roleDao.checkRole(role);
	}
	
}
