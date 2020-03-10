package com.cxytiandi.kittycloud.comment.provider.convert;

import com.cxytiandi.kittycloud.comment.api.request.CommentQueryRequest;
import com.cxytiandi.kittycloud.comment.biz.param.CommentQueryParam;
import com.cxytiandi.kittycloud.common.base.EntityConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 评论查询参数转换器
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-16 16:14
 */
@Component
public class CommentQueryParamConvert implements EntityConvert<CommentQueryRequest, CommentQueryParam> {

    @Override
    public CommentQueryParam convert(CommentQueryRequest source) {
        CommentQueryParam param = new CommentQueryParam();
        BeanUtils.copyProperties(source, param);
        return param;
    }

}