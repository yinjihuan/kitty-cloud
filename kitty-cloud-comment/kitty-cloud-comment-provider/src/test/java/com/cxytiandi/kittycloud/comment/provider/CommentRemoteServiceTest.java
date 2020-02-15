package com.cxytiandi.kittycloud.comment.provider;

import com.cxytiandi.kittycloud.comment.api.request.CommentSaveRequest;
import com.cxytiandi.kittycloud.comment.api.service.CommentRemoteService;
import com.cxytiandi.kittycloud.comment.biz.enums.CommentBizTypeEnum;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-15 19:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentRemoteServiceTest {

    @Autowired
    private CommentRemoteService commentRemoteService;

    @Test
    public void saveComment() {
        CommentSaveRequest saveRequest = CommentSaveRequest.builder()
                .commentBizId("1")
                .commentBizType(CommentBizTypeEnum.ARTICLE.getType())
                .commentBizUserId(1L)
                .userId(2L)
                .content("欢迎来到最低调的开源项目kitty-cloud")
                .build();
        ResponseData<String> saveCommentResp = commentRemoteService.saveComment(saveRequest);
        Assert.assertTrue(saveCommentResp.isSuccess());
    }

    @Test
    public void removeComment() {
        CommentSaveRequest saveRequest = CommentSaveRequest.builder()
                .commentBizId("1")
                .commentBizType(CommentBizTypeEnum.ARTICLE.getType())
                .commentBizUserId(1L)
                .userId(2L)
                .content("欢迎来到最低调的开源项目kitty-cloud")
                .build();
        ResponseData<String> saveCommentResp = commentRemoteService.saveComment(saveRequest);
        ResponseData<Boolean> removeCommentResp = commentRemoteService.removeComment(saveCommentResp.getData());
        Assert.assertTrue(removeCommentResp.isSuccess() && removeCommentResp.getData());
    }

}