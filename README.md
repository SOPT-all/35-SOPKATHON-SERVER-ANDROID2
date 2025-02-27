# 🥔 stup!d potato (35-SOPKATHON-SERVER-ANDROID2)
![image](https://github.com/user-attachments/assets/c2c53c8b-ee04-41ff-95ea-bec764bfeeaf)


📌 감자들이 감자짓을 공유해 친구들과 웃음을 나누는 서비스📌 

- 감자 키우기를 통해 바보같은 일들을 재밌게 기록해서 공유하고, 친구들의 감자짓을 보고 감자력을 비교하며 서로 웃음을 나누는 서비스입니다.
- [x]  게시글 생성
- [x]  게시글 단건조회
- [x]  게시글 목록 조회
- [x]  유저 조회
- [x]  친구 맺은 유저 목록 조회

## 🥔 바보 같은 일 기록

게시판에 바보 같은 일들을 기록하는데, 바보 같은 일을 기록한 후 수정하거나 삭제하면 바보 같은 일들이 모인 게시판의 내용이 적을 거라고 생각해서 `patch` 와 `delete` api는 만들지 않았고, 바보같은 일 생성, 조회만 했습니다.

## 🥔 유저 = 감자

유저를 감자라고 생각해서 유저 테이블을 설계한 후 바보같은 일을 기록하는 게시판과의 연관관계를 맺어서 구현했습니다.

## 🥔 감자 키우기 관련 내용 분석

### 1. 단계수

5단계로 나눈다.

### 2. 단계별 기준

1. 1단계: 기본
2. 2단계: 2개 작성 
3. 3단계:4개 작성
4. 4단계:7개 작성
5. 5단계:15개 작성
- 인스타 공유시 +1개 인정(글 작성하고 공유까지 하면 하루에 최대 2개 인정 가능)

다음 기능에 맞춰서 핵심 로직을 설계했습니다.

**▶️ BoardService의 핵심 로직**

```java
       // 게시글 수에 따른 레벨 계산
        if (count >= 15) {
            newLevel = 5; // 5단계
        } else if (count >= 7) {
            newLevel = 4; // 4단계
        } else if (count >= 4) {
            newLevel = 3; // 3단계
        } else if (count >= 2) {
            newLevel = 2; // 2단계
        } else {
            newLevel = 1; // 기본 단계
        }
```

# 공수 산정

- 지원 : 게시글 생성, 단일 게시글 조회, 배포
- 예은 : user 정보 조회, user 리스트 조회, board 리스트 조회, 더미 데이터 넣기

# 설계도 작성

## ERD
<img width="933" alt="Screenshot 2024-11-24 at 5 13 47 AM" src="https://github.com/user-attachments/assets/8b6ddab0-cbb8-4be3-8d3e-73af66e52ba1">

## API 명세서
https://www.notion.so/API-147c7c599e65808f9d64c2350f35cfeb?p=147c7c599e658117b357e299c2ce470f&pm=s

