package me.robsonsky.x_player.videoList

import android.content.Context
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import me.robsonsky.x_player.data.Video
import me.robsonsky.x_player.data.VideoRepository
import me.robsonsky.x_player.R

class VideoListViewModel(val repository: VideoRepository, val context: Context) {

    val videos = ObservableArrayList<Video>()
    val loadingVisibility = ObservableBoolean(false)
    val message = ObservableField<String>()

    fun load() {
        loadingVisibility.set(true)
        message.set("")
        repository.listAll({ items ->

            videos.clear()
            videos.addAll(items)
            loadingVisibility.set(false)

            if(items.isEmpty()) {
                message.set(context.getString(R.string.empty_video_list))
            }

        }, { errorMsg ->

            message.set(errorMsg)
            loadingVisibility.set(false)
        })
    }
}