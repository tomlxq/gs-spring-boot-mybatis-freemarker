package com.tom;

import com.tom.mappers.UserMapper;
import com.tom.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
public class DemoApplicationTests {
Logger logger= LoggerFactory.getLogger(DemoApplicationTests.class);
	@Test
	public void contextLoads() {
	}
	@Autowired
	private UserMapper userMapper;

	@Test
	public void findAllUsers() {
		List<User> users = userMapper.findAllUsers();
		logger.debug("{}",users);
		assertNotNull(users);
		assertTrue(!users.isEmpty());
	}

	@Test
	public void findUserById() {
		User user = userMapper.findUserById(1l);
		assertNotNull(user);
	}

	@Test
	public void createUser() {
		User user = new User(0l, "tom", "tomluo@gmail.com");
		userMapper.insertUser(user);
		User newUser = userMapper.findUserById(user.getId());
		assertEquals("tom", newUser.getName());
		assertEquals("tomluo@gmail.com", newUser.getEmail());
	}
}
