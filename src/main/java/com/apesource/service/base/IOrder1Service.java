package com.apesource.service.base;

import com.apesource.pojo.Order1;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;

public interface IOrder1Service {
    //新增订单
    int insertOrder(Order1 order) throws IOException;

    //根据用户id查询订单
    List<Order1> selectByUserId(@Param("id")int id) throws IOException;

    //将订单状态改为支付
    int updateByOrderId(@Param("id")int id) throws IOException;

    //查看已完成支付的订单
    List<Order1> selectByUserIdByType(@Param("id")int id) throws IOException;

    //根据菜单id添加评论id
    int updateCommentId(@Param("comid")int comid,@Param("oid")int oid) throws IOException;

    //查询未支付订单
    List<Order1> selectByUserIdByTypeNo(@Param("id")int id) throws IOException;
}
