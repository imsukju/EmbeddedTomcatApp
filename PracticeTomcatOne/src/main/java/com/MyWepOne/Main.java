package com.MyWepOne;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

public class Main {
    public static void main(String[] args) throws Exception {
        // 내장 Tomcat 서버 생성 및 설정
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);  // 포트 설정

        // Webapp 디렉토리 지정
        String contextPath = "";  // 루트 컨텍스트
        String docBase = new File("src/main/webapp").getAbsolutePath();
        System.out.println("Document Base: " + docBase);  // 디버그용 출력
        
        Context ctx = tomcat.addWebapp(contextPath, docBase);
        
        // 컨텍스트 생성 실패 처리
        if (ctx == null) {
            System.err.println("Context creation failed.");
            return;
        }
        
        // 톰캣 서버 시작
        tomcat.getConnector();  // 커넥터 초기화
        tomcat.start();
        System.out.println("Tomcat started on port 8080.");
        tomcat.getServer().await();  // 서버 대기
        
    }
}
