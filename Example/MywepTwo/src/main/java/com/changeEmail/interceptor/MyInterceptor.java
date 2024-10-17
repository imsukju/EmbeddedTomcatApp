package com.changeEmail.interceptor;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MyInterceptor implements HandlerInterceptor {

    // 컨트롤러 실행 전에 실행됨
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Interceptor: Before handling the request");

        // true를 반환하면 다음 핸들러 또는 컨트롤러로 진행, false 반환 시 요청을 여기서 종료
        return true;
    }

    // 컨트롤러 실행 후, 뷰 렌더링 전에 실행됨
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("Interceptor: After handling the request, before rendering the view");
    }

    // 뷰가 렌더링된 후 실행됨
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("Interceptor: After rendering the view");
    }
}
