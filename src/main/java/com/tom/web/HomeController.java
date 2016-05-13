package com.tom.web;

import com.tom.domain.City;
import com.tom.mappers.CityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by tom on 2016/5/14.
 */
@Controller
public class HomeController {
    @Autowired
    private CityMapper cityMapper;
//http://localhost:8080/likeName?name=ZhongShan
    @RequestMapping("/likeName")
    public ModelAndView likeName(@RequestParam String name){
        List<City> cities=cityMapper.likeName(name);
        return new ModelAndView("index","cities",cities);
    }
}
