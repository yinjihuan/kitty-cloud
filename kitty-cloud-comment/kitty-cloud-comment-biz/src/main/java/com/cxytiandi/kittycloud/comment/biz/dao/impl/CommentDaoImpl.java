package com.cxytiandi.kittycloud.comment.biz.dao.impl;

import com.cxytiandi.kittycloud.comment.biz.dao.CommentDao;
import com.cxytiandi.kittycloud.comment.biz.document.CommentDocument;
import com.cxytiandi.kittycloud.comment.biz.document.CommentReplyDocument;
import com.cxytiandi.kittycloud.comment.biz.param.CommentQueryParam;
import com.mongodb.BasicDBObject;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

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
        Date currentTime = new Date();
        commentDocument.setAddTime(currentTime);
        commentDocument.setUpdateTime(currentTime);
        mongoTemplate.save(commentDocument);
        return commentDocument.getId();
    }

    @Override
    public boolean removeComment(String id) {
        DeleteResult deleteResult = mongoTemplate.remove(Query.query(Criteria.where("id").is(id)), CommentDocument.class);
        return deleteResult.getDeletedCount() > 0;
    }

    @Override
    public String saveCommentReply(String commentId, CommentReplyDocument commentReplyDocument) {
        String replyId = new ObjectId().toString();
        Date currentTime = new Date();
        commentReplyDocument.setId(replyId);
        commentReplyDocument.setAddTime(currentTime);
        commentReplyDocument.setUpdateTime(currentTime);

        Query query = Query.query(Criteria.where("id").is(commentId));
        Update update = new Update().addToSet("replys", commentReplyDocument);
        mongoTemplate.updateFirst(query, update, CommentDocument.class);
        return replyId;
    }

    @Override
    public CommentDocument getComment(String id) {
        return mongoTemplate.findOne(Query.query(Criteria.where("id").is(id)), CommentDocument.class);
    }

    @Override
    public boolean removeCommentReply(String replyId) {
        Query query = Query.query(Criteria.where("replys._id").is(replyId));

        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.append("_id", replyId);
        Update update = new Update().pull("replys", basicDBObject);

        UpdateResult updateResult = mongoTemplate.updateFirst(query, update, CommentDocument.class);
        return updateResult.getModifiedCount() > 0;
    }

    @Override
    public long countComment(CommentQueryParam param) {
        Query query = Query.query(
                Criteria.where("commentBizType").is(param.getCommentBizType())
                        .and("commentBizId").is(param.getCommentBizId()));
        return mongoTemplate.count(query, CommentDocument.class);
    }

    @Override
    public List<CommentDocument> listComments(CommentQueryParam param) {
        Query query = Query.query(
                Criteria.where("commentBizType").is(param.getCommentBizType())
                        .and("commentBizId").is(param.getCommentBizId()));
        query.with(PageRequest.of(param.getPage() - 1, param.getPageSize(), new Sort(Sort.Direction.DESC, "id")));
        return mongoTemplate.find(query, CommentDocument.class);
    }
}