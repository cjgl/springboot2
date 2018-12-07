package cn.cjgl.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@RequestMapping("/index")
	public ModelAndView index(ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView.setViewName("index");
		modelAndView.addObject("sessionId", request.getSession().getId());
		return modelAndView;
	}
	
	@RequestMapping("/")
	public ModelAndView index0(ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView.setViewName("index");
		modelAndView.addObject("sessionId", request.getSession().getId());
		return modelAndView;
	}
	
	@RequestMapping("/treegrid")
	public ModelAndView treegrid(ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView.setViewName("treegrid");
		return modelAndView;
	}
	
	@RequestMapping("/group")
	public ModelAndView group(ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView.setViewName("group");
		return modelAndView;
	}
}
