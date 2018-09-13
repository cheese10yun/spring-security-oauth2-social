# 기본 설정

# Facebook 설정

[Facebook for Developers ](https://developers.facebook.com/) 으로 이동합니다.

![app-setting](/assets/app-setting.png)

* 테스트 APP를 생성합니다.
* 제품 + 버튼을 클릭해서 Facebook 로그인을 추가합니다.

![url-setting](/assets/url-setting_o5ntpngqj.png)

* 설정 탭에서 유효한 OAuth 리다이렉트 URL 설정합니다.
* **페이스북 정책이 변경되어서 HTTPS URL만 리다이렉트 URL 설정이 가능합니다. 하단에서 Https 적용법을 참고하세요**

![id-](/assets/id-_rtg7iccpw.png)
* 발급받은 앱 Id, 앱시크릿 코드를 확인합니다.

# Google 설정
[Google Colud](https://console.cloud.google.com/)로 이동합니다.

![google-id-](/assets/google-id-.png)
* 프로젝트 만드는 스크린 샷은 따로 찍지 못해서 첨부하지 못했습니다.
* 프로젝트에서 Client Id, Client secret을 확인합니다.
* Authorized reirect URLs에 적용합니다. **페이스북과 달리 Http를 허용합니다. 하지만 해당 프로젝트에서는 Https를 적용시킬것이라서 Https를 적용 시킵니다.**

# Https 적용

## 키스토어 생성
```
keytool -genkey -alias tomcat -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 4000

키 저장소 비밀번호 입력:
새 비밀번호 다시 입력:
이름과 성을 입력하십시오.
  [Unknown]:  test
조직 단위 이름을 입력하십시오.
  [Unknown]:  test
조직 이름을 입력하십시오.
  [Unknown]:  test
구/군/시 이름을 입력하십시오?
  [Unknown]:  test
시/도 이름을 입력하십시오.
  [Unknown]:  test
이 조직의 두 자리 국가 코드를 입력하십시오.
  [Unknown]:  01
CN=test, OU=test, O=test, L=test, ST=test, C=01이(가) 맞습니까?
  [아니오]:  y
```

## properties 설정

### YML
```yml
server:
  ssl:
    key-store: keystore.p12
    key-store-password: cheese
    keyStoreType: PKCS12
    keyAlias: tomcat
```


### Properties
```
server.ssl.key-store: keystore.p12
server.ssl.key-store-password: cheese
server.ssl.keyStoreType: PKCS12
server.ssl.keyAlias: tomcat
```

* [스프링 부트](https://www.inflearn.com/course/스프링부트 ) 참고