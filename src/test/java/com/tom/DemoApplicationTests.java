package com.tom;

import com.github.pagehelper.PageHelper;
import com.tom.domain.City;
import com.tom.mappers.CityMapper;
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

		//likeName?name＝"ZhongShan"
	}
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private CityMapper cityMapper;
	@Test
	public void 分页测试() {
		PageHelper.startPage(1, 1);
		List<City> list= cityMapper.likeName("ZhongShan");
		logger.debug("{}",list);
	}
	@Test
	public void findCity() {
		City city = cityMapper.findByName("ZhongShan");
		logger.debug("{}",city);
		assertNotNull(city);
		//assertTrue(!city.isEmpty());
		assertEquals("ZhongShan", city.getName());
		//在mapper文件里写
		City city2=cityMapper.selectCityById(1l);
		logger.debug("{}",city2);
		String country = cityMapper.findCountryByName("ZhongShan");
		logger.debug("{}",country);

	}

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
