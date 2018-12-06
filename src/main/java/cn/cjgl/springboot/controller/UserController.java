package cn.cjgl.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.cjgl.springboot.pojo.User;
import cn.cjgl.springboot.service.UserService;


@Controller
public class UserController {
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
    private UserService userService;
	
	@RequestMapping("/queryUsers")
	public ModelAndView queryUsers(ModelAndView modelAndView, HttpServletRequest request) {
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
	public List<User> queryUsersJson(HttpServletRequest request) {
		User user = new User();
		List<User> userList = this.userService.queryUsers(user);
		for(User u : userList) {
			log.info(u.getId()+" : "+u.getName());
		}
		return userList;
	}
	
	@RequestMapping("/testTransaction")
	public ModelAndView testTransaction(ModelAndView modelAndView, HttpServletRequest request) {
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
}
