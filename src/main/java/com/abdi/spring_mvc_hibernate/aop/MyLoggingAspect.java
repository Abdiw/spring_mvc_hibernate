package com.abdi.spring_mvc_hibernate.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {

    @Around("execution(* com.abdi.spring_mvc_hibernate.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodsName = methodSignature.getName();
        System.out.println("Beginning of " + methodsName);

        Object targetMethodProceed = proceedingJoinPoint.proceed();

        System.out.println("Ending of " + methodsName);

        return targetMethodProceed;
    }
}
