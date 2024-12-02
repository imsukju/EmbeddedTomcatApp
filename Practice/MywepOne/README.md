# MywepOne 프로젝트

Spring Web과 Spring MVC를 활용하여 사용자 데이터 관리와 요청 매개변수 처리 기능을 구현한 프로젝트입니다. 이 프로젝트는 계층화된 구조로 설계되어 있으며, RESTful API와 데이터 검증, CORS 처리 등을 포함하고 있습니다.

---

## 프로젝트 구조
```
MywepOne/
├── src/
│   ├── main/
│   │   ├── java/com/MyWepOne/
│   │   │   ├── Main.java                       # 메인 애플리케이션 클래스
│   │   │   ├── config/
│   │   │   │   └── WebConfig.java              # Spring Web 설정
│   │   │   ├── controller/
│   │   │   │   ├── LoginController.java        # 로그인 처리 컨트롤러
│   │   │   │   ├── RegisterController.java     # 사용자 등록 컨트롤러
│   │   │   │   ├── BankController.java         # 은행 계좌 관리 컨트롤러
│   │   │   │   └── RequestParamController.java # 요청 매개변수 처리 컨트롤러
│   │   │   ├── entity/
│   │   │   │   ├── Bank.java                   # 은행 계좌 엔티티
│   │   │   │   └── User.java                   # 사용자 엔티티
│   │   │   ├── service/
│   │   │   │   ├── BankService.java            # 은행 계좌 관리 서비스
│   │   │   │   └── UserService.java            # 사용자 관리 서비스
│   │   │   ├── repository/
│   │   │   │   ├── BankRepository.java         # 은행 데이터 접근 레이어
│   │   │   │   └── UserRepository.java         # 사용자 데이터 접근 레이어
│   │   │   ├── filter/
│   │   │   │   └── LoggingFilter.java          # 요청 로깅 필터
│   ├── webapp/
│   │   ├── WEB-INF/
│   │   │   ├── views/
│   │   │   │   ├── loginForm.jsp               # 로그인 폼
│   │   │   │   ├── registerForm.jsp            # 사용자 등록 폼
│   │   │   │   ├── bankAccountList.jsp         # 계좌 목록 보기 페이지
│   │   │   │   └── requestParams.jsp           # 요청 매개변수 처리 페이지
├── resources/
│   │   ├── application.properties              # 애플리케이션 설정 파일
├── pom.xml                                     # Maven 프로젝트 설정 파일
```

---

## 주요 기능

### 1. **사용자 관리**
- **RegisterController**:
  - 사용자 등록 API를 제공합니다.
  - 사용자 데이터를 데이터베이스에 저장.
- **LoginController**:
  - 사용자의 로그인 요청을 처리합니다.

### 2. **은행 계좌 관리**
- **BankController**:
  - 은행 계좌 정보를 생성, 조회, 업데이트, 삭제(CRUD)합니다.
  - 주요 엔드포인트:
    - `GET /accounts` – 계좌 목록 조회.
    - `POST /accounts` – 새 계좌 생성.
    - `PUT /accounts/{id}` – 계좌 정보 수정.
    - `DELETE /accounts/{id}` – 계좌 삭제.

### 3. **요청 매개변수 처리**
- **RequestParamController**:
  - HTTP 요청에서 전달된 매개변수를 처리하여 사용자 맞춤형 데이터를 제공합니다.

### 4. **데이터 검증 및 로깅**
- **LoggingFilter**:
  - 모든 요청의 로깅 정보를 기록하여 디버깅과 요청 추적을 지원.

---

## 실행 방법

### 1. **필수 조건**
- **Java 17 이상**
- **Spring Framework**: 5.0 이상
- **Maven**: 프로젝트 빌드 및 의존성 관리

### 2. **빌드 및 실행**
1. 프로젝트를 다운로드하여 IDE (IntelliJ, Eclipse 등)에서 열기.
2. `Main.java`를 실행하여 서버를 구동.
3. `application.properties` 파일에서 설정을 확인하여 데이터베이스 연결 및 서버 포트를 설정.

### 3. **테스트**
- 브라우저 또는 Postman으로 다음 엔드포인트를 호출하여 테스트:
  - **/login**: 로그인 페이지.
  - **/register**: 사용자 등록 폼.
  - **/accounts**: 계좌 관리 페이지.
  - **/requestParams**: 요청 매개변수 테스트.

---

## 프로젝트 목적

이 프로젝트는 다음을 학습하기 위해 설계되었습니다:
1. Spring Web MVC를 활용한 계층화된 애플리케이션 구조.
2. 사용자 데이터 및 은행 계좌 관리 RESTful API 구현.
3. 요청 매개변수 처리 및 데이터 검증 로직 통합.

---

## 엔드포인트

| HTTP 메서드 | 엔드포인트       | 설명                        |
|-------------|------------------|-----------------------------|
| GET         | `/login`         | 로그인 페이지 제공          |
| POST        | `/register`      | 사용자 등록                 |
| GET         | `/accounts`      | 계좌 목록 조회              |
| POST        | `/accounts`      | 새 계좌 생성                |
| GET         | `/requestParams` | 요청 매개변수 처리 결과 반환|
