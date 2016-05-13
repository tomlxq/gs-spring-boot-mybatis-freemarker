package com.tom.mappers;

import com.tom.domain.City;
import com.tom.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by tom on 2016/5/14.
 */
@Mapper //可有可无
public interface CityMapper {
    @Select("select * from city where name = #{name}")
    City findByName(@Param("name") String name);
    City selectCityById(Long id);
    List<City> likeName(String name);
    @Select("select country from city where name = #{name}")
    String findCountryByName(@Param("name") String name);

}
