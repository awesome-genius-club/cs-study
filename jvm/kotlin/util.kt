// 확장 함수의 묶음 형식으로 internal object 사용

data class User(
    val name: String,
    val age: Int,
    val password: String
)

internal object UserUtils {
    fun User.isAdult() = age >= 20
    fun User.isPasswordValid() = password.length >= 8
    fun User.isNameValid() = name.length >= 2
}

// Main Class에 App 관련 String 모음 예시
class AppApplication {
    init {
        // start logic...
    }

    companion object {
        const val PACKAGE_NAME = "com.test.test"

        const val VERSION = "0.0.1"
    }
}

// MimeType 분리 Pattern
// 필요시에 추가하는 Pattern으로 하면 좋을 듯 함.
// MDN: https://developer.mozilla.org/ko/docs/Web/HTTP/Basics_of_HTTP/MIME_types/Common_types
object MimeType {
    const val JSON = "application/json"
    const val XML = "application/xml"
    const val HTML = "text/html"
    const val EXCEL = "application/vnd.ms-excel"
    const val PDF = "application/pdf"
    const val ZIP = "application/zip"
}

// api paths 분리 Pattern
object WebPath {
    const val ROOT = "/"
    const val ERROR = "/error"
    const val API = "/api"
    const val HEALTH = "/health"
    const val DOCS = "/docs"
}

object ApiVariable {
    const val ID = "{id}"
}

object ApiPathV1 {
    const val PREFIX = "${WebPath.API}/v1"

    @Deprecated("Use ApiPathV2")
    const val USER = "$PREFIX/user"

    const val USER_ID = "$USER/${ApiVariable.ID}"
}

// Controller interface 분리
// Hexagonal Architecture에서 사용하는 in Adapter의 관점으로 사용

// port interface ( in port )
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
interface UserController {
    @GetMapping(ApiPathV1.USER_ID, consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun getUser(id: String): User

    @PostMapping(ApiPathV1.USER, consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun createUser(user: User): User

    @PutMapping(ApiPathV1.USER_ID, consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updateUser(id: String, user: User): User

    @DeleteMapping(ApiPathV1.USER_ID)
    fun deleteUser(id: String)
}

// Adapter 구현체
@RestController
internal class UserControllerImpl : UserController {
    override fun getUser(id: String): User {
        TODO("Not implemented")
    }

    override fun createUser(user: User): User {
        TODO("Not implemented")
    }

    override fun updateUser(id: String, user: User): User {
        TODO("Not implemented")
    }

    override fun deleteUser(id: String) {
        TODO("Not implemented")
    }
}

// Json Serializer 분리, FE의 send field가 바뀌더라도, 구현체는 변경하지 않아도 됨.
// 이름이 커플링될 필요는 없음. 이는, FE/BE의 결합도를 낮추는 용도

@JsonDeserialize
data class CreateUserRequest(
    @field:NotEmpty
    @field:Email
    @JsonProperty(FIELD_LOGIN_EMAIL)
    val name: String,

    @field:NotEmpty
    @JsonProperty(FIELD_AGE)
    val age: Int,

    @field:NotEmpty
    @JsonProperty(FIELD_PASSWORD)
    val password: String
) {
    companion object {
        const val FIELD_NAME = "name"
        const val FIELD_AGE = "age"
        const val FIELD_PASSWORD = "password"
    }
}