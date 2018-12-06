package cn.cjgl.springboot.pojo;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("Department")
public class Department {
	private int id;
	private String name;
	private String remark;
	private List<User> users;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(int id, String name, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.remark = remark;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}
