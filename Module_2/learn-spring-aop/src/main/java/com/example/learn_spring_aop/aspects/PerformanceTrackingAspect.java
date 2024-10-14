package com.example.learn_spring_aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

//    @Around("execution(* com.example.learn_spring_aop.*.*.*(..))")
    @Around("com.example.learn_spring_aop.aspects.LoggingAspect.trackTimeAnnotation()")
    public Object findExceptiontime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //start a timmer
        long startTimeMillis = System.currentTimeMillis();

        //Execute the  method
        Object returnvalue = proceedingJoinPoint.proceed();

        // stop a timmer
        long stopTimeMillies = System.currentTimeMillis();

        long exceptionDuration = stopTimeMillies - startTimeMillis;

        logger.info("Around Aspect - {} Method Execution in ms {}", proceedingJoinPoint, exceptionDuration);
        return returnvalue;
    }
}
