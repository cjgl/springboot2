package cn.cjgl.springboot.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cjgl.springboot.dao.ProjectDao;
import cn.cjgl.springboot.pojo.Project;

@Service
@Transactional
public class ProjectService {
	
	@Resource(name = "projectDao")
	private ProjectDao projectDao;
	
	public int addProject(Project project) {
		int nResult = 0;
		if((nResult = this.projectDao.checkProject(project)) == 0) {
			this.projectDao.addProject(project);
		}
		return nResult;
	}
	
	public int modProject(Project project) {
		int nResult = 0;
		if((nResult = this.projectDao.checkProject(project)) == 0) {
			this.projectDao.modProject(project);
		}
		return nResult;
	}
	
	public void delProject(Project project) {
		this.projectDao.delProject(project);
	}
	
	public Project queryProject(Project project) {
		return this.projectDao.queryProject(project);
	}
	
	public List<Project> queryProjectList(Project project){
		return this.projectDao.queryProjectList(project);
	}
	
	public Integer checkProject(Project project) {
		return this.projectDao.checkProject(project);
	}
	
}
