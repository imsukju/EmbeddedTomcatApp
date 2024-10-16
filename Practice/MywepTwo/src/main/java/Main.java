import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.apache.catalina.Context;
import org.apache.catalina.core.ApplicationFilterChain;
import org.apache.catalina.startup.Tomcat;

public class Main {
	public static void main(String[] args) throws Exception {
        // 임베디드 톰캣 생성 및 설정
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        // 웹 애플리케이션 컨텍스트 경로 설정
        String contextPath = "";
        String docBase = new File("src/main/webapp").getAbsolutePath();
        Context ctx = tomcat.addWebapp(contextPath, docBase);

        if (ctx == null) {
            System.out.println("Context creation failed.");
            return;
        }

        // 톰캣 서버 시작
        tomcat.getConnector();  // 커넥터 초기화
        tomcat.start();
        tomcat.getServer().await();  // 서버 대기
    }
	
	public void abc()
	{
		List<String> list = Arrays.asList("A", "B", "C");
		list.forEach(item -> System.out.println(item));  // 각 요소를 출력
		ApplicationFilterChain a;

	}
	
}
