package cn.cjgl.springboot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.cjgl.springboot.pojo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	private static final Logger log = LoggerFactory.getLogger(UserServiceTest.class);
	
	@Autowired
    private UserService userService;
	
	@Test
	public void testAddUser() {
		log.info("testAddUser");
		
		User user = new User();
		user.setUsername("Jack");
		this.userService.addUser(user);
	}

	@Test
	public void testModUser() {
		log.info("testModUser");
		
		User user = new User();
		user.setUserid(0);
		user.setUsername("Jack");
		this.userService.modUser(user);
	}

	@Test
	public void testDelUser() {
		log.info("testDelUser");
		
		User user = new User();
		user.setUserid(0);
		this.userService.delUser(user);
	}

	@Test
	public void testQueryUsers() {
		log.info("testQueryUsers");
	}

}
