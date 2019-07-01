package me.robsonsky.x_player.mediaPlayer

import android.content.Context
import android.net.Uri
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.Util
import me.robsonsky.x_player.R
import me.robsonsky.x_player.data.Video

class MediaPlayerViewModel(val context: Context, val exoPlayer: ExoPlayer, val video: Video): MediaPlayerContract {

    override fun play() {

        val userAgent = Util.getUserAgent(context, context.getString(R.string.app_name))

        val mediaSource = ProgressiveMediaSource
            .Factory(DefaultHttpDataSourceFactory(userAgent), DefaultExtractorsFactory())
            .createMediaSource(Uri.parse(video.url))

        exoPlayer.prepare(mediaSource)
        exoPlayer.playWhenReady = true
    }

    override fun release() {
        exoPlayer.release()
    }

}