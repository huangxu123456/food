package com.apesource.service.base;

import com.apesource.pojo.Address;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;

public interface IAddressService  {
    //查询用户所有地址
    List<Address> selectAllByUserId(@Param("id") int id) throws IOException;
    //根据地址id查询地址
    Address selectByid(@Param("id")int id) throws IOException;
    //新增地址
    int insertAddress(Address address) throws IOException;
    //修改地址
    int updateAddress(Address address) throws IOException;
    //删除地址
    int deleteAddressById(@Param("id")int id) throws IOException;
}
