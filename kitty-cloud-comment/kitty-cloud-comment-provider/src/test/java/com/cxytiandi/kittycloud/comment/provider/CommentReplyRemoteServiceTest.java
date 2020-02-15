package com.cxytiandi.kittycloud.comment.provider;

import com.cxytiandi.kittycloud.comment.api.request.CommentReplySaveRequest;
import com.cxytiandi.kittycloud.comment.api.service.CommentReplyRemoteService;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * CommentReplyRemoteService测试类
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-15 20:50
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentReplyRemoteServiceTest {

    @Autowired
    private CommentReplyRemoteService commentReplyRemoteService;

    @Test
    public void saveCommentReply() {
        CommentReplySaveRequest request = CommentReplySaveRequest.builder()
                .commentId("5e47df88b0aa74aa95a96c14")
                .content("你说的真好")
                .replayRefUserId(2L)
                .userId(3L)
                .build();
        ResponseData<String> saveCommentReplyResp = commentReplyRemoteService.saveCommentReply(request);
        Assert.assertTrue(saveCommentReplyResp.isSuccess());
    }

    @Test
    public void removeCommentReply() {
        ResponseData<Boolean> removeCommentReplyResp = commentReplyRemoteService.removeCommentReply("5e47f09ab0aa74adc80f9c6e");
        Assert.assertTrue(removeCommentReplyResp.isSuccess() && removeCommentReplyResp.getData());
    }

}