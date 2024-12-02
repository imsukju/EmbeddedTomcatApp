# MywepTwo 프로젝트

Spring Web을 기반으로 사용자 관리, 이메일 변경 기능, 데이터 검증 등을 포함하는 프로젝트입니다.

---

## 프로젝트 구조
```
MywepTwo/
├── src/
│   ├── main/
│   │   ├── java/com/changeEmail/
│   │   │   ├── config/
│   │   │   │   ├── AppConfig.java                 # 애플리케이션 전반 설정
│   │   │   │   └── WebConfig.java                 # Spring Web 설정
│   │   │   ├── controller/
│   │   │   │   ├── emailcontroller.java           # 이메일 변경 API 컨트롤러
│   │   │   │   ├── GetTestPageController.java     # 테스트 페이지 컨트롤러
│   │   │   │   └── validControll/
│   │   │   │       ├── AccountConroller.java      # 계정 관리 컨트롤러
│   │   │   │       └── GetValidTestPageController.java # 데이터 검증 테스트 컨트롤러
│   │   │   ├── entity/
│   │   │   │   └── Person.java                    # 사용자 엔티티
│   │   │   ├── filter/
│   │   │   │   ├── LoggingFilter.java            # 요청 로깅 필터
│   │   │   │   └── SimpleCORSFilter.java          # CORS 처리 필터
│   │   │   ├── handlefh/
│   │   │   │   ├── PersonFormHandler.java         # 사용자 폼 데이터 처리 핸들러
│   │   │   │   └── PersonHandler.java             # 사용자 데이터 핸들러
│   │   │   ├── interceptor/
│   │   │   │   └── MyInterceptor.java             # 요청 인터셉터
│   │   │   ├── model/
│   │   │   │   ├── AccountForm.java               # 계정 폼 데이터 모델
│   │   │   │   └── ChangeEmail.java               # 이메일 변경 모델
│   │   │   ├── valid/
│   │   │   │   └── GlobalExceptionHandler.java    # 글로벌 예외 처리기
│   ├── webapp/
│   │   ├── WEB-INF/
│   │   │   ├── views/
│   │   │   │   ├── changeEmailForm.jsp            # 이메일 변경 폼
│   │   │   │   ├── changeEmailSuccess.jsp         # 성공 메시지 페이지
│   │   │   │   └── valid/accountForm.jsp          # 데이터 검증 페이지
├── pom.xml                                        # Maven 프로젝트 설정 파일
```

---

## 주요 기능

### 1. **이메일 변경**
- **emailcontroller.java**:
  - 사용자의 이메일을 변경하는 API를 제공합니다.
  - 이메일 변경 후 성공 메시지를 반환.

### 2. **데이터 검증**
- **AccountConroller.java**:
  - 계정 데이터 입력을 검증합니다.
- **GetValidTestPageController.java**:
  - 테스트용 데이터 검증 페이지를 제공합니다.

### 3. **글로벌 예외 처리**
- **GlobalExceptionHandler**:
  - 모든 컨트롤러의 예외를 처리하고 사용자 친화적인 메시지를 제공합니다.

### 4. **CORS 및 로깅**
- **SimpleCORSFilter.java**:
  - Cross-Origin Resource Sharing 문제를 해결.
- **LoggingFilter.java**:
  - 요청 정보를 로깅하여 디버깅 및 분석.

---

## 실행 방법

### 1. **필수 조건**
- **Java 17 이상**
- **Spring Boot 3.0 이상**
- **Maven**: 프로젝트 빌드 및 의존성 관리

### 2. **빌드 및 실행**
1. 프로젝트를 다운로드하고 IDE(IntelliJ, Eclipse 등)에서 열기.
2. `MywepTwoApplication.java`를 실행하여 서버 시작.
3. 브라우저에서 `/change-email`로 접근하여 이메일 변경 테스트.
