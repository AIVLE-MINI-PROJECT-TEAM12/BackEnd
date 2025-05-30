# BackEnd
KT AIVLE Team12 BackEnd Team

📚 도서관리서비스

React + Vite + MUI 프런트엔드와 Spring Boot 백엔드로 구현한 **도서 관리 서비스**  
- CRUD·표지 생성(OpenAI DALL·E)·MUI 컴포넌트·Axios API 통신  
- “📝 notepad” 스타일 카드 위에 표지 이미지를 오버레이 하는 UI

<!-- ![screenshot](./docs/screenshot-list.png) -->

---

## 🚀 Features
| 페이지 | 소스코드 링크 | 주요 기능 |
|--------|------|-----------|
| 📗 **Book Entity Class** | [소스](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/domain/Book.java) | Book Entity 정의 |
| 📘 **BookRepository Interface** | [소스](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/repository/BookRepository.java) | JPA 상속받은 BookRepository 인터페이스 |
| ✏️ **BookService Interface** | [소스](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/service/BookService.java) | BookService 인터페이스 |
| 🖼 **BookServiceImpl Class** | [소스](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/service/BookServiceImpl.java) | BookService 상속받아 구현 |
| ⚡️ **BookController** | [소스](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/controller/BookController.java) | CRUD에 따른 요청 처리 |
| ⚡️ **Book DTO Class** | [소스](https://github.com/AIVLE-MINI-PROJECT-TEAM12/BackEnd/blob/main/BookManageMent/src/main/java/com/bookmanage/BookManageMent/dto/BookDTO.java) | Book DTO 정의 |

---

## 🏗 Tech Stack
| 영역 | 사용 기술 |
|------|----------|
| Frontend | **React 18**, **Vite**, **MUI v5**, Axios, React Router v6 |
| Backend | **Spring Boot 3**, Spring MVC, Spring Data JPA, H2 |
| AI | **OpenAI Images API (DALL·E 3)** |
| Infra | Node >= 18, Java 17, (Option) Docker Compose |

---

## 📂 프로젝트 구조 (backend)
src/
└─ main/java/com/bookmanage/BookManageMent/
  ├─ controller/
  │ ├─ BookController.java
  │ └─ LoginController.java
  ├─ domain/
  │ ├─ Book.java
  │ └─ User.java
  ├─ dto/
  │ ├─ BookDTO.java
  │ └─ UserDTO.java
  ├─ repository/
  │ ├─ BookRepository.java
  │ └─ UserRepository.java
  ├─ service/
  │ ├─ BookService.java
  │ └─ BookServiceImpl.java
  ├─ util/
  │ └─ JwtUtil.java
  └─ BookManageMentApplication.java