package com.apesource.service.base;

import com.apesource.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;

public interface IMenuService {
    List<Menu> selectAll() throws IOException;

    //更新评价星级
    int updateMenuById(@Param("point")int point, @Param("id")int id) throws IOException;

    //查看菜品详情根据id
    Menu selectById(@Param("id")int id) throws IOException;
}
