package com.cxytiandi.kittycloud.comment.provider.convert;

import com.cxytiandi.kittycloud.comment.api.request.CommentReplySaveRequest;
import com.cxytiandi.kittycloud.comment.api.request.CommentSaveRequest;
import com.cxytiandi.kittycloud.comment.biz.param.CommentReplySaveParam;
import com.cxytiandi.kittycloud.comment.biz.param.CommentSaveParam;
import com.cxytiandi.kittycloud.common.base.EntityConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 评论回复保存参数转化器
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-15 19:26
 */
@Component
public class CommentReplySaveParamConvert implements EntityConvert<CommentReplySaveRequest, CommentReplySaveParam> {

    @Override
    public CommentReplySaveParam convert(CommentReplySaveRequest source) {
        CommentReplySaveParam saveParam = new CommentReplySaveParam();
        BeanUtils.copyProperties(source, saveParam);
        return saveParam;
    }
}