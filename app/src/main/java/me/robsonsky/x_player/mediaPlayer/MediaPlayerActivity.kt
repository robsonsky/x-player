package me.robsonsky.x_player.mediaPlayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import me.robsonsky.x_player.R
import me.robsonsky.x_player.data.Video
import me.robsonsky.x_player.extensions.addFragmentTo

class MediaPlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_player)
        addFragmentTo(R.id.main_container, createFragment())
    }

    fun createFragment(): MediaPlayerFragment {
        return MediaPlayerFragment.newInstance(createViewModel())
    }

    fun createViewModel(): MediaPlayerViewModel {

        var video = Video()

        intent?.also { intent ->

            intent.getParcelableExtra<Video>("video")?.also { extra ->
                video = extra
            }
        }

        return MediaPlayerViewModel(this, createPlayer(), video)
    }

    fun createPlayer(): SimpleExoPlayer {

        val trackSelector = DefaultTrackSelector()
        val loadControl = DefaultLoadControl()
        val renderersFactory = DefaultRenderersFactory(this)

        return ExoPlayerFactory.newSimpleInstance(this, renderersFactory, trackSelector, loadControl)
    }
}
