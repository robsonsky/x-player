package me.robsonsky.x_player.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.robsonsky.x_player.R
import me.robsonsky.x_player.data.AuthData
import me.robsonsky.x_player.extensions.addFragmentTo
import me.robsonsky.x_player.signup.SignupFragment
import me.robsonsky.x_player.signup.SignupViewModel

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        addFragmentTo(R.id.main_container, createFragment())
    }

    private fun createViewModel(): LoginViewModel {
        return LoginViewModel(AuthData(), this)
    }

    private fun createFragment(): LoginFragment {
        return LoginFragment.newInstance(createViewModel())
    }
}
