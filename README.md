⏰ Board Module & Restful API Project<br/>
이 프로젝트는 기본적인 게시글 작성, 게시글 리스트 및 상세화면 조회와<br/>
RestFul API를 통해 별도의 작성(수정)화면 없이 게시글을 등록/수정/삭제 할 수 있는 기능을 제공한다.
<br/><br/>
🛠 주요 기능

 1. 게시판 기본기능
   - 게시글 목록/작성/조회 화면 이동
   - 게시글 등록 기능

 2. RestFul API 기능
   - 게시글 등록/수정/삭제 기능
<br/>
🧪 테스트 방법

 - 프로젝트 실행
 - Spring Boot 프로젝트 import 후 실행 (내장톰캣)
 - DB: MySQL 사용
   
 1. 게시판 기본기능
    - 게시글 리스트 (http://localhost:8080/board/brdList)
    - 게시글 등록 (http://localhost:8080/board/brdWrite)
    - 게시글 조회 (http://localhost:8080/board/brdView)

 2. API 테스트
    - Swagger를 통해 API 응답 및 테스트<br/>
      (http://localhost:8080/swagger-ui/index.html)
      1) 게시글 등록
         - POST요청으로 게시글 등록
         - 요청 : http://localhost:8080/save
         - 파라미터 : 제목(title) 및 내용(content)를 json형태로 request body에 담아 호출<br/>
           (ex. {"title":"테스트1", "content":"테스트1 내용입니다."})
      3) 게시글 수정
         - PUT or PATCH 요청으로 게시글 수정
         - 요청 : http://localhost:8080/update/{brdId}
         - 파라미터 : 제목(title) 및 내용(content)를 json형태로 request body에 담아 호출<br/>
           (ex. {"title":"테스트1", "content":"테스트1 내용입니다."})
      5) 게시글 삭제
         - DELETE 요청으로 게시글 삭제
         - 요청 : http://localhost:8080/delete/{brdId}

<참조 이미지>
    ![image](https://github.com/user-attachments/assets/2f42f3dd-1068-4b24-ae92-1e9cf88a5467)
