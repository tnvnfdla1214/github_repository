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
    2. getAccessToken : 깃허브 토큰 받아 오는 함수
        - Dispatcher.IO 사용
  - MainActivity
    1. SetData : githubRepoList 의 정보의 유무에 따라 즐겨찾기 리스트를 리사이클러뷰에 추가시켜준다.
       - Dispatchers.Main 사용 -> 화면에 띄울때
       - Dispatcher.IO 사용 -> 정보를 불러올때
  - SearchActivity
    1. searchKeyword : String 형의 키워드로 깃 허브에 있는 닉네임을 불러온다.
       - Dispatcher.IO 사용
  - RepositoryActivity
    1. loadRepository : 원하는 레파지토리 정보를 자세히 정보를 불러온다.
       - Dispatcher.IO 사용
2. 사용자 지정 CoroutineScope
  - SignInActivity
    1. authTokenProvider : 앱 내에 Token을 받아 저장하는 전역 변수
        - Dispatchers.Main 사용
    2. getAccessToken : 깃허브 토큰 받아 오는 함수
        - Dispatcher.IO 사용
  - MainActivity
    1. SetData : githubRepoList 의 정보의 유무에 따라 즐겨찾기 리스트를 리사이클러뷰에 추가시켜준다.
       - Dispatchers.Main 사용 -> 화면에 띄울때
       - Dispatcher.IO 사용 -> 정보를 불러올때
  - SearchActivity
    1. searchKeyword : String 형의 키워드로 깃 허브에 있는 닉네임을 불러온다.
       - Dispatcher.IO 사용
  - RepositoryActivity
    1. loadRepository : 원하는 레파지토리 정보를 자세히 정보를 불러온다.
       - Dispatcher.IO 사용
#### 검색기능
1. SearchActivity에서 사용자가 입력한 Keyword를 String값으로 받아온다.
2. RetrofitUtil에 Retrofit으로 지정해놓은 GITHUB_API_URL의 serch정보 주소값을 Get해 온다.
3. 해당 정보를 List<GithubRepoEntity> 으로 공정하여 데이터를 저장한다.
4. 해당 데이터를 Recyclerview에 띄워준다.
5. 원하는 데이터의 item을 클릭시 해당 item의 정보를 RepositoryActivity넘겨준다.
6. 데이터를 알맞는 곳에 저장해준다.
#### Room 사용
1. RepositoryActivity에서 즐겨찾기 클릭한다.
2. Room이름을 "github_repository_app.db"으로 저장한다.
3. 저장의 방식은 SearchHistoryDao 에 getRepository 의 Query문의 형식으로 저장한다.
4. MainActivity에서 insertAll SearchHistoryDao 에 getRepository 의 Query문으로 현재 Room에 저장되어있는 데이터를 전부 가져온다.
***

### :paperclip: 소감
코루틴을 공부하기 위해 여러 예제를 보았지만 정확한 이해가 되지 않았다.

그래서 인터넷도 찾아보고 나름의 정리를 하였지만 아직까지 스스로 짜는것은 조금 어려울거같긴한다.
