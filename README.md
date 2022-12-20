# MTG(Meat Toy Gamers) fan site

![image](https://user-images.githubusercontent.com/101491213/198166949-f55c70fd-9028-4329-b838-5ef437774fad.png)

MTG라는 샌드박스에서 발행한 NFT 프로젝트의 팬 사이트를 만들려 했으나
학원에서 진행하는 실습과 과제들을 추가하게 되면서 본래의 성질은 퇴색되었습니다.


## 사용된 기술은 다음과 같습니다.
Spring MVC, JavaScript, jQuery

API 서버와 연계되는 프로세스가 있다보니 모든 서버를 켜둘 수가 없어
작동 하지 않는 기능이 몇 가지 있습니다.  

![image](https://user-images.githubusercontent.com/101491213/198169579-c612dee0-7517-471b-9cca-db6947a0778d.png)
  
1. 블록체인 네트워크를 이용한 회원 가입 및 로그인  
https://ubiquitous-sprite-121.notion.site/72a33baf58d9417689929911ed2e55db  
위 내용을 통해 블록체인 정보를 JSON으로 주고 받는 로직은 구현 했으나 실제 회원가입, 로그인 기능에는 적용하지 못했습니다.  

![image](https://user-images.githubusercontent.com/101491213/198166831-aa5ab0cc-1a44-460f-a0a6-3e2721913cf5.png)

2. 게시판 작성 시 Ai 색상 추천 기능(글 작성 시 직접 색상 코드(헥스 코드)를 입력 해주셔야 합니다.)
3. 서버에 한번 올렸다 내리면서 기존 사진들이 지워져 대부분의 이미지를 불러오지 못합니다.  

![image](https://user-images.githubusercontent.com/101491213/198169384-ad880df5-e242-4709-acb0-601d59d0d6ca.png)
  
4. map 기능 사용시 현재 위치를 받아와야 하나 http로 배포된 상태라 이용이 불가합니다. 원래는 위와 같은 기능이 있습니다.  
  

### 기능 테스트가 필요하시다면 아래의 정보로 로그인 해주시면 감사하겠습니다.
ID : lp2011s
PW : rudgh6401!

학원 일정 상 수업을 급하게 마무리 하면서 팀 프로젝트를 진행했기에  
마무리 되지 않은 프로젝트이며 미흡한 점이 다소 있음을 양해해주시면 감사하겠습니다.  

  
## 보완 및 추가 해야할 점
1. Dataroom - 디자인
2. Map - 메뉴 탭을 내렸을 때 지도가 z축 가장 위에 존재하는 버그 수정
3. 홈 화면 컨텐츠 추가
4. 게시판 화살표로 페이지 이동 기능 추가
5. 게시판 댓글 기능 추가
6. 게시글 수정 오류 수정
