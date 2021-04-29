package school.cactus.succulentshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.Util.EmailValidator
import school.cactus.succulentshop.Util.PasswordValidator
import school.cactus.succulentshop.Util.UsernameValidator
import school.cactus.succulentshop.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private val emailValidator = EmailValidator()
    private val passwordValidator = PasswordValidator()
    private val usernameValidator = UsernameValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.title = getString(R.string.sign_up)

        binding.apply {
            signUpButton.setOnClickListener {
                emailInputLayout.validate()
                usernameInputLayout.validate()
                passwordInputLayout.validate()
            }
            alreadyHaveAccountButton.setOnClickListener {
                redirectToLoginActivity()
            }
        }
    }

    private fun redirectToLoginActivity() {
        val  loginPage = Intent(this,LoginActivity::class.java)
        this.finish()
        startActivity(loginPage)
    }


    private fun TextInputLayout.validate() {
        val errorMessage = validator().validate(editText!!.text.toString())
        error = errorMessage?.resolveAsString()
        isErrorEnabled = errorMessage != null
    }

    private fun Int.resolveAsString() = getString(this)

    private fun TextInputLayout.validator() = when (this) {
        binding.emailInputLayout -> emailValidator
        binding.usernameInputLayout -> usernameValidator
        binding.passwordInputLayout -> passwordValidator
        else -> throw IllegalArgumentException("Cannot find any validator for the given TextInputLayout")
    }

}