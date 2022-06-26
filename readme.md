



# 0625

https://www.youtube.com/watch?v=lqjOqeVzzsc&list=PLumVmq_uRGHgBrimIp2-7MCnoPUskVMnd&index=3

- startspring.io 로 시작하기
- gradle open한 후 open as project 클릭



## 라이브러리 살펴보기

- Gradle은 의존관계가 있는 라이브러리를 함께 다운로드 한다.

  

  - **스프링 부트 라이브러리**
    - spring-boot-starter-web
      - spring-boot-starter-tomcat 톰캣(웹서버)
      - spring-webmvc 스프링 웹 MVC
    - spring-boot-starter-thymeleaf - 타임리프 템플릿 엔진(View)
    - spring-boot-starter(공통) 스프링부트 + 스프링코어+ 로깅
      - spirng boot
        - spring core
      - spring-boot-starter-logging
        - lockback slf4j
  - **테스트 라이브러리**
    - spring-boot-start-test
      - junit: 테스트 프레임워크
      - mockito: 목 라이브러리
      - assertj: 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리
      - spring-test: 스프링 통합 테스트 지원

## View 환경 설정

### Welcome Page 만들기

resources/static/index.html

```html
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>hello world</title>
</head>
<body>
Hello
<a href="/hello">hello</a>
</body>
</html>
```



- **스프링 boot가 제공하는 Welcome Page 기능**

- `static/index.html` 을 올려두면 Welcome Page 기능을 제공한다

- https://docs.spring.io/spring-boot/docs/current/reference/html/index.html

  

- **thymeleaf 템플릿 엔진**
- thymleaf 공식사이트
  - https://www.thymeleaf.org/
- 스프링 공식 튜토리얼
- 



### 실습

- static에 index.html 작성해보고 실행하기
- java/hello.hellospring에 
  - controller 패키지 만들기
    - HelloController 클래스 만들기