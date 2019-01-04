package cn.cjgl.springboot.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cjgl.springboot.dao.MenuDao;
import cn.cjgl.springboot.pojo.Menu;

@Service
@Transactional
public class MenuService {
	
	@Resource(name = "menuDao")
	private MenuDao menuDao;
	
	public int addMenu(Menu menu) {
		int nResult = 0;
		if((nResult=this.menuDao.checkMenu(menu)) == 0) {
			this.menuDao.addMenu(menu);
		}
		return nResult;
	}
	
	public int modMenu(Menu menu) {
		int nResult = 0;
		if((nResult=this.menuDao.checkMenu(menu)) == 0) {
			this.menuDao.modMenu(menu);
		}
		return nResult;
	}
	
	public void delMenu(Menu menu) {
		this.menuDao.delMenu(menu);
	}
	
	public Menu queryMenu(Menu menu) {
		return this.menuDao.queryMenu(menu);
	}
	
	public List<Menu> queryMenuList(Menu menu){
		return this.menuDao.queryMenuList(menu);
	}
	
	public Integer checkMenu(Menu menu) {
		return this.menuDao.checkMenu(menu);
	}
	
}
