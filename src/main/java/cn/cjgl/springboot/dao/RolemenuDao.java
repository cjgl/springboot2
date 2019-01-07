package cn.cjgl.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.cjgl.springboot.pojo.Rolemenu;

@Mapper
public interface RolemenuDao {
	public void addRolemenu(Rolemenu rolemenu);
	public void modRolemenu(Rolemenu rolemenu);
	public void delRolemenu(Rolemenu rolemenu);
	public void delRolemenuByRoleid(Rolemenu rolemenu);
	public Rolemenu queryRolemenu(Rolemenu rolemenu);
	public List<Rolemenu> queryRolemenuList(Rolemenu rolemenu);
}
