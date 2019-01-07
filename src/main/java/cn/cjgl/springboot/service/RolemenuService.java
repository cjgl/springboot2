package cn.cjgl.springboot.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cjgl.springboot.dao.RolemenuDao;
import cn.cjgl.springboot.pojo.Rolemenu;

@Service
@Transactional
public class RolemenuService {
	
	@Resource(name = "rolemenuDao")
	private RolemenuDao rolemenuDao;
	
	public void addRolemenu(Rolemenu rolemenu) {
		this.rolemenuDao.addRolemenu(rolemenu);
	}
	
	public void modRolemenu(Rolemenu rolemenu) {
		this.rolemenuDao.modRolemenu(rolemenu);
	}
	
	public void delRolemenu(Rolemenu rolemenu) {
		this.rolemenuDao.delRolemenu(rolemenu);
	}
	
	public void delRolemenuByRoleid(Rolemenu rolemenu) {
		this.rolemenuDao.delRolemenuByRoleid(rolemenu);
	}
	
	public Rolemenu queryRolemenu(Rolemenu rolemenu) {
		return this.rolemenuDao.queryRolemenu(rolemenu);
	}
	
	public List<Rolemenu> queryRolemenuList(Rolemenu rolemenu){
		return this.rolemenuDao.queryRolemenuList(rolemenu);
	}
	
	public void saveRolemenu(Rolemenu rolemenu, String menuids) {
		this.rolemenuDao.delRolemenuByRoleid(rolemenu);
		if(menuids != null && !"".equals(menuids)) {
			String[] menuidArray = menuids.split(",");
			Rolemenu tempRolemenu = new Rolemenu();
			tempRolemenu.setRoleid(rolemenu.getRoleid());
			for(String menuid : menuidArray) {
				tempRolemenu.setMenuid(Integer.parseInt(menuid));
				this.rolemenuDao.addRolemenu(tempRolemenu);
			}
		}
	}
	
}
