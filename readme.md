



[toc]



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

![image-20220626235905008](readme.assets/image-20220626235905008.png)

![image-20220627000256921](readme.assets/image-20220627000256921.png)

```java
//main/java/hello.hellospirng/controller/HelloController.java

package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class HelloController {

    @GetMapping("hello") //get방식임 hello페이지 들어가면 이게 호출됨
    public String hello(Model model){
        model.addAttribute("data","hello!");
        return "hello"; //이 헬로를 클릭하면 아래와 같음 hello를 렌더링 시켜라
        
    }
}

```

```html
//resources/templates/hello.html

<!doctype html>
<html xmlns:th="http://www.tymeleaf.org">
<head>
    <title>Document</title>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8"/>
</head>
<body>
<p th:text="'안녕하세요. ' + ${data}">안녕하세요 손님</p>
</body>
</html>
```



# 0627

## 빌드하고 실행하기

### 콘솔로 이동

1. ./gradlew build
2. cd build/libs
3. java -jar hello-spring-0.01-SNAPSHOT.jar
4. 실행확인

![image-20220627142057182](readme.assets/image-20220627142057182.png)





## 스프링 웹 개발 기초

- 정적컨텐츠
- MVC와 템플릿 엔진
- API



## 정적 컨텐츠

- 스프링 부트 정적 컨텐츠 기능
- static 하위 폴더에 hello-static.html 작성
- localhost:8080/hello-static.html 입장 가능

![image-20220627145351830](readme.assets/image-20220627145351830.png)



## MVC와 템플릿 엔진

- MVC : Model, View, Controller

### Controller

```java
@Controller
public class HelloController {

    @GetMapping("hello") //hello 가 들어오면 이것이 실행됨
    public String hello(Model model){
        model.addAttribute("data","hello!");
        return "hello";
    }
}

```

- 내부적인 로직에 집중

### View

`resources/remplate/hello-template.hmtl`

```html
<!doctype html>
<html xmlns:th="http://www.tymeleaf.org">
<head>
    <title>Document</title>
    <meta http-equiv="Content-type" content="text/html; charset=UTF-8"/>
</head>
<body>
<p th:text="'안녕하세요. ' + ${data}">안녕하세요 손님</p>
</body>
</html>
```

- view는 화면을 그리는데 모든 역량을 집중해야함



- tymleaf 템플릿의 장점은 서버없어도 html 파일 자체를 열어볼 수 있음 

![image-20220627151305541](readme.assets/image-20220627151305541.png)





## API

### `@ResponseBody 문자반환`

```java
@GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;

    }
    static class Hello{
        private String name;

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
```

![image-20220628143022552](readme.assets/image-20220628143022552.png)



# 0628

## 08비즈니스 요구사항 정리

### 회원 관리 예제 - 백엔드 개발

- 비즈니스 요구사항정리
- 회원 도메인과 리포지토리 만들기
- 회원 리포지토리 테스트 케이스 작성
- 회원 서비스 개발
- 회원 서비스 테스트



- 비즈니스 요구사항 정리
  - 데이터, 회원 ID, 이름
  - 기능, 회원 등록, 조회
  - 아직 데이터 저장소가 선정되지 않음(가상의 시나리오)



- 일반적인 웹 애플리케이션 계층 구조:

![image-20220628143857109](readme.assets/image-20220628143857109.png)

- 컨트롤러 : 웹 MVC의 컨트롤러 역할	
- 서비스 : 핵심 비즈니스 로직 구현
- 리포지토리 : 데이터베이스에 접근, 도메인 객체를 DB에 저장하고 관리
- 도메인 : 비즈니스 도메인 객체 예)회원, 주문, 쿠폰 등등 주로 데이터베이스에 저장하고 관리됨



- 클래스 의존관계

![image-20220628144015740](readme.assets/image-20220628144015740.png)

- 아직 데이터 저장소가 선정되지 않아서, 우선 인터페이스로 구현 클래스를 변경할 수 있도록 설계
- 데이터 저장소는 RDB, NoSQL등 다양한 저장소를 고민중인 상황으로 가정
- 개발을 진행하기 위해서 초기 개발 단계에서는 구현체로 가벼운 메모리 기반의 데이터 저장소 사용



## 09 회원 도메인과 리포지토리 만들기

![image-20220628145831608](readme.assets/image-20220628145831608.png)

- 레포지토리 패키지 작성
  - 하위 implements 작성
  - 하위 클래스 작성

```java
//repository/MemberRepository

package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}

```

```java
//repository/MemoryMemberRepository

package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long squence = 0L;



    @Override
    public Member save(Member member) {
        member.setId(++squence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
        //루프돌려서 같은 이름인거 찾음 없으면 null 반환

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
```



## 10 회원 도메인과 레포지토리 테스트

### 회원레포지토리 테스트 케이스 작성

- 개발한 기능을 테스트 할 때 main 메서드를 통해서 실행하거나, 웹 애플리케이션의 컨트롤러를 통해서 해당 기능을 실행한다. 이러한 방법은 준비하고 실행하는데 오래 걸리고, 반복 실행하기 어렵고 여러 테스트를 한번에 실행하기 어렵다는 단점이 있다. 자바는 JUnit이라는 프레임워크로 테스트를 실행해서 이러한 문제를 해결한다.



### 회원 레포지토리 구현체 테스트

- `src/test/java` 하위 폴더에 생성한다.

![image-20220628163317401](readme.assets/image-20220628163317401.png)

- art+enter누르면 해당 기능에 대한 소스를 임포트함
