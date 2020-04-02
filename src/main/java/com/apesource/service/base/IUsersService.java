package com.apesource.service.base;

import com.apesource.pojo.Users;

import java.io.IOException;

public interface IUsersService {
    Users selectByName(String name) throws IOException;

    //注册账户
    int insertUser(Users user) throws IOException;

    //修改密码
    int updatePwd(Users user) throws IOException;
}
