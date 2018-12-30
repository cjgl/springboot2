package cn.cjgl.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.cjgl.springboot.pojo.SubSystem;

@Mapper
public interface SubSystemDao {
	public void addSubSystem(SubSystem subSystem);
	public void modSubSystem(SubSystem subSystem);
	public void delSubSystem(SubSystem subSystem);
	public SubSystem querySubSystem(SubSystem subSystem);
	public List<SubSystem> querySubSystemList(SubSystem subSystem);
	public Integer checkSubSystem(SubSystem subSystem);
}
