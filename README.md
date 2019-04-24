# springboot-msa-default-setting

- STS 사용해서 추가시 
  - import > Check Out Maven Projects from SCM > git url 입력
  <br/>demo-api : https://github.com/shlee0882/springboot-api-default-setting.git
  <br/>demo-bo  : https://github.com/shlee0882/springboot-bo-default-setting.git

<br/>

## 요약
- spring boot를 이용해 demo-api(로직,쿼리), demo-bo(화면)로 분리하여 기본셋팅(default setting)하였습니다.
- demo-bo(화면)에서 demo-api로 요청을 보내고 결과값을 demo-bo(화면)로 반환합니다.

<br/>

- 현재 api는 1개이지만 확장하여 api를 여러개로 나누어 관리할 수 있습니다.
 <br/>(member-api, product-api, display-api, common-api ...)
- bo또한  확장하여 여러개로 나누어 관리할 수 있습니다.
 <br/>(member-bo, product-bo, display-bo, common-bo ...)
- 한 화면에 필요한 여러개의 api를 각각 다르게 호출하여 데이터를 받을 수 있습니다.
- 프로젝트 별로 분리함으로써 오류나 장애가 발생했을 경우 해당부분만 수정하여 빠른 대처가 가능합니다. 

<br/>

- 화면을 통해 테스트 시 bo, api 서버 모두 실행해야 하며 현재 bo는 localhost로 api는 aws rds로 연결하였습니다.
- api는 REST api로 postman, swagger 등으로 테스트 가능합니다.
- demo-api는 aws rds maria db로 연결해 조회[GET] api 한개를 테스트로 만들었습니다.
- log4j를 이용해 기본적인 로그는 모두 설정했습니다.(쿼리 실행 로그 및 오류로그) 
- application.yml 파일 수정을 통해 필요에 따라 db연결을 바꿔 oracle, mysql 선택 가능합니다.
- postman을 통해 localhost로 api를 실행한 후 테스트 가능합니다.
  - http://localhost:포트번호/demo-api/selectBurger/list
- maven을 사용하여 maven install, update project가 필요할 수 있습니다.


<br/>

## demo-api 패키지 구성도
- annotation
- api
  - common
  - controller
  - dao
  - exception
  - model
    - burger
  - service
  - util
- config

```text
api 패키지에 rest api에 필요한 구성이 있습니다.
annotation, config 패키지는 기본 환경설정 구성이 있습니다.
```

<br/>

## demo-bo 패키지 구성도
- bo
  - common
  - controller
  - exception
  - model
    - burger
  - service
- config

```text
bo 패키지에는 dao를 제외한 api로 요청하기 위한 구성이 있습니다.
config 패키지에 기본 환경설정 구성이 있습니다.
```
