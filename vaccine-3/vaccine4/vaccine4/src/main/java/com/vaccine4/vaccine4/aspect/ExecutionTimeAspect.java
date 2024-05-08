package com.vaccine4.vaccine4.aspect;//package com.vaccine.backend.vaccine.aspect;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//@Slf4j
//public class ExecutionTimeAspect {
//
//    @Around("@annotation(com.vaccine4.vaccine4.LogExecutionTime)")
//    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//        long startTime = System.currentTimeMillis();
//        Object result = joinPoint.proceed();
//        long endTime = System.currentTimeMillis();
//
//        log.info("Method {} took {} ms", joinPoint.getSignature().toShortString(), (endTime - startTime));
//        return result;
//    }
//}
