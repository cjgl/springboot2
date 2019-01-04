package cn.cjgl.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.cjgl.springboot.pojo.Menu;

@Mapper
public interface MenuDao {
	public void addMenu(Menu menu);
	public void modMenu(Menu menu);
	public void delMenu(Menu menu);
	public Menu queryMenu(Menu menu);
	public List<Menu> queryMenuList(Menu menu);
	public Integer checkMenu(Menu menu);
}
