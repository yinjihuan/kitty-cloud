package com.cxytiandi.kittycloud.comment.biz.convert;

import com.cxytiandi.kittycloud.comment.biz.document.CommentDocument;
import com.cxytiandi.kittycloud.comment.biz.param.CommentSaveParam;
import com.cxytiandi.kittycloud.common.base.EntityConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 评论Document转换器
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 21:54
 */
@Component
public class CommentDocumentConvert implements EntityConvert<CommentSaveParam, CommentDocument> {

    @Override
    public CommentDocument convert(CommentSaveParam source) {
        CommentDocument commentDocument = new CommentDocument();
        BeanUtils.copyProperties(source, commentDocument);
        return commentDocument;
    }

}