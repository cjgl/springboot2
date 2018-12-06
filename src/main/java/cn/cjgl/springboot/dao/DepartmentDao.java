package cn.cjgl.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.cjgl.springboot.pojo.Department;

@Mapper
public interface DepartmentDao {
	public void addDepartment(Department department);
	public void modDepartment(Department department);
	public void delDepartment(Department department);
	public List<Department> queryDepartments(Department department);
	public List<Department> queryDepartments1(Department department);
}
