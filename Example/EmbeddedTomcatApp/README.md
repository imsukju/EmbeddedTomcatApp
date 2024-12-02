# EmbeddedTomcatApp 프로젝트

Spring Framework와 Tomcat을 활용하여 내장된 Tomcat 서버 위에서 다양한 웹 애플리케이션 기능을 구현한 프로젝트입니다. 이 프로젝트는 RESTful API, 파일 업로드/다운로드, 사용자 관리, 그리고 요청/응답 처리를 포함합니다.
* Spring Framework 6.0
* Spring WebMvc 적용
* 임베디드 아파치 톰캣 서버 적용
* 교육 목적으로 Spring Data JPA 대신 JPA API + Hibernate API를 적용
* QueryDSL 적용
* 교육 목적으로 View Template 엔진으로 JSP 적용
* File Upload/Download

---

## 프로젝트 구조
```
EmbeddedTomcatApp/
├── src/
│   ├── main/
│   │   ├── java/com/intheeast/
│   │   │   ├── EmbeddedTomcatApp.java          # 메인 애플리케이션 클래스
│   │   │   ├── config/
│   │   │   │   ├── AppConfig.java             # 애플리케이션 전반 설정
│   │   │   │   └── WebConfig.java             # Spring Web 설정
│   │   │   ├── controller/
│   │   │   │   ├── ContactController.java     # 연락처 관리 컨트롤러
│   │   │   │   ├── FileController.java        # 파일 업로드/다운로드 컨트롤러
│   │   │   │   ├── MyController.java          # 기본 요청 처리 컨트롤러
│   │   │   │   ├── PostController.java        # 게시물 관리 컨트롤러
│   │   │   │   └── RequestParamController.java # 요청 매개변수 처리 컨트롤러
│   │   │   ├── entity/
│   │   │   │   ├── Comment.java               # 댓글 엔티티
│   │   │   │   ├── Post.java                  # 게시물 엔티티
│   │   │   │   └── FileEntity.java            # 파일 엔티티
│   │   │   ├── service/
│   │   │   │   ├── CommentService.java        # 댓글 관리 서비스
│   │   │   │   ├── FileService.java           # 파일 관리 서비스
│   │   │   │   └── PostService.java           # 게시물 관리 서비스
│   │   │   ├── dao/
│   │   │   │   ├── CommentDao.java            # 댓글 DAO
│   │   │   │   ├── PostDao.java               # 게시물 DAO
│   │   │   │   └── FileDao.java               # 파일 DAO
│   │   │   ├── filter/
│   │   │   │   ├── LoggingFilter.java         # 요청 로깅 필터
│   │   │   │   └── SimpleCORSFilter.java      # CORS 처리 필터
│   │   ├── webapp/
│   │   │   ├── WEB-INF/
│   │   │   │   ├── views/
│   │   │   │   │   ├── contactForm.jsp        # 연락처 폼
│   │   │   │   │   ├── postList.jsp           # 게시물 목록
│   │   │   │   │   └── uploadForm.jsp         # 파일 업로드 폼
├── resources/
│   │   ├── application.properties             # 애플리케이션 설정 파일
│   │   ├── log4j.xml                          # 로깅 설정 파일
├── pom.xml                                    # Maven 프로젝트 설정 파일
```

---

## 주요 기능

### 1. **RESTful API**
- **PostController**:
  - 게시물 CRUD 작업 제공.
  - 주요 엔드포인트:
    - `GET /posts` – 게시물 목록 조회.
    - `POST /posts` – 새 게시물 생성.
    - `PUT /posts/{id}` – 게시물 수정.
    - `DELETE /posts/{id}` – 게시물 삭제.

### 2. **파일 업로드 및 다운로드**
- **FileController**:
  - 파일 업로드 및 다운로드 기능 제공.
  - 주요 엔드포인트:
    - `POST /files/upload` – 파일 업로드.
    - `GET /files/{id}` – 특정 파일 다운로드.

### 3. **연락처 관리**
- **ContactController**:
  - 사용자 연락처 정보를 저장 및 관리.

### 4. **CORS 처리**
- **SimpleCORSFilter**:
  - Cross-Origin Resource Sharing 문제를 해결.

### 5. **로깅 필터**
- **LoggingFilter**:
  - 모든 요청과 응답의 로그를 기록.

---

## 실행 방법

### 1. **필수 조건**
- **Java 17 이상**
- **Maven**: 프로젝트 빌드 및 종속성 관리

### 2. **빌드 및 실행**
1. 프로젝트를 다운로드 후 IDE (IntelliJ, Eclipse 등)에서 열기.
2. `EmbeddedTomcatApp.java`를 실행하여 애플리케이션 구동.
3. `application.properties` 파일을 확인하여 서버 포트 및 설정 확인.

---

## 프로젝트 목적

이 프로젝트는 다음을 학습하기 위해 설계되었습니다:
1. 내장된 Tomcat을 사용한 Spring Web 애플리케이션 개발.
2. RESTful API 설계 및 파일 처리.
3. 엔티티와 서비스 계층을 활용한 모듈화된 애플리케이션 구조.
