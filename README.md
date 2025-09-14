# Charon Blog Application

간단한 Spring Boot 블로그 애플리케이션입니다.

## 기능
- 블로그 글 목록 조회
- 새 글 작성
- 글 상세보기
- H2 인메모리 데이터베이스 사용

## 실행 방법

### 로컬 실행
```bash
# Maven Wrapper로 빌드 및 실행 (Maven 설치 불필요)
.\mvnw.cmd spring-boot:run

# 또는 JAR 파일 빌드 후 실행
.\mvnw.cmd clean package
java -jar target/blog-1.0.0.jar
```

### Docker 실행
```bash
# JAR 파일 빌드
mvn clean package

# Docker 이미지 빌드
docker build -t charon-blog .

# Docker 컨테이너 실행
docker run -p 8080:8080 charon-blog
```

## 접속
- 애플리케이션: http://localhost:8080
- H2 콘솔: http://localhost:8080/h2-console

## 기술 스택
- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- Thymeleaf
- H2 Database
- Bootstrap 5