package com.apesource.dao;

import com.apesource.pojo.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface CommentDao {
    //添加评论
    int InsertComment(Comment comment);
}
