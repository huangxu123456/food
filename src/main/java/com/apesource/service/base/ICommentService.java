package com.apesource.service.base;

import com.apesource.pojo.Comment;

import java.io.IOException;
import java.util.Map;

public interface ICommentService  {
    //添加评论
    int InsertComment(Comment comment) throws IOException;
}
