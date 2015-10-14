package com.greg82p.skeleton.aop;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Component
public class StopWatchMethodInterceptor implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch stopWatch = new StopWatch(invocation.getMethod().toGenericString());

        stopWatch.start();

        try {
            log.info("--- method start : {}", invocation.getMethod().toGenericString());
            return invocation.proceed();
        } finally {
            stopWatch.stop();

            log.info(stopWatch.prettyPrint());
            log.info("--- method end : {}", invocation.getMethod().toGenericString());
        }
    }
}
