package cn.cjgl.springboot.pojo;

import org.apache.ibatis.type.Alias;

@Alias("Rolemenu")
public class Rolemenu extends Menu {
	private Integer rolemenuid;
	private Integer roleid;
	public Integer getRolemenuid() {
		return rolemenuid;
	}
	public void setRolemenuid(Integer rolemenuid) {
		this.rolemenuid = rolemenuid;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
}
