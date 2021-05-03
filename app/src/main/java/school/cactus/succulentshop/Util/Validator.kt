package school.cactus.succulentshop.Util

interface Validator {
    fun validate(field: String): Int?
}