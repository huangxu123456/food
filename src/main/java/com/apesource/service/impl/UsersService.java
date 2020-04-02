package com.apesource.service.impl;

import com.apesource.dao.UsersDao;
import com.apesource.pojo.Users;
import com.apesource.service.base.IUsersService;
import com.apesource.test.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class UsersService  implements IUsersService{

    @Override
    public Users selectByName(String name) throws IOException {
        SqlSession session =   SessionUtil.getSession();
        Users users = session.getMapper(UsersDao.class).selectByName(name);
        SessionUtil.close();
       return users;
    }

    @Override
    public int insertUser(Users user) throws IOException {
        SqlSession session =   SessionUtil.getSession();
        int i = session.getMapper(UsersDao.class).insertUser(user);
        session.commit();
        SessionUtil.close();
        return i;
    }

    @Override
    public int updatePwd(Users user) throws IOException {
        SqlSession session = SessionUtil.getSession();
        int i = session.getMapper(UsersDao.class).updatePwd(user);
        session.commit();
        SessionUtil.close();
        return i;
    }
}
