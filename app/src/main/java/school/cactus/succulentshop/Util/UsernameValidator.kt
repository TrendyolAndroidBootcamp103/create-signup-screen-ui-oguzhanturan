package school.cactus.succulentshop.Util
import school.cactus.succulentshop.R


class UsernameValidator: Validator {
    private val USERNAME_REGEX by lazy { "[a-z0-9_]{3,19}" }

    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.this_field_is_required
        field.trim().length < 2 -> R.string.this_field_is_required
        field.trim().length > 20 -> R.string.this_field_is_required
        field.trim().matches(USERNAME_REGEX.toRegex()) -> R.string.username_must_contains
        else -> null
    }

}