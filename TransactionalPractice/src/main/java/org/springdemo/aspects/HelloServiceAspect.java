//package org.springdemo.aspects;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class HelloServiceAspect {
//
////    @After("execution(* org.springdemo.service.HelloService.greetings(..))")
////    public void after(){
////        System.out.println("b");
////    }
////
////    @Before("execution(* org.springdemo.service.HelloService.greetings(..))")
////    public void before(){
////        System.out.println("a");
////    }
////
////    @AfterReturning("execution(* org.springdemo.service.HelloService.greetings(..))")
////    public void AfterReturn(){
////        System.out.println("After Return");
////    }
////
////    @AfterThrowing("execution(* org.springdemo.service.HelloService.greetings(..))")
////    public void AfterThrow(){
////        System.out.println("After throw");
////    }
//
//    @Around("execution(* org.springdemo.service.HelloService.greetings(..))")
//    public Object Around(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        System.out.println("Something else");
//
//        Object result = null;
//
//        result = joinPoint.proceed(new Object[]{"Bill"});
//
//        System.out.println("b");
//
//        return result;
//    }
//
//
//}
