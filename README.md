# Spring Security Oauth2 Social



소셜 관련된 라이브러리 및 방법이 너무 많음 딱히 좋은 튜토리얼도 못찾음
여러가지 조합해 본결과 가장 심플하게 하는 방법 소개, 확장에도 열려 있게 나름 해봄

[spring-security-oauth2](https://github.com/spring-projects/spring-security-oauth/tree/master/spring-security-oauth2)를 이용한 소셜 인증 및 회원 가입

# 목차
<!-- TOC -->

- [Spring Security Oauth2 Social](#spring-security-oauth2-social)
- [목차](#%EB%AA%A9%EC%B0%A8)
- [구성](#%EA%B5%AC%EC%84%B1)
- [프로젝트 셋팅](#%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8-%EC%85%8B%ED%8C%85)
  - [maven](#maven)
  - [application.yml](#applicationyml)

<!-- /TOC -->

# 구성
* [step-00: gogole, facebook, https 설정](https://github.com/cheese10yun/spring-security-oauth2-social/blob/master/doc/step-00.md)
* step-01 : google, facebook 간단한 소셜 인증 방법
* step-02: 데이터베이스에 회원 정보 저장

# 프로젝트 셋팅
* **Lombok이 반드시 설치 되있어야 합니다.**
  - [Eclipse 설치 : [lombok] eclipse(STS)에 lombok(롬복) 설치](http://countryxide.tistory.com/16)
  - [Intell J 설치 : [Intellij] lombok 사용하기](http://blog.woniper.net/229)

## maven
```xml
<dependency>
    <groupId>org.springframework.security.oauth</groupId>
    <artifactId>spring-security-oauth2</artifactId>
    <version>2.3.3.RELEASE</version>
</dependency>

<dependency>
    <groupId>org.springframework.security.oauth.boot</groupId>
    <artifactId>spring-security-oauth2-autoconfigure</artifactId>
    <version>2.0.0.RELEASE</version>
</dependency>
```

## application.yml

```yml
facebook:
  client:
    clientId: <your-client-id>
    clientSecret: <your-secret>
    accessTokenUri: https://graph.facebook.com/oauth/access_token
    userAuthorizationUri: https://www.facebook.com/dialog/oauth
    tokenName: oauth_token
    authenticationScheme: query
    clientAuthenticationScheme: form
  resource:
    userInfoUri: https://graph.facebook.com/me

google :
  client :
    clientId : <your-client>
    clientSecret: <your-secret>
    accessTokenUri: https://www.googleapis.com/oauth2/v4/token
    userAuthorizationUri: https://accounts.google.com/o/oauth2/v2/auth
    clientAuthenticationScheme: form
    scope:
    - email
    - profile
  resource:
    userInfoUri: https://www.googleapis.com/oauth2/v3/userinfo
```

* **반드시 위의 설정을 application.yml 추가해야합니다.**


