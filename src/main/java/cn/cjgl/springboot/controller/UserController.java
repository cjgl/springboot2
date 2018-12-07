package cn.cjgl.springboot.controller;

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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.cjgl.springboot.pojo.User;
import cn.cjgl.springboot.service.UserService;


@Controller
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
    private UserService userService;
	
	@RequestMapping("/queryUsers")
	public ModelAndView queryUsers(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) {
		modelAndView.setViewName("user/userList");
		modelAndView.addObject("sessionId", request.getSession().getId());
		User user = new User();
		List<User> userList = this.userService.queryUsers(user);
		for(User u : userList) {
			log.info(u.getId()+" : "+u.getName());
		}
		modelAndView.addObject("userList", userList);
		return modelAndView;
	}
	
	@RequestMapping("/queryUsersJson")
	@ResponseBody
	public List<User> queryUsersJson(HttpServletRequest request, HttpServletResponse response) {
		User user = new User();
		List<User> userList = this.userService.queryUsers(user);
		for(User u : userList) {
			log.info(u.getId()+" : "+u.getName());
		}
		return userList;
	}
	
	@RequestMapping("/testTransaction")
	public ModelAndView testTransaction(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) {
		modelAndView.setViewName("user/userList");
		modelAndView.addObject("sessionId", request.getSession().getId());
		
		try {
			this.userService.testTransaction();
		} catch(Exception e) {
			log.error(e.getMessage());
		}
		
		User user = new User();
		List<User> userList = this.userService.queryUsers(user);
		for(User u : userList) {
			log.info(u.getId()+" : "+u.getName());
		}
		modelAndView.addObject("userList", userList);
		return modelAndView;
	}
	
	@RequestMapping("/queryUsersByPage")
	public ModelAndView queryUsersByPage(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) {
		modelAndView.setViewName("user/userListByPage");
		return modelAndView;
	}
	
	@RequestMapping("/queryUsersByPageJson")
	@ResponseBody
	public Map<String, Object> queryUsersByPageJson(User user, Integer pageSize, Integer pageNumber, String sortName, String sortOrder, HttpServletRequest request, HttpServletResponse response) {
		//PageHelper.startPage(offset, limit, sort + " " + order);
		PageHelper.offsetPage(pageNumber*pageSize, pageSize, true);
		PageHelper.orderBy(sortName + " " + sortOrder);
		List<User> userList = this.userService.queryUsers(user);
		PageInfo<User> page = new PageInfo<User>(userList);
		
		for(User u : userList) {
			log.info(u.getId()+" : "+u.getName());
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("data", userList);
		map.put("total", page.getTotal());

		return map;
	}
	
	@RequestMapping("/addUser")
	@ResponseBody
	public Map<String, Object> addUser(User user, HttpServletRequest request, HttpServletResponse response) {
		
		this.userService.addUser(user);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", "success");

		return map;
	}
	
	@RequestMapping("/modUser")
	@ResponseBody
	public Map<String, Object> modUser(User user, HttpServletRequest request, HttpServletResponse response) {
		
		this.userService.modUser(user);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", "success");

		return map;
	}
	
	@RequestMapping("/delUser")
	@ResponseBody
	public Map<String, Object> delUser(User user, HttpServletRequest request, HttpServletResponse response) {
		
		this.userService.delUser(user);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("state", "success");

		return map;
	}
}
