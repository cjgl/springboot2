package cn.cjgl.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.cjgl.springboot.pojo.Project;

@Mapper
public interface ProjectDao {
	public void addProject(Project project);
	public void modProject(Project project);
	public void delProject(Project project);
	public Project queryProject(Project project);
	public List<Project> queryProjectList(Project project);
	public Integer checkProject(Project project);
}
