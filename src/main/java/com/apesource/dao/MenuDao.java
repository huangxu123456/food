package com.apesource.dao;

import com.apesource.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao {
    //查询所有菜
    List<Menu> selectAll();

    //更新评价星级
    int updateMenuById(@Param("point")int point,@Param("id")int id);

    //查看菜品详情根据id
    Menu selectById(@Param("id")int id);
}
