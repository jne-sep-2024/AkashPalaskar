package com.example.learn_spring_aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@Aspect
public class LoggingAspect {

    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("businessPackageConfig()")
    public void logMethodBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before Aspect - method is called " + joinPoint);
    }

    @After("businessPackageConfig()")
    public void logMethodAfterExecution(JoinPoint joinPoint) {
        logger.info("After   Aspect - method is called " + joinPoint);
    }

    @AfterThrowing(pointcut = "businessPackageConfig()",
            throwing = "exception")
    public void logMethodAfterCallException(JoinPoint joinPoint, Exception exception) {
        logger.info("After Exception   Aspect - method is called " + joinPoint + exception.getMessage());
    }

    @AfterReturning(pointcut = "businessPackageConfig()",
            returning = "resultvalue")
    public void logMethodAfterCallSuccessExecution(JoinPoint joinPoint, Object resultvalue) {
        logger.info("After   Returing    Aspect - method is called " + joinPoint + resultvalue);
    }

    @Pointcut("execution(* com.example.learn_spring_aop.*.*.*(..) )")
    public void businessPackageConfig() {
    }

    @Pointcut("@annotation(com.example.learn_spring_aop.annotation.TrackTime)")
    public void trackTimeAnnotation() {
    }

}
