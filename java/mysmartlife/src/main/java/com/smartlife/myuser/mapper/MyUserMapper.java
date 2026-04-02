package com.smartlife.myuser.mapper;

import com.smartlife.myuser.beans.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyUserMapper {
    // 登录查询
    @Select("select * from myuser where username = #{username} and password = #{password}")
    // 登录查询成功，返回用户信息
    public MyUser findUser(MyUser myuser);
   }
