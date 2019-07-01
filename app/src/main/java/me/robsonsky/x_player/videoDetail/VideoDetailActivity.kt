package me.robsonsky.x_player.videoDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.robsonsky.x_player.R
import me.robsonsky.x_player.data.Video
import me.robsonsky.x_player.data.VideoDataSource
import me.robsonsky.x_player.data.VideoRepository
import me.robsonsky.x_player.extensions.addFragmentTo
import me.robsonsky.x_player.videoList.VideoListFragment
import me.robsonsky.x_player.videoList.VideoListViewModel

class VideoDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_detail)
        addFragmentTo(R.id.main_container, createFragment())
    }

    private fun createViewModel(): VideoDetailViewModel {

        var video = Video()

        intent?.also { intent ->

            intent.getParcelableExtra<Video>("video")?.also { extra ->
                video = extra
            }
        }

        return VideoDetailViewModel(video)
    }

    private fun createFragment(): VideoDetailFragment {
        return VideoDetailFragment.newInstance(createViewModel())
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
