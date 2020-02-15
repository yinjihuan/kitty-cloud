package com.cxytiandi.kittycloud.comment.provider.service;

import com.cxytiandi.kittycloud.comment.api.request.CommentSaveRequest;
import com.cxytiandi.kittycloud.comment.api.service.CommentRemoteService;
import com.cxytiandi.kittycloud.comment.biz.param.CommentSaveParam;
import com.cxytiandi.kittycloud.comment.biz.service.CommentService;
import com.cxytiandi.kittycloud.comment.provider.convert.CommentSaveParamConvert;
import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.common.constant.DubboConstant;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论RPC/REST接口实现
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@RestController
@Service(version = DubboConstant.VERSION_V100, group = DubboConstant.DEFAULT_GROUP)
public class CommentRemoteServiceImpl implements CommentRemoteService {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentSaveParamConvert commentSaveParamConvert;

    @Override
    public ResponseData<String> saveComment(CommentSaveRequest request) {
        CommentSaveParam saveParam = commentSaveParamConvert.convert(request);
        return Response.ok(commentService.saveComment(saveParam));
    }

    @Override
    public ResponseData<Boolean> removeComment(String id) {
        return Response.ok(commentService.removeComment(id));
    }

}