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