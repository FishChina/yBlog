package com.ydh.blogapi.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    //    获取日志对象
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * @Description: 错误异常处理 统一拦截所有exception
     * @Auther: Fish
     * @Date: 15:10 2023/2/23
     * @Param: request:出错的URL;
     *          e:异常
     * @Return: 返回一个错误页面
     */
    @ExceptionHandler(Exception.class)      //标识异常的注解
    public ModelAndView exceptionHander(HttpServletRequest request, Exception e) throws Exception {
        logger.error("Requst URL : {}，Exception : {}", request.getRequestURL(),e);

        //如果找到注解异常码，则不走全局exception
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }

        ModelAndView mv = new ModelAndView();
        //获取url
        mv.addObject("url",request.getRequestURL());
        //获取exception
        mv.addObject("exception", e);
        mv.setViewName("error/error");
        return mv;
    }
}