package cn.cjgl.springboot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

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
		session.setAttribute("sID", "test");
		
		mockMvc.perform((post("/user/queryUserList").param("page", "1").param("rows", "20").session(session))
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk())
				.andDo(print());
	}
	
	@Test
	public void testQueryUsersJson() throws Exception {
		log.info("testQueryUsersJson");
		
		request.setAttribute("rID", "123");
		session.setAttribute("sID", "test");
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
    	map.add("page", "1");
    	map.add("rows", "20");

    	MvcResult result = mockMvc.perform((post("/user/queryUserList").session(session).params(map))
				.accept(MediaType.APPLICATION_JSON_UTF8_VALUE))
				.andExpect(status().isOk())
				.andDo(print()).andReturn();
    	
    	log.info(result.getResponse().getContentAsString());
	}
	
	@Test
	public void testAddUser() throws Exception {
		log.info("testAddUser");
		
		request.setAttribute("rID", "123");
		session.setAttribute("sID", "test");
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
    	map.add("projectid", "1");
    	map.add("subsystemid", "1");
    	map.add("loginname", "test");
    	map.add("username", "test");
    	map.add("pwd", "123456");

    	MvcResult result = mockMvc.perform((post("/user/addUser.do").session(session).params(map))
				.accept(MediaType.TEXT_HTML_VALUE))
				.andExpect(status().isOk())
				.andDo(print()).andReturn();
    	
    	log.info(result.getResponse().getContentAsString());
	}

}
