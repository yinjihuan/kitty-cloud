package com.cxytiandi.kittycloud.comment.biz.convert;

import com.cxytiandi.kittycloud.comment.biz.bo.CommentBO;
import com.cxytiandi.kittycloud.comment.biz.document.CommentDocument;
import com.cxytiandi.kittycloud.common.base.EntityConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 评论BO转换器
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-16 15:24
 */
@Component
public class CommentBOConvert implements EntityConvert<CommentDocument, CommentBO> {

    public CommentBO convertPlus(CommentDocument source, String nickname, int replyCount) {
        CommentBO commentBO = new CommentBO();
        BeanUtils.copyProperties(source, commentBO);
        commentBO.setNickname(nickname);
        commentBO.setReplyCount(replyCount);
        return commentBO;
    }

}