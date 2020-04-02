package com.apesource.service.impl;

import com.apesource.dao.AddressDao;
import com.apesource.pojo.Address;
import com.apesource.service.base.IAddressService;
import com.apesource.test.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class AddressService implements IAddressService {

    @Override
    public List<Address> selectAllByUserId(int id) throws IOException {
        SqlSession session = SessionUtil.getSession();
        List<Address> addresses = session.getMapper(AddressDao.class).selectAllByUserId(id);
        SessionUtil.close();
        return addresses;
    }

    @Override
    public Address selectByid(int id) throws IOException {
        SqlSession session = SessionUtil.getSession();
        Address address = session.getMapper(AddressDao.class).selectByid(id);
        SessionUtil.close();
        return address;
    }

    @Override
    public int insertAddress(Address address) throws IOException {
        SqlSession session = SessionUtil.getSession();
        int i = session.getMapper(AddressDao.class).insertAddress(address);
        session.commit();
        SessionUtil.close();
        return i;
    }

    @Override
    public int updateAddress(Address address) throws IOException {
        SqlSession session = SessionUtil.getSession();
        int i = session.getMapper(AddressDao.class).updateAddress(address);
        session.commit();
        SessionUtil.close();
        return i;
    }

    @Override
    public int deleteAddressById(int id) throws IOException {
        SqlSession session = SessionUtil.getSession();
        int i = session.getMapper(AddressDao.class).deleteAddressById(id);
        session.commit();
        SessionUtil.close();
        return i;
    }
}
