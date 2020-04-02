package com.apesource.service.impl;

import com.apesource.dao.Order1Dao;
import com.apesource.pojo.Order1;
import com.apesource.service.base.IOrder1Service;
import com.apesource.test.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order1Service implements IOrder1Service {
    @Override
    public int insertOrder(Order1 order) throws IOException {
        //Order1 order1=new Order1();
       // SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //String date = sdf.format(new Date());
        SqlSession sesssion = SessionUtil.getSession();
         int i = sesssion.getMapper(Order1Dao.class).insertOrder(order);
        sesssion.commit();
        SessionUtil.close();
        return i;
    }

    @Override
    public List<Order1> selectByUserId(int id) throws IOException {
        List<Order1> order1s = SessionUtil.getSession().getMapper(Order1Dao.class).selectByUserId(id);
        SessionUtil.close();
        return order1s;
    }

    @Override
    public int updateByOrderId(int id) throws IOException {
        SqlSession session= SessionUtil.getSession();
         int i = session.getMapper(Order1Dao.class).updateByOrderId(id);
        session.commit();
        SessionUtil.close();
        return i;
    }

    @Override
    public List<Order1> selectByUserIdByType(int id) throws IOException {
        SqlSession session= SessionUtil.getSession();
        List<Order1> order1s = session.getMapper(Order1Dao.class).selectByUserIdByType(id);
        SessionUtil.close();
        return order1s;

    }

    @Override
    public int updateCommentId(int comid, int oid) throws IOException {
        SqlSession session= SessionUtil.getSession();
        int i = session.getMapper(Order1Dao.class).updateCommentId(comid, oid);
        session.commit();
        SessionUtil.close();
        return i;
    }


    @Override
    public List<Order1> selectByUserIdByTypeNo(int id) throws IOException {
        SqlSession session = SessionUtil.getSession();
        List<Order1> order1s = session.getMapper(Order1Dao.class).selectByUserIdByTypeNo(id);
        SessionUtil.close();
        return order1s;
    }
}
