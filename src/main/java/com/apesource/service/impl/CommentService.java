package com.apesource.service.impl;

import com.apesource.dao.CommentDao;
import com.apesource.pojo.Comment;
import com.apesource.service.base.ICommentService;
import com.apesource.test.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class CommentService implements ICommentService {
    @Override
    public int InsertComment(Comment comment) throws IOException {
        SqlSession session = SessionUtil.getSession();
        int i = session.getMapper(CommentDao.class).InsertComment(comment);
        session.commit();
        SessionUtil.close();
        return i;
    }
}
