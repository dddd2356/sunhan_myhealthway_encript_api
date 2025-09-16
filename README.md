# sunhan_myhealthway_encript_api

## 선한 건강정보고속도로 암호화 API

### 프로젝트 개요
`sunhan_myhealthway_encript_api`는 주민등록번호와 같은 민감한 개인 정보를 **SEED 암호화**하기 위한 전용 API 서버입니다. 이 프로젝트는 건강정보 고속도로 연동 시 요구되는 보안 표준을 준수하기 위해 개발되었습니다. 클라이언트로부터 받은 주민등록번호를 지정된 SEED 키로 안전하게 암호화하여 반환하는 단일 목적을 가집니다.

---

### 주요 기능

-   **주민등록번호 SEED 암호화**: 클라이언트가 제공하는 주민등록번호와 SEED 키를 사용하여 SEED 알고리즘으로 데이터를 암호화합니다.
-   **입력 유효성 검사**: 주민등록번호와 SEED 키가 필수적으로 포함되어야 하며, 올바른 주민등록번호 형식인지 검증합니다.
-   **오류 처리**: 필수 입력값이 누락되거나 암호화 과정에서 오류가 발생하면 적절한 오류 메시지를 반환합니다.

---

### 기술 스택

-   **백엔드**: Java, Spring Boot
-   **암호화**: SEED 알고리즘 (MymdSeedCtrUtil)
-   **의존성**: Lombok, Spring Validation

---

### API 명세서

#### 1. 암호화 (`/api/encryption`)

| HTTP 메소드 | 엔드포인트 | 설명 |
| :--- | :--- | :--- |
| `POST` | `/resident-number` | 주민등록번호를 SEED 알고리즘으로 암호화합니다. |

**요청 (Request Body)**
- `residentNumber`: `String` (필수)
  - 암호화할 주민등록번호. `-` 포함 여부 관계없이 처리됩니다.
- `seedKey`: `String` (필수)
  - 암호화에 사용할 SEED 키.

**응답 (Response)**
- **성공**: 상태 코드 `200 OK`, 암호화된 문자열을 포함한 `String`
  - 예시: `"암호화된 문자열..."`
- **실패**: 상태 코드 `400 Bad Request` 또는 `500 Internal Server Error`, 오류 메시지를 포함한 `String`
  - 예시: `"유효하지 않은 입력값입니다."`, `"암호화 실패"`

---

### 설치 및 실행

1.  프로젝트를 클론합니다.
2.  의존성 관리를 위해 `Maven` 또는 `Gradle`을 사용합니다.
3.  애플리케이션을 실행합니다. 기본적으로 포트 `8080`에서 실행됩니다.

**Swagger 사용 시**:
Swagger UI를 통해 API를 테스트할 수 있습니다.
- `http://localhost:8080/swagger-ui.html`
