# Spring Security-basic
* 해당 어플리케이션은 Spring-Security 를 사용한 초기 테스트 용도 어플리케이션 입니다.

## 개요
* 해당 어플리케이션은 Spring-security 도입하고 Test Code 구현을 위한 어플리케이션 입니다.

## 사용된 의존성 목록
본 어플리케이션을 작성하기 위해서 대표적으로 아래와 같은 의존성이 사용되었습니다.
* spring-boot-starter-data-jpa
* spring-boot-starter-web
* spring-boot-starter-test
* spring-boot-starter-security
* jsonwebtoken
* h2database (in memory)
* lombok

## 특이사항
* In Memory 접근을 위한 port 는 8080 입니다.
* In Memory 기반 으로 동작하기에 별도의 설정은 필요하지 않습니다.
* H2 Console [http://localhost:8080/h2-console](http://localhost:8080/h2-console) 주소로 접근할 수 있습니다.
* 어플리케이션은 update 진행 중 입니다.