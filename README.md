## 기술 스택

| Language | Java |
| --- | --- |
| Library&Framework | Spring Boot, Spring MVC (REST API), Spring Data JPA, Lombok |
| Database | H2 |
| API | RESTful API |

---

## ERD 소개

User 엔티티와 Book 엔티티는 **1:N 관계**를 갖습니다. 하나의 User는 여러 Book을 소유할 수 있지만, 각 Book은 단일 User에만 속합니다.

### Book

|  | Column | Type |
| --- | --- | --- |
| PK | **id** | **BIGINT** |
|  | story | TEXT |
|  | category | TEXT |
|  | bookCoverUrl | TEXT |
|  | createDate | DATETIME |
|  | lastUpdateDate | DATETIME |
| FK | userId | BIGINT |

`user_id`는 User 테이블의 기본 키를 참조하는 외래 키입니다.

### User

|  | Column | Type |
| --- | --- | --- |
| PK | **id** | **BIGINT** |
|  | username | VARCHAR(30) |
|  | token | TEXT |
|  | createdDate | DATETIME |

---

## API 명세

![image](https://github.com/user-attachments/assets/82c4b31f-6660-41ef-ad63-98abd8eb85f5)

![image](https://github.com/user-attachments/assets/63efa162-5b28-4172-8022-7b95444dba07)

![image](https://github.com/user-attachments/assets/23d4bca8-65e3-4497-a6b7-167c1c921f8f)

## 깨달은 점

### 1. 초기 설계와 소통의 중요성

프로젝트 초기에는 프론트엔드에서 사용자로부터 API key를 받아 AI 표지를 생성하는 방식으로 설계했습니다. 그러나 API key 보안을 위해 화면에 노출하지 않기로 결정하며, 설계를 변경하게 되었습니다. User 테이블을 추가하여, 사용자 등록 시 이름과 API key를 입력받아 백엔드에 저장하고 이를 활용하는 방식으로 수정했습니다.

이 과정에서 변경 사항이 팀원들에게 명확히 전달되지 않아 역할 분담이 모호해졌고, 동일한 기능을 중복 개발하게 되어 코드 병합 시 충돌과 어려움이 발생했습니다. 이를 통해 **초기 설계의 중요성**을 깨달았으며, 요구사항 변경 시에는 **팀원 간 충분한 소통**이 필요하다는 점을 배웠습니다.

### 2. 역할 분담 단위의 중요성

초기에는 Service와 Controller를 담당자로 나누어 역할을 분담했습니다. 그러나 Controller는 Service 구현이 완료될 때까지 작업을 진행하기 어려워 **대기 시간이 발생**하는 비효율적인 상황이 생겼습니다.

이를 통해 도출한 결론은 **Domain 단위** 또는 **API 단위**로 역할을 분담하는 것이 더 효율적이라는 것입니다. 이러한 방식은 팀원의 작업 간 의존성을 줄이고, 병렬로 작업을 진행할 수 있어 생산성을 높일 수 있을 거라고 판단했습니다.
