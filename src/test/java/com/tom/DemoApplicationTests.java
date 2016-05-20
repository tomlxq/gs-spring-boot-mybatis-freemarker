package com.tom;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tom.domain.City;
import com.tom.domain.User;
import com.tom.mappers.CityMapper;
import com.tom.mappers.UserMapper;
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
		//测式添加
		User user = new User("tom", "tomluo@gmail.com");
		userMapper.insertUser(user);
		assertTrue("添加成功",user.getId()!=null);
		logger.debug("{}",user);
		//测式查询
		User newUser = userMapper.findUserById(user.getId());
		assertEquals("tom", newUser.getName());
		assertEquals("tomluo@gmail.com", newUser.getEmail());
		//测式更新
		user.setName("HanHan");
		user.setEmail("HanHan@qq.com");
		userMapper.updateUser(user);
		User newUser2=userMapper.findUserById(user.getId());
		assertEquals("HanHan", newUser2.getName());
		assertEquals("HanHan@qq.com", newUser2.getEmail());
		//测式删除
		userMapper.deleteUser(user.getId());
		User newUser3=userMapper.findUserById(user.getId());
		assertTrue("删除成功",newUser3==null);

		PageHelper.startPage(1, 5); //第几页，每页大小
		List<User> list= userMapper.findAllUsers();
		logger.debug("{}",list); //new PageInfo(list)
		logger.debug("{}",new PageInfo(list));

	}


}
