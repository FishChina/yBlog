package com.ydh.blogapi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @Author: Fish
 */
@Component
@Aspect
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //通过Pointcut声明这是一个切面
    //扫描包下面的所有的
    @Pointcut("execution(* com.ydh.blogapi.*.*(..))")
    public void log() {}


    @Before("log()")
    //public void doBefore(JoinPoint joinPoint) {
    public void doBefore() {
        System.out.println("doBefore");
          logger.info("--------doBefore--------");
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        String url = request.getRequestURL().toString();
//        String ip = request.getRemoteAddr();
//        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
        //RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        //logger.info("Request : {}", requestLog);
    }

    @After("log()")
    public void doAfter() {
        System.out.println("doAfter");
        logger.warn("--------doAfter--------");
    }

    //方法返回
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterRuturn(Object result) {
        System.out.println("Result : {} ");
        logger.info("Result : {}", result);
    }

//    private class RequestLog {
//        private String url;
//        private String ip;
//        private String classMethod;
//        private Object[] args;
//
//        public RequestLog(String url, String ip, String classMethod, Object[] args) {
//            this.url = url;
//            this.ip = ip;
//            this.classMethod = classMethod;
//            this.args = args;
//        }
//
//        @Override
//        public String toString() {
//            return "{" +
//                    "url='" + url + '\'' +
//                    ", ip='" + ip + '\'' +
//                    ", classMethod='" + classMethod + '\'' +
//                    ", args=" + Arrays.toString(args) +
//                    '}';
//        }
//    }

}
