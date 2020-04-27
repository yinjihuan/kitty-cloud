package com.cxytiandi.kittycloud.mqconsume.es.async.support;

import com.cxytiandi.kittycloud.mqconsume.es.event.DataChangeEvent;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EventListenerAspect {

    @Around(value = "@annotation(eventListener)")
    public Object aroundAdvice(ProceedingJoinPoint joinpoint, EventListener eventListener) throws Throwable {
		DataChangeEvent event = null;
		boolean executeResult = true;
    	try {
			event = (DataChangeEvent)joinpoint.getArgs()[0];
			Object result = joinpoint.proceed();
			return result;
		} catch (Exception e) {
			executeResult = false;
    		throw e;
		} finally {
			DefaultFuture.received(event.getMessageId(), executeResult);
		}
    }

}
