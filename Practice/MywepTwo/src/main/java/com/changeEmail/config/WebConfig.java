package com.changeEmail.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;




import com.changeEmail.handlefh.PersonFormHandler;
import com.changeEmail.handlefh.PersonHandler;
import com.changeEmail.interceptor.MyInterceptor;
import com.changeEmail.util.DatabaseMessageSource;

@Configuration
@EnableWebMvc  // 웹 관련 설정 활성화
@ComponentScan(basePackages = {"com.changeEmail.controller", "com.changeEmail.handlefh", "com.changeEmail.interceptor"})  // 컨트롤러 스캔
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
    
    @Bean
    public StandardServletMultipartResolver multipartResolver() {
        return new StandardServletMultipartResolver();
    }   
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("extras/home");  // 빈 경로 매핑
        registry.addViewController("/about").setViewName("extras/about");  // "/about" 경로 매핑
    }

    // 추가적인 설정: Default Servlet Handler  디스패처 서블릿이 정적 리소스도 잘 처리하지만
    // 그래도 Default Servlet Handler 는 구현하는 습관을 가지자
    @Override
    public void configureDefaultServletHandling(org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer configurer) {
        configurer.enable();  // 기본 서블릿 핸들링 활성화
    }
    
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // JSON 메시지 컨버터 추가
        converters.add(new MappingJackson2HttpMessageConverter());
        
        converters.add(new ResourceHttpMessageConverter());        

    }
    @Bean
    public RouterFunction<ServerResponse> personRotes(PersonHandler handler)
    {
    	return RouterFunctions.route().GET("/person/{id}", handler::getPerson)
    			.GET("/people",handler::listPeople)
    			.POST("/person",handler::createPerson).build();
    }
    
    
//    @Bean
//    public RouterFunction<ServerResponse> routerFunction(
//    		PersonFormHandler personFormHander)
//    {
//    	return RouterFunctions.route().GET("/person-form",personFormHander::renderPersonForm).build();
//    }
    
    @Bean
    public RouterFunction<ServerResponse> routerFunction2(
    		PersonFormHandler personFormHander)
    {
    	return RouterFunctions.route().GET("/person-form", p ->
    		ServerResponse.ok().render("handlefh/person")).build();
    }
    
    

//    @Bean
//    public RouterFunction<ServerResponse> routerFuntion2()
//    {
//        RouterFunction<ServerResponse> route = RouterFunctions.route()
//        	    .path("/person", b1 -> b1
//        	        .nest(accept(MediaType.APPLICATION_JSON), b2 -> b2
//        	            .GET("/{id}", handler::getPerson)
//        	            .GET(handler::listPeople))
//        	        .POST(handler::createPerson))
//        	    .build();
//    }
    @Autowired
    MyInterceptor myInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 모든 경로에 대해 인터셉터를 적용
        registry.addInterceptor(myInterceptor).addPathPatterns("/valid/**");
    }
    @Bean
    public MessageSource messageSource()
    {
    	DatabaseMessageSource messageSource = new DatabaseMessageSource();
    	return messageSource;
    }
    @Bean
    public LocaleChangeInterceptor localeIntercepter()
    {
    	LocaleChangeInterceptor inter = new LocaleChangeInterceptor();
    	inter.setParamName("lang");
    	return inter;
    }
    
 
}