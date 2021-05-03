package school.cactus.succulentshop.Util

import school.cactus.succulentshop.R


class IdentifierValidator : Validator {
    private val USERNAME_REGEX by lazy { "[a-z0-9_]{3,19}" }

    override fun validate(field: String): Int? {
        val checkUsername = field.trim().matches(USERNAME_REGEX.toRegex())
        val checkEmail = android.util.Patterns.EMAIL_ADDRESS.matcher(field.trim()).matches()

        return when {
            field.isEmpty() -> R.string.this_field_is_required
            !(checkUsername || checkEmail) -> R.string.identifier_invanlid
            else -> null
        }
    }
}
