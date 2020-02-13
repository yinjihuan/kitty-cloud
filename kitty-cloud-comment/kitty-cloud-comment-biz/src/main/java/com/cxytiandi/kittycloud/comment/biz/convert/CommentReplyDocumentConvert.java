package com.cxytiandi.kittycloud.comment.biz.convert;

import com.cxytiandi.kittycloud.comment.biz.document.CommentDocument;
import com.cxytiandi.kittycloud.comment.biz.document.CommentReplyDocument;
import com.cxytiandi.kittycloud.comment.biz.param.CommentReplySaveParam;
import com.cxytiandi.kittycloud.comment.biz.param.CommentSaveParam;
import com.cxytiandi.kittycloud.common.base.EntityConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 评论回复Document转换器
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 21:54
 */
@Component
public class CommentReplyDocumentConvert implements EntityConvert<CommentReplySaveParam, CommentReplyDocument> {

    @Override
    public CommentReplyDocument convert(CommentReplySaveParam source) {
        CommentReplyDocument replyDocument = new CommentReplyDocument();
        BeanUtils.copyProperties(source, replyDocument);
        return replyDocument;
    }

}