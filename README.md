# 깃허브 레파지토리 앱
### :wrench: 기능 설명
- 깃 허브 Auth에 접근하여 로그인을 한다.
- 검색을 통해 깃허브를 사용하는 유저의 레파지토리 정보를 불러온다.
- Room을 사용하여 원하는 레파지토리를 즐겨찾기로 저장한다.
***
### :lollipop: 완성 화면
<img src="https://user-images.githubusercontent.com/48902047/134470411-a786e31b-a658-455a-af1b-8854f22d7369.jpg" width="20%" height="20%"></img>
<img src="https://user-images.githubusercontent.com/48902047/134470456-bf0f37e3-87a8-4d3f-b94d-14d6147691c3.jpg" width="20%" height="20%"></img>
<img src="https://user-images.githubusercontent.com/48902047/134470695-77c7be06-b2bf-4e84-971f-013b63e42d82.jpg" width="20%" height="20%"></img>
<img src="https://user-images.githubusercontent.com/48902047/134470599-1e025c6d-c5ab-4825-be2b-58c838b36465.jpg" width="20%" height="20%"></img>
***
#### 코루틴 사용
1. GlobalScope
  - SignInActivity
    1. authTokenProvider : 앱 내에 Token을 받아 저장하는 전역 변수
        - Dispatchers.Main 사용
    3. getAccessToken : 깃허브 토큰 받아 오는 함수
        - Dispatcher.IO 사용
  - 
2. 
#### 검색기능

#### Room 사용

***

### :paperclip: 소감
코루틴을 공부하기 위해 예제를 보았지만 정확한 이해가 되지 않았다.

그래서 인터넷도 찾아보고 나름의 정리를 하였지만 아직까지 스스로 짜는것은 조금 어려울거같긴한다.
