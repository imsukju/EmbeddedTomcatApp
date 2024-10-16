package com.changeEmail.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingFilter implements Filter {

    private final Logger logger = Logger.getLogger(LoggingFilter.class.getName());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        // 요청 정보 로깅
        logger.info("Request URI: " + req.getRequestURI());
        logger.info("HTTP Method: " + req.getMethod());
        
        logger.log(Level.SEVERE, "xxxx");

        // 필터 체인 계속 진행
        try
        {
        	chain.doFilter(request, response);
        }
        catch(Exception ex)
        {
        	
        }
       
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 필터 초기화
    }

    @Override
    public void destroy() {
        // 리소스 정리
    }
}