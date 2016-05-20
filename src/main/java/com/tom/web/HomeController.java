package com.tom.web;

import com.tom.domain.City;
import com.tom.domain.User;
import com.tom.mappers.CityMapper;
import com.tom.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tom on 2016/5/14.
 */
@Controller
public class HomeController {
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private UserMapper userMapper;

    //http://localhost:8080/likeName?name=ZhongShan
    @RequestMapping("/")
    public ModelAndView home() {
        List<User> users = userMapper.findAllUsers();
        return new ModelAndView("index", "users", users);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public
    @ResponseBody
    void deleteUser(@PathVariable Long id) {
        userMapper.deleteUser(id);
    }

    @RequestMapping("/likeName")
    public ModelAndView likeName(@RequestParam String name) {
        List<City> cities = cityMapper.likeName(name);
        return new ModelAndView("index", "cities", cities);
    }
}
