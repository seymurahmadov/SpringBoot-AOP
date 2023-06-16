package com.example.springbootaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* com.example.springbootaop.service.ProductService.*(..))")
    public void beforeMethods(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " Before method " + Arrays.toString(joinPoint.getArgs()));

    }

    @After("execution(* com.example.springbootaop.service.ProductService.*(..))")
    public void afterMethods(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " After method " + Arrays.toString(joinPoint.getArgs()));
        System.out.println();
    }

    @AfterReturning("execution(* com.example.springbootaop.service.ProductService.*(..))")
    public void afterReturnOfMethod(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + " After the method returns a value " + Arrays.toString(joinPoint.getArgs()));
    }

    @Pointcut("execution(* com.example.springbootaop.service.ProductService.*(..))")
    public void pointCutForAfterReturning() {
    }


    @AfterThrowing(
            pointcut = "pointCutForAfterReturning()", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("LogAfterThrowing is runnning");
        System.out.println("MethodName: " + joinPoint.getSignature().getName());
        System.out.println("Exception: " + error);
        System.out.println("***");

    }

    @Around("execution(* com.example.springbootaop.service.ProductService.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("LogAround is running");
        System.out.println("LogAround method " + joinPoint.getSignature().getName());
        System.out.println("Logging Arguments " + Arrays.toString(joinPoint.getArgs()));

        System.out.println("Around before is running");
        Object res = joinPoint.proceed();
        System.out.println("Around after is running");

        System.out.println("***");
        return res;

    }


}
