package com.vkopendoh.springcrm.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    //setup pointcut
    @Pointcut("execution(* com.vkopendoh.springcrm.controller.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.vkopendoh.springcrm.service.*.*(..))")
    private void forServicePackage(){}

    @Pointcut("execution(* com.vkopendoh.springcrm.dao.*.*(..))")
    private void forDaoPackage(){}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        myLogger.info("====>> in @Before calling method:" + joinPoint.getSignature().toShortString());

        Object[] args = joinPoint.getArgs();

        for (Object argument:args){
            myLogger.info("====>> argument: " + argument);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        myLogger.info("====>> in @AfterReturning calling method:" + joinPoint.getSignature().toShortString());

        myLogger.info("====>> @AfterReturning result: " + result);
    }
}
