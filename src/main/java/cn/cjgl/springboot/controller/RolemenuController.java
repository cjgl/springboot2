package cn.cjgl.springboot.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;

import cn.cjgl.springboot.pojo.Rolemenu;
import cn.cjgl.springboot.service.RolemenuService;

@Controller
@RequestMapping("rolemenu")
public class RolemenuController {
	
	@Autowired
    private RolemenuService rolemenuService;
	
	@RequestMapping("/queryRolemenuList")
	@ResponseBody
	public List<Map<String, Object>> queryRolemenuList(Rolemenu rolemenu, HttpServletRequest request, HttpServletResponse response) {
		rolemenu.setPmenuid(0);
		PageHelper.orderBy("t.seqno ASC");
		List<Rolemenu> rolemenuList = this.rolemenuService.queryRolemenuList(rolemenu);
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(Rolemenu rm : rolemenuList) {
			Map<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("id", ""+rm.getMenuid());
			hashMap.put("pId", rolemenu.getPmenuid());
			hashMap.put("text", rm.getMenuname());
			hashMap.put("state", "open");
			hashMap.put("iconCls", rm.getIconcls());
			if(rm.getRolemenuid() != null) {
				hashMap.put("checked", true);
			} else {
				hashMap.put("checked", false);
			}
			
			Map<String, Object> attributes = new HashMap<String, Object>();
			attributes.put("subsystemid", rolemenu.getSubsystemid());
			attributes.put("menuurl", rm.getMenuurl());
			attributes.put("seqno", rm.getSeqno());
			hashMap.put("attributes", attributes);
			
			addRolemenu(hashMap, rolemenu.getSubsystemid(), rm.getMenuid(), rolemenu.getRoleid());
			
			list.add(hashMap);
		}
		
		return list;
	}
	
	private void addRolemenu(Map<String, Object> map, int subsystemid, int pmenuid, int roleid) {
		Rolemenu rolemenu = new Rolemenu();
		rolemenu.setSubsystemid(subsystemid);
		rolemenu.setPmenuid(pmenuid);
		rolemenu.setRoleid(roleid);
		
		PageHelper.orderBy("t.seqno ASC");
		List<Rolemenu> rolemenuList = this.rolemenuService.queryRolemenuList(rolemenu);
		
		if(rolemenuList.size() == 0) {
			return;
		}
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for(Rolemenu rm : rolemenuList) {
			Map<String, Object> hashMap = new HashMap<String, Object>();
			hashMap.put("id", ""+rm.getMenuid());
			hashMap.put("pId", map.get("id"));
			hashMap.put("text", rm.getMenuname());
			hashMap.put("state", "open");
			hashMap.put("iconCls", rm.getIconcls());
			if(rm.getRolemenuid() != null) {
				hashMap.put("checked", true);
			} else {
				hashMap.put("checked", false);
			}
			
			Map<String, Object> attributes = new HashMap<String, Object>();
			attributes.put("subsystemid", subsystemid);
			attributes.put("menuurl", rm.getMenuurl());
			attributes.put("seqno", rm.getSeqno());
			hashMap.put("attributes", attributes);
			
			addRolemenu(hashMap, subsystemid, rm.getMenuid(), roleid);
			
			list.add(hashMap);
		}
		
		map.put("children", list);
		
	}
	
	@RequestMapping(value= {"/saveRolemenu"}, produces = {"text/html;charset=UTF-8"})
	@ResponseBody
	public String saveRolemenu(Rolemenu rolemenu, String menuids, HttpServletRequest request, HttpServletResponse response) throws IOException {
		this.rolemenuService.saveRolemenu(rolemenu, menuids);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("nResult", "0");
		map.put("msg", "操作成功");

		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(map);
	}
}
