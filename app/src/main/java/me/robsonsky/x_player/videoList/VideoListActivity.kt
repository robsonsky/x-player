package me.robsonsky.x_player.videoList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.robsonsky.x_player.data.VideoDataSource
import me.robsonsky.x_player.data.VideoRepository
import me.robsonsky.x_player.extensions.addFragmentTo
import me.robsonsky.x_player.R

class VideoListActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_list)
        addFragmentTo(R.id.main_container, createFragment())
    }

    private fun createViewModel(): VideoListViewModel {
        val videoDataSource = VideoDataSource()
        val repository = VideoRepository(videoDataSource)
        return VideoListViewModel(repository, applicationContext)
    }

    private fun createFragment(): VideoListFragment {
        return VideoListFragment.newInstance(createViewModel())
    }
}
