package com.cxytiandi.kittycloud.comment.biz.dao.impl;

import com.cxytiandi.kittycloud.comment.biz.dao.CommentDao;
import com.cxytiandi.kittycloud.comment.biz.document.CommentDocument;
import com.cxytiandi.kittycloud.comment.biz.document.CommentReplyDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

/**
 * 评论DAO实现
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public String saveComment(CommentDocument commentDocument) {
        mongoTemplate.save(commentDocument);
        return commentDocument.getId();
    }

    @Override
    public String saveCommentReply(String commentId, CommentReplyDocument commentReplyDocument) {
        Query query = Query.query(Criteria.where("id").is(commentId));
        Update update = new Update().addToSet("replys", commentReplyDocument);
        mongoTemplate.updateFirst(query, update, CommentDocument.class);
        return null;
    }
}