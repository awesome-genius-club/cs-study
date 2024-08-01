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