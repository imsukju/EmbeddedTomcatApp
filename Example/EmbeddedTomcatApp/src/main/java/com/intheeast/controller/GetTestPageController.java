package com.intheeast.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tests")
public class GetTestPageController {
	
	@GetMapping("/requestparam")
	public String getTestRequestParam() {
		System.out.println("getTestRequestParam");
		return "methodarguments/requestparamTest";
	}
	
	
//	@GetMapping("/requestheader")
//	public String handleRequestHeader(@RequestHeader Map<String, String> headers) {
//	StringBuilder result = new StringBuilder ("Request Headers: <br>");
//	headers.forEach((key, value) -> {
//	result.append(key).append(": ").append(value).append("<br>");
//	});
//	return result.toString();
//	}

	
	
	@GetMapping("/requestheader")
	public String handleRequestHeader(@RequestHeader Map<String, String> headers) {
		StringBuilder reslut = new StringBuilder("Request Header: <br>");
		
		headers.forEach(
				(key,value) -> {
					
					reslut.append(key).append(":").append(value).append("<br>");
				}
				);
		
		
		
		
		return reslut.toString();
	}
	
	@GetMapping("/demo")
	public void handle(@RequestHeader("Accept=Encoding") String encoding
			, @RequestHeader(name = "Kepp-Alive", required = false) String KeepAlive
			, @CookieValue("JSESSIONID") String cookie)
	{
		System.out.println("Accept-Encoding: " + encoding);
		System.out.println("Keep-Alive" + KeepAlive);
		System.out.println("JSESSIONID" + cookie);
		
	}
	
	@GetMapping("/sessionattributesTest")
	public String getTestSessionAttributes()
	{
		System.out.println("getTestSessionAttributes");
		return "methodarguments/sessionattributesTest";
	}
	
	@GetMapping("/sessionattribute")
	public String getTestSettion()
	{
		System.out.println("getTestSessionAttribute");
		return "methodarguments/sessionattributeTest";
	}
	
	@GetMapping("/requestbody")
	public String getRequestbody()
	{
		System.out.println("getRequestbody");
		return "methodarguments/requestbody";
	}
	
	@GetMapping("/responsebody")
	public String getresponsebody()
	{
		System.out.println("getresponsebody");
		return "methodarguments/responsebodytest";
	}
	
	@GetMapping("/redirectattributes")
	public String getredirectattributes()
	{
		System.out.println("getredirectattributes");
		return "methodarguments/redirectattributesTest";
	}
}