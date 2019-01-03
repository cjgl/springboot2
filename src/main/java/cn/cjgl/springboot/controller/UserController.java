package cn.cjgl.springboot.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.cjgl.springboot.pojo.User;
import cn.cjgl.springboot.service.UserService;
import cn.cjgl.springboot.util.DateTimeUtil;

@Controller
@RequestMapping("user")
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
    private UserService userService;
	
	@RequestMapping("/userPage")
	public ModelAndView userPage(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) {
		log.debug("userPage");
		
		modelAndView.setViewName("user/userPage");
		return modelAndView;
	}
	
	@RequestMapping("/queryUserJson")
	@ResponseBody
	public Map<String, Object> queryUserJson(User user, Integer page, Integer rows, String sortName, String sortOrder, HttpServletRequest request, HttpServletResponse response) {
		//PageHelper.startPage(offset, limit, sort + " " + order);
		PageHelper.offsetPage((page-1)*rows, rows, true);
		PageHelper.orderBy("t.createtime DESC");
		
		user.setDelflag("0");
		List<User> userList = this.userService.queryUserList(user);
		PageInfo<User> pageInfo = new PageInfo<User>(userList);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rows", userList);
		map.put("total", pageInfo.getTotal());

		return map;
	}
	
	@RequestMapping(value= {"/addUser"}, produces = {"text/html;charset=UTF-8"})
	@ResponseBody
	public String addUser(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String now = DateTimeUtil.getDateTime19();
		user.setCreatetime(now);
		user.setUpdatetime(now);
		user.setDelflag("0");
		
		int nResult = this.userService.addUser(user);
		String msg = "操作成功";
		if(nResult != 0) {
			msg = "登录名重复";
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nResult", nResult+"");
		map.put("msg", msg);

		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(map);
	}
	
	@RequestMapping(value= {"/modUser"}, produces = {"text/html;charset=UTF-8"})
	@ResponseBody
	public String modUser(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String now = DateTimeUtil.getDateTime19();
		user.setUpdatetime(now);
		user.setDelflag("0");
		
		int nResult = 0;
		String msg = "";
		
		if(user.getUserid() != 0) {
			nResult = this.userService.modUser(user);
			
			if(nResult != 0) {
				msg = "登录名重复";
			} else {
				msg = "操作成功";
			}
		} else {
			nResult = 1;
			msg = "内置用户无法修改";
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nResult", nResult+"");
		map.put("msg", msg);

		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(map);
	}
	
	@RequestMapping(value= {"/delUser"}, produces = {"text/html;charset=UTF-8"})
	@ResponseBody
	public String delUser(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(user.getUserid() != 0) {
			this.userService.delUser(user);

			map.put("nResult", "0");
			map.put("msg", "操作成功");
		} else {
			map.put("nResult", "1");
			map.put("msg", "内置用户无法删除");
		}

		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(map);
	}
}
