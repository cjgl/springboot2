package cn.cjgl.springboot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UploadfileControllerTest {
	private static final Logger log = LoggerFactory.getLogger(UploadfileControllerTest.class);
	
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
	public void testUploadFile() throws Exception {
		log.info("testUploadFile");
		
		MockMultipartFile file = new MockMultipartFile("upload", "orig.txt", "text/plain", "uploadfile test content".getBytes());
		mockMvc.perform(multipart("/file/uploadFile.do").file(file).param("name", "testFile.txt"))
		.andDo(print());
	}

}
