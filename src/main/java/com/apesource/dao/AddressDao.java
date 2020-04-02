package com.apesource.dao;

import com.apesource.pojo.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressDao {
    //查询用户所有地址
    List<Address> selectAllByUserId(@Param("id") int id);
    //根据地址id查询地址
    Address selectByid(@Param("id")int id);
    //新增地址
    int insertAddress(Address address);
    //修改地址
    int updateAddress(Address address);
    //删除地址
    int deleteAddressById(@Param("id")int id);
}
