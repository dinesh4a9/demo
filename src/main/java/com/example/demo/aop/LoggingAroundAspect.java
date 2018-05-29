package com.example.demo.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.AspectJPointcutAdvisor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LoggingAroundAspect {

    private Log log = LogFactory.getLog(getClass());
    @Around("execution(* com.example.demo.aop.CustomerService.*(..))")
    public Object log(ProceedingJoinPoint pointcut) throws Throwable{

        LocalDateTime startTime = LocalDateTime.now();

        Throwable throwto = null;
        Object rtnVal = null;

        try {
            rtnVal = pointcut.proceed();
        } catch (Throwable throwable) {
            throwto = throwable;
        }

        LocalDateTime stopTime = LocalDateTime.now();

        log.info("Starting @ "+startTime);
        log.info("Stopping @ "+ stopTime +" with duration of @"+stopTime.minusNanos(startTime.getNano()));

        if (null != throwto){
            return throwto;
        }

        return rtnVal;
    }


}
