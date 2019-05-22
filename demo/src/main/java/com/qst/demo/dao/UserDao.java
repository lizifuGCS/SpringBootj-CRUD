package com.qst.demo.dao;

import com.qst.demo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from User where id=#{id}" )
    public User getById(@Param("id") int id);

    @Insert("insert into User(id,name,age)values(#{id},#{name},#{age})")
    public int insert(User user);

    /*查询用户*/
    @Select("select id,name,age from User " )
    public List<User>  selectAllUser();
}
