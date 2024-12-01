# 📋 실전 배당금 프로젝트
### 📌 간략 소개
#### 스크래핑 기법을 활용하여 미국 주식 배당금 정보를 제공하는 API를 구현한 프로젝트입니다.

## ⚙Tech Stack
- **Framework** : Spring Boot 3.3.5
- **Language** : Java
- **Build** : Gradle
- **JDK** : JDK 17
- **Database** : H2 Database
- **Library** : Lombok, Spring-web, SpringSecurity, Logback, JPA, Jsoup, Jwt, Redis

## 💡 API 명세서
### ✅ 회원 API
#### 1) POST - auth/signup
- 회원가입 API
- 중복 ID 는 허용하지 않음
- 패스워드는 암호화된 형태로 저장

#### 2) POST - auth/signin
- 로그인 API
- 회원가입이 되어있고, 아이디/패스워드 정보가 옳은 경우 JWT 발급
  
### ✅ 배당금 API
#### 1) GET - finance/dividend/{companyName} 
- 특정 회사의 배당금 내역 조회
- 회사 이름을 인풋으로 받아서 해당 회사의 메타 정보와 배당금 정보를 반환
- 잘못된 회사명이 입력으로 들어온 경우 400 status 코드와 에러메시지 반환

#### 2) GET - company/autocomplete
- 배당금 검색 - 자동완성
- 검색하고자 하는 prefix 를 입력으로 받고, 해당 prefix 로 검색되는 회사명 리스트 중 10개 반환

#### 3) GET - company
- 회사 리스트 조회
- 반환 결과는 Page 인터페이스 형태

#### 4) POST - company
- 새로운 회사 및 배당금 정보 추가
- 추가하고자 하는 회사의 ticker 를 입력으로 받아 해당 회사의 정보를 스크래핑하고 저장
- 이미 보유하고 있는 회사의 정보일 경우 400 status 코드와 에러 메시지 반환
- 존재하지 않는 회사 ticker 일 경우 400 status 코드와 에러 메시지 반환

#### 5) DELETE - company/{ticker}
- ticker 에 해당하는 회사 삭제
- 삭제시 회사의 배당금 정보와 캐시도 모두 삭제


### ✅ 배당금 정보 업데이트
스케줄러를 사용하여 매일 0시에 배당금 정보를 스크래핑하여 업데이트 사항 저장

### ✅ 로그 남기기 
logback을 사용해 Info레벨 이상의 로그를 로그 파일로 남기도록 설정

## 💡 ERD
![dividndERD](https://github.com/user-attachments/assets/9a9452dc-640a-492b-88c4-7a770dfbc75b)

