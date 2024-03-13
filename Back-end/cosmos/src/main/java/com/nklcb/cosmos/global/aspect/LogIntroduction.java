package com.nklcb.cosmos.global.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.function.BiConsumer;

/**
 * @author 이민재
 * @description 각종 클래스의 요청에 대해 AOP로 로깅을 진행하는 클래스
 */

@Slf4j
@Aspect
@Component
public class LogIntroduction {
    private static final String LOG_FORMAT = "METHOD : {}";

    @Pointcut("execution(* com.nklcb.cosmos..*Controller*.*(..))")
    public void allController() {}

    @Pointcut("execution(* com.nklcb.cosmos..*Service*.*(..))")
    public void allService() {}

    @Pointcut("execution(* com.nklcb.cosmos..*Repository*.*(..))")
    public void allRepository() {}

    @Before("allController()")
    public void controllerLog(final JoinPoint joinPoint) {
        logging(joinPoint, log::info);
    }

    @Before("allService() || allRepository()")
    public void serviceAndRepositoryLog(final JoinPoint joinPoint) {
        logging(joinPoint, log::debug);
    }


    private void logging(final JoinPoint joinPoint, final BiConsumer<String, String> consumer) {
        consumer.accept(LOG_FORMAT, joinPoint.getSignature().toShortString());
    }

}