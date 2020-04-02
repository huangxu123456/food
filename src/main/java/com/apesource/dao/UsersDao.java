package com.apesource.dao;

import com.apesource.pojo.Users;
import org.apache.ibatis.annotations.Param;

public interface UsersDao {
   //根据用户名数据库中查找
    Users selectByName(@Param("name") String name);

    //注册账户
    int insertUser(Users user);

    //修改密码
    int updatePwd(Users user);
}
