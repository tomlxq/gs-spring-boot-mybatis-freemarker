package com.tom.mappers;

import com.tom.domain.User;

import java.util.List;

/**
 * Created by tom on 2016/5/13.
 */


public interface UserMapper
{
    void insertUser(User user);
    User findUserById(Long id);
    List<User> findAllUsers();
}
/*
public interface UserMapper
{
    @Insert("insert into users(name,email) values(#{name},#{email})")
    @SelectKey(statement="call identity()", keyProperty="id",
            before=false, resultType=Integer.class)
    void insertUser(User user);

    @Select("select id, name, email from users WHERE id=#{id}")
    User findUserById(Integer id);

    @Select("select id, name, email from users")
    List<User> findAllUsers();

}*/
