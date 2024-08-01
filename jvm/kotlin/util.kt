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