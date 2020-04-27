package com.cxytiandi.kittycloud.mqconsume.es.async.support;


import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import com.cxytiandi.kittycloud.mqconsume.es.request.DataChangeRequest;
import lombok.extern.slf4j.Slf4j;


/**
 * 异步转同步实现
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-26 23:14
 */
@Slf4j
public class DefaultFuture extends CompletableFuture<Boolean> {
    /**
     * Key: 请求ID Value: DefaultFuture
     */
    private static final Map<String, DefaultFuture> FUTURES = new ConcurrentHashMap();

    /**
     * 请求ID
     */
    private final String id;

    /**
     * 超时时间
     */
    private final int timeout;

    /**
     * 请求信息
     */
    private DataChangeRequest request;

    /**
     * 总任务数量
     */
    private long taskCount;

    /**
     * 反馈结果数量
     */
    private AtomicLong feedbackResultCount = new AtomicLong();

    /**
     * 反馈失败结果数量
     */
    private AtomicLong feedbackFailResultCount = new AtomicLong();

    private final Lock lock = new ReentrantLock();
    private final Condition done = lock.newCondition();

    private DefaultFuture(DataChangeRequest request, long taskCount, int timeout) {
        this.id = request.getMessageId();
        this.request = request;
        this.taskCount = taskCount;
        this.timeout = timeout;
        FUTURES.put(this.id, this);
    }

    public static DefaultFuture newFuture(DataChangeRequest request, long taskCount, int timeout) {
        DefaultFuture future = new DefaultFuture(request, taskCount, timeout);
        return future;
    }

    @Override
    public boolean isDone() {
        return feedbackResultCount.get() == taskCount;
    }

    private boolean isSuccessDone() {
        return feedbackFailResultCount.get() == 0;
    }

    @Override
    public Boolean get() {
        if (isDone()) {
            return true;
        }

        long start = System.currentTimeMillis();
        lock.lock();
        try {
            while (!isDone()) {
                done.await(timeout, TimeUnit.MILLISECONDS);

                // 有失败的任务反馈
                if (!isSuccessDone()) {
                    return false;
                }

                // 全部执行成功
                if (isDone()) {
                    return true;
                }

                // 超时
                if (System.currentTimeMillis() - start > timeout) {
                    return false;
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
        return true;
    }

    public static void received(String id, boolean result) {
        DefaultFuture future = FUTURES.get(id);
        if (future != null) {
            // 累加失败任务数量
            if (!result) {
                future.feedbackFailResultCount.incrementAndGet();
            }

            // 累加执行完成任务数量
            future.feedbackResultCount.incrementAndGet();
            if (future.isDone()) {
                FUTURES.remove(id);
                future.doReceived();
            }
        }
    }

    private void doReceived() {
        lock.lock();
        try {
            if (done != null) {
                // 唤醒阻塞的线程
                done.signal();
            }
        } finally {
            lock.unlock();
        }
    }

}
