package cn.cjgl.springboot.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cjgl.springboot.dao.SubSystemDao;
import cn.cjgl.springboot.pojo.SubSystem;

@Service
@Transactional
public class SubSystemService {
	
	@Resource(name = "subSystemDao")
	private SubSystemDao subSystemDao;
	
	public int addSubSystem(SubSystem subSystem) {
		int nResult = 0;
		if((nResult = this.subSystemDao.checkSubSystem(subSystem)) == 0) {
			this.subSystemDao.addSubSystem(subSystem);
		}
		return nResult;
	}
	
	public int modSubSystem(SubSystem subSystem) {
		int nResult = 0;
		if((nResult = this.subSystemDao.checkSubSystem(subSystem)) == 0) {
			this.subSystemDao.modSubSystem(subSystem);
		}
		return nResult;
	}
	
	public void delSubSystem(SubSystem subSystem) {
		this.subSystemDao.delSubSystem(subSystem);
	}
	
	public SubSystem querySubSystem(SubSystem subSystem) {
		return this.subSystemDao.querySubSystem(subSystem);
	}
	
	public List<SubSystem> querySubSystemList(SubSystem subSystem){
		return this.subSystemDao.querySubSystemList(subSystem);
	}
	
	public Integer checkSubSystem(SubSystem subSystem) {
		return this.subSystemDao.checkSubSystem(subSystem);
	}
}
