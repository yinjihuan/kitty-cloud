package com.cxytiandi.kittycloud.comment.provider.convert;

import com.cxytiandi.kittycloud.comment.api.request.CommentSaveRequest;
import com.cxytiandi.kittycloud.comment.biz.param.CommentSaveParam;
import com.cxytiandi.kittycloud.common.base.EntityConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-15 19:26
 */
@Component
public class CommentSaveParamConvert implements EntityConvert<CommentSaveRequest, CommentSaveParam> {

    @Override
    public CommentSaveParam convert(CommentSaveRequest source) {
        CommentSaveParam saveParam = new CommentSaveParam();
        BeanUtils.copyProperties(source, saveParam);
        return saveParam;
    }
}