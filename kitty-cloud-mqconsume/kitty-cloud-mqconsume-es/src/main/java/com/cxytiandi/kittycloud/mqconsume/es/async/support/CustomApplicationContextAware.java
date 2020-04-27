package com.cxytiandi.kittycloud.mqconsume.es.async.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-27 21:01
 */
@Component
public class CustomApplicationContextAware implements ApplicationContextAware {

    /**
     * 总任务数量
     */
    private long taskCount;

    public long getTaskCount() {
        return taskCount;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> beanMap = applicationContext.getBeansWithAnnotation(Component.class);
        if (beanMap == null) {
            return;
        }
        for (Object bean : beanMap.values()) {
            Class<?> clz = bean.getClass();
            Method[] methods = clz.getMethods();
            for (Method method : methods) {
                EventListener eventListener = AnnotationUtils.findAnnotation(method, EventListener.class);
                if (eventListener != null) {
                    taskCount++;
                }
            }
        }
    }
}
