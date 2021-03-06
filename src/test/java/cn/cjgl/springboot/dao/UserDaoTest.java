package cn.cjgl.springboot.dao;

import java.util.List;

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
public class UserDaoTest {
	private static final Logger log = LoggerFactory.getLogger(UserDaoTest.class);
	
	@Autowired
	private UserDao userDao;

    @Test
    public void testQueryUsers(){
    	log.info("testQueryUsers");
    	
    	User user = new User();
    	List<User> userList = this.userDao.queryUserList(user);
    	for(User u : userList) {
    		log.info(u.getUserid() + " : " + u.getUsername());
    	}
    }
}
