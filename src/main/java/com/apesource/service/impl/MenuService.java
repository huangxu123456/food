package com.apesource.service.impl;

import com.apesource.dao.MenuDao;
import com.apesource.pojo.Menu;
import com.apesource.service.base.IMenuService;
import com.apesource.test.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class MenuService implements IMenuService {

    @Override
    public List<Menu> selectAll() throws IOException {
        SqlSession session = SessionUtil.getSession();
        List<Menu> menus = session.getMapper(MenuDao.class).selectAll();

        SessionUtil.close();
        return menus;
    }

    @Override
    public int updateMenuById(int point, int id) throws IOException {
        SqlSession session = SessionUtil.getSession();
        int i = session.getMapper(MenuDao.class).updateMenuById(point, id);
        session.commit();
        SessionUtil.close();
        return i;
    }

    @Override
    public Menu selectById(int id) throws IOException {
        SqlSession session = SessionUtil.getSession();
        Menu menu = session.getMapper(MenuDao.class).selectById(id);
        SessionUtil.close();
        return menu;
    }
}
