package me.robsonsky.x_player.data

class VideoRepository(private val videoDataSource: VideoDataSource): VideoContract {

    override fun listAll(success: (List<Video>) -> Unit, failure: (String) -> Unit) {
        videoDataSource.listAll(success, failure)
    }
}