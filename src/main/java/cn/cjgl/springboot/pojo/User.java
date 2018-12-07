package cn.cjgl.springboot.pojo;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class User {
	private Integer id;
	private String name;
	private String pwd;
	private Date createtime;
	private Date updatetime;
	private Department department;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer id, String name, String pwd, Date createtime,
			Date updatetime) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
}
