package cn.cjgl.springboot.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import net.minidev.json.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
	private static final Logger log = LoggerFactory.getLogger(UserControllerTest.class);
	
	private MockMvc mockMvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。  
	  
    @Autowired
    private WebApplicationContext wac;
    
    @Autowired
	MockHttpServletRequest request;
	
	@Autowired
	MockHttpSession session;
    
    @Before // 在测试开始前初始化工作  
    public void setup() {  
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();  
    }
    
	@Test
	public void testQueryUsers() throws Exception {
		log.info("testQueryUsers");
		
		request.setAttribute("rID", "123");
		session.setAttribute("sID", "sID=test");
		
		mockMvc.perform(post("/queryUsers").session(session)
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void testQueryUsersJson() throws Exception {
		log.info("testQueryUsersJson");
		
		Map<String, Object> map = new HashMap<String, Object>();
    	map.put("address", "合肥");
    	
        MvcResult result = mockMvc.perform(post("/queryUsersJson").content(JSONObject.toJSONString(map)))
        		.andExpect(status().isOk())// 模拟向testRest发送get请求  
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))// 预期返回值的媒体类型text/plain;charset=UTF-8  
                .andReturn();// 返回执行请求的结果  
		
		log.info(result.getResponse().getContentAsString());
	}

}
