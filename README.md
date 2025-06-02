# BackEnd

KT AIVLE Team 12 Back-End Team

📚 도서관리서비스

React + Vite + MUI 프런트엔드와 Spring Boot 백엔드로 구현한 **도서 관리 서비스**  
- JWT 인증을 기반으로 한 사용자 인증
- 인증된 사용자의 도서 등록, 수정 삭제 기능 지원
- 등록된 정보는 H2 Database에 저장

## 🧾 System Configuration
![시스템 구성도](https://github.com/user-attachments/assets/8dce9301-cb9c-4312-8faf-a1187b859e16)


## 🚀 Features
| JAVA 클래스 | 주요 기능 |
|--------|-----------|
| 📘 [ **Book Entity Class** ](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/domain/Book.java) | Book Entity 정의 |
| 👤 [ **User Entity Class** ](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/domain/User.java) | User Entity 정의 |
| 🧾 [ **Book DTO Class** ](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/dto/BookDTO.java) | Book DTO 정의 |
| 🧾 [ **User DTO Class** ](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/dto/UserDTO.java) | User DTO 정의 |
| 🗂 [ **BookRepository Interface** ](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/repository/BookRepository.java) | JPA 기반 BookRepository 인터페이스 |
| 🗂 [ **UserRepository Interface** ](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/repository/UserRepository.java) | JPA 기반 UserRepository 인터페이스 |
| 🧩 [ **BookService Interface** ](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/service/BookService.java) | BookService 인터페이스 |
| 🛠 [ **BookServiceImpl Class** ](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/service/BookServiceImpl.java) | BookService 기능 정의 |
| 🌐 [ **BookController Class** ](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/controller/BookController.java) | CRUD에 따른 요청 처리 |
| 🔐 [ **LoginController Class** ](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/controller/LoginController.java) | 로그인 요청 처리 |
| 🧰 [ **BookMapper Class** ](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/util/BookMapper.java) | Book 데이터 형식 매핑 |
| 🛡 [ **JWTUtil Class** ](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/util/JWTUtil.java) | 로그인 사용자 토큰 부여 |


## 🏗 Tech Stack
| 영역 | 사용 기술 |
|------|----------|
| Frontend | **React 18**, **Vite**, **MUI v5**, Axios, React Router v6 |
| Backend | **Spring Boot 3**, Spring MVC, Spring Data JPA, H2 |
| AI | **OpenAI Images API (DALL·E 3)** |
| Infra | Node >= 22, Java 17 |


## 📂 프로젝트 구조 (backend)
```
src/
└── main/java/com/bookmanage/BookManageMent/
    ├── domain/
    │   ├── Book.java
    │   └── User.java
    ├── dto/
    │   ├── BookDTO.java
    │   └── UserDTO.java
    ├── repository/
    │   ├── BookRepository.java
    │   └── UserRepository.java
    ├── service/
    │   ├── BookService.java
    │   └── BookServiceImpl.java
    ├── controller/
    │   ├── BookController.java
    │   └── LoginController.java
    ├── util/
    │   ├── BookMapper.java
    │   └── JwtUtil.java
    └── BookManageMentApplication.java
```
---

## 📚 Book Management API 사용 가이드 (Postman 기반)
✅ 1. 로그인 (POST /auth/login)
- 요청 Body
  ```
  {
    "user_id": "user01",
    "user_name": "aivle"
  }
  ```
- 응답
  ```
  {
    "token": "uuid-토큰",
  }
  ```
  
![image](https://github.com/user-attachments/assets/899352af-56cf-43f9-af72-145d90a7894c)

📘 2. 도서 등록 (POST /books)
- /books 으로 도서 등록
- book 1
- 요청 Body
  ```
  {
    "book_name": "자바의 정석",
    "summary": "자바 언어의 기본부터 객체지향, 예외 처리까지 상세하게 다룬 프로그래밍 입문서입니다."
  }
  ```

![image](https://github.com/user-attachments/assets/d0cd48ab-50f1-45af-924d-e0189e5a4aaa)

- /books 으로 도서 등록
- book 2
- 요청 Body
  ```
  {
    "book_name": "스프링 부트 마스터",
    "summary": "Spring Boot 기반 웹 애플리케이션 개발에 필요한 실무 노하우를 정리한 가이드 입니다."
  }
  ```
  
![image](https://github.com/user-attachments/assets/28869eaf-fb90-4f5f-a51c-9a063d02a751)

📘 3. 도서 목록 조회 (GET /books)
- /books/97 으로 book_id가 97번인 도서 조회
- 조회 결과

![image](https://github.com/user-attachments/assets/be13c674-24b5-4107-996f-439080bea88b)

- /books/98 으로 book_id가 98번인 도서 조회
- 조회 결과
  
![image](https://github.com/user-attachments/assets/488085ee-263e-4222-bea7-1a561b5423d7)



- /books 으로 전체 도서 목록 조회
- 조회 결과

![image](https://github.com/user-attachments/assets/e2b2379b-018f-4c4a-8c68-ad9a08f90222)

📘 4. 도서 삭제 (DELETE /books/{book_id})
- /books/97 으로 book_id가 97번인 도서 삭제

![image](https://github.com/user-attachments/assets/0feba05b-69be-4693-a435-c80ca435a919)

📘 5. 도서 수정 (PUT /books/{book_id})
- /books/98 으로 book_id가 98번인 도서 제목, 본문 수정
- 요청 Body
  ```
  {
  "book_name": "스프링 부트 마스터 수정하기",
  "summary": "Spring Boot 기반 웹 애플리케이션 개발에 필요한 실무 노하우를 정리한 가이드 수정합니다."
  }
  ```
![image](https://github.com/user-attachments/assets/12f3e2ce-8281-44e8-9a2a-fb3efb066e09)

📘 6. 도서 표지 생성 (PUT /books/{book_id}/cover)
- /books/98 으로 book_id가 98번인 도서 표지 생성
- 요청 Body
  ```
  {
    "book_image": "http://nmixx.pmg"
  }
  ```
![image](https://github.com/user-attachments/assets/0dd9b4b3-5ddf-4438-ac92-782d9f06d8c6)

