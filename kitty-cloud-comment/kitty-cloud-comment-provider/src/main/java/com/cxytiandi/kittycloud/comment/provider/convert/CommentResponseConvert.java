package com.cxytiandi.kittycloud.comment.provider.convert;

import com.cxytiandi.kittycloud.comment.api.response.CommentResponse;
import com.cxytiandi.kittycloud.comment.biz.bo.CommentBO;
import com.cxytiandi.kittycloud.common.base.EntityConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 评论Response转换器
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-16 16:20
 */
@Component
public class CommentResponseConvert implements EntityConvert<CommentBO, CommentResponse> {

    @Override
    public CommentResponse convert(CommentBO source) {
        CommentResponse response = new CommentResponse();
        BeanUtils.copyProperties(source, response);
        return response;
    }

}