package com.cxytiandi.kittycloud.comment.biz.service.impl;

import com.cxytiandi.kittycloud.comment.biz.convert.CommentDocumentConvert;
import com.cxytiandi.kittycloud.comment.biz.convert.CommentReplyDocumentConvert;
import com.cxytiandi.kittycloud.comment.biz.dao.CommentDao;
import com.cxytiandi.kittycloud.comment.biz.document.CommentDocument;
import com.cxytiandi.kittycloud.comment.biz.enums.CommentBizTypeEnum;
import com.cxytiandi.kittycloud.comment.biz.param.CommentReplySaveParam;
import com.cxytiandi.kittycloud.comment.biz.param.CommentSaveParam;
import com.cxytiandi.kittycloud.comment.biz.service.CommentService;
import com.cxytiandi.kittycloud.common.base.ResponseCode;
import com.cxytiandi.kittycloud.common.exception.BizException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 评论业务接口实现
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 21:45
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private CommentDocumentConvert commentDocumentConvert;

    @Autowired
    private CommentReplyDocumentConvert commentReplyDocumentConvert;

    @Override
    public String saveComment(CommentSaveParam param) {
        if (param == null || !StringUtils.hasText(param.getCommentBizId()) || !StringUtils.hasText(param.getContent())
                || param.getCommentBizUserId() == null || param.getUserId() == null) {
            throw new BizException(ResponseCode.PARAM_ERROR_CODE);
        }

        if (CommentBizTypeEnum.fromType(param.getCommentBizType()) == null) {
            throw new BizException(ResponseCode.PARAM_ERROR_CODE, "评论业务类型不存在");
        }

        return commentDao.saveComment(commentDocumentConvert.convert(param));
    }

    @Override
    public boolean removeComment(String id) {
        if (!StringUtils.hasText(id)) {
            return false;
        }
        return commentDao.removeComment(id);
    }

    @Override
    public String saveCommentReply(CommentReplySaveParam param) {
        if (param == null || !StringUtils.hasText(param.getCommentId()) || !StringUtils.hasText(param.getContent())
                || param.getReplayRefUserId() == null || param.getUserId() == null) {
            throw new BizException(ResponseCode.PARAM_ERROR_CODE);
        }

        CommentDocument comment = commentDao.getComment(param.getCommentId());
        if (comment == null) {
            throw new BizException(ResponseCode.NOT_FOUND_CODE, "评论不存在");
        }

        return commentDao.saveCommentReply(param.getCommentId(), commentReplyDocumentConvert.convert(param));
    }

    @Override
    public boolean removeCommentReply(String replyId) {
        return commentDao.removeCommentReply(replyId);
    }

}