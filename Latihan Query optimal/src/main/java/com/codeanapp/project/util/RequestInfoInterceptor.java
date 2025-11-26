package com.codeanapp.project.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class RequestInfoInterceptor implements HandlerInterceptor {

    @Autowired
    private LoggingHolder loggingHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        loggingHolder.setPath(request.getRequestURI());
        loggingHolder.setDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss:SS")));
        loggingHolder.setVersion("1.0.0");
        return true;
    }
}
