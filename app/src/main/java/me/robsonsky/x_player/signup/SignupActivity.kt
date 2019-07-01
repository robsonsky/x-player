package me.robsonsky.x_player.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.robsonsky.x_player.R
import me.robsonsky.x_player.data.AuthData
import me.robsonsky.x_player.data.Video
import me.robsonsky.x_player.extensions.addFragmentTo
import me.robsonsky.x_player.videoDetail.VideoDetailFragment
import me.robsonsky.x_player.videoDetail.VideoDetailViewModel

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        addFragmentTo(R.id.main_container, createFragment())
    }

    private fun createViewModel(): SignupViewModel {
        return SignupViewModel(AuthData(), this)
    }

    private fun createFragment(): SignupFragment {
        return SignupFragment.newInstance(createViewModel())
    }
}
